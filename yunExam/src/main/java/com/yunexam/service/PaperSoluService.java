package com.yunexam.service;

public interface PaperSoluService {
    int InsertSolution(int piid,int sid,int qbid,int[] solu); // 根据试卷id，学生id，题目id将答案存入paper_solution表
    boolean ReviewSolution(int piid,int sid); // 阅卷
    int[] FindSolution(int piid,int sid); // 根据piid，sid在paper_solution表中返回qbid（数组）
    int FindAllPaper(int sid); // 返回sid的所有piid
}
