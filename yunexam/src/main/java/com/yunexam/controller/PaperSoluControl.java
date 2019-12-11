package com.yunexam.controller;

import com.yunexam.dao.GradeDao;
import com.yunexam.domain.Grade;
import com.yunexam.domain.PaperSolution;
import com.yunexam.service.PaperSoluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;


@Controller
@RequestMapping(path = "/template/student")
public class PaperSoluControl {

    @Autowired
    GradeDao gradeDao;

    @Autowired
    PaperSoluService paperSoluService;

    /**
     * 获取考试成绩
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "/grade.json")
    public List<Grade> getGrade(int sid) throws SQLException {
        List<Grade> grades = gradeDao.FindGradeBysid(sid);
        return grades;
    }

    /**
     * 获取试题解析
     * @return
     */
    @RequestMapping(path = "/page/paper-solution")
    public String getPaperSolution() {
        return "paper-solution.html";
    }

    /**
     * 存储答题
     * @param paperSolutions
     * @return
     */
    public boolean putPaperSolution(List<PaperSolution> paperSolutions) {
        return paperSoluService.InsertSolution(paperSolutions);
    }
}
