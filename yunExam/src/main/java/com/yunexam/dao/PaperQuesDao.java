package com.yunexam.dao;

import com.yunexam.domain.PaperQuestion;

import java.sql.SQLException;
import java.util.List;

public interface PaperQuesDao {
    boolean AddPaperQues(PaperQuestion PQ); // 将试题插入paper_question
    List<PaperQuestion> FindPaperQues(int piid) throws SQLException; // 根据piid返回qbid
}
