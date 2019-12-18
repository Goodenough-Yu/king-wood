package com.yunexam.controller;

import com.yunexam.domain.Admin;
import com.yunexam.domain.Student;
import com.yunexam.domain.Teacher;
import com.yunexam.service.UpdateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class UpdateInfoControl {

    @Autowired
    UpdateInfoService updateInfoService;

    @Autowired
    HttpSession httpSession;

//    public boolean UpdateAdmin(Admin admin){
//        return updateInfoService.UpdateAdmin(admin);
//    }

    /**
     * 修改学生密码
     * @param oldspwd 旧密码
     * @param newspwd 新密码
     * @return 修改成功返回true，失败返回false
     * @throws SQLException
     */
    @ResponseBody
    @RequestMapping(path = "/UpdateStudent", method = RequestMethod.POST)
    public boolean UpdateStudent(@RequestParam("oldspwd") String oldspwd,
                                 @RequestParam("newspwd") String newspwd) throws SQLException {
        int sid = (int)httpSession.getAttribute("sid");
        return updateInfoService.UpdateStudent(sid, oldspwd, newspwd);
    }

//    public boolean UpdateTeacher(Teacher teacher){
//        return updateInfoService.UpdateTeacher(teacher);
//    }
}
