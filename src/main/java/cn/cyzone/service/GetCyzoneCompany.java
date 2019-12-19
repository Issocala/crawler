package cn.cyzone.service;

public interface GetCyzoneCompany {
    /***
     * 输入url爬取相应的公司基本数据
     * @param url　创业公司首页地址
     * @return
     */
    String getDataCompanyDo(String url);


    /**
     * 获取自然人信息方法
     * @param path 输入公司详细页所在url
     */
    void getEntrepreneur(String path);

    /**
     * 获取融资信息
     * @param path　输入公司详细页所在url
     */
    void getFinance(String path);
}
