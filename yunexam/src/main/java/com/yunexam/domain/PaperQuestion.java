package com.yunexam.domain;

public class PaperQuestion {
    private int piid; // 试卷id
    private int qbid; // 题目id
    private float pq_score; // 改题目分数

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

    public float getPq_score() {
        return pq_score;
    }

    public void setPq_score(float pq_score) {
        this.pq_score = pq_score;
    }
}
