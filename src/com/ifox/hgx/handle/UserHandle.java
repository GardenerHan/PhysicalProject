package com.ifox.hgx.handle;

import com.ifox.hgx.dao.proxy.UserDAOProxy;
import com.ifox.hgx.domain.Users;

public class UserHandle {
    public static boolean UHLogin(String email,String password){
        return  new UserDAOProxy().login(email,password) ;
    }
    public  static  boolean UHRegistered(Users users){
        return  new UserDAOProxy().registered(users) ;
    }
}
