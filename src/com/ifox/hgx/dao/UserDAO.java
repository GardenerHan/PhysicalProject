package com.ifox.hgx.dao;

import com.ifox.hgx.domain.Users;

public interface UserDAO {
    boolean registered(Users users) ;
    boolean login(String email,String password);
}
