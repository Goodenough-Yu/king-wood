package com.yunexam.dao;

import com.yunexam.domain.QuestionBank;

import java.sql.SQLException;
import java.util.List;

public interface QuesBankDao {
    boolean AddQuesBank(QuestionBank QB); // 在Qusetion_Bank中新增题目
    QuestionBank FindQuesBankByqbid(int qbid) throws SQLException; // 根据qbid获取题目
    List<Integer> FindQuestion(int cid, int is_single, int degree) throws SQLException; // 根据题目信息获取题目
}
