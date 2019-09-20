<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>index</h1>
	<!-- 목록 선택 리스트 -->
	<div>
		<ul>
						<!-- EL방법으로 프로젝트명까지 절대주소 찾아줌-->
			<li><a href = "${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a>
			
			<li><a href = "${pageContext.request.contextPath}/employees/getEmployeesList">사원 목록</a>
		</ul>
	</div>
	<div>
		사원테이블 총 갯수 : ${employeesRowCount}
	</div>
</body>
</html>