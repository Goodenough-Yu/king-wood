package com.yunexam.dao;

import com.yunexam.domain.Grade;

import java.sql.SQLException;
import java.util.List;

public interface GradeDao {
    Grade FindGradeBygid(int gid) throws SQLException; // 根据gid查找成绩
    List<Grade> FindGradeBysid(int sid) throws SQLException; // 根据sid查找成绩
    List<Grade> FindGradeBysidAndpiid(int sid,int piid) throws SQLException; // 根据sid和piid查找成绩
}
