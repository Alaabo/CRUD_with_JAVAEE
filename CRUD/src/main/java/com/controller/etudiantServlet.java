//package com.controller;
//
//import com.dao.etudientDAO;
//import com.model.etudient;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Date;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//@WebServlet(name = "etudiantServlet", value = "/etudiant")
//public class etudiantServlet extends HttpServlet {
//    etudientDAO DAO;
//    public void init() {
//       DAO = new etudientDAO();
//    }
//    @Override
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getServletPath();
//        switch (action) {
//            case "/new":
//                showNewForm(request, response);
//                break;
//            case "/insert":
////            {
////                try {
////                    insertUser(request, response);
////                } catch (SQLException ex) {
////                    Logger.getLogger(etudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (ClassNotFoundException e) {
////                    throw new RuntimeException(e);
////                }
////            }
//            break;
//
//            case "/delete":
//            {
//                try {
//                    deleteUser(request, response);
//                } catch (SQLException ex) {
//                    Logger.getLogger(etudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            break;
//
//            case "/edit":
//            {
//                try {
//                    showEditForm(request, response);
//                } catch (SQLException | ClassNotFoundException ex) {
//                    Logger.getLogger(etudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            break;
//
//            case "/update":
////            {
////                try {
////                    updateUser(request, response);
////                } catch (SQLException ex) {
////                    Logger.getLogger(etudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (ClassNotFoundException e) {
////                    throw new RuntimeException(e);
////                }
////            }
//            break;
//
//            default:
//                try {
//                    listUser(request, response);
//                } catch (ClassNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//                break;
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            doGet(request, response);
//    }
//


//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException, ClassNotFoundException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        etudient existingUser = DAO.selectUser(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//        request.setAttribute("user", existingUser);
//        dispatcher.forward(request, response);
//
//    }

////    private void updateUser(HttpServletRequest request, HttpServletResponse response)
////            throws SQLException, IOException, ClassNotFoundException {
////        int id = Integer.parseInt(request.getParameter("id"));
////        String nom = request.getParameter("nom");
////        String prenom = request.getParameter("prenom");
////        Date datenaiss = Integer.parseInt("datenaiss");
////        String sexe = request.getParameter("sexe");
////        String numbac = request.getParameter("numbac");
////        Integer dateinsc = Integer.parseInt("dateinsc");
////
////        etudient book = new etudient(id, nom, prenom, datenaiss , sexe , numbac , dateinsc);
////        DAO.updateUser(book);
////        response.sendRedirect("list");
////    }
//
//    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ClassNotFoundException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        DAO.deleteUser(id);
//        response.sendRedirect("list");
//
//    }
//}
