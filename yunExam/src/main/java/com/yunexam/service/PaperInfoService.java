package com.yunexam.service;

import com.yunexam.domain.QuestionBank;

import java.sql.SQLException;
import java.util.List;

public interface PaperInfoService {
    int CreatePaper(int eiid); // 根据EIid创建试卷，返回PIid
    List<Integer> FindPaper(int piid); // 根据PIid查找试卷，返回所有QBid(数组)
    List<Integer> InsertQuestion(int piid) throws SQLException; // 根据PIid生产试卷试题，返回QBid(数组)
    QuestionBank FindQusetion(int piid); // 根据PIid返回QBid(数组)
}
