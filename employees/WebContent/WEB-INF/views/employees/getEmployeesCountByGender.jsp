<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1">
		<thead>
			<tr>
				<th>성별</th>
				<th>명수</th>
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
	
	<a href = "${pageContext.request.contextPath}/index">홈으로</a>
</body>
</html>