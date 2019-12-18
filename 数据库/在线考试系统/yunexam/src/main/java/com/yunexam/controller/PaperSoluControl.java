package com.yunexam.controller;

import com.yunexam.dao.GradeDao;
import com.yunexam.domain.Grade;
import com.yunexam.domain.PaperSolution;
import com.yunexam.domain.QuestionBank;
import com.yunexam.service.GradeService;
import com.yunexam.service.PaperSoluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @Autowired
    HttpSession httpSession;

    /**
     * 获取学生所有考试成绩
     * @return map考试成绩和试卷信息
     */
    @ResponseBody
    @RequestMapping(path = "/getGrade", method = RequestMethod.GET)
    public Map<String,Object> getGrade() throws SQLException {
        int sid = (int)httpSession.getAttribute("sid");
        Map<String,Object> map = new HashMap<String, Object>();
        map = gradeService.getGrade(sid);
        return map;
    }

    /**
     * 生成试题解析载体
     * @return
     */
    @RequestMapping(path = "/page/paper-solution", method = RequestMethod.GET)
    public String getPaperSolution(@RequestParam("gid") int gid,
                                   @RequestParam("cname") String cname) {
        httpSession.setAttribute("gid", gid);
        httpSession.setAttribute("cname", cname);
        return "paper-solution.html";
    }

    /**
     * 获取试题解析
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "/getPaperSolution", method = RequestMethod.GET)
    public Map<String,Object> getPaperSolution() throws SQLException {
        int gid = (int)httpSession.getAttribute("gid");
        String cname = (String)httpSession.getAttribute("cname");
        Map<String,Object> map = new HashMap<String, Object>();
        map = gradeService.getSolution(gid);
        map.put("title", cname);
        return map;
    }
}
