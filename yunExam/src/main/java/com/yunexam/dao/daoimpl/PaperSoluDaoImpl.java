package com.yunexam.dao.daoimpl;

import com.yunexam.dao.BaseDao;
import com.yunexam.dao.PaperSoluDao;
import com.yunexam.domain.PaperSolution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaperSoluDaoImpl implements PaperSoluDao {

    private BaseDao baseDao = new BaseDao();

    @Override
    public boolean AddPaperSolu(PaperSolution PS) {
        String sql = "INSERT INTO paper_solution(PIid,Sid,QBid,solution,PSscore) values(?,?,?,?,?)";
        Object[] params ={PS.getPiid(),PS.getSid(),PS.getQbid(),PS.getSolution(),PS.getPsscore()};
        return baseDao.executeUpdate(sql,params);
    }

    @Override
    public List<PaperSolution> FindPaperSolu(int piid, int sid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<PaperSolution> paperSolutions = new ArrayList<PaperSolution>();
        PaperSolution PS = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from paper_solution where PIid = ? and Sid = ?");
        pstmt.setInt(1, piid);
        pstmt.setInt(2,sid);
        rs = pstmt.executeQuery();

        while (rs.next()){
            PS = new PaperSolution();
            PS.setPiid(rs.getInt("PIid"));
            PS.setSid(rs.getInt("Sid"));
            PS.setQbid(rs.getInt("QBid"));
            PS.setSolution(rs.getString("solution"));
            PS.setPsscore(rs.getFloat("PSscore"));
            paperSolutions.add(PS);
        }

        baseDao.closeAll(rs,pstmt,con);

        return paperSolutions;
    }

    @Override
    public boolean UpdatePaperSolu(PaperSolution PS) {
        String sql = "update paper_solution set PSscore = ? where Sid = ? and PIid = ? and QBid = ?";
        Object[] params ={PS.getPsscore(),PS.getSid(),PS.getPiid(),PS.getQbid()};
        return baseDao.executeUpdate(sql,params);
    }

    @Override
    public List<Integer> FindPaperSoluBysid(int sid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Integer> piids = new ArrayList<Integer>();

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select PIid from paper_solution where Sid = ?");
        pstmt.setInt(1, sid);
        rs = pstmt.executeQuery();

        while (rs.next()){
            piids.add(rs.getInt("PIid"));
        }

        return piids;
    }
}
