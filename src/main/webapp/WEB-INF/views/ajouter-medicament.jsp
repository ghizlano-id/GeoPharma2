<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"  >

<html>
<head>
<meta charset="UTF-8">
<title>Ajouter</title>



<link href="<c:url value="/resources/CSS/ajouter-medicament.css" />" rel="stylesheet">


</head>

<body>
<f:form action="ajouter/${id} " method="post" command="pharmacie_medicament">
  <table cellpadding="15px">
  	<tr>
  		<td class="champ">Nom de M�dicament</td>

      <td>
  
   <f:select  path="medicament.nom">
    <f:options items="${listmed}"></f:options>
    </f:select>
      	
      </td>
  	</tr>

  	  	<tr>
  		<td class="champ">Quantit� de M�dicament</td>

      <td>
      	<f:input path="quantite"/>
      	
      </td>
 
  	  	<tr> 
  	        
  	          <td></td>
  	    

      <td>
      	<input type="submit" value="Ajouter"/>
      
      </td>
  	</tr>



  </table>	


</f:form>

</body>


</html>
