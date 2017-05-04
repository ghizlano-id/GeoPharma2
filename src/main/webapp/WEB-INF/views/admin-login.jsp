<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="<c:url value="/resources/CSS/admin-login.css" />" rel="stylesheet">
</head>
<body>
	<form >
	    <input type="email" name="email" placeholder="email"/><br/><br/>
		<input type="password" name="mdp" placeholder="Mot de passe" /><br/><br/><br/>
	  	<input type="submit" value="SE CONNECTER"/><br/>
  </form>
</body>
</body>
</html>