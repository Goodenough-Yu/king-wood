package com.yunexam.controller;

import com.yunexam.domain.Admin;
import com.yunexam.domain.Student;
import com.yunexam.domain.Teacher;
import com.yunexam.service.UpdateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UpdateInfoControl {

    @Autowired
    UpdateInfoService updateInfoService;

    public boolean UpdateAdmin(Admin admin){
        return updateInfoService.UpdateAdmin(admin);
    }

    /**
     * 修改用户密码
     * @param student
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "/UpdateStudent")
    public boolean UpdateStudent(@RequestBody Student student){
        return updateInfoService.UpdateStudent(student);
    }

    public boolean UpdateTeacher(Teacher teacher){
        return updateInfoService.UpdateTeacher(teacher);
    }
}
