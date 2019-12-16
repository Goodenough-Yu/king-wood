package com.yunexam.service.serviceimpl;

import com.yunexam.dao.*;
import com.yunexam.domain.*;
import com.yunexam.service.GradeService;
import com.yunexam.service.PaperInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.SQLException;
import java.util.*;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeDao gradeDao;

    @Autowired
    PaperInfoDao paperInfoDao;

    @Autowired
    ExamInforDao examInforDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    QuesBankDao quesBankDao;

    @Autowired
    PaperSoluDao paperSoluDao;

    @Autowired
    PaperInfoService paperInfoService;

    @Override
    public Map<String, Object> getGrade(int sid) throws SQLException {
        List<Grade> grades = gradeDao.FindGradeBysid(sid);
        List<ExamInformation> examInformations = new ArrayList<ExamInformation>();
        PaperInformation paperInformation = null;
        ExamInformation examInformation = null;
        Grade grade = new Grade();
        for(int i = 0;i<grades.size();i++){
            paperInformation = new PaperInformation();
            examInformation = new ExamInformation();
            grade = grades.get(i);
            paperInformation = paperInfoDao.FindPaperInfoBypiid(grade.getPiid());
            examInformation = examInforDao.FindExamInfoByeiid(paperInformation.getEiid());
            examInformations.add(examInformation);
        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("grade",grades);
        map.put("examInformation",examInformations);
        return map;
    }

    @Override
    public Map<String, Object> getSolution(int gid) throws SQLException {
        Grade grade = gradeDao.FindGradeBygid(gid);
        List<PaperSolution> paperSolutions = paperSoluDao.FindPaperSolu(grade.getPiid(),grade.getSid());
        List<QuestionBank> questionBanks = paperInfoService.FindQusetion(grade.getPiid());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("grade",grade.getScore());
        map.put("paperSolution",paperSolutions);
        map.put("questionBank",questionBanks);
        return map;
    }

    @Override
    public float getTotalScore(int piid,int sid) throws SQLException {
        List<PaperSolution> paperSolutions = paperSoluDao.FindPaperSolu(piid,sid);
        Grade grade = new Grade();
        grade.setSid(sid);
        grade.setPiid(piid);
        int n = (int) (Math.random() * 900000000) + 100000000; // 生成9位gid
        grade.setGid(n);
        int totalscore = 0;
        for(int i = 0;i<paperSolutions.size();i++){
            totalscore += paperSolutions.get(i).getPsscore();
        }
        grade.setScore(totalscore);
        gradeDao.AddGrade(grade);
        return totalscore;
    }
}
