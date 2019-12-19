package cn.cyzone.entity;
//投资人
public class Investor {
    private int investorId; //唯一自增主键
    private String investorName;    //投资人姓名
    private String investorPosition;    //所在机构职位
    private String investorInfo;    //投资人简介
    private String investorDirection;   //投资人关注领域
    private String investorFinanceName; //投资阶段
    private String investorOnceInvestment;  //单笔投资
    private String investorLocation;    //常驻城市
    private String investorPicture; //投资人头像url
    private String investorUrl; //投资人所在url
    private String investorInvestmentCompanyName;   //投资人所在公司名称

    public int getInvestorId() {
        return investorId;
    }

    public void setInvestorId(int investorId) {
        this.investorId = investorId;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getInvestorPosition() {
        return investorPosition;
    }

    public void setInvestorPosition(String investorPosition) {
        this.investorPosition = investorPosition;
    }

    public String getInvestorInfo() {
        return investorInfo;
    }

    public void setInvestorInfo(String investorInfo) {
        this.investorInfo = investorInfo;
    }

    public String getInvestorDirection() {
        return investorDirection;
    }

    public void setInvestorDirection(String investorDirection) {
        this.investorDirection = investorDirection;
    }

    public String getInvestorFinanceName() {
        return investorFinanceName;
    }

    public void setInvestorFinanceName(String investorFinanceName) {
        this.investorFinanceName = investorFinanceName;
    }

    public String getInvestorOnceInvestment() {
        return investorOnceInvestment;
    }

    public void setInvestorOnceInvestment(String investorOnceInvestment) {
        this.investorOnceInvestment = investorOnceInvestment;
    }

    public String getInvestorLocation() {
        return investorLocation;
    }

    public void setInvestorLocation(String investorLocation) {
        this.investorLocation = investorLocation;
    }

    public String getInvestorPicture() {
        return investorPicture;
    }

    public void setInvestorPicture(String investorPicture) {
        this.investorPicture = investorPicture;
    }

    public String getInvestorUrl() {
        return investorUrl;
    }

    public void setInvestorUrl(String investorUrl) {
        this.investorUrl = investorUrl;
    }

    public String getInvestorInvestmentCompanyName() {
        return investorInvestmentCompanyName;
    }

    public void setInvestorInvestmentCompanyName(String investorInvestmentCompanyName) {
        this.investorInvestmentCompanyName = investorInvestmentCompanyName;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "investorId=" + investorId +
                ", investorName='" + investorName + '\'' +
                ", investorPosition='" + investorPosition + '\'' +
                ", investorInfo='" + investorInfo + '\'' +
                ", investorDirection='" + investorDirection + '\'' +
                ", investorFinanceName='" + investorFinanceName + '\'' +
                ", investorOnceInvestment='" + investorOnceInvestment + '\'' +
                ", investorLocation='" + investorLocation + '\'' +
                ", investorPicture='" + investorPicture + '\'' +
                ", investorUrl='" + investorUrl + '\'' +
                ", investorInvestmentCompanyName='" + investorInvestmentCompanyName + '\'' +
                '}';
    }
}
