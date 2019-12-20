package cn.cyzone;


import cn.cyzone.service.GetCyzoneCompanyAll;
import cn.cyzone.service.GetCyzoneInvestmentCompanyAll;
import cn.cyzone.service.impl.GetCyzoneCompanyAllImpl;
import cn.cyzone.service.impl.GetCyzoneInvestmentCompanyAllImpl;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/**
 * 代码注入魔法，请勿改动
 */
public class StartApplication {
    public static void main(String[] args){
        CountDownLatch c1 = new CountDownLatch(1);
        Run();

    }
    public static void Run(){
        GetCyzoneCompanyAll getCyzoneCompanyAll = new GetCyzoneCompanyAllImpl();
        //获取公司信息
        getCyzoneCompanyAll.getCompanyRun();
        //获取自然人信息
        getCyzoneCompanyAll.getEntrepreneurRun();


        GetCyzoneInvestmentCompanyAll getCyzoneInvestmentCompanyAll = new GetCyzoneInvestmentCompanyAllImpl();
        //获取投资机构信息
        getCyzoneInvestmentCompanyAll.getInvestmentCompanyRun();
        //获取投资人信息
        getCyzoneInvestmentCompanyAll.getInvestorRun();
        //获取投资机构投资结果
        getCyzoneInvestmentCompanyAll.getInvestmentResult();
        //获取投资机构投资案例
        getCyzoneInvestmentCompanyAll.getOrganize();
    }
}
