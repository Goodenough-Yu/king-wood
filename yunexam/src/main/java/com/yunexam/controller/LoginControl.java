package com.yunexam.controller;

import com.yunexam.domain.Admin;
import com.yunexam.domain.Student;
import com.yunexam.domain.Teacher;
import com.yunexam.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class LoginControl {

    @Autowired
    LoginService loginService;

    @RequestMapping(path = "")
    public String Login(){
        // 用户登陆 service 验证处理
        System.out.println("用户登录");
        return "login.html";
    }

    public  String StudentLogin(Student student) throws SQLException {
        int sid = student.getSid();
        String spwd = student.getSpwd();
        if(loginService.StudentLogin(sid,spwd)){
            return "/template/student";
        }else {
            return "login.html";
        }
    }

    public String AdminLogin(Admin admin) throws SQLException {
        int mid = admin.getMid();
        String mpwd = admin.getMpwd();
        if(loginService.AdminLogin(mid,mpwd)){
            return "1";
        }else{
            return "0";
        }
    }

    public String TeacherLogin(Teacher teacher) throws SQLException {
        int tid = teacher.getTid();
        String tpwd = teacher.getTpwd();
        if(loginService.TeacherLogin(tid,tpwd)){
            return "1";
        }else {
            return "0";
        }
    }
}
