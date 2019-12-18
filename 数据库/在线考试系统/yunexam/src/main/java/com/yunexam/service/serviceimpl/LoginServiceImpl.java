package com.yunexam.service.serviceimpl;

import com.yunexam.dao.AdminDao;
import com.yunexam.dao.StudentDao;
import com.yunexam.dao.TeacherDao;
import com.yunexam.dao.daoimpl.AdminDaoImpl;
import com.yunexam.dao.daoimpl.StudentDaoImpl;
import com.yunexam.dao.daoimpl.TeacherDaoImpl;
import com.yunexam.domain.Admin;
import com.yunexam.domain.Student;
import com.yunexam.domain.Teacher;
import com.yunexam.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    AdminDao adminDao;

    @Override
    public boolean StudentLogin(int sid, String spwd) throws SQLException {
        Student student = new Student();
        student = studentDao.FindStuBynameAndpwd(sid,spwd);
        return student != null;
    }

    @Override
    public boolean TeacherLogin(int tid, String tpwd) throws SQLException {
        Teacher teacher = new Teacher();
        teacher = teacherDao.FindTeaBytidAndtpwd(tid,tpwd);
        return teacher != null;
    }

    @Override
    public boolean AdminLogin(int mid, String mpwd) throws SQLException {
        Admin admin = new Admin();
        admin = adminDao.FindAdmByaidAndapwd(mid,mpwd);
        return admin != null;
    }
}
