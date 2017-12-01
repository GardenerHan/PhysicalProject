package com.ifox.hgx.servlet;

import com.ifox.hgx.domain.Users;
import com.ifox.hgx.handle.UserHandle;
import com.ifox.hgx.tools.IDandDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "UserRegisteredServelt", urlPatterns = "/userRegisteredServelt")
public class UserRegisteredServelt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        int id = 100001 + IDandDate.getID();
        Date date=new Date();
        Timestamp t=new Timestamp(date.getTime());
        Timestamp createAt  = t ;
        Timestamp updateAt  = t ;
        Users users = new Users(email, password, name, id, createAt, updateAt);
        boolean result =  UserHandle.UHRegistered(users);



        if (result){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }







    }
}

