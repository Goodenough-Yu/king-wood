package com.yunexam.domain;

public class PaperSolution {
    private int sid; // 学生id
    private int piid; // 试卷id
    private int qbid; // 试题id
    private String solution; // 答题结果
    private float psscore; // 此题得分

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

    public int getQbid() {
        return qbid;
    }

    public void setQbid(int qbid) {
        this.qbid = qbid;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public float getPsscore() {
        return psscore;
    }

    public void setPsscore(float psscore) {
        this.psscore = psscore;
    }
}
