<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	p {
		font-size : x-large;
	}

</style>
</head>
<body>
	<div class = "container" style = "margin: 10">
	<div>
		<p>사원 목록 리스트</p>
		<p>사내 사원의 리스트를 보여줍니다</p>
	</div>
	
	<div style = float:right><button class = "btn btn-success" onclick= "location.href ='${pageContext.request.contextPath}/index'">메인화면</button></div>
	<form method = "get" action = "${pageContext.request.contextPath}/employees/getEmployeesList">
		<select name = "limit">
		<!-- 페이지당 보여줄 갯수 선택 -->
		<c:forEach var="i" begin = "10" end = "150" step = "10">
		<!-- 변수, 시작값, 끝값, 반복할크기 -->
			<option value = "${i}">${i}</option>
		</c:forEach>
		</select>개씩 보기
		<button type = "submit" class = "btn btn-info">확인!</button>
	</form>
	
	<table class = "table table-hover" style = "text-align : center">
		<thead>
			<tr>
				<th>사원 번호</th>
				<th>사원 생일</th>
				<th>사원 이름</th>
				<th>사원  이름(성)</th>
				<th>성별</th>
				<th>입사날짜 / 퇴사 날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "employees" items = "${list}">
				<tr>
					<td>${employees.empNo}</td>
					<td>${employees.birthDate}</td>
					<td>${employees.firstName}</td>
					<td>${employees.lastName}</td>
					<td>${employees.gender}</td>
					<td>${employees.hireDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>