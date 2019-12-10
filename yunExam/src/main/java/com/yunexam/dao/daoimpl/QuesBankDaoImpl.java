package com.yunexam.dao.daoimpl;

import com.yunexam.domain.QuestionBank;
import com.yunexam.dao.BaseDao;
import com.yunexam.dao.QuesBankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuesBankDaoImpl implements QuesBankDao {

    @Autowired
    private BaseDao baseDao;

    @Override
    public boolean AddQuesBank(QuestionBank QB) {
        return false;
    }

    @Override
    public QuestionBank FindQuesBankByqbid(int qbid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        QuestionBank QB= null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from question_bank where QBid = ?");
        pstmt.setInt(1, qbid);
        rs = pstmt.executeQuery();

        while (rs.next()){
            QB = new QuestionBank();
            QB.setQbid(rs.getInt("QBid"));
            QB.setCid(rs.getInt("Cid"));
            QB.setIs_single(rs.getInt("is_single"));
            QB.setDegree(rs.getInt("degree"));
            QB.setAnswer(rs.getString("answer"));
            QB.setA(rs.getString("A"));
            QB.setB(rs.getString("B"));
            QB.setC(rs.getString("C"));
            QB.setD(rs.getString("D"));
            QB.setQuestion(rs.getString("question"));
        }

        baseDao.closeAll(rs,pstmt,con);

        return QB;
    }

    @Override
    public List<Integer> FindQuestion(int cid, int is_single, int degree) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Integer> questions = new ArrayList<Integer>();
        int qbid = 0;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select QBid from question_bank where Cid = ? and is_single = ? and degree = ?");
        pstmt.setInt(1, cid);
        pstmt.setInt(2,is_single);
        pstmt.setInt(3,degree);
        rs = pstmt.executeQuery();

        while (rs.next()){
            qbid=rs.getInt("QBid");
            questions.add(qbid);
        }

        baseDao.closeAll(rs,pstmt,con);

        return questions;
    }
}
