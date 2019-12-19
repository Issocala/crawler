package cn.cyzone.entity;
//投资机构最佳合投伙伴
public class InvestmentBestPartner {
    private int investmentBestPartnerId;    //唯一自增主键
    private String investmentBestPartnerCompanyName;    //机构名称
    private String investmentBestPartnerCompanyUrl; //机构所在url
    private String investmentBestPartnerPartnerCompanyName; //最佳合投伙伴机构名称
    private String investmentBestPartnerPartnerCompanyUrl;  //最佳合投伙伴机构所在url
    private int investmentBestPartnerNum;   //合作次数

    public int getInvestmentBestPartnerId() {
        return investmentBestPartnerId;
    }

    public void setInvestmentBestPartnerId(int investmentBestPartnerId) {
        this.investmentBestPartnerId = investmentBestPartnerId;
    }

    public String getInvestmentBestPartnerCompanyName() {
        return investmentBestPartnerCompanyName;
    }

    public void setInvestmentBestPartnerCompanyName(String investmentBestPartnerCompanyName) {
        this.investmentBestPartnerCompanyName = investmentBestPartnerCompanyName;
    }

    public String getInvestmentBestPartnerCompanyUrl() {
        return investmentBestPartnerCompanyUrl;
    }

    public void setInvestmentBestPartnerCompanyUrl(String investmentBestPartnerCompanyUrl) {
        this.investmentBestPartnerCompanyUrl = investmentBestPartnerCompanyUrl;
    }

    public String getInvestmentBestPartnerPartnerCompanyName() {
        return investmentBestPartnerPartnerCompanyName;
    }

    public void setInvestmentBestPartnerPartnerCompanyName(String investmentBestPartnerPartnerCompanyName) {
        this.investmentBestPartnerPartnerCompanyName = investmentBestPartnerPartnerCompanyName;
    }

    public String getInvestmentBestPartnerPartnerCompanyUrl() {
        return investmentBestPartnerPartnerCompanyUrl;
    }

    public void setInvestmentBestPartnerPartnerCompanyUrl(String investmentBestPartnerPartnerCompanyUrl) {
        this.investmentBestPartnerPartnerCompanyUrl = investmentBestPartnerPartnerCompanyUrl;
    }

    public int getInvestmentBestPartnerNum() {
        return investmentBestPartnerNum;
    }

    public void setInvestmentBestPartnerNum(int investmentBestPartnerNum) {
        this.investmentBestPartnerNum = investmentBestPartnerNum;
    }

    @Override
    public String toString() {
        return "InvestmentBestPartner{" +
                "investmentBestPartnerId=" + investmentBestPartnerId +
                ", investmentBestPartnerCompanyName='" + investmentBestPartnerCompanyName + '\'' +
                ", investmentBestPartnerCompanyUrl='" + investmentBestPartnerCompanyUrl + '\'' +
                ", investmentBestPartnerPartnerCompanyName='" + investmentBestPartnerPartnerCompanyName + '\'' +
                ", investmentBestPartnerPartnerCompanyUrl='" + investmentBestPartnerPartnerCompanyUrl + '\'' +
                ", investmentBestPartnerNum=" + investmentBestPartnerNum +
                '}';
    }
}
