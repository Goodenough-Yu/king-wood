package com.yunexam.controller;

import com.yunexam.domain.QuestionBank;
import com.yunexam.service.PaperInfoService;
import com.yunexam.service.PaperSoluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(path = "/paper.json", method = RequestMethod.GET)
    public Map<String, Object> getPaperQuestion(
            @RequestParam("eiid") int eiid,
            @RequestParam("title") String title) throws SQLException {
        // 调用抽题方法，返回题目数据
        int piid = paperInfoService.CreatePaper(eiid);
        List<Integer> qbids = paperInfoService.InsertQuestion(piid);
        List<QuestionBank> questionBankList = paperInfoService.FindQusetion(piid);
        // 存入map映射
        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("questionBankList", questionBankList);
        return map;
    }

    /**
     * 阅卷
     * @param piid
     * @param sid
     * @return
     * @throws SQLException
     */
    public  boolean reviewPaper(int piid,int sid) throws SQLException {
        return paperSoluService.ReviewSolution(piid,sid);
    }
}
