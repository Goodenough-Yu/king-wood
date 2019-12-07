package com.yunexam.service;

public interface PaperInfoService {
    int CreatePaper(int eiid); // 根据EIid创建试卷，返回PIid
    int[] FindPaper(int piid); // 根据PIid查找试卷，返回所有QBid(数组)
    int[] InsertQuestion(int piid); // 根据PIid生产试卷试题，返回QBid(数组)
    int[] FindQusetion(int piid); // 根据PIid返回QBid(数组)
}
