package com.yunexam.dao.daoimpl;

import com.yunexam.dao.AdminDao;
import com.yunexam.dao.BaseDao;
import com.yunexam.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    BaseDao baseDao;

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
