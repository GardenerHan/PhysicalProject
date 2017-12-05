package com.ifox.hgx.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* 数据库操作工具类
*
* @author guixain
*
*/
public class JDBCTools {
/**
 * 执行删除操作 用法范例:String sql = "delete from user where id =    ?" ; boolean flag =JDBCTools.update(sql, 1) ;
 *
 * @param sql  sql语句
 * @param o    删除的标志列
 */
public static Boolean delete(String sql, Object o) {
    Boolean flag = false;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = DatabaseConnection.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setObject(1, o);
        if (ps.executeUpdate() > 0) {
            flag = true;
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    JDBCTools.close(null, ps, conn);
    return flag;
}

/**
 * 修改操作 用法范例:String sql = "update user set username=?,password = ? ,balance = ?
 * where username = ?"; boolean flag = JDBCTools.update(sql, "奥拉fu", "233423",567, "Jerry");
 *
 * @param sql    sql语句
 * @param args   修改的记录的列的参数
 */
public static boolean update(String sql, Object... args) {
    System.out.println("sql:"+sql);
    Boolean flag = false;
    PreparedStatement ps = null;
    Connection conn = null;
    try {
        conn = DatabaseConnection.getConnection();
        ps = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        if (ps.executeUpdate() > 0) {
            flag = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    JDBCTools.close(null, ps, conn);
    return flag;
}

/**
 * 执行查找 用法范例: String sql = "select id,username,password,balance from user where
 * id like ?"; List<List<Object>> list = new ArrayList<>(); List<Object> list2 = null; list = JDBCTools.query(sql, 1); for (int i = 0; i < list.size(); i++) { list2 = list.get(i); for (int j = 0; j < list2.size(); j++) { System.out.println(i+1 + "属性:" + list2.get(j)); } }
 *
 * @param sql  sql语句
 * @return     结果集List里面存储了装了Object对象的List
 */
public static List<List<Object>> result(String sql, Object... args) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;
    List<List<Object>> list = new ArrayList<>();
    List<Object> list2 = null;
    try {
        conn = DatabaseConnection.getConnection();
        ps = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            if (sql.indexOf("like") != -1) {
                ps.setObject(i + 1, "%" + args[i] + "%");
            } else {
                ps.setObject(i + 1, args[i]);
            }
        }
        rs = ps.executeQuery();
        int m = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            list2 = new ArrayList<>();
            for (int k = 0; k < m; k++) {
                list2.add(rs.getString(k + 1));
            }
            list.add(list2);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    JDBCTools.close(rs, ps, conn);
    return list;

}

/**
 * 关闭相关操作
 *
 * @param rs   ResultSet 对象
 * @param ps   PreparedStatement 对象
 * @param conn Connection 对象
 */
public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
    if (rs != null) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (ps != null) {
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (conn != null) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
}
