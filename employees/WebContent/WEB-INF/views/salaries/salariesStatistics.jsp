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
	<br><br><br>
	<div style = "text-align: center;">
		<header>연봉조회 + 성별에 따른 직원 수</header>
	</div>
	<div style = float:right><button class = "btn btn-success" onclick= "location.href ='${pageContext.request.contextPath}/index'">메인화면</button>
	</div>
	
	<br>
	<hr>
	<table class = "table table-hover" style = "text-align : center">
		<thead>
			<tr>
				<th>연봉 평균</th>
				<th>지금까지의 연봉 총합</th>
				<th>총 연봉 평균</th>
				<th>최고 연봉 수령급여</th>
				<th>최저 연봉 수령급여</th>
				<th>연봉 표준편차</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${map.count}</td>
					<td>${map.sum}</td>
					<td>${map.avg}</td>
					<td>${map.max}</td>
					<td>${map.min}</td>
					<td>${map.std}</td>
				</tr>
		</tbody>
	</table>
	
	<table class = "table table-hover" style = "text-align : center">
		<thead>
			<tr>
				<th>성별</th>
				<th>직원 수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "employees" items = "${list}">
				<tr>
					<td>${employees.gender}</td>
					<td>${employees.cnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	</div>
</body>
</html>