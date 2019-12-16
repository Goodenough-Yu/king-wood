package com.yunexam.dao.daoimpl;

import com.yunexam.dao.BaseDao;
import com.yunexam.dao.CourseDao;
import com.yunexam.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    BaseDao baseDao;

    @Override
    public Course FindCourseBycid(int cid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Course course = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from course where Cid = ?");
        pstmt.setInt(1, cid);
        rs = pstmt.executeQuery();

        while (rs.next()){
            course = new Course();
            course.setCid(rs.getInt("Cid"));
            course.setCname(rs.getString("Cname"));
        }

        baseDao.closeAll(rs,pstmt,con);

        return course;
    }
}
