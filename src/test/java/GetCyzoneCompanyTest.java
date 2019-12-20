import cn.cyzone.service.impl.GetCyzoneCompanyImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class GetCyzoneCompanyTest {
    Logger logger = LoggerFactory.getLogger(GetCyzoneCompanyTest.class);
    GetCyzoneCompanyImpl getCyzoneCompanyImpl = new GetCyzoneCompanyImpl();
    @Test
    public void getEntrepreneur(){
        getCyzoneCompanyImpl.getEntrepreneur("http://www.cyzone.cn/company/1513586.html");
    }
    @Test
    public void getFinance(){
        getCyzoneCompanyImpl.getFinance("http://www.cyzone.cn/company/1321846.html");
    }
    @Test
    public void getCompanyOneDo(){
        getCyzoneCompanyImpl.getDataCompanyOneDo("http://data.cyzone.cn/company/list-0-0-0-1-1/0");
    }
}
