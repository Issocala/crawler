package cn.cyzone.service.impl;

import cn.cyzone.service.GetCyzoneCompanyAll;
import cn.cyzone.util.CrawlerUtil;
import cn.cyzone.dao.DataBaseUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetCyzoneCompanyAllImpl implements GetCyzoneCompanyAll {
    /**
     * 执行此方法自动爬取创投全部信息
     */
    public void getCompanyRun(){
        GetCyzoneCompanyImpl getCyzoneCompanyImpl = new GetCyzoneCompanyImpl();
        List<String> list = new LinkedList<>();
        String url = "http://www.cyzone.cn/company/list-0-0-0-1-1/0";
        int total = CrawlerUtil.pageTotal(url);
        for(int i = 1; i < total; i++){
            list.add("http://www.cyzone.cn/company/list-0-0-0-1-" + i +"/0");
        }
        ExecutorService executors = Executors.newFixedThreadPool(8);
        for(int i = 0; i < list.size(); i++){
            int finalI = i;
            executors.execute((Runnable)()->{
                getCyzoneCompanyImpl.getDataCompanyDo(list.get(finalI));
            });
        }
        executors.shutdown();
    }

    /**
     * 执行此方法获取全部自然人信息
     */
    public void getEntrepreneurRun(){
        GetCyzoneCompanyImpl getCyzoneCompanyImpl = new GetCyzoneCompanyImpl();
        DataBaseUtil dataBaseUtil = new DataBaseUtil();
        List<String> list = dataBaseUtil.getCompanyUrlAll("select company_url from cyzone_company");
        ExecutorService executors = Executors.newFixedThreadPool(8);
        for(int i = 0; i < list.size(); i++){
            int finalI = i;
            executors.execute((Runnable)()->{
                getCyzoneCompanyImpl.getEntrepreneur(list.get(finalI));
            });
        }
        executors.shutdown();
    }

    /**
     * 执行此方法获取全部公司融资信息
     */
    public void getFinanceRun(){
        GetCyzoneCompanyImpl getCyzoneCompanyImpl = new GetCyzoneCompanyImpl();
        DataBaseUtil dataBaseUtil = new DataBaseUtil();
        List<String> list = dataBaseUtil.getCompanyUrlAll("select company_url from cyzone_company");
        ExecutorService executors = Executors.newFixedThreadPool(8);
        for(int i = 0; i < list.size(); i++){
            int finalI = i;
            executors.execute((Runnable)()->{
                getCyzoneCompanyImpl.getFinance(list.get(finalI));
            });
        }
        executors.shutdown();
    }
}
