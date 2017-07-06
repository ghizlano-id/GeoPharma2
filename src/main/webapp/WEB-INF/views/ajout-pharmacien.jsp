<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="header" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout pharmacien</title>
</head>

<body>
  <header:header /> 
  
  <div class="container ">
	  <div class="row">
	  	<div class="col-md-offset-2 col-md-8 pharma">
  		<form:form method="POST" action="ajouter1" command="pharmacien" class="form-horizontal"> 
	  	
		   <fieldset > 
		    <legend><h1>Pharmacien</h1></legend> 
		    <c:if test="${!empty erreur }">
    			<div class="alert alert-danger">${erreur }</div>
    		</c:if>
		    <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label" >Nom :</label>
		      <div class="col-md-6">
		        <form:input path="nom" class="form-control"  required="required"/>
		      </div>
		    </div>
		     <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label" >Prenom :</label>
		      <div class="col-md-6">
		        <form:input path="prenom" class="form-control"  required="required"/>
		      </div>
		    </div>
		     <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label"  required="required">Email :</label>
		      <div class="col-md-6">
		        <form:input type="email" path="email" class="form-control"  required="required"/>
		      </div>
		    </div>
		     <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label" >CIN :</label>
		      <div class="col-md-6">
		        <form:input path="CIN" class="form-control"  required="required"/>
		      </div>
		    </div>
		     <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label"  required="required">Tel :</label>
		      <div class="col-md-6">
		        <form:input path="tel" class="form-control"/>
		      </div>
		    </div>
		    <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label" ></label>
		      <div class="col-md-4">
		        <input type="submit" value="suivant" class="btn btn-success btn-login"/>
		      </div>
		    </div>
		    	
		   </fieldset>
   		 </form:form>
	  	</div>
	  </div>	
  </div>
<%--  <form:form method="POST" action="ajouter1" command="pharmacien"> --%>
<!--    <fieldset> -->
<!--     <legend>Pharmacien</legend> -->
<!--    <table> -->
<!--       <tr> -->
<!--         <td class="leftColumn">Nom :</td> -->
<%--         <td><form:input path="nom" class="field"/></td> --%>
<!--      </tr> -->
<!--       <tr> -->
<!--         <td class="leftColumn" >Prenom :</td> -->
<%--         <td><form:input path="prenom" class="field"/></td> --%>
<!--      </tr> -->
<!--       <tr> -->
<!--         <td class="leftColumn" >email :</td> -->
<%--         <td><form:input type="email" path="email" class="field" /></td> --%>
<!--      </tr> -->
<!--       <tr> -->
<!--         <td class="leftColumn" >CIN :</td> -->
<%--         <td><form:input path="CIN" name="CIN" class="field" /></td> --%>
<!--      </tr> -->
<!--      <tr> -->
<!--         <td class="leftColumn" >Tel :</td> -->
<%--         <td><form:input path="tel" name="tel" class="field"  /></td> --%>
<!--      </tr> -->
<!--      <tr> -->
<!--        <td></td> -->
<!--        <td>	<input type="submit" value="suivant" id="nexto"/></td> -->
<!--      </tr> -->
<!--     </table> -->
<!--     </fieldset> -->
<%--  </form:form> --%>
<!--  </div> -->
</body>
</html>