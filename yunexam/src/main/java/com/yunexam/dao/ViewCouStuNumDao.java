package com.yunexam.dao;

import com.yunexam.domain.StunumCourse;

import java.sql.SQLException;
import java.util.List;

public interface ViewCouStuNumDao {
    List<StunumCourse> FindNumAll() throws SQLException; // 返回每门课程的人数
}
