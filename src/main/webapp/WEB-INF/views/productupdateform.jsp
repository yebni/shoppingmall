<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateform.jsp</title>
</head>
<body>
<h1>게시물 수정</h1>

<form action="/shop/productupdate" method="post">
<input type="hidden" name="pnum" value="${pnum}">
제품이름 <input type=text name="pname"> <br>
<input type=submit value="수정완료">
</form>
</body>
</html>