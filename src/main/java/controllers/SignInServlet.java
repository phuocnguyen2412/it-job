package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.bo.AccountBO;

import java.io.IOException;

@WebServlet(name = "SignInServlet", urlPatterns = "account/login")
public class SignInServlet extends BaseController{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        // chuyển đến form đăng nhập
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(AccountBO.checkSignIn(email, password)){
            // list top company
            // add to request
            // chuyển đến trang welcome
        }
        else{
            request.setAttribute("errorMessage", "Invalid username or password!");
            // cút về login
        }
    }
}
