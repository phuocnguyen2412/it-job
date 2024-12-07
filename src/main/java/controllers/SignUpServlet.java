package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bo.AccountBO;

import java.io.IOException;

public class SignUpServlet extends BaseController{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // chuyển đến form đăng ký
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        if(!AccountBO.checkExistEmail(email)){
            // add
            // list top company
            // add to request
            // chuyển đến trang welcome
        }
        else{
            // cút về signUp
        }
    }
}
