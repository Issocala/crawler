import cn.cyzone.service.impl.GetCyzoneCompanyImpl;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestGetCyzoneCompany {
    GetCyzoneCompanyImpl getCyzoneCompanyImpl = new GetCyzoneCompanyImpl();
    @Test
    public void getPageTotal() throws IOException {
        String url = "http://www.cyzone.cn/company/list-0-0-0-1-1/";
        String charset = "utf-8";
//        getChuangTou.pageTotal(url);
    }
}
