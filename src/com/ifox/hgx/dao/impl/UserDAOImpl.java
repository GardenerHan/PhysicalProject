package com.ifox.hgx.dao.impl;

import com.ifox.hgx.dao.UserDAO;
import com.ifox.hgx.db.operating.UsersCRUD;
import com.ifox.hgx.domain.Users;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean registered(Users users) {
        String sql = "INSERT INTO users VALUES("+users.getId()+","+users.getEmail()+","+users.getPassword()+","+users.getName()+",'"+users.getCreateAt()+"','"+users.getUpdateAt() + "')" ;
        return UsersCRUD.create(sql) ;
    }

    @Override
    public Users login(String email, String password) {
        boolean flag = false ;
        String sql = "select id,email,password,name,createdAt,updatedAt from users where email = ? and password = ? ";
       List<List<Users>> lists = UsersCRUD.result(sql,email,password) ;
       List<Users> list = lists.get(0) ;
        Users user = null;
        System.out.println(list.size());
       if (list.size() >0)
           user = list.get(0) ;
        return user ;

    }
}
