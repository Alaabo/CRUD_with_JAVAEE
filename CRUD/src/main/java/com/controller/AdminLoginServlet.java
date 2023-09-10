package com.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "AdminLoginServlet", value = "/admin")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("hello nigger get");
        request.getRequestDispatcher("List").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("hello nigger frokm post");
        request.getRequestDispatcher("List").forward(request , response);
    }
}
