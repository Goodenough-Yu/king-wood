package com.yunexam.controller;

import com.yunexam.domain.PaperSolution;
import com.yunexam.domain.QuestionBank;
import com.yunexam.service.GradeService;
import com.yunexam.service.PaperInfoService;
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
public class PaperControl {

    @Autowired
    PaperInfoService paperInfoService;

    @Autowired
    PaperSoluService paperSoluService;

    @Autowired
    HttpSession httpSession;

    @Autowired
    GradeService gradeService;

    /**
     * 生成试卷载体
     * @return
     */
    @RequestMapping(path = "/page/paper", method = RequestMethod.GET)
    public String getPaper() {
        return "paper.html";
    }


    /**
     * 获取题目
     * @param eiid 考试信息id
     * @return 所有题目
     */
    @ResponseBody
    @RequestMapping(path = "/getPaperQuestion", method = RequestMethod.GET)
    public Map<String, Object> getPaperQuestion(
            @RequestParam("eiid") int eiid,
            @RequestParam("title") String title) throws SQLException {
        int sid = (int)httpSession.getAttribute("sid");
        // 调用抽题方法，返回题目数据
        int piid = paperInfoService.CreatePaper(eiid);
        List<Integer> qbids = paperInfoService.InsertQuestion(piid);
        List<QuestionBank> questionBankList = paperInfoService.FindQusetion(piid);
        // 将信息存入map映射
        Map<String, Object> map = new HashMap<>();
        map.put("sid", sid);
        map.put("piid", piid);
        map.put("title", title);
        map.put("questionBankList", questionBankList);
        return map;
    }

    /**
     * 存储答题,并批改试题
     * @param paperSolutions 试题答案
     * @return 成绩查询页面
     * @throws SQLException
     */
    @ResponseBody
    @RequestMapping(path = "/putPaperSolution", method = RequestMethod.POST)
    public Map<String, Object> putPaperSolution(@RequestBody List<PaperSolution> paperSolutions) throws SQLException{
        Map<String, Object> map = new HashMap<>();
        int piid = paperSolutions.get(0).getPiid(); // 试卷id
        int sid = (int)httpSession.getAttribute("sid"); // 学生id
        paperSoluService.InsertSolution(paperSolutions); // 插入试卷到题库
        paperSoluService.ReviewSolution(piid,sid); // 阅卷
        float score = gradeService.getTotalScore(piid,sid); // 获取总分
        map.put("score", score);
        return map;
    }

}
