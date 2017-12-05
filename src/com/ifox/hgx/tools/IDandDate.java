package com.ifox.hgx.tools;

import com.ifox.hgx.db.DatabaseConnection;

import java.sql.*;

public class IDandDate {

    public static int getID() {
        Connection conn = DatabaseConnection.getConnection();
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException e) {

        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery("select * from users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs.last(); // 将光标移动到最后一行
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int rowCount = 0 ;
        try {
             rowCount = rs.getRow(); // 得到当前行号，即结果集记录数
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(rowCount);
        return  rowCount ;
    }



}
