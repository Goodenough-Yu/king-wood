package com.yunexam.controller;

import com.yunexam.dao.GradeDao;
import com.yunexam.domain.Grade;
import com.yunexam.domain.PaperSolution;
import com.yunexam.domain.QuestionBank;
import com.yunexam.service.GradeService;
import com.yunexam.service.PaperSoluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(path = "/template/student")
public class PaperSoluControl {

    @Autowired
    PaperSoluService paperSoluService;

    @Autowired
    GradeDao gradeDao;

    @Autowired
    GradeService gradeService;

    /**
     * 获取考试成绩
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "/grade.json", method = RequestMethod.GET)
    public Map<String,Object> getGrade(int sid) throws SQLException {
        Map<String,Object> map = new HashMap<String, Object>();
        map = gradeService.getGrade(sid);
        return map;
    }

    /**
     * 答题结束，获取试题解析
     * @return
     */
    @RequestMapping(path = "/page/paper-solution", method = RequestMethod.POST)
    public Map<String,Object> getPaperSolution(int gid) throws SQLException {
        Map<String,Object> map = new HashMap<String, Object>();
        map = gradeService.getSolution(gid);
        return map;
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
