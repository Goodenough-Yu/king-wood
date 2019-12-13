package com.yunexam.controller;

import com.yunexam.domain.Admin;
import com.yunexam.domain.Student;
import com.yunexam.domain.Teacher;
import com.yunexam.service.UpdateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UpdateInfoControl {

    @Autowired
    UpdateInfoService updateInfoService;

    public boolean UpdateAdmin(Admin admin){
        return updateInfoService.UpdateAdmin(admin);
    }

    public boolean UpdateStudent(Student student){
        return updateInfoService.UpdateStudent(student);
    }

    public boolean UpdateTeacher(Teacher teacher){
        return updateInfoService.UpdateTeacher(teacher);
    }
}
