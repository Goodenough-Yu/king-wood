package com.yunexam.dao;

import com.yunexam.domain.Student;

import java.sql.SQLException;

public interface StudentDao {
    Student FindStuBynameAndpwd(int sid,String spwd) throws SQLException; // 根据Sid和Spwd查找该学生
}
