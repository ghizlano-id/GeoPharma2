<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
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
<form:form   action="login" method="post"    >
	<div class="login-form">

		<div class="form-group ">
			<form:input path="email" class="saisi" placeholder="Username " id="UserName" name="login"/>
			
		</div>
		<div class="form-group">
			<form:password path="password" class="saisi" placeholder="Password" id="Passwod" name="pwd"/>
				
		</div>

		<a class="link" href="#">Lost your password?</a>
	 <a href="http://localhost:8080/gestion-pharmacie/test">
            <input type="submit" value="Log in" class="btn"/>
        
				
			
					</button>


	</div>
     </form:form>
</body>
</html>
