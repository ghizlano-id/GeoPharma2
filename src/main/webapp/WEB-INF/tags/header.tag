<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" /> " rel="stylesheet">
	<link href="<c:url value="/resources/CSS/style.css" /> "  rel="stylesheet">
	
</head>
<body>
	 <header class="header-admin">
		<div class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header ">
			      <a class="navbar-brand titre" href="<c:url value="/PageAcceuilAdmin"/>">GeoPharma GN</a>
			    </div>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="/admin"/>"><span class="glyphicon glyphicon-off" aria-hidden="true" style="margin-right: 10px;"></span>Deconnexion</a></li>
				</ul>
			</div>
		</div>
	</header>
</body>
</html>