package com.yunexam.service;

import java.sql.SQLException;

public interface LoginService {
    boolean StudentLogin(int sid,String spwd) throws SQLException; // 学生登陆判断
    boolean TeacherLogin(int tid,String tpwd) throws SQLException; // 教师登录判断
    boolean AdminLogin(int mid,String mpwd) throws SQLException; // 管理员登录判断
}
