package cn.cyzone.service;

public interface GetCyzoneCompanyAll {

    /**
     * 执行此方法自动爬取创投全部信息
     */
    void getCompanyRun();


    /**
     * 执行此方法获取全部自然人信息
     */
    void getEntrepreneurRun();

    /**
     * 执行此方法获取全部公司融资信息
     */
    void getFinanceRun();
}
