import cn.cyzone.service.impl.GetCyzoneInvestmentCompanyImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetCyzoneInvestmentCompanyImplTest {
    GetCyzoneInvestmentCompanyImpl getCyzoneInvestmentCompanyImpl = new GetCyzoneInvestmentCompanyImpl();
    Logger logger = LoggerFactory.getLogger(GetCyzoneInvestmentCompanyImplTest.class);
    @Test
    public void getInvestmentCompanyTest(){
        logger.debug("..........开始测试");
        String url = "http://www.cyzone.cn/capital/list-0-1-3/";
        getCyzoneInvestmentCompanyImpl.getInvestmentCompany(url);
        logger.debug("..........测试完成");
    }

    @Test
    public void getInvestorTest(){
        logger.debug("..........开始测试");
        String url = "http://www.cyzone.cn/capital/1393213.html";
        getCyzoneInvestmentCompanyImpl.getInvestor(url);
        logger.debug("..........测试完成");

    }
    @Test
    public void getOrganizeTest(){
        logger.debug("..........开始测试");
        String url = "http://www.cyzone.cn/capital/1393213.html";
        getCyzoneInvestmentCompanyImpl.getOrganize(url);
        logger.debug("..........测试完成");
    }

    @Test
    public void getInvestmentResultTest(){
        logger.debug("..........开始测试");
        String url = "http://www.cyzone.cn/capital/1393213.html";
        getCyzoneInvestmentCompanyImpl.getInvestmentResult(url);
        logger.debug("..........测试完成");
    }
}
