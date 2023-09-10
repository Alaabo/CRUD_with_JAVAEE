package com.controller;

import com.dao.etudientDAO;
import com.model.etudient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewEtudientServlet", value = "/new")
public class NewEtudientServlet extends HttpServlet {
    etudientDAO DAO;
    public void init(){
        DAO = new etudientDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user-form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String datenaiss = request.getParameter("datenaiss");
        String sexe = request.getParameter("sexe");
        Integer numbac = Integer.valueOf(request.getParameter("numbac"));
        String dateinsc = request.getParameter("dateinsc");
        etudient newUser = new etudient(id ,nom, prenom, datenaiss , sexe , numbac , dateinsc );
        try {
            DAO.insertUser(newUser);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("List");
    }
}
