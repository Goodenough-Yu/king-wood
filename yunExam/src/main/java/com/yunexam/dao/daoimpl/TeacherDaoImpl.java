package com.yunexam.dao.daoimpl;

import com.yunexam.dao.BaseDao;
import com.yunexam.dao.TeacherDao;
import com.yunexam.domain.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDaoImpl implements TeacherDao {

    BaseDao baseDao = new BaseDao();

    @Override
    public Teacher FindTeaBytidAndtpwd(int tid, String tpwd) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Teacher teacher = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from teacher where Tid = ? and Spwd = ?");
        pstmt.setInt(1, tid);
        pstmt.setString(2,tpwd);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            teacher = new Teacher();
            teacher.setTid(rs.getInt("Tid"));
            teacher.setTpwd(rs.getString("Tpwd"));
            teacher.setTname(rs.getString("Tname"));
            teacher.setTmobile(rs.getString("Tmobile"));
        }

        baseDao.closeAll(rs,pstmt,con);

        return teacher;
    }
}
