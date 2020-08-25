<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${myinfo.name }의 Mypage</title>
</head>
<body>
<div>
	<h1>내 정보</h1>
	<table>
		<tr>
			<td>이름</td>
			<td>${myinfo.name }</td>
			
		</tr>
		<tr>
			<td>아이디</td>
			<td>${myinfo.id}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${myinfo.phone }</td>
		
		</tr>
		<tr>
			<td>내 정보 수정하기</td>
			<td></td>
		</tr>
	</table>
	<a href="cart">내 장바구니</a>
	
	
</div>
</body>
</html>