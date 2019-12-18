package com.yunexam.dao;

import java.sql.SQLException;
import java.util.List;

public interface StudentCourseDao {
    List<Integer> FindStuCouBysid(int sid) throws SQLException; // 根据sid查找cid
}
