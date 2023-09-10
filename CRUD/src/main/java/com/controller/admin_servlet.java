package com.controller;

import com.dao.adminDAO;
import com.model.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "admin_servlet", value = "/login")

public class admin_servlet extends HttpServlet {
    adminDAO dao;
    @Override
    public void init(){
        dao = new adminDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("seconnecter.jsp");
    dispatcher.forward(request , response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");

//        admin admin = new admin();
//        admin.setId(parseInt(id));
//        admin.setEmail(email);
//        admin.setName(name);
//        admin.setPassword(password);
//
//        try {
//            dao.registerAdmin(admin);
//        } catch (Exception e) {

//            e.printStackTrace();
//        }
//
//        response.sendRedirect("seconnecter.jsp");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        admin admin = new admin();
        admin.setEmail(email);
        admin.setPassword(password);

        try {
            if (dao.adminvalidate(admin)) {
                System.out.println("true");
                response.sendRedirect("List");
            } else {
                System.out.println("false");
                RequestDispatcher dispatcher = request.getRequestDispatcher("seconnecter.jsp");
                dispatcher.forward(request , response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
