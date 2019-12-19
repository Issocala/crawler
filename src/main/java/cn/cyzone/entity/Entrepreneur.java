package cn.cyzone.entity;

//自然人
public class Entrepreneur {
    private int entrepreneurId; //唯一自增主键
    private String entrepreneurName;    //自然人姓名
    private String entrepreneurInfo;    //自然人简介
    private String entrepreneurUrl;     //自然人所在URL
    private String entrepreneurPosition;    //自然人职位
    private String entrepreneurPicture; //自然人头像

    public String getEntrepreneurPicture() {
        return entrepreneurPicture;
    }

    public void setEntrepreneurPicture(String entrepreneurPicture) {
        this.entrepreneurPicture = entrepreneurPicture;
    }

    public int getEntrepreneurId() {
        return entrepreneurId;
    }

    public Entrepreneur setEntrepreneurId(int entrepreneurId) {
        this.entrepreneurId = entrepreneurId;
        return this;
    }

    public String getEntrepreneurName() {
        return entrepreneurName;
    }

    public Entrepreneur setEntrepreneurName(String entrepreneurName) {
        this.entrepreneurName = entrepreneurName;
        return this;
    }

    public String getEntrepreneurInfo() {
        return entrepreneurInfo;
    }

    public Entrepreneur setEntrepreneurInfo(String entrepreneurInfo) {
        this.entrepreneurInfo = entrepreneurInfo;
        return this;
    }

    public String getEntrepreneurUrl() {
        return entrepreneurUrl;
    }

    public Entrepreneur setEntrepreneurUrl(String entrepreneurUrl) {
        this.entrepreneurUrl = entrepreneurUrl;
        return this;
    }

    public String getEntrepreneurPosition() {
        return entrepreneurPosition;
    }

    public Entrepreneur setEntrepreneurPosition(String entrepreneurPosition) {
        this.entrepreneurPosition = entrepreneurPosition;
        return this;
    }

    @Override
    public String toString() {
        return "Entrepreneur{" +
                "entrepreneurId=" + entrepreneurId +
                ", entrepreneurName='" + entrepreneurName + '\'' +
                ", entrepreneurInfo='" + entrepreneurInfo + '\'' +
                ", entrepreneurUrl='" + entrepreneurUrl + '\'' +
                ", entrepreneurPosition='" + entrepreneurPosition + '\'' +
                ", entrepreneurPicture='" + entrepreneurPicture + '\'' +
                '}';
    }
}
