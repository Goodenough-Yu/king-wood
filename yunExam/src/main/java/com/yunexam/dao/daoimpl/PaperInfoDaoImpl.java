package com.yunexam.dao.daoimpl;

import com.yunexam.dao.BaseDao;
import com.yunexam.dao.PaperInfoDao;
import com.yunexam.domain.PaperInformation;

import java.sql.*;

public class PaperInfoDaoImpl implements PaperInfoDao {

    private BaseDao baseDao = new BaseDao();

    @Override
    public boolean AddPaperInfo(PaperInformation PI) {
        String sql = "INSERT INTO paper_information(PIid,EIid,total_score,total_time) values(?,?,?,?)";
        Object[] params ={PI.getPiid(),PI.getEiid(),PI.getTotal_score(),PI.getTotal_time()};
        return baseDao.executeUpdate(sql,params);
    }

    @Override
    public PaperInformation FindPaperInfoBypiid(int piid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PaperInformation PI = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from paper_information where PIid = ?");
        pstmt.setInt(1, piid);
        rs = pstmt.executeQuery();

        while (rs.next()){
            PI = new PaperInformation();
            PI.setPiid(rs.getInt("PIid"));
            PI.setEiid(rs.getInt("EIid"));
            PI.setTotal_score(rs.getFloat("total_score"));
            PI.setTotal_time(rs.getInt("total_time"));
        }

        baseDao.closeAll(rs,pstmt,con);

        return PI;
    }

    @Override
    public PaperInformation FindPaperInfoByeiid(int piid, int eiid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PaperInformation PI = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from paper_information where PIid = ? and EIid = ?");
        pstmt.setInt(1, piid);
        pstmt.setInt(2,eiid);
        rs = pstmt.executeQuery();

        while (rs.next()){
            PI = new PaperInformation();
            PI.setPiid(rs.getInt("PIid"));
            PI.setEiid(rs.getInt("EIid"));
            PI.setTotal_score(rs.getFloat("total_score"));
            PI.setTotal_time(rs.getInt("total_time"));
        }

        baseDao.closeAll(rs,pstmt,con);

        return PI;
    }
}
