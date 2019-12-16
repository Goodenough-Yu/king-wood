package com.yunexam.dao.daoimpl;

import com.yunexam.dao.BaseDao;
import com.yunexam.dao.ViewCouStuNumDao;
import com.yunexam.domain.StunumCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ViewCouStuNumDaoImpl implements ViewCouStuNumDao {

    @Autowired
    BaseDao baseDao;

    @Override
    public List<StunumCourse> FindNumAll() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<StunumCourse> stunumCourses = new ArrayList<StunumCourse>();
        StunumCourse stunumCourse = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from view_stu_cou_num");
        rs = pstmt.executeQuery();

        while (rs.next()){
            stunumCourse = new StunumCourse();
            stunumCourse.setCname(rs.getString("Cname"));
            stunumCourse.setStunum(rs.getInt("Stu_num"));
            stunumCourses.add(stunumCourse);
        }

        baseDao.closeAll(rs,pstmt,con);

        return stunumCourses;
    }
}
