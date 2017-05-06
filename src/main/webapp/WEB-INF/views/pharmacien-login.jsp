<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"  >

<html>
<head>
<meta charset="UTF-8">
<title>Login</title>


<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>

<link href="<c:url value="/resources/CSS/pharmacien-login.css" />" rel="stylesheet">


</head>

<body>
	<div class="login-form">

		<div class="form-group ">
			<input type="text" class="saisi" placeholder="Username "
				id="UserName"> <i class="fa fa-user"></i>
		</div>
		<div class="form-group">
			<input type="password" class="saisi" placeholder="Password"
				id="Passwod"> <i class="fa fa-lock"></i>
		</div>

		<a class="link" href="#">Lost your password?</a>
		<button type="button" class="btn">Log in</button>


	</div>

</body>
</html>
