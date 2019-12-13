package com.yunexam.dao;

import com.yunexam.domain.Teacher;

import java.sql.SQLException;

public interface TeacherDao {
    Teacher FindTeaBytidAndtpwd(int tid, String tpwd) throws SQLException; // 根据Tid和Tpwd查找教师
    Teacher FindTeaBytid(int tid) throws SQLException; // 根据tid查找教师
    boolean UpdateTeacher(Teacher teacher); // 修改教师信息
}
