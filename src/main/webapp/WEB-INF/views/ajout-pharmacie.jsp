<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="header" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout pharmacie</title>
	
</head>
<body>

  <header:header /> 
  <div class="container">
	  <div class="row">
	  	<div class="col-md-offset-2 col-md-8 pharma">
	  	<c:url value="/ajouter2" var="url"/>
  		<form:form action="${url}" method="POST" command="pharmacie" class="form-horizontal"> 
	  	
		   <fieldset > 
		    <legend><h1>Pharmacie</h1></legend> 
		    <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label" >Nom :</label>
		      <div class="col-md-6">
		        <form:input path="name" class="form-control"  required="required"/>
		      </div>
		    </div>
		     <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label" >Adresse :</label>
		      <div class="col-md-6">
		        <form:input path="adresse" class="form-control" required="required" />
		      </div>
		    </div>
		     <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label" >Laltitude :</label>
		      <div class="col-md-6">
		        <form:input path="x" class="form-control"  required="required"/>
		      </div>
		    </div>
		     <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label" >Longitude :</label>
		      <div class="col-md-6">
		        <form:input path="y" class="form-control"  required="required"/>
		      </div>
		    </div>
		    <div  class="form-group row">
		      <label class="col-md-offset-1 col-md-2 control-label" ></label>
		      <div class="col-md-4">
		        <input type="submit" value="enregistrer" class="btn btn-success btn-login"/>
		      </div>
		    </div>
		    	<input type="hidden" name="cinAttrribute" value="${cin}" />
		   </fieldset>
   		 </form:form>
	  	</div>
	  </div>	
  </div>
<%--   <c:url value="/ajouter2" var="url"/> --%>
<%--   <form:form action="${url}" method="post" command="pharmacie"> --%>
<!--    <fieldset> -->
<!--     <legend>Pharmacie</legend> -->
<!--    <table> -->
<!--      <tr> -->
<!--         <td class="leftColumn">Nom :</td> -->
<%--         <td><form:input path="name" class="field" /></td> --%>
<!--      </tr> -->
<!--       <tr> -->
<!--         <td class="leftColumn">adresse :</td> -->
<%--         <td><form:input path="adresse" class="field" /></td> --%>
<!--      </tr> -->
<!--       <tr> -->
<!--         <td class="leftColumn">Latitude :</td>  -->
<%--         <td><form:input path="x" class="field" /></td> --%>
<!--      </tr> -->
<!--       <tr> -->
<!--         <td class="leftColumn">Longitude :</td> -->
<%--         <td><form:input path="y" class="field"/></td> --%>
<!--      </tr> -->
<!--      <tr> -->
<!--   	   <td></td> -->
<!--        <td>	<input type="submit" value="enregistrer" id="nexto"/></td> -->

<%--        <td>	<input type="hidden" name="cinAttrribute" value="${cin}" /><br/></td> --%>
<!--      </tr> -->
<!--      <tr> -->
<%--        <td>	<input type="hidden" name="var" value="${cin}" /><br/></td> --%>
<!--      </tr> -->
<!--     </table> -->
<!--     </fieldset> -->
<%--  </form:form> --%>
</body>
</html>