package com.ifox.hgx.domain;

import java.sql.Timestamp;

public class Users {
    private  String email ;
    private  String password ;
    private  String name ;
    private  Integer id ;
    private  Timestamp createAt ;
    private  Timestamp updateAt ;


    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Users() {
    }

    public Users(String email, String password, String name, Integer id, Timestamp createAt, Timestamp updateAt) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.id = id;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
