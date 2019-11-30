package com.yunexam.dao;

import java.sql.*;

public class BaseDao {

    // 获取数据库连接
    public Connection getConnection() {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/javaexam";
        String username = "root";
        String password = "hsy98106";

        Connection con = null;

        try {
            // 加载数据库驱动类
            Class.forName(driverClassName);
            // 连接数据库
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动类加载失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
        return con;
    }

    // 完成 DML 操作：insert，delete，update
    public int executeUpdate(String sql, Object[] params) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int n = 0;

        try {
            // 连接数据库
            con = this.getConnection();
            // 获取命令发送器
            pstmt = con.prepareStatement(sql);
            // 发送命令得到结果
            for (int i = 0;i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            n = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("数据操作失败");
            e.printStackTrace();
        } finally {
            // 关闭资源
            this.closeAll(null, pstmt, con);
        }
        return n;
    }

    // 关闭资源
    public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
