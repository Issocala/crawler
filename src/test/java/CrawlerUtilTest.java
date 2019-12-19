import cn.cyzone.entity.Finance;
import cn.cyzone.util.CrawlerUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CrawlerUtilTest {
    CrawlerUtil crawlerUtil = new CrawlerUtil();
    Logger logger = LoggerFactory.getLogger(CrawlerUtil.class);
    @Test
    public void getUrlFromFile(){
        logger.debug("测试获取最后一行url");
//        String s = carwlerUtil.readLastLine(new File("/home/ly/testPath.txt"),"utf-8");
        String s = CrawlerUtil.getUrlFromFile("/home/ly/testPath.txt");
        System.out.println(s);
        logger.debug(s);
    }

    @Test
    public void setUrlToFile(){
        logger.debug("测试写入数据");
        CrawlerUtil.setUrlToFile("/home/ly/testPath.txt","http://www.cyzone.cn/company/list-0-0-0-1-3/0");
        logger.debug("测试写入正常");
    }
    @Test
    public void getNextPage(){
        StringBuffer stringBuffer = new StringBuffer();
        Document doc = CrawlerUtil.getDocument("http://www.cyzone.cn/company/list-0-0-0-1-1/0");
        Elements elementsNextUrl = doc.select("#pages");
        Elements elementsNextUrlA = elementsNextUrl.select("a");
        elementsNextUrlA.forEach(enua->{
            if(enua.text().equals("下一页")){
                stringBuffer.append("http://www.cyzone.cn" + enua.attr("href"));
            }
        });
        System.out.println(stringBuffer.toString());
    }
    //获取数据测试
    @Test
    public void getText(){
        Finance finance = new Finance();
        Document doc = CrawlerUtil.getDocument("http://www.cyzone.cn/company/1513617.html");
        Elements elementsTr = doc.select("div.live").select("tr");
        for(int i = 1; i < elementsTr.size(); i++) {
            Elements elementsTd = elementsTr.get(i).select("td");
            for (int j = 0; j < elementsTd.size(); j++) {
                if(j == 0){
                    finance.setFinanceName(elementsTd.get(j).text());
                }else if(j == 1){
                    finance.setFinanceMoney(elementsTd.get(j).text());
                }else if(j == 2){
                    finance.setFinanceInvestmentCompany(elementsTd.get(j).text());
                }else {
                    try {
                        finance.setFinanceDate(new SimpleDateFormat("yyyy-MM-dd").parse(elementsTd.get(j).text()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        String companyFullName = doc.select("li.time").text();
        finance.setFinanceCompanyUrl(companyFullName.substring(5));
    }
    @Test
    public void text(){
        CrawlerUtil crawlerUtil = new CrawlerUtil();
        int i = crawlerUtil.pageTotal("http://www.cyzone.cn/company/list-0-0-0-1-2/0");
    }
}
