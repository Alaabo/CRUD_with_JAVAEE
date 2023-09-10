package com.controller;

import com.dao.etudientDAO;
import com.model.etudient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListEtudientsServlet", value = "/List")
public class ListEtudientsServlet extends HttpServlet {
    etudientDAO dao;
    public void init(){
        dao = new etudientDAO()
                ;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
           List<etudient> listUser = dao.selectAllUsers();
            request.setAttribute("ListUser", listUser);
            request.getRequestDispatcher("list.jsp").forward(request,response);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request , response);
    }
}
