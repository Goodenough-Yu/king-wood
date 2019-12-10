package com.yunexam.domain;

public class PaperInformation {
    private int piid; // 试卷id
    private int eiid; // 考试id
    private float total_score; // 试卷总分
    private int total_time; // 试卷总时间

    public int getPiid() {
        return piid;
    }

    public void setPiid(int piid) {
        this.piid = piid;
    }

    public int getEiid() {
        return eiid;
    }

    public void setEiid(int eiid) {
        this.eiid = eiid;
    }

    public float getTotal_score() {
        return total_score;
    }

    public void setTotal_score(float total_score) {
        this.total_score = total_score;
    }

    public int getTotal_time() {
        return total_time;
    }

    public void setTotal_time(int total_time) {
        this.total_time = total_time;
    }
}
