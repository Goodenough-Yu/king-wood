package com.yunexam.controller;

import com.yunexam.domain.ExamInformation;
import com.yunexam.service.ExamInfoService;
import com.yunexam.service.serviceimpl.ExamInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ExamControl {

    @Autowired
    private ExamInfoService examInfoService;

    /**
     *  获取考试信息
     * @return 考试信息
     * @throws SQLException
     */
    @RequestMapping(path = "/getExamInformation", method = RequestMethod.GET)
    public List<ExamInformation> getExamInformation() throws SQLException {
       return examInfoService.FindExamInfo();
    }

    @ResponseBody
    @RequestMapping(path = "/releaseExamInformation", method = RequestMethod.POST)
    public boolean releaseExamInformation(@RequestBody ExamInformation examInformation) {
        return examInfoService.AddExamInfo(examInformation);
    }
}
