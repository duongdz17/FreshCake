<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<c:url value="/views/client/assets" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<title>Đăng nhập</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">

<!-- Favicon -->
<link href="${url}/img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Oswald:wght@500;600;700&family=Pacifico&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/${url}/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="${url}/css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="${url}/css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center">Đăng nhập tài khoản</h3>
						<c:if test="${not empty succMsg }">
							<p class="alert alert-success text-center" role="alert">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<c:if test="${not empty failedMsg }">
							<p class="alert alert-danger text-center" role="alert">${failedMsg}</p>
							<c:remove var="failedMsg" scope="session" />
						</c:if>
						<form action="../../userLogin" method="post">
							<div class="mb-3">
								<label>Tên đăng nhập</label> <input type="text"
									class="form-control" required="required" name="username">
							</div>
							<div class="mb-3">
								<label>Mật khẩu</label> <input type="password"
									class="form-control" required="required" name="password">
							</div>
							<div class="mb-3" hidden="">
								<label>Role</label> <input type="number" 
									class="form-control" required="required" name="role_id" value="2">
							</div>
							<div>
								<a href="forgotPassword.jsp">Quên mật khẩu?</a>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Đăng nhập</button>
								<br> <a href="registerUser.jsp"
									style="text-decoration: none">Tạo tài khoản</a>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>