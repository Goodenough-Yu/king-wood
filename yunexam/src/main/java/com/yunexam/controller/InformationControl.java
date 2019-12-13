package com.yunexam.controller;

import com.yunexam.dao.*;
import com.yunexam.domain.Admin;
import com.yunexam.domain.Student;
import com.yunexam.domain.StunumCourse;
import com.yunexam.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

    public Student StudentInfor(String sidstr) throws SQLException {
        int sid = Integer.parseInt(sidstr);
       return studentDao.FindStuBysid(sid);
    }

    public Teacher TeacherInfo(String tidstr) throws SQLException {
        int tid = Integer.parseInt(tidstr);
        return teacherDao.FindTeaBytid(tid);
    }

    public Admin AdminInfo(String midstr) throws SQLException {
        int mid = Integer.parseInt(midstr);
        return adminDao.FindAdmBymid(mid);
    }

    public Map<String,Object> getStuNumAll() throws SQLException {
        List<StunumCourse> stunumCourses = viewCouStuNumDao.FindNumAll();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("stunumCourse",stunumCourses);
        return map;
    }


}
