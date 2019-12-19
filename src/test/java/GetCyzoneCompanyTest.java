import cn.cyzone.service.GetCyzoneCompany;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class GetCyzoneCompanyTest {
    Logger logger = LoggerFactory.getLogger(GetCyzoneCompanyTest.class);
    GetCyzoneCompany getCyzoneCompany = new GetCyzoneCompany();
    @Test
    public void getEntrepreneur(){
        getCyzoneCompany.getEntrepreneur("http://www.cyzone.cn/company/1513586.html");
    }
    @Test
    public void getFinance(){
        getCyzoneCompany.getFinance("http://www.cyzone.cn/company/1321846.html");
    }
}
