package com.yunexam.controller;

import com.yunexam.domain.QuestionBank;
import com.yunexam.service.PaperInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(path = "/template/student")
public class PaperControl {

    @Autowired
    PaperInfoService paperInfoService;

    /**
     * 生成试卷载体
     * @return
     */
    @RequestMapping(path = "/page/paper")
    public String getPaper() {
        return "paper.html";
    }


    /**
     * 获取题目
     * @param eiid 考试信息id
     * @return 所有题目
     */
    @ResponseBody
    @RequestMapping(path = "/paper.json")
    public List<QuestionBank> getPaperQuestion(@RequestParam("id") int eiid) throws SQLException {
        // 调用抽题方法，返回题目数据
        System.out.println("eiid="+eiid);
        int piid = paperInfoService.CreatePaper(eiid);
        List<Integer> qbids = paperInfoService.InsertQuestion(piid);
        return paperInfoService.FindQusetion(piid);
    }


}
