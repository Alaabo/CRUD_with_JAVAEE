package com.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import com.dao.adminDAO;
import com.model.admin;

import static java.lang.Integer.parseInt;

@WebServlet(name = "helloServlet", value = "/connexion")
public class HelloServlet extends HttpServlet {
private adminDAO dao;

    public void init() {
        dao = new adminDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("seconnecter.jsp").forward(request,response);
    }


}