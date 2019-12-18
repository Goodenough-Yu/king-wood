package com.yunexam.dao.daoimpl;

import com.yunexam.dao.BaseDao;
import com.yunexam.dao.StudentDao;
import com.yunexam.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    BaseDao baseDao;

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

    @Override
    public Student FindStuBysid(int sid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from student where Sid = ?");
        pstmt.setInt(1, sid);
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

    @Override
    public boolean UpdateStudent(Student student) {
        String sql = "UPDATE student set Spwd = ? where Sid = ?";
        Object[] params ={student.getSpwd(), student.getSid()};
        return baseDao.executeUpdate(sql,params);
    }
}
