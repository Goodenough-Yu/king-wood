package com.yunexam.dao;

import com.yunexam.domain.PaperInformation;

import java.sql.SQLException;

public interface PaperInfoDao {
    boolean AddPaperInfo(PaperInformation PI); // 在paper_information表中新建试卷
    PaperInformation FindPaperInfoBypiid(int piid) throws SQLException; // 根据piid从paper_information表中得到改试卷信息
    PaperInformation FindPaperInfoByeiid(int piid,int eiid) throws SQLException; // 根据piid和eiid从paper_information表中得到改试卷信息
}
