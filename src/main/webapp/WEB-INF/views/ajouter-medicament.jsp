<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"  >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter</title>


<link href="<c:url value="/resources/CSS/ajouter-medicament.css"/>" rel="stylesheet">



</head>

<body>
           
    <div id="top">Ajouter un nouveau médicament</div>

       <div id="form">                     
<f:form action="ajout" method="post" command="pharmacie_medicament"> 
  <table cellpadding="15px">
  	<tr>
  		<td class="champ">Nom de Médicament</td>

      <td>
  
   <f:select  path="medicament.nom" class="select">
    <f:options items="${listmed}"></f:options>
    </f:select>
      	
      </td>
  	</tr>

  	  	<tr>
  		<td class="champ">Quantité de Médicament</td>

      <td>
      	<f:input path="quantite" class="select"/>
      	
      </td>
 
  	  	<tr> 
  	        
  	        <td></td>
  	        
  	    

      <td >
      	<input type="submit" value="Ajouter" id="btn"/>
      
      </td>
      <td></td>
  	</tr>



  </table>	


</f:form>
 </div>
 <footer>&copy; Tous droits réservés</footer>
</body>


</html>
