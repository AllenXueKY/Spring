package com.allen.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.注册驱动(mysql8.0不需要加载驱动，SPI自动注册)
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //2.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","991104");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = con.prepareStatement("select * from account");
        //4.执行SQL，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        con.close();
    }
}
