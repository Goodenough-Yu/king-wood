package com.yunexam.controller;

import com.yunexam.dao.*;
import com.yunexam.domain.Admin;
import com.yunexam.domain.Student;
import com.yunexam.domain.StunumCourse;
import com.yunexam.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InformationControl {

    @Autowired
    StudentDao studentDao;

    @Autowired
    AdminDao adminDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    ViewCouStuNumDao viewCouStuNumDao;

    @Autowired
    HttpSession httpSession;

    /**
     * 根据id查找学生个人信息
     * @return 学生
     * @throws SQLException
     */
    @ResponseBody
    @RequestMapping(path = "/StudentInfo", method = RequestMethod.GET)
    public Map<String, Object> StudentInfo() throws SQLException {
        Map<String, Object> map = new HashMap<>();
        int sid = (int)httpSession.getAttribute("sid");
        map.put("student", studentDao.FindStuBysid(sid));
        return map;
    }

    public Teacher TeacherInfo(String tidstr) throws SQLException {
        int tid = Integer.parseInt(tidstr);
        return teacherDao.FindTeaBytid(tid);
    }

    public Admin AdminInfo(String midstr) throws SQLException {
        int mid = Integer.parseInt(midstr);
        return adminDao.FindAdmBymid(mid);
    }

    @ResponseBody
    @RequestMapping("/getStuNumAll")
    public Map<String,Object> getStuNumAll() throws SQLException {
        List<StunumCourse> stunumCourses = viewCouStuNumDao.FindNumAll();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data",stunumCourses);
        map.put("code", 0);
        return map;
    }


}
