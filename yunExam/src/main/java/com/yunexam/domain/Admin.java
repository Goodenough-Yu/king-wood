package com.yunexam.domain;

public class Admin {
    private int mid; // 管理员id
    private String mpwd; // 密码
    private String mname; // 管理员姓名
    private int mmobile; // 手机号码

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMpwd() {
        return mpwd;
    }

    public void setMpwd(String mpwd) {
        this.mpwd = mpwd;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getMmobile() {
        return mmobile;
    }

    public void setMmobile(int mmobile) {
        this.mmobile = mmobile;
    }
}
