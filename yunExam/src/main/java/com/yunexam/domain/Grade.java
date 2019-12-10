package com.yunexam.domain;

public class Grade {
    private int gid; // 成绩id
    private int sid; // 学生id
    private int piid; // 试卷id
    private float score; // 考试得分
    private int use_time; // 考试用时

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getPiid() {
        return piid;
    }

    public void setPiid(int piid) {
        this.piid = piid;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getUse_time() {
        return use_time;
    }

    public void setUse_time(int use_time) {
        this.use_time = use_time;
    }
}
