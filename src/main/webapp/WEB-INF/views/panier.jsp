<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panier</title>
  <script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/getCoord.js"></script>
  <script src="resources/js/annulerCmd.js"></script>
	<style>
		html, body {
			height: 100%;
			margin: 0;
			padding: 0;
		}
		#div-top {
			height: 15%;
			width: 100%;
			background-color: #78AB46;
			font-weight: bolder;
			font-size: 24pt;
			color: White;
		}
		
		#table-medicament,.medicament{
		    border: 2px solid grey;
		     padding: 10px;
		    border-collapse: collapse;
		}
		.medicament{
			background-color:#f6f6f6;
		}
		th{
			color: #78AB46;
		}
		#divo{
		margin-top: 20px;
		margin-left: 100px;
		}
		input[type="submit"]{
	   	color:white;
		background-color: #78AB46;
		cursor: pointer;
		font-weight: bold;
		height:30px;
		width:80px;
		border:none;
	    border-radius: 5px;
	    width:200px;
		}
		.field{
	   height: 30px;
	   outline-color:#78AB46; 
	   border:1px solid grey;
	   border-radius: 5px;
	   width: 300px;
	   }
	   .form{
		 background-color: #eee;
		 width: 700px;
		 margin-left: 60px;
		 margin-bottom: 60px;
		 border:1px solid #78AB46;
		 border-radius: 20px;
		 padding: 20px;
		}
		.leftColumn{
		color:grey;
		text-align: right;
		width: 100px;
		padding: 15px;
		}
		#div-medicament{
		margin-left:60px; 
		margin-bottom: 60px;
		}
		#msg{
		color:#78AB46;
		margin-left: 60px;
		margin-top: 60px;
		font-size: 16pt;
		text-indent: 40px;
		padding: 6px;
		}
	</style>
</head>
<body>
	<div id="div-top">GeoPharma GN</div>
	
	 <div id="msg">Veuillez remplir cette formulaire:</div>
	 <form:form action="ajouterClient" command="client" class="form">
	   <table id="table-client">
	   		<tr>
	   		 <td class="leftColumn">Nom</td>
	   		 <td><form:input path="nom" class="field"/>	</td>
	   		</tr>
	   		<tr>
	   		 <td class="leftColumn">Prenom</td>
	   		 <td><form:input path="prenom" class="field"/></td>
	   		</tr>
	   		<tr>
	   		 <td class="leftColumn">CIN</td>
	   		 <td><form:input path="CIN" class="field"/></td>
	   		</tr>
	   		<tr>
	   		 <td class="leftColumn">Tel</td>
	   		 <td><form:input path="tel" class="field"/></td>
	   		</tr>
	   		<tr>
	   		 <td class="leftColumn">Email</td>
	   		 <td><form:input path="email" class="field"/></td>
	   		</tr>
	   		<tr>
	   		 <td class="leftColumn">Laltitude</td>
	   		 <td><form:input path="x" class="field" id="lat"/></td>
	   		</tr>
	   		<tr>
	   		 <td class="leftColumn">Longitude</td>
	   		 <td><form:input path="y" class="field" id="lng"/></td>
	   		 <td><button onclick="getLocation()">Get Coordinates</button></td>
	   		</tr>
	   		<tr>
	   		 <td></td>
	   		 <td><input type="submit" value="PASSER LA COMMANDE"/> </td>
	   		</tr>
	   </table>
	  </form:form>
	  
	   <div id="div-medicament">
	   <table id="table-medicament">
	     <tr>
	     	<th class="medicament">MEDICAMENT</th>
	     	<th class="medicament">QUANTITÉ</th>
	     	<th class="medicament">PRIX UNITAIRE</th>
	     	<th class="medicament">SOUS-TOTAL</th>
	     </tr>
	     <c:forEach items="${medicaments}" var="medicament">
		      <tr class="medicament">
		     	<td class="medicament"><c:out value="${medicament.nom}"/></td>
		     	<td class="medicament" >1</td>
		     	<td class="medicament"><c:out value="${medicament.prix}"/></td>
		     	<td class="medicament"><c:out value="${medicament.prix}"/></td>
		     	<td class="medicament"><a href="annuler?nom=${medicament.nom}" >X Annuler</a> </td>
		     	<td><button class="b">annuler</button><input type="hidden" class="monM" value="<c:out value="${medicament.nom}"/>"/></td>
		     	<td><button class="c">confirmer</button><input type="hidden" class="monM" value="<c:out value="${medicament.nom}"/>"/></td>
		     	
		     	<td class="dst">disatance:<span></span></td>
		     </tr>
	     </c:forEach>
	   </table>
	 </div>
	 <div id="distance"></div>
	 <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew">
		
	</script>
	 
</body>
</html>
	
	
	
	
	