package cn.cyzone.entity;

import java.util.Date;
//创业公司融资阶段
public class Finance {
    private int financeId;  //唯一自增主键
    private String financeName; //融资阶段名称
    private String financeMoney;    //融资金额
    private String financeCompanyUrl;  //对应公司所在Url
    private String financeInvestmentCompany;    //投资方
    private Date financeDate;   //获投时间

    public int getFinanceId() {
        return financeId;
    }

    public void setFinanceId(int financeId) {
        this.financeId = financeId;
    }

    public String getFinanceName() {
        return financeName;
    }

    public void setFinanceName(String financeName) {
        this.financeName = financeName;
    }

    public String getFinanceMoney() {
        return financeMoney;
    }

    public void setFinanceMoney(String financeMoney) {
        this.financeMoney = financeMoney;
    }

    public String getFinanceCompanyUrl() {
        return financeCompanyUrl;
    }

    public void setFinanceCompanyUrl(String financeCompanyUrl) {
        this.financeCompanyUrl = financeCompanyUrl;
    }

    public String getFinanceInvestmentCompany() {
        return financeInvestmentCompany;
    }

    public void setFinanceInvestmentCompany(String financeInvestmentCompany) {
        this.financeInvestmentCompany = financeInvestmentCompany;
    }

    public Date getFinanceDate() {
        return financeDate;
    }

    public void setFinanceDate(Date financeDate) {
        this.financeDate = financeDate;
    }

    @Override
    public String toString() {
        return "Finance{" +
                "financeId=" + financeId +
                ", financeName='" + financeName + '\'' +
                ", financeMoney='" + financeMoney + '\'' +
                ", financeCompanyUrl='" + financeCompanyUrl + '\'' +
                ", financeInvestmentCompany='" + financeInvestmentCompany + '\'' +
                ", financeDate=" + financeDate +
                '}';
    }
}
