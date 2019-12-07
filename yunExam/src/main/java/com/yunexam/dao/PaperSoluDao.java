package com.yunexam.dao;

import com.yunexam.domain.PaperSolution;

public interface PaperSoluDao {
    boolean AddPaperSolu(PaperSolution PS); // 在表Paper_solution中新建
    PaperSolution FindPaperSolu(int piid,int sid); // 根据piid和sid查
}
