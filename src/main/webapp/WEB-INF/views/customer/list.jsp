<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<script src="/shop/resources/jquery-3.2.1.min.js"></script>
</head>
<body>

	<h1>회원 리스트 입니다.</h1>

	<table border="3px">
		<c:forEach items="${customerlist }" var="vo">
			<tr>
				<td><a href="/shop/customerdetail?id=${vo.id }">${vo.id }</a></td>
				<td>${vo.name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>