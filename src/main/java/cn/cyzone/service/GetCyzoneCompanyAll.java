package cn.cyzone.service;

import cn.cyzone.util.CrawlerUtil;
import cn.cyzone.util.DataBaseUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetCyzoneCompanyAll {
    /**
     * 执行此方法自动爬取创投全部信息
     */
    public void getCompanyRun(){
        GetCyzoneCompany getCyzoneCompany = new GetCyzoneCompany();
        List<String> list = new LinkedList<>();
        String url = "http://www.cyzone.cn/company/list-0-0-0-1-1/0";
        int total = CrawlerUtil.pageTotal(url);
        for(int i = 1; i < total; i++){
            list.add("http://www.cyzone.cn/company/list-0-0-0-1-" + i +"/0");
        }
        ExecutorService executors = Executors.newFixedThreadPool(16);
        for(int i = 0; i < list.size(); i++){
            int finalI = i;
            executors.execute((Runnable)()->{
                getCyzoneCompany.getDataCompanyDo(list.get(finalI));
            });
        }
        executors.shutdown();
    }

    /**
     * 执行此方法获取全部自然人信息
     */
    public void getEntrepreneurRun(){
        GetCyzoneCompany getCyzoneCompany = new GetCyzoneCompany();
        DataBaseUtil dataBaseUtil = new DataBaseUtil();
        List<String> list = dataBaseUtil.getCompanyUrlAll("select company_url from cyzone_company");
        ExecutorService executors = Executors.newFixedThreadPool(16);
        for(int i = 0; i < list.size(); i++){
            int finalI = i;
            executors.execute((Runnable)()->{
                getCyzoneCompany.getEntrepreneur(list.get(finalI));
            });
        }
        executors.shutdown();
    }

    /**
     * 执行此方法获取全部公司融资信息
     */
    public void getFinanceRun(){
        GetCyzoneCompany getCyzoneCompany = new GetCyzoneCompany();
        DataBaseUtil dataBaseUtil = new DataBaseUtil();
        List<String> list = dataBaseUtil.getCompanyUrlAll("select company_url from cyzone_company");
        ExecutorService executors = Executors.newFixedThreadPool(16);
        for(int i = 0; i < list.size(); i++){
            int finalI = i;
            executors.execute((Runnable)()->{
                getCyzoneCompany.getFinance(list.get(finalI));
            });
        }
        executors.shutdown();
    }
}
