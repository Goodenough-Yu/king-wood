package com.yunexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/template/teacher")
public class TeacherControl {

    /**
     *
     * @return 教师首页
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    public String getIndex() {
        return "index.html";
    }
}
