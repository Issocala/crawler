package cn.cyzone.entity;

import java.util.Date;

//投资机构
public class InvestmentCompany {
    private int investmentCompanyId;    //唯一自增主键
    private String investmentCompanyName;   //投资机构名称
    private String investmentCompanyInfo;   //投资机构简介
    private String investmentCompanyUrl;    //投资机构所在rul
    private String investmentCompanyPicture;       //投资机构图标
    private String investmentCompanyOfficialWebsite;    //投资机构官网
    private int investmentCompanyInvestorNum;    //投资案例总数
    private String investmentCompanyInvestorLike;   //投资偏好
    private String investmentCompanyInvestorDirection;  //投资领域
    private Date investmentCompanyCreateDate;   //投资机构成立时间

    public int getInvestmentCompanyId() {
        return investmentCompanyId;
    }

    public void setInvestmentCompanyId(int investmentCompanyId) {
        this.investmentCompanyId = investmentCompanyId;
    }

    public String getInvestmentCompanyName() {
        return investmentCompanyName;
    }

    public void setInvestmentCompanyName(String investmentCompanyName) {
        this.investmentCompanyName = investmentCompanyName;
    }

    public String getInvestmentCompanyInfo() {
        return investmentCompanyInfo;
    }

    public void setInvestmentCompanyInfo(String investmentCompanyInfo) {
        this.investmentCompanyInfo = investmentCompanyInfo;
    }

    public String getInvestmentCompanyUrl() {
        return investmentCompanyUrl;
    }

    public void setInvestmentCompanyUrl(String investmentCompanyUrl) {
        this.investmentCompanyUrl = investmentCompanyUrl;
    }

    public String getInvestmentCompanyPicture() {
        return investmentCompanyPicture;
    }

    public void setInvestmentCompanyPicture(String investmentCompanyPicture) {
        this.investmentCompanyPicture = investmentCompanyPicture;
    }

    public String getInvestmentCompanyOfficialWebsite() {
        return investmentCompanyOfficialWebsite;
    }

    public void setInvestmentCompanyOfficialWebsite(String investmentCompanyOfficialWebsite) {
        this.investmentCompanyOfficialWebsite = investmentCompanyOfficialWebsite;
    }

    public int getInvestmentCompanyInvestorNum() {
        return investmentCompanyInvestorNum;
    }

    public void setInvestmentCompanyInvestorNum(int investmentCompanyInvestorNum) {
        this.investmentCompanyInvestorNum = investmentCompanyInvestorNum;
    }

    public String getInvestmentCompanyInvestorLike() {
        return investmentCompanyInvestorLike;
    }

    public void setInvestmentCompanyInvestorLike(String investmentCompanyInvestorLike) {
        this.investmentCompanyInvestorLike = investmentCompanyInvestorLike;
    }

    public String getInvestmentCompanyInvestorDirection() {
        return investmentCompanyInvestorDirection;
    }

    public void setInvestmentCompanyInvestorDirection(String investmentCompanyInvestorDirection) {
        this.investmentCompanyInvestorDirection = investmentCompanyInvestorDirection;
    }

    public Date getInvestmentCompanyCreateDate() {
        return investmentCompanyCreateDate;
    }

    public void setInvestmentCompanyCreateDate(Date investmentCompanyCreateDate) {
        this.investmentCompanyCreateDate = investmentCompanyCreateDate;
    }

    @Override
    public String toString() {
        return "InvestmentCompany{" +
                "investmentCompanyId=" + investmentCompanyId +
                ", investmentCompanyName='" + investmentCompanyName + '\'' +
                ", investmentCompanyInfo='" + investmentCompanyInfo + '\'' +
                ", investmentCompanyUrl='" + investmentCompanyUrl + '\'' +
                ", investmentCompanyPicture='" + investmentCompanyPicture + '\'' +
                ", investmentCompanyOfficialWebsite='" + investmentCompanyOfficialWebsite + '\'' +
                ", investmentCompanyInvestorNum=" + investmentCompanyInvestorNum +
                ", investmentCompanyInvestorLike='" + investmentCompanyInvestorLike + '\'' +
                ", investmentCompanyInvestorDirection='" + investmentCompanyInvestorDirection + '\'' +
                ", investmentCompanyCreateDate=" + investmentCompanyCreateDate +
                '}';
    }
}
