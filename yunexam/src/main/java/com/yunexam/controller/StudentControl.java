package com.yunexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/template/student")
public class StudentControl {

    /**
     *
     * @return 学生首页
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    public String getIndex() {
        return "index.html";
    }

    /**
     *
     * @return 考试安排页面
     */
    @RequestMapping(path = "/page/exam-manage", method = RequestMethod.GET)
    public String getExamInfo() {
        return "exam-manage.html";
    }

    /**
     *
     * @return 成绩查询页面
     */
    @RequestMapping(path = "/page/grade-query", method = RequestMethod.GET)
    public String getGrade() {
        return "grade-query.html";
    }

    /**
     *
     * @return 密码修改页面
     */
    @RequestMapping(path = "/page/user-password", method = RequestMethod.GET)
    public String modifyPassword() {
        return "user-password.html";
    }

    /**
     *
     * @return 学生设置页面
     */
    @RequestMapping(path = "/page/user-setting", method = RequestMethod.GET)
    public String modifyUserSetting() {
        return "user-setting.html";
    }
}
