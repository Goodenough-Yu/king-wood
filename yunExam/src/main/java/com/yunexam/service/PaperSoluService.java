package com.yunexam.service;

import com.yunexam.domain.PaperSolution;

import java.sql.SQLException;
import java.util.List;

public interface PaperSoluService {
    boolean InsertSolution(List<PaperSolution> paperSolutions,int piid,int sid,int qbid); // 将答案存入paper_solution表
    boolean ReviewSolution(int piid,int sid) throws SQLException; // 阅卷
    List<PaperSolution> FindSolution(int piid,int sid) throws SQLException; // 根据piid，sid在paper_solution表中返回
}
