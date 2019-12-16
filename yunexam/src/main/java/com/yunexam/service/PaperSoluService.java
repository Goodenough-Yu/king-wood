package com.yunexam.service;

import com.yunexam.domain.PaperSolution;

import java.sql.SQLException;
import java.util.List;

public interface PaperSoluService {
    //错误的方法
    boolean InsertSolution(List<PaperSolution> paperSolutions); // 将答案存入paper_solution表
    boolean ReviewSolution(int piid, int sid) throws SQLException; // 阅卷
    List<PaperSolution> FindSolution(int piid, int sid) throws SQLException; // 根据piid，sid在paper_solution表中返回
}
