<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="principalHeader" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="principalFooter" tagdir="/WEB-INF/tags" %>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon panier</title>
  <script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/getCoord.js"></script>
<!--   <script src="resources/js/annulerCmd.js"></script> -->
  <script src="resources/js/gestionPanier.js"></script>
  <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  
</head>
<body>
	<principalHeader:principalHeader/>
	
 <div class="container" style="margin-top: 100px;">
	<div class="row">
        <div class="col-sm-12">
            <legend>Acheter medicaments:</legend>
        </div>
           <c:if test="${erreur ne null }" >
	        <div class="col-sm-12 alert alert-danger " id="verifier">
	             <strong>${erreur}</strong>
	        </div>
		      </c:if>
        
        <!-- formulaire -->
        <div class="col-sm-5">
            <h4>Remplir la formulaire:</h4>
            <div class="panel panel-default">
                <div class="panel-body form-horizontal payment-form">
                
                <form:form action="ajouter" command="client">
                    <div class="form-group">
                        <label for="concept" class="col-sm-3 control-label" >Nom :</label>
                        <div class="col-sm-9">
                            <form:input type="text" class="form-control"  path="nom" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description" class="col-sm-3 control-label">Prenom :</label>
                        <div class="col-sm-9">
                            <form:input type="text" class="form-control" path="prenom" required="required"/>
                        </div>
                    </div>   
                    <div class="form-group">
                        <label for="description" class="col-sm-3 control-label">CIN :</label>
                        <div class="col-sm-9">
                            <form:input type="text" class="form-control"  path="CIN" required="required"/>
                        </div>
                    </div> 
                    <div class="form-group">
                        <label for="description" class="col-sm-3 control-label">Tel :</label>
                        <div class="col-sm-9">
                            <form:input type="text" class="form-control"  path="tel" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-3 control-label">Email :</label>
                        <div class="col-sm-9">
                            <form:input type="email" class="form-control"  path="email"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-3 control-label">Laltitude:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="lat" name="x" readonly="readonly" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Longitude:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="lng" name="y" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12 text-right">
                            <button type="submit" class="btn btn-default preview-add-button medica" onClick="verifier()">
                                <span class="glyphicon glyphicon-plus"></span> Acheter
                            </button>
                        </div>
                    </div>
                   </form:form>
                </div>
            </div>            
        </div>
      <!--  table -->
        <div class="col-sm-5 offset-col-sm-1">
            <h4>Mon panier:</h4>
            <div id="panier"></div>	 
            <div id="distance"></div>		
        </div>
	  </div>
	</div>	
		
		
		
		<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew">
		
	    </script>
		
		
	<principalFooter:principalFooter/>
</body>
</html>