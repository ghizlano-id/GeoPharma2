<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p> les informations que vous avez saisi sont :</p>
	<%@ page import="java.util.List" %>
	<%@ page  import="java.util.Set" %>
	<%
	Set<String> idMeds=(Set<String>)request.getSession().getAttribute("idMeds") ; 
	
	if(idMeds!=null){
		for(String med :idMeds){
	%>
   <p><%=med %></p>


	 <%} }%>
</body>
</html>