package cn.cyzone.service.impl;
import cn.cyzone.entity.*;
import cn.cyzone.service.GetCyzoneInvestmentCompany;
import cn.cyzone.util.CrawlerUtil;
import cn.cyzone.dao.DataBaseUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GetCyzoneInvestmentCompanyImpl implements GetCyzoneInvestmentCompany {

    /**
     * 获取创投机构首页url，爬取当前页15个机构的基本信息，主要获取每个机构所在url
     * @param url 输入创投机构首页url
     */
    public void getInvestmentCompany(String url){
        Document doc = CrawlerUtil.getDocument(url);
        ArrayList<InvestmentCompany> arrayList = new ArrayList();
        Elements etr = doc.select("tr.table-plate2");
        etr.forEach(e1->{
            Elements etd = e1.select("td");
            int i = 0;
            InvestmentCompany investmentCompany = new InvestmentCompany();
            for(Element e2 : etd){
                i++;
                if(i == 1){
                    //获取插入机构所在url
                    String investmentCompanyUrl = "http://cyzone.cn" + e2.select("a").attr("href");
                    investmentCompany.setInvestmentCompanyUrl(investmentCompanyUrl);
                    //获取插入机构图标所在url
                    investmentCompany.setInvestmentCompanyPicture(e2.select("a").select("img").attr("src"));
                }else if(i == 2){
                    //名称
                    investmentCompany.setInvestmentCompanyName(e2.select("a").text());
                }else if(i == 3){
                    //成立时间
                    String date = e2.text();
                    if(date != null && !date.equals("—") && !date.equals("不明确") && !date.equals("不清楚") && !date.equals("未公开")){
                        try {
                            investmentCompany.setInvestmentCompanyCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }else if(i == 4){
                    //投资案例总数
                    investmentCompany.setInvestmentCompanyInvestorNum(Integer.parseInt(e2.text()));
                }else if(i == 5){
                    //投资偏好
                    investmentCompany.setInvestmentCompanyInvestorLike(e2.text());
                }else if(i ==6){
                    //投资领域
                    investmentCompany.setInvestmentCompanyInvestorDirection(e2.text());
                }
            }
            //进入机构所在url
            Document docUrl = CrawlerUtil.getDocument(investmentCompany.getInvestmentCompanyUrl());
            //拿到官网url
            investmentCompany.setInvestmentCompanyOfficialWebsite(docUrl.select("a.web").text());
            //拿到机构简介
            investmentCompany.setInvestmentCompanyInfo(docUrl.select("div.people-info-box").text());
            arrayList.add(investmentCompany);
        });
        String sql = "insert into cyzone_investment_company(investment_company_name,investment_company_info," +
                "investment_company_url,investment_company_picture,investment_company_official_website," +
                "investment_company_investor_num,investment_company_investor_like,investment_company_investor_direction," +
                "investment_company_create_date) values(?,?,?,?,?,?,?,?,?)";
        if(arrayList.size() > 0){
            DataBaseUtil dataBaseUtil = new DataBaseUtil();
            dataBaseUtil.addNewsAll(sql,arrayList);
        }
    }

    /**
     * 通过机构所在url，获取机构下投资人信息,一并获取投资人工作经历
     * @param url　
     */
    public void getInvestor(String url){
        //机构和投资人对应表
        InvestmentCompanyToInvestor investmentCompanyToInvestor = new InvestmentCompanyToInvestor();
        investmentCompanyToInvestor.setInvestmentCompanyToInvestorCompanyUrl(url);

        Document doc = CrawlerUtil.getDocument(url);
        Elements eli = doc.select("div.team.clearfix.look").select("ul.clearfix").select("li");
        eli.forEach(e1->{
            Investor investor = new Investor();
            Elements eImg = e1.select("div.team-img");
            //投资人所在url
            String investorUrl = "http://cyzone.cn" + eImg.select("a").attr("href");
            investor.setInvestorUrl(investorUrl);
            investmentCompanyToInvestor.setInvestmentCompanyToInvestorInvestorUrl(investorUrl);
            //投资人所在公司名称
            investor.setInvestorInvestmentCompanyName(eli.select("li.organize").select("h1").text());
            //投资人头像
            String investorImgUrl = eImg.select("img").attr("src");
            investor.setInvestorPicture(investorImgUrl);
            Elements eInfo= e1.select("div.team-info");
            //投资人名字
            investor.setInvestorName(eInfo.select("p.name").text());
            //投资人职位
            investor.setInvestorPosition(eInfo.select("p.job").text());

            Document docUrl = CrawlerUtil.getDocument(investorUrl);
            Elements eInvestInfo = docUrl.select("div.invest").select("div.info");
            if(eInvestInfo !=null){
                for(int i = 0; i < eInvestInfo.size(); i++){
                    if(i == 0){
                        StringBuilder stringBuilder = new StringBuilder();
                        //投资人关注领域
                        eInvestInfo.get(i).select("span.trade").forEach(e21-> stringBuilder.append(e21.text() + " "));
                        investor.setInvestorDirection(stringBuilder.toString().trim());
                    }else if(i == 1){
                        //投资人投资阶段
                        investor.setInvestorFinanceName(eInvestInfo.get(i).select("span.turn").text());
                    }else if(i == 2){
                        //投资人单笔投资
                        investor.setInvestorOnceInvestment(eInvestInfo.get(i).text().substring(5).trim());
                    }else if(i == 3){
                        //投资人常驻城市
                        investor.setInvestorLocation(eInvestInfo.get(i).select("span.city").text());
                    }
                }
            }
            if(docUrl.select("div.people-info-box").text() != null){
                //投资人简介
                investor.setInvestorInfo(docUrl.select("div.people-info-box").text());
            }

            InvestorJob investorJob = new InvestorJob();
            Elements eJob = docUrl.select("div.record").select("div.r-bar.clearfix");
            if(eJob != null){
                eJob.forEach(e2->{
                    //投资人工作经历单位图片
                    investorJob.setInvestorJobPicture(e2.select("div.rb-left").select("img").attr("src"));
                    //投资人工作经历单位名称
                    investorJob.setInvestorJobName(e2.select("div.rb-right").select("span.com").select("a").text());
                    //投资人工作经历单位任职职位
                    investorJob.setInvestorJobPosition(e2.select("div.rb-right").select("span.job").text());
                    //投资人url
                    investorJob.setInvestorJobInvestorUrl(investor.getInvestorUrl());
                    //投资人名称
                    investorJob.setInvestorJobInvestorName(investor.getInvestorName());
                });

            }
            DataBaseUtil dataBaseUtil = new DataBaseUtil();
            String investorSql = "insert into cyzone_investor(investor_name,investor_position,investor_info," +
                    "investor_direction,investor_finance_name,investor_once_investment,investor_location," +
                    "investor_picture,investor_url,investor_investment_company_name) values(?,?,?,?,?,?,?,?,?,?)";
            int result = dataBaseUtil.addOne(investorSql,investor);
            if(result == 1){
                String investmentCompanyToInvestorSql = "insert into cyzone_investment_company_to_investor(" +
                        "investment_company_to_investor_company_url,investment_company_to_investor_investor_url) values(?,?)";
                dataBaseUtil.addOne(investmentCompanyToInvestorSql,investmentCompanyToInvestor);
                String investorJobSql = "insert into cyzone_investor_job(investor_job_name,investor_job_position," +
                        "investor_job_picture,investor_job_investor_name,investor_job_investor_url) values(?,?,?,?,?)";
                dataBaseUtil.addOne(investorJobSql,investorJob);
            }
        });
    }

    /**
     * 获取投资机构投资案例,输入投资机构所在url
     * @param url
     */
    public void getOrganize(String url){
        Document doc = CrawlerUtil.getDocument(url);

        Elements eTr = doc.select("table.limit-8").select("tr");
        ArrayList<Organize> arrayList = new ArrayList<>();
        if(eTr == null){
            return;
        }
        for(int i = 1; i < eTr.size(); i++){
            Organize organize = new Organize();
            //投资案例所在机构名称
            organize.setOrganizeInvestmentCompanyName(doc.select("li.organize").text());
            //投资案例所在机构url
            organize.setOrganizeInvestmentCompanyUrl(url);
            Elements eTd = eTr.get(i).select("td");
            for(int j = 0; j < eTd.size(); j++){
                if(j == 0){
                    //获取写入案例公司名称
                    String organizeName = eTd.get(j).select("a").text().trim();
                    if(organizeName == null || organizeName.equals("")) break;
                    organize.setOrganizeName(organizeName);

                }else if(j == 1){
                    //案例公司获投金额
                    organize.setOrganizeMoney(eTd.get(j).text());
                }else if(j == 2){
                    //案例公司服务行业
                    organize.setOrganizeServiceType(eTd.get(j).text());
                }else if(j == 3){
                    //案例公司融资阶段
                    organize.setOrganizeFinanceName(eTd.get(j).text());
                }else if(j == 4){
                    //成立时间
                    String date = eTd.get(j).text();
                    if(date != null && !date.equals("—") && !date.equals("不明确") && !date.equals("不清楚") && !date.equals("未公开")) {
                        try {
                            organize.setOrganizeDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if(organize.getOrganizeName() == null) continue;
            arrayList.add(organize);
        }
        String organizeSql = "insert into cyzone_organize(organize_name,organize_money,organize_service_type,organize_finance_name," +
                "organize_date,organize_investment_company_url,organize_investment_company_name) values(?,?,?,?,?,?,?)";
        DataBaseUtil dataBaseUtil = new DataBaseUtil();
        dataBaseUtil.addNewsAll(organizeSql,arrayList);
    }

    /**
     * 输入投资机构所在url，获取投资案例战绩结果，最佳合投伙伴，下一轮最佳合投伙伴，上一轮最佳合投伙伴
     * @param url
     */
    public void getInvestmentResult(String url){
        Document doc = CrawlerUtil.getDocument(url);
        String organizeName = doc.select("li.organize").select("h1").text();
        ArrayList<InvestmentBestPartner> arrayListBestPartner = new ArrayList<>();
        ArrayList<InvestmentNextBestPartner> arrayListNextBestPartner = new ArrayList<>();
        ArrayList<InvestmentPreviousBestPartner> arrayListPreviousBestPartner = new ArrayList<>();
        Elements elements = doc.select("div.ir-all.clearfix");
        if(elements != null){
            Elements eBar = doc.select("div.ir-bar");
            if(eBar != null){
                InvestmentResult investmentResult = new InvestmentResult();
                //投资公司名字
                investmentResult.setInvestmentResultCompanyName(organizeName);
                //投资公司url
                investmentResult.setInvestmentResultCompanyUrl(url);
                for(int i = 0; i < eBar.size(); i++){
                    Elements e = eBar.get(i).select("div.detail").select("div.d-bar.clearfix");
                    if(i == 0){
                        //已披露投资事件数
                        investmentResult.setInvestmentResultInvestmentKnowNum(
                                Integer.parseInt(eBar.get(i).select("div.num.num1").text()));
                        if(investmentResult.getInvestmentResultInvestmentKnowNum() == 0){
                            return;
                        }
                        e.forEach(e1->{
                            //最佳合投伙伴
                            InvestmentBestPartner investmentBestPartner = new InvestmentBestPartner();
                            investmentBestPartner.setInvestmentBestPartnerCompanyName(organizeName);
                            investmentBestPartner.setInvestmentBestPartnerCompanyUrl(url);
                            String bestUrl = e1.select("div.db-left").select("a").attr("href").trim();
                            if(bestUrl != null && !bestUrl.equals("")){
                                investmentBestPartner.setInvestmentBestPartnerPartnerCompanyUrl(
                                        "http://www.cyzone.cn" + bestUrl);
                            }

                            //最佳合投伙伴机构名字
                            investmentBestPartner.setInvestmentBestPartnerPartnerCompanyName(
                                    e1.select("div.db-right").select("div.com").text());
                            //合作次数
                            String num = e1.select("div.db-right").select("div.times").text();
                            num = num.substring(0,num.length() - 1);
                            investmentBestPartner.setInvestmentBestPartnerNum(Integer.parseInt(num));
                            arrayListBestPartner.add(investmentBestPartner);
                        });
                    }else if(i == 1){
                        //走到下一轮公司数
                        investmentResult.setInvestmentResultNextCompanyNum(Integer.parseInt(eBar.get(i).select("div.num.num2").text()));
                        e.forEach(e1->{
                            InvestmentNextBestPartner investmentNextBestPartner = new InvestmentNextBestPartner();
                            investmentNextBestPartner.setInvestmentNextBestPartnerCompanyName(organizeName);
                            investmentNextBestPartner.setInvestmentNextBestPartnerCompanyUrl(url);
                            String bestUrl = e1.select("div.db-left").select("a").attr("href").trim();
                            if(bestUrl != null && !bestUrl.equals("")){
                                investmentNextBestPartner.setInvestmentNextBestPartnerPartnerCompanyUrl(
                                        "http://www.cyzone.cn" + bestUrl);
                            }

                            //下一轮最佳合投伙伴机构名字
                            investmentNextBestPartner.setInvestmentNextBestPartnerPartnerCompanyName(
                                    e1.select("div.db-right").select("div.com").text());
                            //合作次数
                            String num = e1.select("div.db-right").select("div.times").text();
                            num = num.substring(0,num.length() - 1);
                            investmentNextBestPartner.setInvestmentNextBestPartnerNum(Integer.parseInt(num));
                            arrayListNextBestPartner.add(investmentNextBestPartner);
                        });
                    }else if(i == 2){
                        //连续投资公司数
                        investmentResult.setInvestmentResultContinuousInvestNum(Integer.parseInt(eBar.get(i).select("div.num.num3").text()));


                        
                        e.forEach(e1->{
                            InvestmentPreviousBestPartner investmentPreviousBestPartner = new InvestmentPreviousBestPartner();
                            investmentPreviousBestPartner.setInvestmentPreviousBestPartnerCompanyName(organizeName);
                            investmentPreviousBestPartner.setInvestmentPreviousBestPartnerCompanyUrl(url);
                            String bestUrl = e1.select("div.db-left").select("a").attr("href").trim();
                            if(bestUrl != null && !bestUrl.equals("")){
                                investmentPreviousBestPartner.setInvestmentPreviousBestPartnerPartnerCompanyUrl(
                                        "http://www.cyzone.cn" + bestUrl);
                            }

                            //上一轮最佳合投伙伴机构名字
                            investmentPreviousBestPartner.setInvestmentPreviousBestPartnerPartnerCompanyName(
                                    e1.select("div.db-right").select("div.com").text());
                            //合作次数
                            String num = e1.select("div.db-right").select("div.times").text();
                            num = num.substring(0,num.length() - 1);
                            investmentPreviousBestPartner.setInvestmentPreviousBestPartnerNum(Integer.parseInt(num));
                            arrayListPreviousBestPartner.add(investmentPreviousBestPartner);
                        });
                    }
                }
                try {
                    investmentResult.setInvestmentCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String investmentResultSql = "insert into cyzone_investment_result(investment_result_company_name," +
                        "investment_result_company_url,investment_result_investment_know_num,investment_result_next_company_num," +
                        "investment_result_continuous_invest_num,investment_create_date) values(?,?,?,?,?,?)";
                String investmentBestPartnerSql = "insert into cyzone_investment_best_partner(investment_best_partner_company_name,"+
                        "investment_best_partner_company_url,investment_best_partner_partner_company_name," +
                        "investment_best_partner_partner_company_url,investment_best_partner_num) values(?,?,?,?,?)";
                String investmentNextBestPartnerSql = "insert into cyzone_investment_next_best_partner(investment_next_best_partner_company_name," +
                        "investment_next_best_partner_company_url,investment_next_best_partner_partner_company_name," +
                        "investment_next_best_partner_partner_company_url,investment_next_best_partner_num) values(?,?,?,?,?)";
                String investmentPreviousBestPartnerSql = "insert into cyzone_investment_previous_best_partner(investment_previous_best_partner_company_name," +
                        "investment_previous_best_partner_company_url,investment_previous_best_partner_partner_company_name," +
                        "investment_previous_best_partner_partner_company_url,investment_previous_best_partner_num) values(?,?,?,?,?)";
                DataBaseUtil dataBaseUtil = new DataBaseUtil();
                dataBaseUtil.addOne(investmentResultSql,investmentResult);
                dataBaseUtil.addNewsAll(investmentBestPartnerSql,arrayListBestPartner);
                dataBaseUtil.addNewsAll(investmentNextBestPartnerSql,arrayListNextBestPartner);
                dataBaseUtil.addNewsAll(investmentPreviousBestPartnerSql,arrayListPreviousBestPartner);
            }
        }
    }
}
