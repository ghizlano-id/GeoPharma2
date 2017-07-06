<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/CSS/update.css"/>" rel="stylesheet">
<title>Ajout</title>
	
</head>

<body>
<div>

   <div id="top">Modifier un médicament</div>

       <div id="form"> 

 <form:form method="POST" action="update2/${id}" command="pharmacie_medicament"> 

   
   <table cellpadding="15px">
      <tr>
        <td class="champ">Nom du médicament</td>
        <td>          
         <form:select  path="medicament.nom"  class="field">
    <form:options items="${listmed}" class="select"></form:options>
    </form:select></td>
     </tr>
      <tr>
        <td class="champ" >Quantité ajoutée</td>
        <td><form:input path="quantite" class="select"/></td>
     </tr>
     <tr>
       <td></td>
       <td>	<input type="submit" value="Update"  id="btn"></td>
     </tr>
    </table>
  
 </form:form>
 </div>
 </div>
</body>
</html>