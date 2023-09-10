
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
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
            <a href="https://www.xadmin.net" class="navbar-brand"> User Management Application </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/List"
                   class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="new" method="post">


                <caption>
                    <h2>

                            Add New User

                    </h2>
                </caption>




                <fieldset class="form-group">
                    <label>ID</label> <input type="text"
                                                    value="<c:out value='${user.id}' />" class="form-control"
                                                    name="id" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>User Name</label> <input type="text"
                                                    value="<c:out value='${user.nom}' />" class="form-control"
                                                    name="nom" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>User Email</label> <input type="text"
                                                     value="<c:out value='${user.prenom}' />" class="form-control"
                                                     name="prenom">
                </fieldset>

                <fieldset class="form-group">
                    <label>User Country</label> <input type="text"
                                                       value="<c:out value='${user.datenaiss}' />" class="form-control"
                                                       name="datenaiss">
                </fieldset>
                <fieldset class="form-group">
                    <label>User sexe</label> <input type="text"
                                                    value="<c:out value='${user.sexe}' />" class="form-control"
                                                    name="sexe">
                </fieldset>
                <fieldset class="form-group">
                    <label>User bac</label> <input type="text"
                                                   value="<c:out value='${user.numbac}' />" class="form-control"
                                                   name="numbac">
                </fieldset>
                <fieldset class="form-group">
                    <label>User date</label> <input type="text"
                                                    value="<c:out value='${user.dateinsc}' />" class="form-control"
                                                    name="dateinsc">
                </fieldset>



                <button type="submit" class="btn btn-success">Save</button>
            </form>

        </div>
    </div>
</div>
</body>
</html>