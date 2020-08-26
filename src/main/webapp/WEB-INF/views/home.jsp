<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/shop/resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#btn").on('click', function(){
		location.href="/shop/productcontroll";
	});
});
</script>
</head>
<body>
<table border="3px" >
<c:forEach items="${productlist }" var="vo" >
   <tr><td><a href="/shop/productdetail?pnum=${vo.pnum}">${vo.pname }</a></td></tr>
</c:forEach>
</table>

${vo.pnum}
<a href="/shop/productcontroll">글쓰기</a>로 이동
<input id="btn" type=button value="글쓰기">
</body>
</html>




