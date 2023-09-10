
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="icon" type="image/x-icon" href="Icon.png">
    <style><%@include file="/WEB-INF/page1.css"%></style>
    <title> Gestion de la Presence</title>
</head>
<body>
<form >
    <div id="image">
        <img src="business-3d-295.png "style="height: 400px; width:320px;">
    </div>

    <div id="cont">
        <h1>se connecter</h1>
        <h2>pour les administrateurs</h2>
        <br>
        <button ><h3><a href="<%= request.getContextPath() %>/connexion">Se connecter </a></h3></button>
        <br>

        <br>
    </div>
</form>

</body>
</html>