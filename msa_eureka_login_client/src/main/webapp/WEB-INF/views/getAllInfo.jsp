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

	<h1>��� ��ü ���</h1>
	<table border="2">
		<tr>
			<td>�̸�</td>
			<td>��ȭ��ȣ</td>
		</tr>
		<c:forEach var="sawon" items="${sawonList}">
			<tr>
				<td><a href="getinfo?name=${sawon.name}">${sawon.name}</a></td>
				<td>${sawon.tel}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="insertForm">[����Է�]</a>

</body>
</html>