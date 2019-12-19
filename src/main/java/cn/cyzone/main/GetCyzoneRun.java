package cn.cyzone.main;


import cn.cyzone.service.GetCyzoneCompanyAll;
import cn.cyzone.service.GetCyzoneInvestmentCompany;
import cn.cyzone.service.GetCyzoneInvestmentCompanyAll;

/**
 * 代码注入魔法，请勿改动
 */
public class GetCyzoneRun {
    public static void main(String[] args){
        GetCyzoneCompanyAll getCyzoneCompanyAll = new GetCyzoneCompanyAll();
//        //获取公司融资阶段
        getCyzoneCompanyAll.getFinanceRun();
////        获取公司信息
////        getCyzoneCompanyAll.getCompanyRun();
//        //获取自然人信息
//        getCyzoneCompanyAll.getEntrepreneurRun();
//        GetCyzoneInvestmentCompanyAll getCyzoneInvestmentCompanyAll = new GetCyzoneInvestmentCompanyAll();
        //获取投资机构信息
//        getCyzoneInvestmentCompanyAll.getInvestmentCompanyRun();
        //获取投资人信息
//        getCyzoneInvestmentCompanyAll.getInvestorRun();
        //获取投资机构投资结果
//        getCyzoneInvestmentCompanyAll.getInvestmentRelust();
        //获取投资机构投资案例
//        getCyzoneInvestmentCompanyAll.getOrganize();

    }
//
//
//
//
//
//
//    String path = "/home/ly/testPath2.txt";
//    String preUrl = "http://www.cyzone.cn/company/list-0-0-0-1-3684/0";
//        String nextUrl = CarwlerUtil.getUrlFromFile(path);
//        while (!preUrl.equals(nextUrl)){
//            preUrl = nextUrl;
//            nextUrl = getChuangTou.getDataCompanyDo(nextUrl);
//            CarwlerUtil.setUrlToFile(path,nextUrl);
//        }
}
