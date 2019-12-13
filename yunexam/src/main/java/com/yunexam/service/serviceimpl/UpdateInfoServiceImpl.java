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

@Service
public class UpdateInfoServiceImpl implements UpdateInfoService {

    @Autowired
    AdminDao adminDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentDao studentDao;

    @Override
    public boolean UpdateAdmin(Admin admin) {
        return adminDao.UpdateAdmin(admin);
    }

    @Override
    public boolean UpdateStudent(Student student) {
        return studentDao.UpdateStudent(student);
    }

    @Override
    public boolean UpdateTeacher(Teacher teacher) {
        return teacherDao.UpdateTeacher(teacher);
    }
}
