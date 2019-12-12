package com.yunexam.controller;

import com.yunexam.domain.Admin;
import com.yunexam.domain.Student;
import com.yunexam.domain.Teacher;
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

<<<<<<< HEAD
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
=======
    /**
     *  检查学生用户名和密码
     * @param sidStr 用户名
     * @param spwd 密码
     * @return 是否存在用户
     * @throws SQLException
     */
    @ResponseBody
    @RequestMapping(path = "/studentLogin", method = RequestMethod.POST)
    public  boolean StudentLogin(
            @RequestParam("username") String sidStr,
            @RequestParam("password") String spwd) throws SQLException {
        int sid = Integer.parseInt(sidStr);
        return loginService.StudentLogin(sid,spwd);
    }

    /**
     *  检查教师用户名和密码
     * @param sidStr 用户名
     * @param spwd 密码
     * @return 是否存在用户
     * @throws SQLException
     */
    @ResponseBody
    @RequestMapping(path = "/teacherLogin", method = RequestMethod.POST)
    public  boolean teacherLogin(
            @RequestParam("username") String sidStr,
            @RequestParam("password") String spwd) throws SQLException {
        int sid = Integer.parseInt(sidStr);
        return loginService.TeacherLogin(sid,spwd);
    }

    /**
     *  检查管理员用户名和密码
     * @param sidStr 用户名
     * @param spwd 密码
     * @return 是否存在用户
     * @throws SQLException
     */
    @ResponseBody
    @RequestMapping(path = "/adminLogin", method = RequestMethod.POST)
    public  boolean AdminLogin(
            @RequestParam("username") String sidStr,
            @RequestParam("password") String spwd) throws SQLException {
        int sid = Integer.parseInt(sidStr);
        return loginService.AdminLogin(sid,spwd);
>>>>>>> 020513caafbf07ed0abc368cb409d563031beb65
    }
}
