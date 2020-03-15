package com.allen.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2、获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?useSSL=false&serverTimezone=UTC","root","991104");
        //3、获取操作数据库的预处理对象
        String sql = "select * from account ";
        PreparedStatement pstm = conn.prepareStatement(sql);
        //4、执行sql，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5、遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6、释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
