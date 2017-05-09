<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout pharmacie</title>
</head>
<body>
	<form:form action="ajouter2" method="POST" command="pharmacie">
   <fieldset>
    <legend>Pharmacie</legend>
   <table>
     <tr>
        <td>Nom :</td>
        <td><form:input path="name"/></td>
     </tr>
      <tr>
        <td>adresse :</td>
        <td><form:input path="adresse"/></td>
     </tr>
      <tr>
        <td>Longitude :</td>
        <td><form:input path="x"/></td>
     </tr>
      <tr>
        <td>Latitude :</td>
        <td><form:input path="y"/></td>
     </tr>
     
     <tr>
       <td>	<input type="hidden" name="var" value="CIN" /><br/></td>
     </tr>
  	 
  	 <tr>
       <td>	<input type="submit" value="Save" /><br/></td>
     </tr>
    </table>
    </fieldset>
 </form:form>

</body>
</html>