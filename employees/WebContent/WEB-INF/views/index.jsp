<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
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
<div class = "container">

	<div style = "aglign : center">
		<h1>메인 페이지입니다!~</h1>
		<h1>카테고리를 선택해 주세요~</h1>
	</div>
	<!-- 목록 선택 리스트 -->
					<!-- EL방법으로 프로젝트명까지 절대주소 찾아줌-->
	<div class = "container">
	<a href = "${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록
			
	<a href = "${pageContext.request.contextPath}/employees/getEmployeesList">사원 목록
	
	<!-- 이름으로 오름차순, 내림차순 보기 -->
	<div>
		<br>
		<a href = "${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">이름 오름차순 보기(limit 50)</a>
		<a href = "${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">이름 내림차순 보기(limit 50)</a>
	</div>
	</div>
</div>

</body>
</html>

