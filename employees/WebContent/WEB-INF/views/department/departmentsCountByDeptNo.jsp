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
<style>
	div {
		text-align: center;
	}

</style>
</head>
<body>
<div class = "container" style = "margin: 10">
	<div>
		<header>부서별 인원수 입니다</header>
	</div>
	
	<div style = float:right>
		<button class = "btn btn-success" onclick = "location.href ='${pageContext.request.contextPath}/index'">메인화면</button>
	</div>
	<br><br>
	<table class = "table table-hover" style = "text-align : center">
		<thead class = "table-info">
			<tr>
				<th>부서 번호</th>
				<th>부서 명</th>
				<th>사원 수</th>
			</tr>	
		</thead>
		<tbody>
					<!-- Department클래스를 새로 만들때부터 get과set을 가짐 -->
			<c:forEach var="join" items="${list}">	
				<tbody>
					<tr>
						<td>${join.deptNo}</td>
						<td>${join.deptName}</td>
						<td>${join.cnt}</td>
					</tr>
				</tbody>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>