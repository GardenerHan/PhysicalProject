package com.ifox.hgx.dao.proxy;

import com.ifox.hgx.dao.UserDAO;
import com.ifox.hgx.dao.impl.UserDAOImpl;
import com.ifox.hgx.domain.Users;

public class UserDAOProxy implements UserDAO{
    @Override
    public boolean registered(Users users) {
        return new UserDAOImpl().registered(users) ;
    }

    @Override
    public boolean login(String email, String password) {
        return new UserDAOImpl().login(email,password);
    }
}
