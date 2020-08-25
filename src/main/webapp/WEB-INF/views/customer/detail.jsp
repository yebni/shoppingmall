<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>customerdetail</title>
<script src="/shop/resources/jquery-3.2.1.min.js"></script>
<!-- Bootstrap core CSS -->
<link href="/shop/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/shop/resources/css/shop-homepage.css" rel="stylesheet">

<script>
	$(document).ready(
			function() {
				$("#deletebtn").on(
						'click',
						function() {
							location.href = "/shop/customerdelete?admin="
									+ $("#admin").val() + "&id=${customer.id}";
						});
			});
</script>
<style>
td {
	border: 2px solid
}
.table {
	margin-bottom: 50px;
}

</style>
</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/shop/">multi campus</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="/shop/">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Login</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/shop/customerlist">My page</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="list-group">
				<h3 class="my-4">회원 상세 정보 조회</h3>
				<table class="table" style="color: black; border: 2px solid black";>
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
			</div>
		</div>
		<div class="row">
			관리자 번호 입력<input type=text id="admin" maxlength="2"> <input
				type=button id="deletebtn" value="삭제">
		</div>


	</div>
	<!-- /.container -->

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
</html>