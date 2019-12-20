package cn.cyzone;

import cn.cyzone.service.GetCyzoneCompanyAll;
import cn.cyzone.service.GetCyzoneInvestmentCompanyAll;
import cn.cyzone.service.impl.GetCyzoneCompanyAllImpl;
import cn.cyzone.service.impl.GetCyzoneInvestmentCompanyAllImpl;
import java.util.concurrent.CountDownLatch;

/**
 * 代码注入魔法，请勿改动
 */
public class MainApplication {
    private static CountDownLatch c1 = new CountDownLatch(1);
    private static CountDownLatch c2 = new CountDownLatch(1);
    private static GetCyzoneInvestmentCompanyAll getCyzoneInvestmentCompanyAll = new GetCyzoneInvestmentCompanyAllImpl();
    private static GetCyzoneCompanyAll getCyzoneCompanyAll = new GetCyzoneCompanyAllImpl();

    public static void main(String[] args) throws InterruptedException {
        runFirst();
        runSecond();
    }

    private static void runSecond() throws InterruptedException {
        c1.await();
        //获取自然人信息
        getCyzoneCompanyAll.getEntrepreneurRun();
        //获取融资信息
        getCyzoneCompanyAll.getFinanceRun();
        //获取投资人信息
        getCyzoneInvestmentCompanyAll.getInvestorRun();
        //获取投资机构投资结果
        getCyzoneInvestmentCompanyAll.getInvestmentResult();
        //获取投资机构投资案例
        getCyzoneInvestmentCompanyAll.getOrganize();
    }

    private static void runFirst(){
        //获取公司信息
        getCyzoneCompanyAll.getCompanyRun();
        //获取投资机构信息
        getCyzoneInvestmentCompanyAll.getInvestmentCompanyRun();
        c1.countDown();
    }
}
