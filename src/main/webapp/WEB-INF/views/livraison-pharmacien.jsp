<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@ taglib prefix="headerPharmacien" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head> 
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/> 
<!--importation de l'API google MAP Version 3-->
  	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew&callback=initMap">
		
	</script>
 <script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/test4.js"></script>
  
</head> 
<body > 
<headerPharmacien:headerPharmacien />

    <div class="container">
       <div class="col-sm-8 livraison">
    	<button class="btn  btn-lg " id="b">Livraison a 12H</button>
    	<button class="btn  btn-lg " id="m">Livraison a 18H</button>
      </div>
    </div>
      

		
	
	<div class="container livraison-pharmacien">
	  <div class="col-sm-12">
	     <div class="col-sm-8">
			<div id="divMap" class="map-chercher" style="width:100%;height:500px;"></div>
		 </div >
				
		<div class="col-sm-4">
			<div class="panel panel-default itineraire">
			  <div class="panel-heading">L'itineraire</div>
			  <div class="panel-body" id="divRoute"></div>
			</div>
		</div>
<!-- 	    <div class=""> -->
<!-- 	   		<div id="divMap" ></div> -->
<!-- 	   </div>  -->
<!-- 		<div id="t"> L'itinéraire</div> -->
<!-- 		<div id="divRoute"></div>  -->
	   </div>
	</div>
	
	
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew&callback=initMap">
	</script> 
	<%@ page  import="com.ensa.gestionPharmacie.entity.Pharmacie"%>
	<%@ page  import="com.ensa.gestionPharmacie.entity.Commande"%>
	<%@ page  import="java.util.List"%>
	

	<% Pharmacie ph =(Pharmacie)request.getSession().getAttribute("ph") ; 
	    String x=Double.toString(ph.getX()) ; 
	    String y=Double.toString(ph.getY()) ; 
	  
	    
	    
	%>
    <input type="hidden" value="<%=x %>" id="x">
    <input type="hidden" value="<%=y %>"  id="y">
    

    
      <div class="container livraison-pharmacien" id="div-client">
        <h3> Les livraison</h3>
	   <table class="table table-striped">
	     <tr>
	     	<th>Client CIN</th>
	     	<th >Médicaments commandés</th>
	     	<th >Date de la commande</th>
	     </tr>
	  <c:set var="myVar" value="" />
	  <c:set var="myVar2" value="" />
	  <c:set var="virgule" value="," />
	  <c:set var="espace" value="" />
	     <c:forEach items="${listcommande}" var="commande">
		      <tr >
		      
		     	<td ><c:out value="${commande.client.CIN}"/></td>
		 	<c:forEach items="${listAll}" var="list">
		     	
		     	<c:if test="${commande.client.CIN eq list.client.CIN}">
		     	      <c:if test="${myVar ne espace}">            
		     	    <c:set var="myVar" value="${myVar} ${virgule}  ${list.medicament.nom}" />
                      </c:if>
                      
                       <c:if test="${myVar eq espace}">            
		     	    <c:set var="myVar" value="${list.medicament.nom}" />
                      </c:if>
                      
                      
                      
                        <c:if test="${myVar2 ne espace}">            
		     	    <c:set var="myVar2" value="${myVar2} ${virgule}  ${list.dateTime}" />
                      </c:if>
                      
                       <c:if test="${myVar2 eq espace}">            
		     	    <c:set var="myVar2" value="${list.dateTime}" />
                      </c:if>
                      
                      
                  </c:if>
		     	
		     	</c:forEach>
		     	
		     	<td ><c:out value="${myVar}"/></td>
		     	
		     	
		     	<td ><c:out value="${myVar2}"/></td>
		     	
		     	<c:set var="myVar" value="" />
		     	<c:set var="myVar2" value="" />
		     	
		     	
		     </tr>
	     </c:forEach>
	   </table>
	 </div>
      

    
    
</body>
