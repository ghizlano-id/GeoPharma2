<%@ taglib prefix="principalHeader" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="principalFooter" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Medicaments</title>
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/med_disp.js"></script>
</head>
<body>
	<principalHeader:principalHeader/>
		<div class="container" style="margin:90px">
			<div class="form-group ">
			    <label class="col-sm-2 control-label" style="margin-top:5px;">Nom de médicament:</label>
			    <div class="col-sm-3">
				<select id="op" class="form-control">
					   <c:forEach items="${medicaments}" var="medica">
						   <option >${medica.nom}</option>
						</c:forEach>
				</select>
				</div>
				<button  id="b" type="button" class="btn  medica">
				   Chercher <span class="glyphicon glyphicon-search fa-fw"></span>
				</button>
				<button  id="afficher" type="button" class="btn  medica">Afficher l'itinéraire</button>
			</div>
			<div class="col-sm-12" style="margin-top:20px;">
				
				 <div  class="col-sm-8 map-chercher" id="map" ></div>
				
				<div class="col-sm-4">
<!-- 				  <div  id="divRoute" style="overflow-y:auto;height:400px; border:1px solid black;border-radius:10px;"></div> -->
		    	  <div class="panel panel-default itineraire" >
					  <div class="panel-heading">L'itineraire</div>
					  <div class="panel-body" id="divRoute"></div>
				  </div>
		    	</div>
		    </div>
		  </div>
	<principalFooter:principalFooter/>
	
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDkeI-kIm4S1_WR2xFykRqK6XE7HIL_ew&callback=initMap">
		
	</script>
</body>
</html>