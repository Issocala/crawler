package cn.cyzone.entity;

import java.util.Date;

//投资机构近三年投资战绩
public class InvestmentResult {
    private int investmentResultId; //唯一自增主键
    private String investmentResultCompanyName; //投资机构名称
    private String investmentResultCompanyUrl;  //投资机构url
    private int investmentResultInvestmentKnowNum; //已披露投资事件数
    private int investmentResultNextCompanyNum; //走到下一轮公司数
    private int investmentResultContinuousInvestNum;    //连续投资公司数
    private Date investmentCreateDate;  //数据记录时间

    public int getInvestmentResultId() {
        return investmentResultId;
    }

    public void setInvestmentResultId(int investmentResultId) {
        this.investmentResultId = investmentResultId;
    }

    public String getInvestmentResultCompanyName() {
        return investmentResultCompanyName;
    }

    public void setInvestmentResultCompanyName(String investmentResultCompanyName) {
        this.investmentResultCompanyName = investmentResultCompanyName;
    }

    public String getInvestmentResultCompanyUrl() {
        return investmentResultCompanyUrl;
    }

    public void setInvestmentResultCompanyUrl(String investmentResultCompanyUrl) {
        this.investmentResultCompanyUrl = investmentResultCompanyUrl;
    }

    public int getInvestmentResultInvestmentKnowNum() {
        return investmentResultInvestmentKnowNum;
    }

    public void setInvestmentResultInvestmentKnowNum(int investmentResultInvestmentKnowNum) {
        this.investmentResultInvestmentKnowNum = investmentResultInvestmentKnowNum;
    }

    public int getInvestmentResultNextCompanyNum() {
        return investmentResultNextCompanyNum;
    }

    public void setInvestmentResultNextCompanyNum(int investmentResultNextCompanyNum) {
        this.investmentResultNextCompanyNum = investmentResultNextCompanyNum;
    }

    public int getInvestmentResultContinuousInvestNum() {
        return investmentResultContinuousInvestNum;
    }

    public void setInvestmentResultContinuousInvestNum(int investmentResultContinuousInvestNum) {
        this.investmentResultContinuousInvestNum = investmentResultContinuousInvestNum;
    }

    public Date getInvestmentCreateDate() {
        return investmentCreateDate;
    }

    public void setInvestmentCreateDate(Date investmentCreateDate) {
        this.investmentCreateDate = investmentCreateDate;
    }

    @Override
    public String toString() {
        return "investmentResult{" +
                "investmentResultId=" + investmentResultId +
                ", investmentResultCompanyName='" + investmentResultCompanyName + '\'' +
                ", investmentResultCompanyUrl='" + investmentResultCompanyUrl + '\'' +
                ", investmentResultInvestmentKnowNum=" + investmentResultInvestmentKnowNum +
                ", investmentResultNextCompanyNum=" + investmentResultNextCompanyNum +
                ", investmentResultContinuousInvestNum=" + investmentResultContinuousInvestNum +
                ", investmentCreateDate=" + investmentCreateDate +
                '}';
    }
}
