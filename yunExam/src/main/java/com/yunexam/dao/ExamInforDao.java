package com.yunexam.dao;

import com.yunexam.domain.ExamInformation;

import java.sql.SQLException;

public interface ExamInforDao {
    boolean AddExamInfo(ExamInformation EI); // 导入考试信息到exam_infomation表
    ExamInformation FindExamInfoByeiid(int eiid) throws SQLException; // 根据EIid查找考试信息
}
