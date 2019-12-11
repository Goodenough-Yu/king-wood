package com.yunexam.dao;

import com.yunexam.domain.Admin;

import java.sql.SQLException;

public interface AdminDao {
    Admin FindAdmByaidAndapwd(int mid,String mpwd) throws SQLException; // 根据Mid和Mpwd查找管理员
}
