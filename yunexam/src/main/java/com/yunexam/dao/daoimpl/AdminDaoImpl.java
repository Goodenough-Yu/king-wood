package com.yunexam.dao.daoimpl;

import com.yunexam.dao.AdminDao;
import com.yunexam.dao.BaseDao;
import com.yunexam.domain.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    BaseDao baseDao = new BaseDao();

    @Override
    public Admin FindAdmByaidAndapwd(int mid, String mpwd) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Admin admin = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from admin where Mid = ? and Mpwd = ?");
        pstmt.setInt(1, mid);
        pstmt.setString(2,mpwd);
        rs = pstmt.executeQuery();

        while (rs.next()){
            admin = new Admin();
            admin.setMid(rs.getInt("Mid"));
            admin.setMpwd(rs.getString("Mpwd"));
            admin.setMname(rs.getString("Mname"));
            admin.setMmobile(rs.getString("Mmobile"));
        }

        baseDao.closeAll(rs,pstmt,con);

        return admin;
    }
}
