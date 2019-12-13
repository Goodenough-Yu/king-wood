package com.yunexam.service;

import com.yunexam.domain.Admin;
import com.yunexam.domain.Student;
import com.yunexam.domain.Teacher;

import java.sql.SQLException;

public interface UpdateInfoService {
    boolean UpdateAdmin(int mid,String oldmpwd, String newmpwd) throws SQLException; // 修改管理员信息
    boolean UpdateStudent(int sid,String oldspwd, String newspwd) throws SQLException; // 修改学生信息
    boolean UpdateTeacher(int tid,String oldtpwd, String newtpwd) throws SQLException; // 修改教师信息
}
