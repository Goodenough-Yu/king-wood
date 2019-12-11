package com.yunexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/template/student")
public class PaperControl {

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
     * @param id 考试信息id
     * @return 所有题目
     */
    @ResponseBody
    @RequestMapping(path = "/paper.json")
    public String getPaperQuestion(@RequestParam("id") String id) {
        // 调用抽题方法，返回题目数据
        System.out.println(id);
        return "paper";
    }
}
