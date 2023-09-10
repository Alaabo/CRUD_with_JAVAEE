<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="icon" type="image/x-icon" href="Icon.png">
	 <style><%@include file="/WEB-INF/seconnecter.css"%></style>
	<title> se connecter</title>
</head>
<body>
   <form action="<%= request.getContextPath() %>/login" method="post">
  <h1>Connexion:</h1>
      
         <table class="form-style">
            <tr>
               <td>
                  <label>
                    Email <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input type="text" name="email" class="long"/>
                  
               </td>
            </tr>
            <tr>
               <td>
                  <label>
                     Mot de passe <span class="required">*</span>
                  </label>
               </td>
               <td>

            <input type="password"id="ps"name="password" class="long"/>
                 
                  
               </td>
            </tr>
            
            <tr>
               <td>
                  <input type="submit" value="Connecter">      
                  <input type="reset" value="Retour"> 
               </td>
            </tr>
         </table>
      </form>

</body>
</html>