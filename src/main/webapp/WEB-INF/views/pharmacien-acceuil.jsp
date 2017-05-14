<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8" />
		<link href="<c:url value="/resources/CSS/pharmacien-acceuil.css" />" rel="stylesheet">
	</head>
	<body>
		<header> 

		<div id="ph">ParmaGeo GN</div>
		<a href="http://www.google.com">
         <button type="button" class="bttn" >Déconnexion</button>
             </a>
		</header>
		<footer>&copy; Tous droits réservés</footer>
		
		<section>
			  <div id="div1">
                     <a href="<c:url value="/add_med?id=${id}"/>">
                     <button type="button" class="btn" >
                      
					<img src="<c:url value="/resources/img/ajouter.png"/>" width="70" height="90">
              <p>Ajouter un médicament</p>
                       </button>  
                       </a>

                   <a href="#">
				<button type="button" class="btn" ><img src="<c:url value="/resources/img/ajouter-m.jpg"/>" width="70" height="90">
				<p>Mettre à jour un médicament</p></button></a>
                   
                   <a href="#">
					<button type="button" class="btn" ><img src="<c:url value="/resources/img/supp.jpg"/>" width="70" height="90"><p>Supprimer un médicament</p></button>
					</a>
               </div>
				
                   <div id="div2">
                   <a href="#">
					<button type="button" class="btn" ><img src="<c:url value="/resources/img/ambulance.png"/>" width="70" height="90"><p>Livraison des médicament</p></button>
                     </a>
                    
                    <a href="#">
					<button type="button" class="btn" ><img src="<c:url value="/resources/img/garde.jpg"/>" width="70" height="90"><p>Pharmacie en garde</p></button>
					</a>
					

			</div>




			
		</section>
	</body>
</html>