package com.ifox.hgx.servlet;

import com.ifox.hgx.domain.Users;
import com.ifox.hgx.handle.UserHandle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8") ;
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Users result = UserHandle.UHLogin(email, password);
        PrintWriter out = response.getWriter();

        if (result != null) {
            String userJson = "{\"user\":{\"id\":"+result.getId()+",\"email\":"+result.getEmail()+",\"password\":"+result.getPassword()+
                                        ",\"name\":"+result.getName()+",\"createAt\":"+result.getCreateAt()+",\"updateAt\":"+result.getUpdateAt()+"}}";
            System.out.println(userJson);
            out.print(userJson);
        }else {
            out.print("error");
        }

    }
}
