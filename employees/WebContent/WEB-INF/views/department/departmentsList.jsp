<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- EL을 사용하기위해 먼저 선언해야됨 ==> 스크립트릿을 대신 해줌 -->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departments List</title>
</head>
<body>
	
	<h1>부서 목록</h1>
	<table border = "1">
		<thead>
			<th>부서 번호</th>
			<th>부서 명</th>
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
</body>
</html>



