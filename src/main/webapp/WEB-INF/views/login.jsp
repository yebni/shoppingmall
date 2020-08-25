<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>로그인</h1>
<hr/>

<form action="login.do" method="post">

<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="memberid" value=""/></td>
		
	
	</tr>
	<tr>
		<td>패스워드</td>
		<td><input type="password" name="password" value=""/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인"/>
		</td>
	</tr>
</table>
</form>

</center>

</body>
</html>

