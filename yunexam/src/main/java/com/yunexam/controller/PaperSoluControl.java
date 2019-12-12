package com.yunexam.controller;

import com.yunexam.domain.PaperSolution;
import com.yunexam.service.PaperSoluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(path = "/template/student")
public class PaperSoluControl {

    @Autowired
    PaperSoluService paperSoluService;

    /**
     * 获取考试成绩
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "/grade.json", method = RequestMethod.GET)
    public String getGrade() {
        return "考试成绩";
    }

    /**
     * 答题结束，获取试题解析
     * @return
     */
    @RequestMapping(path = "/page/paper-solution", method = RequestMethod.POST)
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
