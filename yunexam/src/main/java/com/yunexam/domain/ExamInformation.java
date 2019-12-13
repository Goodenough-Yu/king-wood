package com.yunexam.domain;

import org.springframework.context.annotation.Bean;

import java.util.Date;

public class ExamInformation {
    private int eiid; // 考试id
    private String einame; // 考试名称
    private Date start_time; // 考试开放开始时间；
    private Date finish_time; // 考试开放结束时间
    private int cid; // 课程id

    public int getEiid() {
        return eiid;
    }

    public void setEiid(int eiid) {
        this.eiid = eiid;
    }

    public String getEiname() {
        return einame;
    }

    public void setEiname(String einame) {
        this.einame = einame;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Date finish_time) {
        this.finish_time = finish_time;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
