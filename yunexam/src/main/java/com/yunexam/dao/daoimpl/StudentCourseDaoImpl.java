package com.yunexam.dao.daoimpl;

import com.yunexam.dao.BaseDao;
import com.yunexam.dao.StudentCourseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseDaoImpl implements StudentCourseDao {

    BaseDao baseDao = new BaseDao();

    @Override
    public List<Integer> FindStuCouBysid(int sid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Integer> cids = new ArrayList<Integer>();
        int cid;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from student_course where Sid = ?");
        pstmt.setInt(1, sid);
        rs = pstmt.executeQuery();

        while (rs.next()){
            cid = rs.getInt("Cid");
            cids.add(cid);
        }

        baseDao.closeAll(rs,pstmt,con);

        return cids;
    }
}
