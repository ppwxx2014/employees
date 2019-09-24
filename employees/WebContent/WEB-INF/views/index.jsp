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
		<h1>메인 페이지입니다!~</h1>
		<hr width = "100%" color = "blue" size = "1">
		<div style = "color : gray">employees 데이터베이스의 총 테이블과 갯수</div>
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
	<hr width = "100%" color = "blue" size = "1">
		<h1>카테고리를 선택해 주세요~</h1>
	<br>
	</div>
	<!-- 목록 선택 리스트 -->
					<!-- EL방법으로 프로젝트명까지 절대주소 찾아줌-->
	<div class = "container">
	<ul>
		<li style = "color : red"><a href = "${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a></li>
			
		<li><a href = "${pageContext.request.contextPath}/employees/getEmployeesList">사원 목록</a></li>
	</ul>
	</div>
	<hr width = "100%" color = "blue" size = "1">
	<!-- 이름으로 오름차순, 내림차순 보기 -->
	<div>
		<a href = "${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">이름 오름차순 보기(limit 50)</a>
		<a href = "${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">이름 내림차순 보기(limit 50)</a>
	</div>
	
	<ul>
		<li style = "color : red"><a href = "${pageContext.request.contextPath}/titles/getTitlesListDistinct">직급 확인</a></li>
		<li><a href = "${pageContext.request.contextPath}/salaries/getSalariesStatistics">연봉 통계값(count, sum, avg, max, min, std)</a></li>
	</ul>
</div>

</body>
</html>

