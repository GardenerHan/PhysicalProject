package com.ifox.hgx.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 通过读取资源文件连接数据库的类
 * @author guixain
 *
 */
public class DatabaseConnection {
    private static String driver ;
    private static String url ;
    public static String user ;
    public static String pass ;
    static {
        InputStream in = DatabaseConnection.class.getClassLoader()
                .getResourceAsStream("JDBC.properties") ;
        Properties properties = new Properties() ;
        try {
            properties.load(in);
            driver = properties.getProperty("driver") ;
            url = properties.getProperty("url") ;
            user= properties.getProperty("user") ;
            pass = properties.getProperty("pass") ;
            Class.forName(driver) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接
     * @return Connection
     */
    public static Connection getConnection() {

        Connection conn = null ;
        try {
            conn =  DriverManager.getConnection(url, user, pass) ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  conn;

    }
}