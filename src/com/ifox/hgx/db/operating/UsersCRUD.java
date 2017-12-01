package com.ifox.hgx.db.operating;

import com.ifox.hgx.db.JDBCTools;
import com.ifox.hgx.domain.Users;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UsersCRUD{
    public  static Boolean create(String insert ,Object...args){
        return JDBCTools.update(insert,args) ;
    }

    public  static List<List<Users>> result(String result,Object...args){
        List<List<Object>> list =  JDBCTools.result(result,args);
        List<Object> list2 = null;
        List<Users> listUsers = new ArrayList<>() ;
        List<List<Users>> lists= new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list2 = list.get(i);
            Users users = new Users() ;
            users.setId(Integer.parseInt((String) list2.get(0)));
            users.setPassword((String) list2.get(1));
            users.setEmail((String) list2.get(2));
            users.setName((String) list2.get(3));
            users.setCreateAt(Timestamp.valueOf((String)list2.get(4)));
            users.setUpdateAt(Timestamp.valueOf((String)list2.get(5)));
            listUsers.add(users) ;
        }
        lists.add(listUsers) ;
        return  lists ;
    }

    public  static  boolean update(String update ,Object...args){
        return  JDBCTools.update(update,args) ;
    }

    public  static  boolean delete(String delete,Object...args){
        return JDBCTools.delete(delete,args) ;
    }
}
