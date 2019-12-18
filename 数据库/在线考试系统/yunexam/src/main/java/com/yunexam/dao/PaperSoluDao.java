package com.yunexam.dao;

import com.yunexam.domain.PaperSolution;

import java.sql.SQLException;
import java.util.List;

public interface PaperSoluDao {
    boolean AddPaperSolu(PaperSolution PS); // 在表Paper_solution中新建
    List<PaperSolution> FindPaperSolu(int piid, int sid) throws SQLException; // 根据piid和sid查
    boolean UpdatePaperSolu(PaperSolution PS); // 修改答题（打分）
    List<Integer> FindPaperSoluBysid(int sid) throws SQLException; // 返回学生的所有已做试卷
}
