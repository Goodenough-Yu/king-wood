package com.yunexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path = "/template/student")
public class PaperSoluControl {

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
}
