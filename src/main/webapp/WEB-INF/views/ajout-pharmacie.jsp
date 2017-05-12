<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout pharmacie</title>
	<style type="text/css">
		body{
		margin: 0;
	   }
	   legend{
	   	   font-family:verdana, arial, sans-serif; 
		   font-size:14pt; 
		   font-weight:bold; 
		   color:white; 
		   margin:10px; 
		   padding:5px 10px 5px 10px; 
		   background-color:#AAAAAA; 
		   border-radius:4px; 
	   }
	   fieldset{ 
		   margin:10px; 
		   border:none; 
		   background-color:#eee; 
		   border-radius:10px; 
		   padding:20px; 
		} 
	   div{
	   margin-left:30%;
	   margin-top:10%;
	   height:400px;
	   width:400px;
	   }
	   .field{
	   height: 30px;
	   outline-color:#78AB46; 
	   border:1px solid grey;
	   border-radius: 5px;
	   }
	   input[type="submit"]{
	   	color:white;
		background-color: #78AB46;
		cursor: pointer;
		font-weight: bold;
		height:30px;
		width:90px;
		border:none;
	    border-radius: 5px;
		}
		form{
		 background-color: #fff;
		}
		.leftColumn{
		color:grey;
		text-align: right;
		width: 100px;
		}
	</style>
</head>
<body>
<div>
  <c:url value="/ajouter2" var="url"/>
  <form:form action="${url}" method="post" command="pharmacie">
   <fieldset>
    <legend>Pharmacie</legend>
   <table>
     <tr>
        <td class="leftColumn">Nom :</td>
        <td><form:input path="name" class="field" /></td>
     </tr>
      <tr>
        <td class="leftColumn">adresse :</td>
        <td><form:input path="adresse" class="field" /></td>
     </tr>
      <tr>
        <td class="leftColumn">Longitude :</td>
        <td><form:input path="x" class="field" /></td>
     </tr>
      <tr>
        <td class="leftColumn">Latitude :</td>
        <td><form:input path="y" class="field"/></td>
     </tr>
     <tr>
  	   <td></td>
       <td>	<input type="submit" value="enregistrer" id="nexto"/></td>

       <td>	<input type="hidden" name="cinAttrribute" value="${cin}" /><br/></td>
     </tr>
     <tr>
       <td>	<input type="hidden" name="var" value="${cin}" /><br/></td>
     </tr>
    </table>
    </fieldset>
 </form:form>
</div>
</body>
</html>