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
		<p>부서-사원 관계도입니다.</p>
		<p>해당 사원이 근무하고있는 부서가 오름차순으로 표기 됩니다.</p>
	</div>
	<div style = float:right>
		<button class = "btn btn-success" onclick= "location.href ='${pageContext.request.contextPath}/index'">메인화면</button>
	</div>
	
	<form method = "get" action = "${pageContext.request.contextPath}/deptEmp/getDeptEmpList?currentPage=${currentPage}">
		<select name = "rowPerPage">
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
				<th>부서 번호</th>
				<th>부서 이름</th>
				<th>사원 번호</th>
				<th>이름</th>
				<th>근속일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "deptEmp" items = "${list}">
				<tr>
					<td>${deptEmp.department.deptNo}</td>
					<td>${deptEmp.department.deptName}</td>
					<td>${deptEmp.employees.empNo}</td>
					<td>${deptEmp.employees.firstName}</td>
					<td>${deptEmp.toDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 이전, 다음 -->
	<c:forEach var= "i" begin = "${currentPage}" end ="${currentPage + 10}" step="1">
	<!-- 현재 페이지 앞에 출력될 숫자 -->
		<c:if test="${currentPage > 5}">
			<a href="${pageContext.request.contextPath}/deptEmp/getDeptEmpList?currentPage=${i-5}&rowPerPage=${rowPerPage}">${i-5}</a>
		</c:if>
	</c:forEach>
			
	<c:forEach var= "i" begin = "1" end ="6" step="1">
		<!-- 현재 페이지 뒤에 출력될 숫자 -->
		<c:if test="${currentPage <= 5}">
			<a href="${pageContext.request.contextPath}/deptEmp/getDeptEmpList?currentPage=${i}&rowPerPage=${rowPerPage}">${i}</a>
		</c:if>
	</c:forEach>
	
	<div>
		<a href = "${pageContext.request.contextPath}/deptEmp/getDeptEmpList?currentPage=1&rowPerPage=${rowPerPage}">첫 페이지로</a>
	</div>
	</div>
</body>
</html>








