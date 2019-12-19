package cn.cyzone.entity;


import java.util.Date;
//创业公司
public class Company {
    private int companyId;  //唯一自增主键
    private String companyName; //公司名称
    private String companyFullName; //公司全称
    private String companyInfo; //公司简单描述
    private String companyDetails;  //公司简介
    private String companyFinance;  //公司融资阶段
    private String companyServerType;   //公司服务类型
    private String companyUrl;  //公司详细页面URL
    private String companyOfficialWebsite;  //公司官网URL
    private String companyLocation; //公司地址
    private String companyPicture;  //公司图标URL
    private Date companyCreateDate; //公司创建时间

    public String getCompanyOfficialWebsite() {
        return companyOfficialWebsite;
    }

    public void setCompanyOfficialWebsite(String companyOfficialWebsite) {
        this.companyOfficialWebsite = companyOfficialWebsite;
    }

    public String getCompanyFullName() {
        return companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    public String getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(String companyDetails) {
        this.companyDetails = companyDetails;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getCompanyPicture() {
        return companyPicture;
    }

    public void setCompanyPicture(String companyPicture) {
        this.companyPicture = companyPicture;
    }

    public int getCompanyId() {
        return companyId;
    }

    public Company setCompanyId(int companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Company setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public Company setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
        return this;
    }

    public String getCompanyFinance() {
        return companyFinance;
    }

    public Company setCompanyFinance(String companyFinance) {
        this.companyFinance = companyFinance;
        return this;
    }

    public String getCompanyServerType() {
        return companyServerType;
    }

    public Company setCompanyServerType(String companyServerType) {
        this.companyServerType = companyServerType;
        return this;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public Company setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
        return this;
    }

    public Date getCompanyCreateDate() {
        return companyCreateDate;
    }

    public Company setCompanyCreateDate(Date companyCreateDate) {
        this.companyCreateDate = companyCreateDate;
        return this;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyFullName='" + companyFullName + '\'' +
                ", companyInfo='" + companyInfo + '\'' +
                ", companyDetails='" + companyDetails + '\'' +
                ", companyFinance='" + companyFinance + '\'' +
                ", companyServerType='" + companyServerType + '\'' +
                ", companyUrl='" + companyUrl + '\'' +
                ", companyOfficialWebsite='" + companyOfficialWebsite + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", companyPicture='" + companyPicture + '\'' +
                ", companyCreateDate=" + companyCreateDate +
                '}';
    }
}
