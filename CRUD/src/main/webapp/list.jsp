<%@ page import="com.model.etudient" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>User Management Application</title>
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>

<header>
  <nav class="navbar navbar-expand-md navbar-dark"
       style="background-color: blue">
    <div>
      <a href="https://www.xadmin.net" class="navbar-brand"> User
        Management Application </a>
    </div>

    <ul class="navbar-nav">
<%--      <li><a href="<%=request.getContextPath()%>/List"--%>
<%--             class="nav-link">Users</a></li>--%>
    </ul>
  </nav>
</header>
<br>

<div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
    <h3 class="text-center">List of Users</h3>
    <hr>
    <div class="container text-left">

      <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
        New User</a>
    </div>
    <br>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>ID</th>
        <th>nom</th>
        <th>prenom</th>
        <th>datenaiss</th>
        <th>sexe</th>
        <th>numbac</th>
        <th>dateinsc</th>


      </tr>
      </thead>
      <tbody>
      <%
        List<etudient> listUser =
              (List<etudient>)request.getAttribute("ListUser");
        for(etudient e :listUser){

       %>
      <tr>
        <td><%out.print(e.getId());%> </td>
        <td><%out.print(e.getNom());%></td>
        <td><%out.print(e.getPrenom());%> </td>
        <td><%out.print(e.getDateNaiss());%> </td>
        <td><%out.print(e.getSexe());%> </td>
        <td><%out.print(e.getNumBac());%> </td>
        <td><%out.print(e.getDateInsc());%> </td>



          <td><a href="update">Update</a>
            &nbsp;&nbsp;&nbsp;&nbsp; <a
                    href="delete?id=<%out.print(e.getId());%>">Delete</a></td>

      </tr>
      <%}%>


      </tbody>

    </table>
  </div>
</div>
</body>
</html>