<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8" />
		<link href="<c:url value="/resources/CSS/style.css" />" rel="stylesheet">
	</head>
	<body>

		<header >
         <table width="100%" height="220" border="0" cellspacing="2" cellpadding="0" id="table">
         	<td id="d1" width="20%" > <img src="<c:url value="/resources/img/log2.png"/>" width="100%" height="220">
         	 
         	
         	</td>
				<td width="100%" colspan="2">
					<img src="<c:url value="/resources/img/im6.PNG"/>"  width="100%" height="220">
				</td>
			</tr>



         </table>
	
        <!--  <div class="disp" id="d1" >coucou</div>

          <div class="disp" id="d2">
		<img src="im6.PNG" ></div> -->
 
		</header>


	 <footer>&copy; Tous droits réservés</footer>
		<!--<nav>NAV</nav>-->
		<section>
			<table border="0" cellspacing="30" cellpadding="3">
				<tr class="line" >
					<td class="care"><a href="<c:url value="/pharmacies-de-garde"/>">Pharmacie de garde</a></td>
					<td class="care"><a href="#">Pharmacies</a></td>
					<td class="care"><a href="#">Pharmacie à priximité </a></td>

				</tr>
				<tr class="line">
					<td class="care"><img src="<c:url value="/resources/img/liv.png"/>"  width="130" height="150"></td>
					<td class="care">  <a href="<c:url value="/commander"/>">Médicaments</a></td>
					<td class="care"><a href="#">A propos </a></td>

				</tr>




			</table>
		</section> 
		
	</body>
</html>