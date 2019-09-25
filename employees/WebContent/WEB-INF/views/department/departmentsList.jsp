<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- EL을 사용하기위해 먼저 선언해야됨 ==> 스크립트릿을 대신 해줌 -->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departments List</title>

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
		background-color: silver;
	}

</style>
</head>
<body>
<div class = "container" style = "margin: 10">
	<div style = "background-color: silver">
		<p>부서 목록 리스트</p>
		<p>모든 부서리스트 입니다.</p>
	</div>
	<div style = float:right><button class = "btn btn-success" onclick = "location.href ='${pageContext.request.contextPath}/index'">메인화면</button></div>
	<table class = "table table-hover" style = "text-align : center">
	<div></div>
		<thead class = "table-info">	
			<th>부서 번호</th>
			<th>부서 명</th>
			<th>사원 수</th>
		</thead>
		<tbody>
					<!-- Department클래스를 새로 만들때부터 get과set을 가짐 -->
			<c:forEach var = "department" items = "${list}">
					<!-- var = 사용할 클래스의 변수명 items = Collection 객체 -->
				<tr>
					<!-- set,get으로만 만들어야만 EL을 사용가능함 -->
					<td>${department.deptNo}</td>
					<td>${department.deptName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>



