<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<!-- url ����� (/kaja/login) ������ return kaja/userLogin ���� ���� ���Ϸ� ��
	���� form�� ���� �̸�, pw �Է� ���� �� �α��� ������ /loginHaja�� ��
	
	loginPage(/kaja/login) �α��� �������� ���Ѱ�
	.loginProcessUrl(loginHaha) /loginHaja���� ���� �α����� �ǽ���, action�� /loginHaja�� �ǽ�
	
	.defaultSuccessUrl(/toResult) /toResult�� �̵� > resutl.jsp
 -->
 
 <form action="/loginHaja" method="post">
 	ID: <input type="text" name="username"><br>
 	PW: <input type="text" name="password"><br>
 	<input type="submit" value="����">
 </form>

</body>
</html>