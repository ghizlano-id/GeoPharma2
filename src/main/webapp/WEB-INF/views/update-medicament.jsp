<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
 <%@ taglib prefix="headerPharmacien" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/CSS/update.css"/>" rel="stylesheet">
<title>Ajout</title>
	
</head>

<body>
     
   <headerPharmacien:headerPharmacien />
   
   <div class="container ">
	  <div class="row">
	  	<div class="col-md-offset-2 col-md-8 pharma">
  		<form:form method="POST" action="updat" command="pharmacie_medicament" class="form-horizontal"> 
	  	
		   <fieldset > 
		    <legend><h1>Modifier un médicament</h1></legend> 
		    
		     <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label"  required="required">Nom médicament :</label>
		      <div class="col-md-6">
		        <form:select  path="medicament.nom"  class="form-control"> 
				  <form:options items="${listmed}" ></form:options>
			    </form:select>
		      </div>
		    </div>
		     <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label"  required="required">Quantité :</label>
		      <div class="col-md-6">
		        <form:input path="quantite" class="form-control"/>
		      </div>
		    </div>
		    <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label" ></label>
		      <div class="col-md-4">
		        <input type="submit" value="Modifier" class="btn btn-success btn-login"/>
		      </div>
		    </div>
		    	
		   </fieldset>
   		 </form:form>
	  	</div>
	  </div>	
  </div>
<!-- <div> -->

<!--    <div id="top">Modifier un médicament</div> -->

<!--        <div id="form">  -->

<%--  <form:form method="POST" action="updat" command="pharmacie_medicament">  <!-- e2/${id} --> --%>

   
<!--    <table cellpadding="20px"> -->
<!--       <tr> -->
<!--         <td class="champ">Nom du médicament</td> -->
<!--         <td>           -->
<%--          <form:select  path="medicament.nom"  class="field"> --%>
<%--     <form:options items="${listmed}" class="select"></form:options> --%>
<%--     </form:select></td> --%>
<!--      </tr> -->
<!--       <tr> -->
<!--         <td class="champ" >Quantité ajoutée</td> -->
<%--         <td><form:input path="quantite" class="select"/></td> --%>
<!--      </tr> -->
<!--      <tr> -->
<!--        <td></td> -->
<!--        <td>	<input type="submit" value="Update"  id="btn"></td> -->
<!--      </tr> -->
<!--     </table> -->
  
<%--  </form:form> --%>
<!--  </div> -->
 
 
 
 
<!--       <div id="div-tab"> -->
<!-- 	   <table id="table-tab"> -->
<!-- 	     <tr> -->
<!-- 	     	<th class="tab">MEDICAMENT</th> -->
<!-- 	     	<th class="tab">QUANTITÉ</th> -->

<!-- 	     </tr> -->
<%-- 	     <c:forEach items="${lpm}" var="l"> --%>
<!-- 		      <tr class="tab"> -->
<%-- 		     	<td class="tab"><c:out value="${l.medicament.nom}"/></td> --%>
<%-- 		     	<td class="tab" ><c:out value="${l.quantite}"/></td> --%>
		     
<!-- 		     </tr> -->
<%-- 	     </c:forEach> --%>
<!-- 	   </table> -->
<!-- 	 </div> -->
 
 
 </div>
</body>
</html>