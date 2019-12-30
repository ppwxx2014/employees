<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class = "container" style = "margin: 10">
	<div>
		<p>사내 직책 리스트입니다</p>
	</div>
	
	<div style = float:right>
		<button class = "btn btn-success" onclick= "location.href ='${pageContext.request.contextPath}/index'">메인화면</button>
	</div>
	
	<br>
	<hr>
	<ol>
		<c:forEach var = "row" items = "${list}">
			<li>${row}</li>
		</c:forEach>
	</ol>
	
	</div>
</body>
</html>

