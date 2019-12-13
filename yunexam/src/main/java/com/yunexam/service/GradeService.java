package com.yunexam.service;

import java.sql.SQLException;
import java.util.Map;

public interface GradeService {
    Map<String, Object> getGrade(int sid) throws SQLException; // 根据sid返回grade,course,examinformation
    Map<String, Object> getSolution(int gid) throws SQLException; // 根据gid返回solution,question_bank,grade
    float getTotalScore(int sid,int piid) throws SQLException; // 合分
}
