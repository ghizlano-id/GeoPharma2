<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" 	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Ghizlane</h1>
	<c:forEach var="test" items="${allTest}" >
		${test.name} <br>
	</c:forEach>

<c:forEach var="test" items="${listph}" >
		${test.name} <br>
	</c:forEach>






</body>
</html>