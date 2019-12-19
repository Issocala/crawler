package cn.cyzone.entity;
//投资机构上一轮最佳合作伙伴
public class InvestmentPreviousBestPartner {
    private int investmentPreviousBestPartnerId;    //唯一自增主键
    private String investmentPreviousBestPartnerCompanyName; //机构名字
    private String investmentPreviousBestPartnerCompanyUrl; //机构所在url
    private String investmentPreviousBestPartnerPartnerCompanyName; //上一轮最佳合投伙伴机构名称
    private String investmentPreviousBestPartnerPartnerCompanyUrl;  //上一轮最佳合投伙伴机构所在url
    private int investmentPreviousBestPartnerNum;   //合作次数

    public int getInvestmentPreviousBestPartnerId() {
        return investmentPreviousBestPartnerId;
    }

    public void setInvestmentPreviousBestPartnerId(int investmentPreviousBestPartnerId) {
        this.investmentPreviousBestPartnerId = investmentPreviousBestPartnerId;
    }

    public String getInvestmentPreviousBestPartnerCompanyName() {
        return investmentPreviousBestPartnerCompanyName;
    }

    public void setInvestmentPreviousBestPartnerCompanyName(String investmentPreviousBestPartnerCompanyName) {
        this.investmentPreviousBestPartnerCompanyName = investmentPreviousBestPartnerCompanyName;
    }

    public String getInvestmentPreviousBestPartnerCompanyUrl() {
        return investmentPreviousBestPartnerCompanyUrl;
    }

    public void setInvestmentPreviousBestPartnerCompanyUrl(String investmentPreviousBestPartnerCompanyUrl) {
        this.investmentPreviousBestPartnerCompanyUrl = investmentPreviousBestPartnerCompanyUrl;
    }

    public String getInvestmentPreviousBestPartnerPartnerCompanyName() {
        return investmentPreviousBestPartnerPartnerCompanyName;
    }

    public void setInvestmentPreviousBestPartnerPartnerCompanyName(String investmentPreviousBestPartnerPartnerCompanyName) {
        this.investmentPreviousBestPartnerPartnerCompanyName = investmentPreviousBestPartnerPartnerCompanyName;
    }

    public String getInvestmentPreviousBestPartnerPartnerCompanyUrl() {
        return investmentPreviousBestPartnerPartnerCompanyUrl;
    }

    public void setInvestmentPreviousBestPartnerPartnerCompanyUrl(String investmentPreviousBestPartnerPartnerCompanyUrl) {
        this.investmentPreviousBestPartnerPartnerCompanyUrl = investmentPreviousBestPartnerPartnerCompanyUrl;
    }

    public int getInvestmentPreviousBestPartnerNum() {
        return investmentPreviousBestPartnerNum;
    }

    public void setInvestmentPreviousBestPartnerNum(int investmentPreviousBestPartnerNum) {
        this.investmentPreviousBestPartnerNum = investmentPreviousBestPartnerNum;
    }

    @Override
    public String toString() {
        return "InvestmentPreviousBestPartner{" +
                "investmentPreviousBestPartnerId=" + investmentPreviousBestPartnerId +
                ", investmentPreviousBestPartnerCompanyName='" + investmentPreviousBestPartnerCompanyName + '\'' +
                ", investmentPreviousBestPartnerCompanyUrl='" + investmentPreviousBestPartnerCompanyUrl + '\'' +
                ", investmentPreviousBestPartnerPartnerCompanyName='" + investmentPreviousBestPartnerPartnerCompanyName + '\'' +
                ", investmentPreviousBestPartnerPartnerCompanyUrl='" + investmentPreviousBestPartnerPartnerCompanyUrl + '\'' +
                ", investmentPreviousBestPartnerNum=" + investmentPreviousBestPartnerNum +
                '}';
    }
}
