<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<style>
	 li {
        display: inline;
        border: 1px solid #bcbcbc;
        padding: 10px;
      }
      a:link {color:green; text-decoration:none;}
      a:visited {color:teal; text-decoration:none;}
	  a:hover {color:red; text-decoration:underline;}
	  a:active {color:yellow; text-decoration:underline;}
	
	br {
		size : 10pt;
	}
</style>
</head>
<body>
<div class = "container">

	<div style = "aglign : center">
		<h3>Employees Index</h3><span style = "float: right;">
			<c:if test = "${sessionEmpNo != null}">
				<a href = "${pageContext.request.contextPath}/logout">로그아웃</a> <!-- LogoutServlet -->
			</c:if>
		</span>
		<table class = "table tablr-horver">
			<thead>
				<tr>
					<th>테이블이름</th>
					<th>전체 행의 수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>departments</td>
					<td>${departmentsRowCount}</td>
				</tr>
				<tr>
					<td>employees</td>
					<td>${employeesRowCount}</td>
				</tr>
				<tr>
					<td>dept_manager</td>
					<td>${deptManagerRowCount}</td>
				</tr>
				<tr>
					<td>dept_emp</td>
					<td>${deptEmpRowCount}</td>
				</tr>
				<tr>
					<td>titles</td>
					<td>${titlesRowCount}</td>
				</tr>
				<tr>
					<td>salaries</td>
					<td>${salariesRowCount}</td>
				</tr>
			</tbody>
		</table>
	<hr>
	<br>
	</div>
		
	<div class = "container">
		<header style = "text-align: center;">카테고리 목록</header>
		<table class = "table-bordered">
			<tr>
				<td><a href = "${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a></td>
				<td><a href = "${pageContext.request.contextPath}/titles/getTitlesListDistinct">직급 확인</a></td>
				<td><a href = "${pageContext.request.contextPath}/employees/getEmployeesList">사원 목록</a></td>
				<td><a href = "${pageContext.request.contextPath}/employees/getEmployeesListByPage">사원목록 페이징(10명씩)</a></td>
				<td><a href = "${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">이름 오름차순 보기(limit 50)</a></td>
				<td><a href = "${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">이름 내림차순 보기(limit 50)</a></td>
				<td><a href = "${pageContext.request.contextPath}/deptEmp/getDeptEmpList">부서-사원목록(20명씩)</a></td>
			</tr>
		</table>
		
		<hr>
		<header style = "text-align: center;">통계 목록</header>
		
		<table class = "table tablr-horver">
			<tr>
				<td><a href = "${pageContext.request.contextPath}/salaries/getSalariesStatistics">연봉 통계값 + 성별에 따른 직원 수</a></td>
				<td><a href="${pageContext.request.contextPath}/departments/getDepartmentCountByDeptNo">직원 수(부서별)</a></td>	
			</tr>
		</table>
		
		<div>
			<form method = "post" action = "${pageContext.request.contextPath}/employees/getEmployeesListBetween">
				<input type = "number" name = "begin">~<input type = "number" name = "end">
				<button type = "submit">사원 목록 between ... and ...</button>
				(10001~499999)
			</form>
		</div>
	</div>
	<hr>
</div>

</body>
</html>

