<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="<c:url value="/resources/CSS/admin-login.css" />" rel="stylesheet">
</head>

<body>
<%-- 	<form:form action="PageAcceuilAdmin" method="POST" > --%>
<%-- 		<form:input type="email" path="email" placeholder="email"/><br/><br/> --%>
<%-- 		<form:password path="password" placeholder="Mot de passe" /><br/><br/><br/> --%>
<!-- 		<input type="submit" value="SE CONNECTER" /><br/> -->
<%--    </form:form> --%>
<div class="container">
    <div class="row vertical-offset-100">
    	<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Please sign in</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form:form action="login" method="POST" >
                    <fieldset>
                    	<c:if test="${!empty erreur }">
			    			<div class="alert alert-danger">${erreur }</div>
			    		</c:if>
			    	  	<div class="input-group">
			    	  		<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			    		    <form:input path="email" class="form-control" placeholder="E-mail" name="login" type="text" />
			    		</div>
			    		<div class="input-group">
			    			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
			    			<form:input path="password" class="form-control" placeholder="Password" name="pwd" type="password"/>
			    		</div>
			    		<input class="btn btn-lg btn-success btn-block btn-login" type="submit" value="Login">
			    	</fieldset>
			      	</form:form>
			    </div>
			</div>
		</div>
	</div>
</div>
</body>
</body>
</html>