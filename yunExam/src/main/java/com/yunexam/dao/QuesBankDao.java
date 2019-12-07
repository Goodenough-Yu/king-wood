package com.yunexam.dao;

import com.yunexam.domain.QuestionBank;

public interface QuesBankDao {
    boolean AddQuesBank(QuestionBank QB); // 在Qusetion_Bank中新增题目
    QuestionBank FindQuesBankByqbid(int qbid); // 根据qbid获取题目
    int[] FindQuestion(int cid,int is_single,int degree); // 根据题目信息获取题目
}
