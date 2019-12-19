package cn.cyzone.entity;
//投资机构下一轮最佳合作伙伴
public class InvestmentNextBestPartner {
    private int investmentNextBestPartnerId;    //唯一自增主键
    private String investmentNextBestPartnerCompanyName;    //机构名字
    private String investmentNextBestPartnerCompanyUrl; //机构所在url;
    private String investmentNextBestPartnerPartnerCompanyName; //下一轮最佳合投伙伴机构名称
    private String investmentNextBestPartnerPartnerCompanyUrl;  //下一轮最佳合投伙伴机构所在url
    private int investmentNextBestPartnerNum;   //合作次数

    public int getInvestmentNextBestPartnerId() {
        return investmentNextBestPartnerId;
    }

    public void setInvestmentNextBestPartnerId(int investmentNextBestPartnerId) {
        this.investmentNextBestPartnerId = investmentNextBestPartnerId;
    }

    public String getInvestmentNextBestPartnerCompanyName() {
        return investmentNextBestPartnerCompanyName;
    }

    public void setInvestmentNextBestPartnerCompanyName(String investmentNextBestPartnerCompanyName) {
        this.investmentNextBestPartnerCompanyName = investmentNextBestPartnerCompanyName;
    }

    public String getInvestmentNextBestPartnerCompanyUrl() {
        return investmentNextBestPartnerCompanyUrl;
    }

    public void setInvestmentNextBestPartnerCompanyUrl(String investmentNextBestPartnerCompanyUrl) {
        this.investmentNextBestPartnerCompanyUrl = investmentNextBestPartnerCompanyUrl;
    }

    public String getInvestmentNextBestPartnerPartnerCompanyName() {
        return investmentNextBestPartnerPartnerCompanyName;
    }

    public void setInvestmentNextBestPartnerPartnerCompanyName(String investmentNextBestPartnerPartnerCompanyName) {
        this.investmentNextBestPartnerPartnerCompanyName = investmentNextBestPartnerPartnerCompanyName;
    }

    public String getInvestmentNextBestPartnerPartnerCompanyUrl() {
        return investmentNextBestPartnerPartnerCompanyUrl;
    }

    public void setInvestmentNextBestPartnerPartnerCompanyUrl(String investmentNextBestPartnerPartnerCompanyUrl) {
        this.investmentNextBestPartnerPartnerCompanyUrl = investmentNextBestPartnerPartnerCompanyUrl;
    }

    public int getInvestmentNextBestPartnerNum() {
        return investmentNextBestPartnerNum;
    }

    public void setInvestmentNextBestPartnerNum(int investmentNextBestPartnerNum) {
        this.investmentNextBestPartnerNum = investmentNextBestPartnerNum;
    }

    @Override
    public String toString() {
        return "InvestmentNextBestPartner{" +
                "investmentNextBestPartnerId=" + investmentNextBestPartnerId +
                ", investmentNextBestPartnerCompanyName='" + investmentNextBestPartnerCompanyName + '\'' +
                ", investmentNextBestPartnerCompanyUrl='" + investmentNextBestPartnerCompanyUrl + '\'' +
                ", investmentNextBestPartnerPartnerCompanyName='" + investmentNextBestPartnerPartnerCompanyName + '\'' +
                ", investmentNextBastPartnerPartnerCompanyUrl='" + investmentNextBestPartnerPartnerCompanyUrl + '\'' +
                ", investmentNextBestPartnerNum=" + investmentNextBestPartnerNum +
                '}';
    }

}
