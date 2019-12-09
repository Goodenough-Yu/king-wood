package com.yunexam.service.serviceimpl;

import com.yunexam.dao.ExamInforDao;
import com.yunexam.dao.PaperInfoDao;
import com.yunexam.dao.QuesBankDao;
import com.yunexam.dao.daoimpl.ExamInforDaoImpl;
import com.yunexam.dao.daoimpl.PaperInfoDaoImpl;
import com.yunexam.dao.daoimpl.QuesBankDaoImpl;
import com.yunexam.domain.ExamInformation;
import com.yunexam.domain.PaperInformation;
import com.yunexam.domain.QuestionBank;
import com.yunexam.service.PaperInfoService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class PaperInfoServiceImpl implements PaperInfoService {
    @Override
    public int CreatePaper(int eiid){
        PaperInformation PI_put = new PaperInformation();
        int n = (int) (Math.random() * 900000000) + 100000000; // 生成9位piid
        PI_put.setEiid(eiid);
        PI_put.setPiid(n);
        PI_put.setTotal_time(120);
        PI_put.setTotal_score(100);

        PaperInfoDao paperInfoDao = new PaperInfoDaoImpl();
        paperInfoDao.AddPaperInfo(PI_put);

        return n;
    }

    @Override
    public List<Integer> FindPaper(int piid) {

        return null;
    }

    @Override
    public List<Integer> InsertQuestion(int piid) throws SQLException {
        //获取eiid
        PaperInfoDao paperInfoDao = new PaperInfoDaoImpl();
        PaperInformation PI = paperInfoDao.FindPaperInfoBypiid(piid);
        int eiid = PI.getEiid();

        //获取cid
        ExamInforDao examInforDao = new ExamInforDaoImpl();
        ExamInformation examInformation = examInforDao.FindExamInfoByeiid(eiid);
        int cid = examInformation.getCid();

        //获取各难度qbid
        QuesBankDao quesBankDao = new QuesBankDaoImpl();
        List<Integer> qbid_degree_1 = quesBankDao.FindQuestion(cid,1,1);
        List<Integer> qbid_degree_2 = quesBankDao.FindQuestion(cid,1,2);
        List<Integer> qbid_degree_3 = quesBankDao.FindQuestion(cid,1,3);

        //生成改试卷的piid
        Collections.shuffle(qbid_degree_1);
        int randomSeriesLength_1 = 4;
        List<Integer> qbid_degree_1_1 = qbid_degree_1.subList(0, randomSeriesLength_1);
        Collections.shuffle(qbid_degree_2);
        int randomSeriesLength_2 = 4;
        List<Integer> qbid_degree_2_1 = qbid_degree_2.subList(0, randomSeriesLength_2);
        Collections.shuffle(qbid_degree_3);
        int randomSeriesLength_3 = 2;
        List<Integer> qbid_degree_3_1 = qbid_degree_1.subList(0, randomSeriesLength_3);
        qbid_degree_1_1.addAll(qbid_degree_2_1);
        qbid_degree_1_1.addAll(qbid_degree_3_1);
        return qbid_degree_1_1;
    }

    @Override
    public QuestionBank FindQusetion(int piid) {
        return null;
    }


}
