import cn.cyzone.service.GetCyzoneInvestmentCompany;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetCyzoneInvestmentCompanyTest {
    GetCyzoneInvestmentCompany getCyzoneInvestmentCompany = new GetCyzoneInvestmentCompany();
    Logger logger = LoggerFactory.getLogger(GetCyzoneInvestmentCompanyTest.class);
    @Test
    public void getInvestmentCompanyTest(){
        logger.debug("..........开始测试");
        String url = "http://www.cyzone.cn/capital/list-0-1-3/";
        getCyzoneInvestmentCompany.getInvestmentCompany(url);
        logger.debug("..........测试完成");
    }

    @Test
    public void getInvestorTest(){
        logger.debug("..........开始测试");
        String url = "http://www.cyzone.cn/capital/1393213.html";
        getCyzoneInvestmentCompany.getInvestor(url);
        logger.debug("..........测试完成");

    }
    @Test
    public void getOrganizeTest(){
        logger.debug("..........开始测试");
        String url = "http://www.cyzone.cn/capital/1393213.html";
        getCyzoneInvestmentCompany.getOrganize(url);
        logger.debug("..........测试完成");
    }

    @Test
    public void getInvestmentResultTest(){
        logger.debug("..........开始测试");
        String url = "http://www.cyzone.cn/capital/1393213.html";
        getCyzoneInvestmentCompany.getInvestmentResult(url);
        logger.debug("..........测试完成");
    }
}
