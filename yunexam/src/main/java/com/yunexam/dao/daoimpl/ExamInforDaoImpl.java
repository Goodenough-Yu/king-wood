package com.yunexam.dao.daoimpl;

import com.yunexam.domain.ExamInformation;
import com.yunexam.dao.BaseDao;
import com.yunexam.dao.ExamInforDao;
<<<<<<< HEAD:yunExam/src/main/java/com/yunexam/dao/daoimpl/ExamInforDaoImpl.java
=======
import com.yunexam.domain.ExamInformation;
>>>>>>> ver4.0:yunexam/src/main/java/com/yunexam/dao/daoimpl/ExamInforDaoImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ExamInforDaoImpl implements ExamInforDao {

    @Autowired
<<<<<<< HEAD:yunExam/src/main/java/com/yunexam/dao/daoimpl/ExamInforDaoImpl.java
    private BaseDao baseDao;
=======
    BaseDao baseDao;
>>>>>>> ver4.0:yunexam/src/main/java/com/yunexam/dao/daoimpl/ExamInforDaoImpl.java

    @Override
    public boolean AddExamInfo(ExamInformation EI) {
        String sql = "INSERT INTO exam_information(EIid,Cid,EIname,start_time,finish_time) values(?,?,?,?,?)";
        Object[] params ={EI.getEiid(),EI.getCid(),EI.getEiname(),EI.getStart_time(),EI.getFinish_time()};
        return baseDao.executeUpdate(sql,params);
    }

    @Override
    public List<ExamInformation> FindExamInfo() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ExamInformation> examInformations = new ArrayList<ExamInformation>();
        ExamInformation EI = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from exam_information");
        rs = pstmt.executeQuery();

        while (rs.next()){
            EI = new ExamInformation();
            EI.setEiid(rs.getInt("EIid"));
            EI.setCid(rs.getInt("Cid"));
            EI.setEiname(rs.getString("EIname"));
            EI.setStart_time(rs.getDate("start_time"));
            EI.setFinish_time(rs.getDate("finish_time"));
            examInformations.add(EI);
        }

        baseDao.closeAll(rs,pstmt,con);

        return examInformations;
    }

    @Override
    public ExamInformation FindExamInfoByeiid(int eiid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ExamInformation EI = null;

        con = BaseDao.getConnection();
        pstmt = con.prepareStatement("select * from exam_information where EIid = ?");
        pstmt.setInt(1, eiid);
        rs = pstmt.executeQuery();

        while (rs.next()){
            EI = new ExamInformation();
            EI.setCid(rs.getInt("Cid"));
            EI.setEiid(rs.getInt("EIid"));
            EI.setEiname(rs.getString("EIname"));
            EI.setStart_time(rs.getDate("start_time"));
            EI.setFinish_time(rs.getDate("finish_time"));
        }

        baseDao.closeAll(rs,pstmt,con);

        return EI;
    }
}
