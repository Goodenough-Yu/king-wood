package com.yunexam.service;

import com.yunexam.domain.ExamInformation;

import java.sql.SQLException;
import java.util.List;

public interface ExamInfoService {
    boolean AddExamInfo(ExamInformation EI);  // 设置考试
    List<ExamInformation> FindExamInfo() throws SQLException; // 查询全部考试
    ExamInformation FindExamInfoByeiid(int eiid) throws SQLException; // 根据eiid查询考试
}
