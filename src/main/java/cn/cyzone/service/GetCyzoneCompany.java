package cn.cyzone.service;

import cn.cyzone.entity.Company;
import cn.cyzone.entity.Entrepreneur;
import cn.cyzone.entity.EntrepreneurToCompany;
import cn.cyzone.entity.Finance;
import cn.cyzone.util.CrawlerUtil;
import cn.cyzone.util.DataBaseUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GetCyzoneCompany {

    /***
     * 输入url爬取相应的公司基本数据
     * @param url　创业公司首页地址
     * @return
     */
    public String getDataCompanyDo(String url) {
        DataBaseUtil<Company> dataBaseUtil = new DataBaseUtil();
        ArrayList<Company> arrayList = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        Document doc = CrawlerUtil.getDocument(url);
        //通过class获取主网站上公司信息条
        Elements elementsCompany = doc.getElementsByClass("table-company-tit");
        if(elementsCompany != null){
            elementsCompany.forEach(ec-> {
                Company company = new Company();
                //获取、写入公司名称
                company.setCompanyName(ec.text());
                Elements href = ec.select("a");
                //获取、写入公司详细页url
                String href1 = "http://www.cyzone.cn" + href.attr("href");
                company.setCompanyUrl(href1);
                arrayList.add(company);
            });
            //获取描述信息和服务行业两个class一样，下面做了处理
            Elements elements = doc.getElementsByClass("table-type");
            final int[] i = {0};
            elements.forEach(es->{
                int yushu = i[0] % 2;
                int index = i[0] / 2;
                if(yushu == 0){
                    //获取、写入公司简单描述
                    Company company = arrayList.get(index);
                    company.setCompanyInfo(es.text());
                }
                //获取、写入公司服务类型
                Company company = arrayList.get(index);
                company.setCompanyServerType(es.text());
                i[0]++;
            });
            //获取下一个网页的url
            Elements elementsNextUrlA = doc.select("#pages").select("a");
            elementsNextUrlA.forEach(enua->{
                if(enua.text().equals("下一页")){
                    stringBuffer.append("http://www.cyzone.cn" + enua.attr("href"));
                }
            });
            //进入公司详细页获取更多信息
            for(int j = 0; j < arrayList.size(); j++){
                Company company = arrayList.get(j);
                Document docUrl = CrawlerUtil.getDocument(company.getCompanyUrl());
                //获取、写入公司全称
                String fullName = docUrl.select("li.time").text();
                if(fullName != null && fullName.length() > 5){
                    fullName = fullName.substring(5);
                }
                company.setCompanyFullName(fullName);
                //获取、写入公司图标
                company.setCompanyPicture(docUrl.select("div.tl-img-bar").select("img").attr("src"));
                Elements element = docUrl.select("div.info-tag.clearfix").select("li");
                element.forEach(e->{
                    String elements1 = e.select("i").attr("class");
                    if(elements1.equals("i1")){
                        try {
                            //获取公司创建时间
                            String date = e.select("span").text();

                            if(date != null && !date.equals("不明确") && !date.equals("至今") && !date.equals("不清楚")){
                                company.setCompanyCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                            }
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                    }else if(elements1.equals("i2")){
                        //获取公司地址
                        company.setCompanyLocation(e.select("span").text());
                    }else {
                        //获取工资融资情况
                        company.setCompanyFinance(e.select("span").text());
                    }
                });
                //获取、写入公司简介
                company.setCompanyDetails(docUrl.select("div.info-box").text());
                //获取、写入公司官网url
                company.setCompanyOfficialWebsite(docUrl.select("div.com-url").select("a").text());
            }

            //插入公司表数据库
            String sql = "insert into cyzone_company(company_name,company_full_name,company_info,company_details," +
                    "company_finance,company_server_type,company_url,company_official_website,company_location," +
                    "company_picture,company_create_date) values(?,?,?,?,?,?,?,?,?,?,?)";
            if(arrayList.size() > 0){
                dataBaseUtil.addNewsAll(sql,arrayList);
            }
            return stringBuffer.toString();
        }
        return null;
    }

    /**
     * 获取自然人信息方法
     * @param path 输入公司详细页所在url
     */
    public void getEntrepreneur(String path){
        Document doc = CrawlerUtil.getDocument(path);
        DataBaseUtil<Entrepreneur> dataBaseUtilE = new DataBaseUtil();
        DataBaseUtil<EntrepreneurToCompany> dataBaseUtilETC = new DataBaseUtil();
        EntrepreneurToCompany entrepreneurToCompany = new EntrepreneurToCompany();
        //写入公司、自然人对应表公司的url
        entrepreneurToCompany.setEntrepreneurToCompanyCompanyUrl(path);
        if(doc.select("div.team.clearfix") != null){
            doc.select("div.team.clearfix").select("li").forEach(docE->{
                Entrepreneur entrepreneur = new Entrepreneur();
                //获取写入自然人所在url
                String url = "http://www.cyzone.cn" + docE.select("p.name").select("a").attr("href");
                entrepreneur.setEntrepreneurUrl(url);
                //写入公司、自然人对应表自然人的url
                entrepreneurToCompany.setEntrepreneurToCompanyEntrepreneurUrl(url);
                Document docUrl = CrawlerUtil.getDocument(url);
                //获取、写入自然人姓名
                entrepreneur.setEntrepreneurName(docUrl.select("li.name").text());
                //获取、写入自然人头像url
                String pictureUrl = doc.select("div.tl-img-bar").select("img").attr("src");
                entrepreneur.setEntrepreneurPicture(pictureUrl);
                //获取、写入自然人职位
                entrepreneur.setEntrepreneurPosition(docUrl.select("li.time.company").text());
                //获取、写入自然人简介
                entrepreneur.setEntrepreneurInfo(docUrl.select("div.people-info-box").text().trim());
                String sqlEntrepreneur = "insert into cyzone_entrepreneur(entrepreneur_name,entrepreneur_info,entrepreneur_url," +
                        "entrepreneur_position,entrepreneur_picture) values(?,?,?,?,?)";
                String sqlEntrepreneurToCompany = "insert into cyzone_entrepreneur_to_company(entrepreneur_to_company_entrepreneur_url," +
                        "entrepreneur_to_company_company_url) values(?,?)";
                if(entrepreneur.getEntrepreneurName() != null && !entrepreneur.getEntrepreneurName().trim().equals("")){
                    dataBaseUtilE.addOne(sqlEntrepreneur,entrepreneur);
                    dataBaseUtilETC.addOne(sqlEntrepreneurToCompany,entrepreneurToCompany);
                }
            });
        }
    }

    /**
     * 获取融资信息
     * @param path　输入公司详细页所在url
     */
    public void getFinance(String path){
        Document doc = CrawlerUtil.getDocument(path);
        if(doc.select("div.live") != null){
            DataBaseUtil<Finance> dataBaseUtil = new DataBaseUtil<>();
            Finance finance = new Finance();
            //获取该公司的融资信息
            Elements elementsTr = doc.select("div.live").select("tr");
            finance.setFinanceCompanyUrl(path);
            for(int i = 1; i < elementsTr.size(); i++) {
                Elements elementsTd = elementsTr.get(i).select("td");
                for (int j = 0; j < elementsTd.size(); j++) {
                    if(j == 0){
                        //获取、写入融资阶段
                        finance.setFinanceName(elementsTd.get(j).text());
                    }else if(j == 1){
                        //获取、写入融资金额
                        finance.setFinanceMoney(elementsTd.get(j).text());
                    }else if(j == 2){
                        //获取、写入投资方
                        String sBr = elementsTd.get(j).html().replace("<br>","#@");
                        Document docBr = Jsoup.parse(sBr);
                        finance.setFinanceInvestmentCompany(docBr.text().trim());
                    }else {
                        try {
                            //获取、写入融资时间
                            finance.setFinanceDate(new SimpleDateFormat("yyyy-MM-dd").parse(elementsTd.get(j).text()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                String s = finance.getFinanceInvestmentCompany();
                if(s != null){
                    s = s.trim();
                    if(s.length() == 0){
                        continue;
                    }
                    String[] sArr = s.split("#@");
                    for(int k = 0; k < sArr.length; k++){
                        finance.setFinanceInvestmentCompany(sArr[k]);
                        if(finance.getFinanceName() != null){
                            String sql = "insert into cyzone_finance(finance_name,finance_money,finance_company_url," +
                                    "finance_investment_company,finance_date) values(?,?,?,?,?)";
                            dataBaseUtil.addOne(sql,finance);
                        }
                    }
                }else if(finance.getFinanceName() != null){
                    String sql = "insert into cyzone_finance(finance_name,finance_money,finance_company_url," +
                            "finance_investment_company,finance_date) values(?,?,?,?,?)";
                    dataBaseUtil.addOne(sql,finance);
                }
            }
        }
    }
}
