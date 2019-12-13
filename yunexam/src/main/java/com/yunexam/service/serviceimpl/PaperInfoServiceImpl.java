package com.yunexam.service.serviceimpl;

<<<<<<< HEAD:yunExam/src/main/java/com/yunexam/service/serviceimpl/PaperInfoServiceImpl.java
import com.yunexam.domain.PaperInformation;
import com.yunexam.domain.QuestionBank;
import com.yunexam.dao.*;
=======
>>>>>>> ver4.0:yunexam/src/main/java/com/yunexam/service/serviceimpl/PaperInfoServiceImpl.java
import com.yunexam.dao.ExamInforDao;
import com.yunexam.dao.PaperInfoDao;
import com.yunexam.dao.PaperQuesDao;
import com.yunexam.dao.QuesBankDao;
import com.yunexam.dao.daoimpl.ExamInforDaoImpl;
import com.yunexam.dao.daoimpl.PaperInfoDaoImpl;
import com.yunexam.dao.daoimpl.PaperQuesDaoImpl;
import com.yunexam.dao.daoimpl.QuesBankDaoImpl;
import com.yunexam.domain.ExamInformation;
import com.yunexam.domain.PaperQuestion;
import com.yunexam.service.PaperInfoService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD:yunExam/src/main/java/com/yunexam/service/serviceimpl/PaperInfoServiceImpl.java
=======
import org.springframework.stereotype.Repository;
>>>>>>> ver4.0:yunexam/src/main/java/com/yunexam/service/serviceimpl/PaperInfoServiceImpl.java
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PaperInfoServiceImpl implements PaperInfoService {

    @Autowired
<<<<<<< HEAD:yunExam/src/main/java/com/yunexam/service/serviceimpl/PaperInfoServiceImpl.java
    private PaperInfoDao paperInfoDao;
    @Autowired
    private ExamInforDao examInforDao;
    @Autowired
    private QuesBankDao quesBankDao;
    @Autowired
    private PaperQuesDao paperQuesDao;
=======
    PaperInfoDao paperInfoDao;

    @Autowired
    ExamInforDao examInforDao;

    @Autowired
    QuesBankDao quesBankDao;

    @Autowired
    PaperQuesDao paperQuesDao;
>>>>>>> ver4.0:yunexam/src/main/java/com/yunexam/service/serviceimpl/PaperInfoServiceImpl.java

    @Override
    public int CreatePaper(int eiid){
        PaperInformation PI_put = new PaperInformation();
        int n = (int) (Math.random() * 900000000) + 100000000; // 生成9位piid
        PI_put.setEiid(eiid);
        PI_put.setPiid(n);
        PI_put.setTotal_time(120);
        PI_put.setTotal_score(100);

        paperInfoDao.AddPaperInfo(PI_put);

        return n;
    }

    @Override
    public List<Integer> InsertQuestion(int piid) throws SQLException {
        PaperQuestion PQ = new PaperQuestion();
        //获取eiid
        PaperInformation PI = paperInfoDao.FindPaperInfoBypiid(piid);
        int eiid = PI.getEiid();
        System.out.println("eiid "+eiid);

        //获取cid
        ExamInformation examInformation = examInforDao.FindExamInfoByeiid(eiid);
        int cid = examInformation.getCid();
        System.out.println("cid "+cid);

        //获取各难度qbid
        List<Integer> qbid_degree_1 = quesBankDao.FindQuestion(cid,1,1);
        List<Integer> qbid_degree_2 = quesBankDao.FindQuestion(cid,1,2);
        List<Integer> qbid_degree_3 = quesBankDao.FindQuestion(cid,1,3);

        //生成改试卷的piid
<<<<<<< HEAD:yunExam/src/main/java/com/yunexam/service/serviceimpl/PaperInfoServiceImpl.java
=======
        PaperQuestion PQ = new PaperQuestion();
>>>>>>> ver4.0:yunexam/src/main/java/com/yunexam/service/serviceimpl/PaperInfoServiceImpl.java
        PQ.setPiid(piid);
        PQ.setPq_score(10);

        Collections.shuffle(qbid_degree_1);
        int randomSeriesLength_1 = 4;
        List<Integer> qbid_degree_1_1 = qbid_degree_1.subList(0, randomSeriesLength_1);
        for(int i = 0;i<qbid_degree_1_1.size();i++){
            PQ.setQbid(qbid_degree_1_1.get(i));
            paperQuesDao.AddPaperQues(PQ);
        }

        Collections.shuffle(qbid_degree_2);
        int randomSeriesLength_2 = 4;
        List<Integer> qbid_degree_2_1 = qbid_degree_2.subList(0, randomSeriesLength_2);
        for(int i = 0;i<qbid_degree_2_1.size();i++){
            PQ.setQbid(qbid_degree_2_1.get(i));
            paperQuesDao.AddPaperQues(PQ);
        }

        Collections.shuffle(qbid_degree_3);
        int randomSeriesLength_3 = 2;
        List<Integer> qbid_degree_3_1 = qbid_degree_3.subList(0, randomSeriesLength_3);
        for(int i = 0;i<qbid_degree_3_1.size();i++){
            PQ.setQbid(qbid_degree_3_1.get(i));
            paperQuesDao.AddPaperQues(PQ);
        }

        qbid_degree_1_1.addAll(qbid_degree_2_1);
        qbid_degree_1_1.addAll(qbid_degree_3_1);
        return qbid_degree_1_1;
    }

    @Override
    public List<QuestionBank> FindQusetion(int piid) throws SQLException {
        List<PaperQuestion> paperQuestions = paperQuesDao.FindPaperQues(piid);
        int qbid;
        List<QuestionBank> questionBanks = new ArrayList<QuestionBank>();
        for(int i = 0;i<paperQuestions.size();i++){
            qbid = paperQuestions.get(i).getQbid();
            questionBanks.add(quesBankDao.FindQuesBankByqbid(qbid));
        }
        return questionBanks;
    }


}
