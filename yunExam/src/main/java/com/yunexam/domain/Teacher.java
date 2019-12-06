package com.yunexam.domain;

public class Teacher {
    private int tid; // 教师id
    private String tname; // 教师姓名
    private String tpwd; // 密码
    private int tmobile; // 手机号

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpwd() {
        return tpwd;
    }

    public void setTpwd(String tpwd) {
        this.tpwd = tpwd;
    }

    public int getTmobile() {
        return tmobile;
    }

    public void setTmobile(int tmobile) {
        this.tmobile = tmobile;
    }
}
