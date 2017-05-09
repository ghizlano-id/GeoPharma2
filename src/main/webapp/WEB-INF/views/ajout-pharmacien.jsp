<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout</title>
</head>
<body>
 <form:form method="POST" action="ajouter1" command="pharmacien">
   <fieldset>
    <legend>Pharmacien</legend>
   <table>
      <tr>
        <td>Nom :</td>
        <td><form:input path="nom"/></td>
     </tr>
      <tr>
        <td>Prenom :</td>
        <td><form:input path="prenom"/></td>
     </tr>
      <tr>
        <td>email :</td>
        <td><form:input type="email" path="email"/></td>
     </tr>
      <tr>
        <td>CIN :</td>
        <td><form:input path="CIN" name="CIN"/></td>
     </tr>
     <tr>
        <td>Tel :</td>
        <td><form:input path="tel" name="tel"/></td>
     </tr>
     <tr>
       <td>	<input type="submit" value="next" /><br/></td>
     </tr>
    </table>
    </fieldset>
 </form:form>
</body>
</html>