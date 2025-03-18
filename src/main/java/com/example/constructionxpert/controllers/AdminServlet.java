package com.example.constructionxpert.controllers;
import com.example.constructionxpert.DAO.AdminDAO;
import com.example.constructionxpert.Models.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class AdminServlet extends HttpServlet {
    private AdminDAO adminDAO;

    @Override
    public void init() {
        adminDAO = new AdminDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Admin admin = adminDAO.login(email, password);
        if (admin != null) {
            request.getSession().setAttribute("admin", admin);
            response.sendRedirect("project.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}