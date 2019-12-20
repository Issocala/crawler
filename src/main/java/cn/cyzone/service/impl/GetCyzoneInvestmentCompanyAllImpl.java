package cn.cyzone.service.impl;

import cn.cyzone.service.GetCyzoneInvestmentCompanyAll;
import cn.cyzone.util.CrawlerUtil;
import cn.cyzone.dao.DataBaseUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetCyzoneInvestmentCompanyAllImpl implements GetCyzoneInvestmentCompanyAll {
    GetCyzoneInvestmentCompanyImpl getCyzoneInvestmentCompanyImpl = new GetCyzoneInvestmentCompanyImpl();
    /**
     * 获取全部投资机构的信息
     */
    public void getInvestmentCompanyRun(){
        List<String> list = new LinkedList<>();
        String url = "http://www.cyzone.cn/capital/list-0-1-3/";
        int total = CrawlerUtil.pageTotal(url);
        for(int i = 1; i < total; i++){
            list.add("http://www.cyzone.cn/capital/list-0-" + i +"-3/");
        }
        ExecutorService executors = Executors.newFixedThreadPool(8);
        for(int i = 0; i < list.size(); i++){
            int finalI = i;
            executors.execute((Runnable)()->{
                getCyzoneInvestmentCompanyImpl.getInvestmentCompany(list.get(finalI));
            });
        }
        executors.shutdown();
    }

    /**
     * 获取全部投资人信息
     */
    public void getInvestorRun(){
        DataBaseUtil dataBaseUtil = new DataBaseUtil();
        List<String> list = dataBaseUtil.getCompanyUrlAll("select investment_company_url from cyzone_investment_company");
        ExecutorService executors = Executors.newFixedThreadPool(8);
        for(int i = 0; i < list.size(); i++){
            int finalI = i;
            executors.execute((Runnable)()->{
                getCyzoneInvestmentCompanyImpl.getInvestor(list.get(finalI));
            });
        }
        executors.shutdown();
    }

    /**
     * 获取全部投资机构投资结果
     */
    public void getInvestmentResult(){
        DataBaseUtil dataBaseUtil = new DataBaseUtil();
        List<String> list = dataBaseUtil.getCompanyUrlAll("select investment_company_url from cyzone_investment_company");
        ExecutorService executors = Executors.newFixedThreadPool(8);
        for(int i = 0; i < list.size(); i++){
            int finalI = i;
            executors.execute((Runnable)()->{
                getCyzoneInvestmentCompanyImpl.getInvestmentResult(list.get(finalI));
            });
        }
        executors.shutdown();
    }

    /**
     * 获取全部机构的投资案例
     */
    public void getOrganize(){
        DataBaseUtil dataBaseUtil = new DataBaseUtil();
        List<String> list = dataBaseUtil.getCompanyUrlAll("select investment_company_url from cyzone_investment_company");
        ExecutorService executors = Executors.newFixedThreadPool(8);
        for(int i = 0; i < list.size(); i++){
            int finalI = i;
            executors.execute((Runnable)()->{
                getCyzoneInvestmentCompanyImpl.getOrganize(list.get(finalI));
            });
        }
    }
}
