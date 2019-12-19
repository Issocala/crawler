package cn.cyzone.entity;

import java.util.Date;
//投资机构投资案例
public class Organize {

    private int organizeId; //唯一自增主键
    private String organizeName;    //案例公司名称
    private String organizeMoney;   //获投金额
    private String organizeServiceType; //服务行业
    private String organizeFinanceName; //融资阶段
    private Date organizeDate;  //投资时间
    private String organizeInvestmentCompanyUrl;    //投资机构所在url
    private String organizeInvestmentCompanyName;   //投资机构名称

    public int getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(int organizeId) {
        this.organizeId = organizeId;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }

    public String getOrganizeMoney() {
        return organizeMoney;
    }

    public void setOrganizeMoney(String organizeMoney) {
        this.organizeMoney = organizeMoney;
    }

    public String getOrganizeServiceType() {
        return organizeServiceType;
    }

    public void setOrganizeServiceType(String organizeServiceType) {
        this.organizeServiceType = organizeServiceType;
    }

    public String getOrganizeFinanceName() {
        return organizeFinanceName;
    }

    public void setOrganizeFinanceName(String organizeFinanceName) {
        this.organizeFinanceName = organizeFinanceName;
    }

    public Date getOrganizeDate() {
        return organizeDate;
    }

    public void setOrganizeDate(Date organizeDate) {
        this.organizeDate = organizeDate;
    }

    public String getOrganizeInvestmentCompanyUrl() {
        return organizeInvestmentCompanyUrl;
    }

    public void setOrganizeInvestmentCompanyUrl(String organizeInvestmentCompanyUrl) {
        this.organizeInvestmentCompanyUrl = organizeInvestmentCompanyUrl;
    }

    public String getOrganizeInvestmentCompanyName() {
        return organizeInvestmentCompanyName;
    }

    public void setOrganizeInvestmentCompanyName(String organizeInvestmentCompanyName) {
        this.organizeInvestmentCompanyName = organizeInvestmentCompanyName;
    }

    @Override
    public String toString() {
        return "Organize{" +
                "organizeId=" + organizeId +
                ", organizeName='" + organizeName + '\'' +
                ", organizeMoney='" + organizeMoney + '\'' +
                ", organizeServiceType='" + organizeServiceType + '\'' +
                ", organizeFinanceName='" + organizeFinanceName + '\'' +
                ", organizeDate=" + organizeDate +
                ", organizeInvestmentCompanyUrl='" + organizeInvestmentCompanyUrl + '\'' +
                ", organizeInvestmentCompanyName='" + organizeInvestmentCompanyName + '\'' +
                '}';
    }
}
