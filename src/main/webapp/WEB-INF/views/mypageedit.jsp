<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport"
	content="width=device-width, initial-sacle=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

	<title>Insert title here</title>
<script src="/resources/jquery-3.2.1.min.js"></script>
<!-- Bootstrap core CSS -->
<link href="/shop/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/shop/resources/css/shop-homepage.css" rel="stylesheet">


</head>
<body>
	<h1>회원정보 수정 </h1>
	<hr>
	<form id="signFrm" name="signFrm" action="infoEdit.do">
		<table>
			<tbody>
				<tr>

					<td>아이디</td>
				
					<td>${myinfo.id }</td>

				</tr>
				<tr>
					<td colspan=3 id="idCheck"></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td colspan="2"><input id="password" name="password" type="password" value="${myinfo.pw }" ></td>
				</tr>
				<tr>
					<td>패스워드 확인</td>
					<td colspan="2"><input id="passwordCheck" name="passwordCheck" type="password" value="${myinfo.pw }"></td>
				</tr>
				
				<tr>
					<td>이름</td>
					<td><input type="text" id="name" name="name" value="${myinfo.name }"></td>
				</tr>
				
				<tr>
					<td>전화번호 </td>
					<td><input type="text" id="phone" name="phone" value="${myinfo.phone }"></td>
				</tr>
				
				<tr>
					<td colspan="3"><input type="button" id="signUp" value="수정하기"></td>
				</tr>
			</tbody>
		</table>
	</form>

		<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Multi Campus 2020</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="/shop/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="/shop/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

<script type="text/javascript">
	$(document).ready(function(e){
		
		var idx = false;
		
		$('#signUp').click(function(){
			if($.trim($('#password').val()) == ''){
				alert("패스워드 입력.");
				$('#password').focus();
				return;
			}
			//패스워드 확인
			else if($('#password').val() != $('#passwordCheck').val()){
				alert('패스워드가 다릅니다.');
				$('#password').focus();
				return;
			}
			
			$('#signFrm').submit();
			
		});
		
		$('#check').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/idCheck.do",
				type: "GET",
				data:{
					"password":$('#password').val(),
					"name":$('#name').val(),
					"phone":$('#phone').val()
					},
				success: function(data){
					if(data == 0 && $.trim($('#memberid').val()) != '' ){
						idx=true;
						$('#userId').attr("readonly",true);
						var html="<tr><td colspan='3' style='color: green'>사용가능</td></tr>";
						$('#idCheck').empty();
						$('#idCheck').append(html);
					}else{

						var html="<tr><td colspan='3' style='color: red'>사용불가능한 아이디 입니다.</td></tr>";
						$('#idCheck').empty();
						$('#idCheck').append(html);
					}
				},
				error: function(){
					alert("서버에러");
				}
			});
			

		});
		
	});
</script>
</html>