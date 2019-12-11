package com.yunexam.dao;

import com.yunexam.domain.Teacher;

import java.sql.SQLException;

public interface TeacherDao {
    Teacher FindTeaBytidAndtpwd(int tid, String tpwd) throws SQLException; // 根据Tid和Tpwd查找教师
}
