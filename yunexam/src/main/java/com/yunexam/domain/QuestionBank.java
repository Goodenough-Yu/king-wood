package com.yunexam.domain;

public class QuestionBank {
    private int qbid; // 题目id
    private int cid; // 课程id
    private int is_single; // 是否单选
    private int degree; // 难度
    private String question; // 问题
    private String answer; // 答案
    private String A; // 选项A
    private String B; // 选项B
    private String C; // 选项C
    private String D; // 选项D

    public int getQbid() {
        return qbid;
    }

    public void setQbid(int qbid) {
        this.qbid = qbid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getIs_single() {
        return is_single;
    }

    public void setIs_single(int is_single) {
        this.is_single = is_single;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }
}
