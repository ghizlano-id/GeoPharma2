<%@ taglib prefix="principalHeader" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="principalFooter" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medicaments</title>
	<script type="text/javascript">
		function t(){
			alert("done");
		}
	</script>
</head>
<body>
	<principalHeader:principalHeader/>
	
  <div class="container" style="margin-top: 100px;">
    <div class="row">
      <c:forEach items="${listemedicament}" var="medicament">
        <div class="col-md-4">
              <div class="thumbnail">
                <img src="http://tech.firstpost.com/wp-content/uploads/2014/09/Apple_iPhone6_Reuters.jpg" alt="" class="img-responsive">
                <div class="caption">
                  <h4 class="pull-right">${medicament.prix} DH</h4>
                  <h4 class="pre-cost">${medicament.nom}</h4>
                  <p>${medicament.designation}.</p>
                </div>
                <div class="ratings">
                  <p>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                     (15 reviews)
                  </p>
                </div>
                <div class="space-ten"></div>
                <div class="btn-ground text-center">
                	<input type="hidden" class="idMedica" value="${medicament.nom}"/>
                    <button type="button" onClick="t()" class="btn btn-primary a"><i class="fa fa-shopping-cart"></i> Ajouter au panier</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#product_view"><i class="fa fa-search"></i> Quick View</button>
                </div>
                <div class="space-ten"></div>
              </div>
            </div>
           </c:forEach> 
          </div>
        </div>
	<principalFooter:principalFooter/>
</body>
</html>