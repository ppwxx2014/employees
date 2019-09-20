<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 목록</h1>
	<form method = "get" action = "${pageContext.request.contextPath}/employees/getEmployeesList">
		<select name = "limit">
		<!-- 페이지당 보여줄 갯수 선택 -->
		<c:forEach var="i" begin = "10" end = "150" step = "10">
		<!-- 변수, 시작값, 끝값, 반복할크기 -->
			<option value = "${i}">${i}</option>
		</c:forEach>
		</select>개씩 보기
		<button type = "submit">확인!</button>
	</form>
	<table border = "1">
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
</body>
</html>