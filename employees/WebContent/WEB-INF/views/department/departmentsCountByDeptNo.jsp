<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서별 인원</h1>
		<table border="1">
				<thead>
					<tr>
						<th>부서 번호</th>
						<th>부서 이름</th>
						<th>인원 수</th>
					</tr>
				</thead>
			<c:forEach var="join" items="${list}">	
				<tbody>
					<tr>
						<td>${join.deptNo}</td>
						<td>${join.deptName}</td>
						<td>${join.cnt}</td>
					</tr>
				</tbody>
			</c:forEach>			
		</table>
</body>
</html>