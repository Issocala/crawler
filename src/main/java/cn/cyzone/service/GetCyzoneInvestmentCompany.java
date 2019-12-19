package cn.cyzone.service;

public interface GetCyzoneInvestmentCompany {

    /**
     * 获取创投机构首页url，爬取当前页15个机构的基本信息，主要获取每个机构所在url
     * @param url 输入创投机构首页url
     */
    void getInvestmentCompany(String url);

    /**
     * 通过机构所在url，获取机构下投资人信息,一并获取投资人工作经历
     * @param url　
     */
    void getInvestor(String url);

    /**
     * 获取投资机构投资案例,输入投资机构所在url
     * @param url
     */
    public void getOrganize(String url);

    /**
     * 输入投资机构所在url，获取投资案例战绩结果，最佳合投伙伴，下一轮最佳合投伙伴，上一轮最佳合投伙伴
     * @param url
     */
    public void getInvestmentResult(String url);
}
