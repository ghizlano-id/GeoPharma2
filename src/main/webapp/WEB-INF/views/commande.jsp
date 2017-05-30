<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title></title>
      	<meta charset="UTF-8" />
		<link href="<c:url value="/resources/CSS/commande.css" />" rel="stylesheet">

</head>
<body>



         <table cellspacing="20">
         	<tr>
         	<c:forEach var="l" items="${listmed}">
            
             <td class="d">
          <img src="<c:url value="/resources/img/ajouter-m.jpg"/>" width="100" height="100"/><br>
              <span>${l.nom}</span><br/>	
              <span style="color:blue"> ${l.prix}DH </span><br/>
          <a href="<c:url value="/commander?id=${l.nom}"/>">
          
          <button type="button" >Ajouter</button> </a>
       
           
         </td>

     
            </c:forEach>
      </tr>
         



         </table>


        <a href="<c:url value="getpanier/"/>">
          
          <button type="button" >Panier</button> </a>
    


</body>
</html>