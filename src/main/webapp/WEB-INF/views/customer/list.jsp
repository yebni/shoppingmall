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

<title>customerlist</title>
<script src="/shop/resources/jquery-3.2.1.min.js"></script>
<!-- Bootstrap core CSS -->
<link href="/shop/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/shop/resources/css/shop-homepage.css" rel="stylesheet">

<style>
.table{
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

				<h1 class="my-4">회원 리스트</h1>

				<table class="table" border="3px">
					<c:forEach items="${customerlist }" var="vo">
						<tr>
							<td><a href="/shop/customerdetail?id=${vo.id }">${vo.id }</a></td>
							<td>${vo.name }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

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