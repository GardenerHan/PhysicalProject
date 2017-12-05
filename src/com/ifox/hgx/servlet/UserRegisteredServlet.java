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
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "UserRegisteredServlet", urlPatterns = "/userRegisteredServlet")
public class UserRegisteredServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Timestamp t=new Timestamp(new Date().getTime());
        Users users = new Users(email, password, null, 100001 + IDandDate.getID(), t, t);
        boolean result =  UserHandle.UHRegistered(users);
        PrintWriter out = response.getWriter();
        if (result){
           out.print("true");
        }else {
           out.print("false");
        }







    }
}

