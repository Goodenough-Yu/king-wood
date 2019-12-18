package com.yunexam.dao;

import com.yunexam.domain.Admin;

import java.sql.SQLException;

public interface AdminDao {
    Admin FindAdmByaidAndapwd(int mid, String mpwd) throws SQLException; // 根据Mid和Mpwd查找管理员
    Admin FindAdmBymid(int mid) throws SQLException; // 根据mid查找管理员
    boolean UpdateAdmin(Admin admin); // 修改管理员信息
}
