package com.yunexam.service;

import com.yunexam.domain.Admin;
import com.yunexam.domain.Student;
import com.yunexam.domain.Teacher;

public interface UpdateInfoService {
    boolean UpdateAdmin(Admin admin); // 修改管理员信息
    boolean UpdateStudent(Student student); // 修改学生信息
    boolean UpdateTeacher(Teacher teacher); // 修改教师信息
}
