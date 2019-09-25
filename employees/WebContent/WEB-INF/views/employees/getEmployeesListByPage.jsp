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
	p {
		font-size : x-large;
		background-color: silver;
	}
	
	.page {
		text-align: center;
		width: 50%;
	}
	.pagination {
		list-style : none;
		display: inline-block;
		padding: 0%
		margin-top : 20px;
	}
	.pagination li {
		display: inline;
		text-align: center;
	}
	.pagination a {
		float: left;
		display: block;
		font-size: 14px;
		text-decoration: none;
		padding: 5px 12px;
		color : #96a0ad;
		line-height: 1.5;
	}
	.first {
		margin-right: 15px;
	}
	.last {
		margin-left: 15px;
	}
	.first:hover, .last:hover, .left:hover, .right:hover {
		color : #2e9cdf;
	}
	.pagination a:active {
		cursor : default;
		color : #ffffff;
	}
	.modal .num {
		margin-left: 3px;
		padding: 0;
		width: 30px;
		height: 30px;
		line-height: 30px;
		-moz-border-radius:100%;
		-webkit-border-radius:100%;
		border-radius:100%;
	}
	.modal .num:hover {
		background-color: #2e9cdf;
		color : #ffffff;
	}
	.modal .num.active, .model .num:active {
		background-color: #2e9cdf;
		cursor: pointer;
	}
	.arrow-left {
		width : 0;
		height: 0;
		border-top:10px solid transparent;
		border-bottom:10px solid transparent;
		border-right:10px solid blue;
	}
	
</style>
</head>
<body>
	<div class = "container" style = "margin: 10">
	<div style = "background-color: silver">
		<p>사원 목록 리스트</p>
		<p>사내 사원의 리스트를 보여줍니다</p>
	</div>
	<div style = float:right><button class = "btn btn-success" onclick= "location.href ='${pageContext.request.contextPath}/index'">메인화면</button></div>
	<form method = "get" action = "${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage}">
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
	<div></div>
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
	<!-- 이전, 다음 페이지 설정 -->
	<br>
	<div>
	<div class = "page">
		<ul class ="pagination modal">
		
		<li> <a href = "${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=1&rowPerPage=${rowPerPage}">첫 페이지로</a></li>
		<li> <a href = "" class = "arrow left"><<</a></li>
	<c:if test = "${currentPage > 1}"> <!-- ==if(currentPage > 1) -->
		<a href = "${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
	</c:if>
	
	<c:forEach var= "i" begin = "${currentPage}" end ="${currentPage + 6}" step="1">
		<!-- 현재 페이지 앞에 출력될 숫자 -->
		<c:if test="${currentPage > 3}">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${i-3}&rowPerPage=${rowPerPage}">${i-3}</a>
		</c:if>
		<!-- 현재 페이지 뒤에 출력될 숫자 -->
		<c:if test="${currentPage < 3}">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${i}&rowPerPage=${rowPerPage}">${i}</a>
		</c:if>
	</c:forEach>

	<!-- 마지막 페이지설정 -->
	<c:if test= "${currentPage < lastPage }">
		<a href = "${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">다음</a>
	</c:if>
	
		<li> <a href = "" class = "arrow right">>></a></li>
		</ul>
	</div>
	</div>
</body>
</html>