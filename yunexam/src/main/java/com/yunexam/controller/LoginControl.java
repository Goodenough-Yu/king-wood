package com.yunexam.controller;

import com.yunexam.domain.Student;
import com.yunexam.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class LoginControl {

    @Autowired
    LoginService loginService;

    /**
     * 进入登录界面
     * @return
     */
    @RequestMapping(path = "")
    public String Login(){
        return "login.html";
    }

    /**
     *  检查学生用户名和密码
     * @param sidStr 用户名
     * @param spwd 密码
     * @return 是否存在用户
     * @throws SQLException
     */
    @ResponseBody
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public  boolean StudentLogin(
            @RequestParam("identify") String identify,
            @RequestParam("username") String sidStr,
            @RequestParam("password") String spwd) throws SQLException {
        int sid = Integer.parseInt(sidStr);
        if (identify.equals("student")) {
            return loginService.StudentLogin(sid,spwd);
        } else if (identify.equals("admin")) {
            return loginService.AdminLogin(sid,spwd);
        } else {
            return loginService.TeacherLogin(sid,spwd);
        }
    }
}
