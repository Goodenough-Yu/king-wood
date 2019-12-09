package com.yunexam.dao.daoimpl;

import com.yunexam.dao.BaseDao;
import com.yunexam.dao.PaperQuesDao;
import com.yunexam.domain.PaperQuestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaperQuesDaoImpl implements PaperQuesDao {

    private BaseDao baseDao = new BaseDao();

    @Override
    public boolean AddPaperQues(PaperQuestion PQ) {
        String sql = "INSERT INTO paper_question(PIid,QBid,PQ_score) values(?,?,?)";
        Object[] params ={PQ.getPiid(),PQ.getQbid(),PQ.getPq_score()};
        return baseDao.executeUpdate(sql, params);
    }

    @Override
    public List<PaperQuestion> FindPaperQues(int piid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<PaperQuestion> paperQuestions = new ArrayList<PaperQuestion>();
        PaperQuestion PQ = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from paper_question where PIid = ?");
        pstmt.setInt(1, piid);
        rs = pstmt.executeQuery();

        while (rs.next()){
            PQ = new PaperQuestion();
            PQ.setPiid(rs.getInt("PIid"));
            PQ.setQbid(rs.getInt("QBid"));
            PQ.setPq_score(rs.getFloat("PQ_score"));
            paperQuestions.add(PQ);
        }

        baseDao.closeAll(rs,pstmt,con);

        return paperQuestions;
    }
}
