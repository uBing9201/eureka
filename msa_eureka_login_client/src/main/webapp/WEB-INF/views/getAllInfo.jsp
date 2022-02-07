<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>사원 전체 명단</h1>
	<table border="2">
		<tr>
			<td>이름</td>
			<td>전화번호</td>
		</tr>
		<c:forEach var="sawon" items="${sawonList}">
			<tr>
				<td><a href="getinfo?name=${sawon.name}">${sawon.name}</a></td>
				<td>${sawon.tel}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="insertForm">[사원입력]</a>

</body>
</html>