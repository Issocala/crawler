package cn.cyzone.entity;
//投资人和投资机构对应表
public class InvestmentCompanyToInvestor {
    private int investmentCompanyToInvestorId;  //唯一自增主键
    private String investmentCompanyToInvestorCompanyUrl;   //投资机构所在url
    private String investmentCompanyToInvestorInvestorUrl;   //投资人所在url

    public int getInvestmentCompanyToInvestorId() {
        return investmentCompanyToInvestorId;
    }

    public void setInvestmentCompanyToInvestorId(int investmentCompanyToInvestorId) {
        this.investmentCompanyToInvestorId = investmentCompanyToInvestorId;
    }

    public String getInvestmentCompanyToInvestorCompanyUrl() {
        return investmentCompanyToInvestorCompanyUrl;
    }

    public void setInvestmentCompanyToInvestorCompanyUrl(String investmentCompanyToInvestorCompanyUrl) {
        this.investmentCompanyToInvestorCompanyUrl = investmentCompanyToInvestorCompanyUrl;
    }

    public String getInvestmentCompanyToInvestorInvestorUrl() {
        return investmentCompanyToInvestorInvestorUrl;
    }

    public void setInvestmentCompanyToInvestorInvestorUrl(String investmentCompanyToInvestorInvestorUrl) {
        this.investmentCompanyToInvestorInvestorUrl = investmentCompanyToInvestorInvestorUrl;
    }

    @Override
    public String toString() {
        return "InvestmentCompanyToInvestor{" +
                "investmentCompanyToInvestorId=" + investmentCompanyToInvestorId +
                ", investmentCompanyToInvestorCompanyUrl='" + investmentCompanyToInvestorCompanyUrl + '\'' +
                ", investmentCompanyToInvestorInvestorUrl='" + investmentCompanyToInvestorInvestorUrl + '\'' +
                '}';
    }
}
