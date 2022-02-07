<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 나는 getinfo.jsp -->
	<h1>사원 한명 보기 및 수정</h1>

	<table border="2">
		<form action="updateinfo" action="post">
			<tr>
				<td>이름</td>
				<td>전화번호</td>
			</tr>
			<tr>
				<td>${vo.name}</td>
				<td><input type="text" name="tel" value=${vo.tel}></td>
			
				<tr><input type="hidden" name="name" value=${vo.name}></tr>
			<tr>
				<td colspan="2"><input type="submit" value="가자수정"></td>
			</tr>
		</form>

	</table>
	<br>

	<a href="getAllInfo">[사원전체보기]</a>
	<a href="deleteinfo?name=${vo.name}">[삭제]</a>
	</td>
</body>
</html>