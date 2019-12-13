package com.yunexam.dao.daoimpl;

import com.yunexam.dao.BaseDao;
import com.yunexam.dao.GradeDao;
import com.yunexam.domain.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GradeDaoImpl implements GradeDao {

    @Autowired
    BaseDao baseDao;

    @Override
    public Grade FindGradeBygid(int gid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Grade grade = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from grade where Gid = ?");
        pstmt.setInt(1, gid);
        rs = pstmt.executeQuery();

        while (rs.next()){
            grade = new Grade();
            grade.setGid(rs.getInt("Gid"));
            grade.setPiid(rs.getInt("PIid"));
            grade.setSid(rs.getInt("Sid"));
            grade.setScore(rs.getInt("score"));
        }

        baseDao.closeAll(rs,pstmt,con);

        return grade;
    }

    @Override
    public List<Grade> FindGradeBysid(int sid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Grade> grades = new ArrayList<Grade>();
        Grade grade = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from grade where Sid = ?");
        pstmt.setInt(1, sid);
        rs = pstmt.executeQuery();

        while (rs.next()){
            grade = new Grade();
            grade.setGid(rs.getInt("Gid"));
            grade.setPiid(rs.getInt("PIid"));
            grade.setSid(rs.getInt("Sid"));
            grade.setScore(rs.getInt("score"));
            grades.add(grade);
        }

        baseDao.closeAll(rs,pstmt,con);

        return grades;
    }

    @Override
    public List<Grade> FindGradeBysidAndpiid(int sid, int piid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Grade> grades = new ArrayList<Grade>();
        Grade grade = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from grade where Sid = ? and PIid = ?");
        pstmt.setInt(1, sid);
        pstmt.setInt(2,piid);
        rs = pstmt.executeQuery();

        while (rs.next()){
            grade = new Grade();
            grade.setGid(rs.getInt("Gid"));
            grade.setPiid(rs.getInt("PIid"));
            grade.setSid(rs.getInt("Sid"));
            grade.setScore(rs.getInt("score"));
            grades.add(grade);
        }

        baseDao.closeAll(rs,pstmt,con);

        return grades;
    }

    @Override
    public boolean AddGrade(Grade grade) {
        String sql = "INSERT INTO grade(GId,Sid,PIid) values(?,?,?,?)";
        Object[] params ={grade.getGid(),grade.getSid(),grade.getPiid(),grade.getScore()};
        return baseDao.executeUpdate(sql,params);
    }

}
