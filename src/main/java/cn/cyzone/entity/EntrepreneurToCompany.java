package cn.cyzone.entity;
//创业公司自然人关系表
public class EntrepreneurToCompany {
    private int entrepreneurToCompanyId;    //唯一自增主键
    private String entrepreneurToCompanyEntrepreneurUrl;   //自然人所在url
    private String entrepreneurToCompanyCompanyUrl;    //公司所在Url

    public int getEntrepreneurToCompanyId() {
        return entrepreneurToCompanyId;
    }

    public void setEntrepreneurToCompanyId(int entrepreneurToCompanyId) {
        this.entrepreneurToCompanyId = entrepreneurToCompanyId;
    }

    public String getEntrepreneurToCompanyEntrepreneurUrl() {
        return entrepreneurToCompanyEntrepreneurUrl;
    }

    public void setEntrepreneurToCompanyEntrepreneurUrl(String entrepreneurToCompanyEntrepreneurUrl) {
        this.entrepreneurToCompanyEntrepreneurUrl = entrepreneurToCompanyEntrepreneurUrl;
    }

    public String getEntrepreneurToCompanyCompanyUrl() {
        return entrepreneurToCompanyCompanyUrl;
    }

    public void setEntrepreneurToCompanyCompanyUrl(String entrepreneurToCompanyCompanyUrl) {
        this.entrepreneurToCompanyCompanyUrl = entrepreneurToCompanyCompanyUrl;
    }

    @Override
    public String toString() {
        return "EntrepreneurToCompany{" +
                "entrepreneurToCompanyId=" + entrepreneurToCompanyId +
                ", entrepreneurToCompanyEntrepreneurUrl='" + entrepreneurToCompanyEntrepreneurUrl + '\'' +
                ", entrepreneurToCompanyCompanyUrl='" + entrepreneurToCompanyCompanyUrl + '\'' +
                '}';
    }
}
