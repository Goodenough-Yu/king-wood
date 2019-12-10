package com.yunexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/template/student")
public class StudentControl {

    /**
     *
     * @return 学生首页
     */
    @RequestMapping(path = "")
    public String getIndex() {
        return "index.html";
    }

    /**
     *
     * @return 考试安排页面
     */
    @RequestMapping(path = "/page/exam-manage")
    public String getExamInfo() {
        return "exam-manage.html";
    }

    /**
     *
     * @return 考试查询页面
     */
    @RequestMapping(path = "/page/grade-query")
    public String getGrade() {
        return "grade-query.html";
    }

    /**
     *
     * @return 密码修改页面
     */
    @RequestMapping(path = "/page/user-password")
    public String modifyPassword() {
        return "user-password.html";
    }

    /**
     *
     * @return 学生设置页面
     */
    @RequestMapping(path = "/page/user-setting")
    public String modifyUserSetting() {
        return "user-setting.html";
    }
}
