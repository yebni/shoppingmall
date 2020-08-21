<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customerdetail.jsp</title>
<script src="/shop/resources/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("#deletebtn").on('click', function(){
			location.href="/mymvc/boarddelete?pw="+$("#pw").val()+"&seq=${board.seq}";
		});
	});
</script>
<style>
td {border: 2px solid navy}
</style>
</head>
<body>
	<h3>조회하신 회원 상세 정보입니다.</h3>
	<table style="color: blue; border: 2px solid red">
		<tr>
			<td>이름</td>
			<td>${customer.name }</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${customer.id }</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${customer.pw }</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${customer.phone }</td>
		</tr>
		<tr>
			<td>관리자 번호</td>
			<td>${customer.admin }</td>
		</tr>
	</table>
	<input type=button id="deletebtn" value="삭제">
</body>
</html>