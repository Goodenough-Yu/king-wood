package com.yunexam.service.serviceimpl;

import com.yunexam.dao.AdminDao;
import com.yunexam.dao.StudentDao;
import com.yunexam.dao.TeacherDao;
import com.yunexam.domain.Admin;
import com.yunexam.domain.Student;
import com.yunexam.domain.Teacher;
import com.yunexam.service.UpdateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UpdateInfoServiceImpl implements UpdateInfoService {

    @Autowired
    AdminDao adminDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentDao studentDao;

    @Override
    public boolean UpdateAdmin(int mid,String oldmpwd,String newmpwd) throws SQLException {
        Admin admin = null;
        admin = adminDao.FindAdmByaidAndapwd(mid,oldmpwd);
        if(admin != null){
            admin.setMpwd(newmpwd);
            adminDao.UpdateAdmin(admin);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean UpdateStudent(int sid, String oldspwd, String newspwd) throws SQLException {
        Student student = null;
        student = studentDao.FindStuBynameAndpwd(sid,oldspwd);
        if(student != null) {
            student.setSpwd(newspwd);
            studentDao.UpdateStudent(student);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean UpdateTeacher(int tid, String oldtpwd, String newtpwd) throws SQLException {
        Teacher teacher = null;
        teacher = teacherDao.FindTeaBytidAndtpwd(tid,oldtpwd);
        if(teacher != null){
            teacher.setTpwd(newtpwd);
            teacherDao.UpdateTeacher(teacher);
            return true;
        }else{
            return false;
        }
    }
}
