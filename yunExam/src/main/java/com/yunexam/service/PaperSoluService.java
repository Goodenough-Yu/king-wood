package com.yunexam.service;

import com.yunexam.domain.PaperSolution;

import java.util.List;

public interface PaperSoluService {
    int InsertSolution(List<PaperSolution> paperSolutions); // 将答案存入paper_solution表
    boolean ReviewSolution(int piid,int sid); // 阅卷
    List<PaperSolution> FindSolution(int piid,int sid); // 根据piid，sid在paper_solution表中返回
    List<Integer> FindAllPaper(int sid); // 返回sid的所有piid
}
