package cn.cyzone.entity;
//投资人工作经历
public class InvestorJob {

    private int investorJobId;  //唯一自增主键
    private String investorJobName; //工作单位名称
    private String investorJobPosition; //职位
    private String investorJobPicture;  //单位图标
    private String investorJobInvestorName; //投资人姓名
    private String investorJobInvestorUrl;  //投资人所在url

    public int getInvestorJobId() {
        return investorJobId;
    }

    public void setInvestorJobId(int investorJobId) {
        this.investorJobId = investorJobId;
    }

    public String getInvestorJobName() {
        return investorJobName;
    }

    public void setInvestorJobName(String investorJobName) {
        this.investorJobName = investorJobName;
    }

    public String getInvestorJobPosition() {
        return investorJobPosition;
    }

    public void setInvestorJobPosition(String investorJobPosition) {
        this.investorJobPosition = investorJobPosition;
    }

    public String getInvestorJobPicture() {
        return investorJobPicture;
    }

    public void setInvestorJobPicture(String investorJobPicture) {
        this.investorJobPicture = investorJobPicture;
    }

    public String getInvestorJobInvestorName() {
        return investorJobInvestorName;
    }

    public void setInvestorJobInvestorName(String investorJobInvestorName) {
        this.investorJobInvestorName = investorJobInvestorName;
    }

    public String getInvestorJobInvestorUrl() {
        return investorJobInvestorUrl;
    }

    public void setInvestorJobInvestorUrl(String investorJobInvestorUrl) {
        this.investorJobInvestorUrl = investorJobInvestorUrl;
    }

    @Override
    public String toString() {
        return "InvestorJob{" +
                "investorJobId=" + investorJobId +
                ", investorJobName='" + investorJobName + '\'' +
                ", investorJobPosition='" + investorJobPosition + '\'' +
                ", investorJobPicture='" + investorJobPicture + '\'' +
                ", investorJobInvestorName='" + investorJobInvestorName + '\'' +
                ", investorJobInvestorUrl='" + investorJobInvestorUrl + '\'' +
                '}';
    }
}
