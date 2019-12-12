package com.yunexam.service.serviceimpl;

import com.yunexam.dao.*;
import com.yunexam.domain.*;
import com.yunexam.service.GradeService;
import com.yunexam.service.PaperInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Course> courses = new ArrayList<Course>();
        PaperInformation paperInformation = null;
        ExamInformation examInformation = null;
        Grade grade = new Grade();
        Course course = new Course();
        for(int i = 0;i<grades.size();i++){
            paperInformation = new PaperInformation();
            examInformation = new ExamInformation();
            grade = grades.get(i);
            paperInformation = paperInfoDao.FindPaperInfoBypiid(grade.getPiid());
            examInformation = examInforDao.FindExamInfoByeiid(paperInformation.getEiid());
            course = courseDao.FindCourseBycid(examInformation.getCid());
            courses.add(course);
        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("grade",grades);
        map.put("course",courses);
        return map;
    }

    @Override
    public Map<String, Object> getSolution(int gid) throws SQLException {
        Grade grade = gradeDao.FindGradeBygid(gid);
        List<PaperSolution> paperSolutions = paperSoluDao.FindPaperSolu(grade.getPiid(),grade.getSid());
        List<QuestionBank> questionBanks = paperInfoService.FindQusetion(grade.getPiid());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("grade",grade);
        map.put("paperSolution",paperSolutions);
        map.put("questionBank",questionBanks);
        return map;
    }
}
