package com.yunexam.dao;

import com.yunexam.domain.Course;

import java.sql.SQLException;

public interface CourseDao {
    Course FindCourseBycid(int cid) throws SQLException; // 根据Cid查找课程
}
