package com.yunexam.dao.daoimpl;

import com.yunexam.dao.BaseDao;
import com.yunexam.dao.StudentDao;
import com.yunexam.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {

    BaseDao baseDao = new BaseDao();

    @Override
    public Student FindStuBynameAndpwd(int sid, String spwd) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from student where Sid = ? and Spwd = ?");
        pstmt.setInt(1, sid);
        pstmt.setString(2,spwd);
        rs = pstmt.executeQuery();

        while (rs.next()){
            student = new Student();
            student.setSid(rs.getInt("Sid"));
            student.setSpwd(rs.getString("Spwd"));
            student.setSname(rs.getString("Sname"));
            student.setSubject(rs.getString("subject"));
            student.setSmobile(rs.getString("Smobile"));
        }

        baseDao.closeAll(rs,pstmt,con);

        return student;
    }
}
