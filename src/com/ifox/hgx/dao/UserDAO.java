package com.ifox.hgx.dao;

import com.ifox.hgx.domain.Users;

public interface UserDAO {
    boolean registered(Users users) ;
    Users login(String email, String password);
}
