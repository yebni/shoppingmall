<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script src="/shop/resources/jquery-3.2.1.min.js"></script>

<script>
   $(document).ready(function() {
	  $("#updatebtn").on('click', function(){
		 location.href = "/shop/productupdate?admin="+ 
				 $("#admin").val() + "&pnum=${product.pnum}";
			
	  });
      $("#deletebtn").on('click',function() {
         location.href = "/shop/productdelete?admin="+ 
        		 $("#admin").val() + "&pnum=${product.pnum}";
      });
   });
</script>

<style>
td{border:2px solid green;}
</style>

 </head>
<body>
<h1>상품목록은 다음과 같습니다.</h1>
<table style="color:blue;border:2px solid green">
<tr><td>상품번호</td><td>${product.pnum }</td></tr>
<tr><td>상품이름</td><td>${product.pname }</td></tr>
<tr><td>상품가격</td><td>${product.price }</td></tr>
<tr><td>상품수량</td><td>${product.stack }</td></tr>
<tr><td>분류</td><td>${product.category }</td></tr>
<%-- <tr><td>글암호</td><td>${board.password }</td></tr>
<tr><td>조회수</td><td>${board.viewcount }</td></tr> --%>
</table>

<!-- 글암호 입력:<input type="password" id="pw"> -->
관리자 번호 입력 <input type=password id="admin" maxlength="2">
<input type="button" id="updatebtn" value="수정">
<input type="button" id="deletebtn" value="삭제">



<!-- 수정버튼 클릭시/ boardupdate url/get방식 호출 
	===>사용자 글암호입력 - 확인
	BoardDAO:checkPassword(글번호, 입력물암호)
	select password from board where seq=1
	===>게시물수정폼출력(제목, 내용, 자성자 수정 가능) 
	게시물수정폼에서 수정완료 submit 버튼 클릭시/ boardupdate / post 호출 
	===>BoardDAO:updateBoard(번호,수정제목,수정내용,수정작성자..) -->
</body>
</html>