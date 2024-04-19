<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<c:url value="/views/client/assets" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng ký</title>
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
	<div class="container p-2">
		<div class="col-md-4 offset-md-4">
			<div class="card">
				<div class="card-body">
					<h4 class="text-center">Đăng ký tài khoản</h4>
					<c:if test="${requestScope.errorUserName != null}">
						<p class="alert alert-success text-center" role="alert">${requestScope.errorUserName}</p>
					</c:if>
					<c:if test="${not empty succMsg }">
						<p class="alert alert-success text-center" role="alert">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>

					<c:if test="${not empty failedMsg }">
						<p class="alert alert-danger text-center" role="alert">${failedMsg}</p>
						<c:remove var="failedMsg" scope="session" />
					</c:if>
					<form action="../../userRegister" method="post">
						<div class="mb-3">
							<label>Họ tên:</label> <input type="text" class="form-control"
								required="required" name="fullname">
						</div>
						<div class="mb-3">
							<label>Tên đăng nhập:</label> <input type="text"
								class="form-control" required="required" name="username">
						</div>
						<div class="mb-3">
							<label>Mật khẩu:</label> <input type="password"
								class="form-control" required="required" name="password">
						</div>
						<div class="mb-3">
							<label>Email:</label> <input type="email" class="form-control"
								required="required" name="email">
						</div>
						<div class="mb-3">
							<label>Số điện thoại:</label> <input type="number"
								class="form-control" required="required" name="phone">
						</div>

						<div class="mb-3">
							<label>Đia chỉ:</label> <input type="text" class="form-control"
								required="required" name="address">
						</div>

						<div class="mb-3" hidden="">
							<label>Roles:</label> <input type="number" class="form-control"
								readonly="readonly" value="2" required="required" name="role_id">
						</div>

						<div class="mb-3" hidden="">
							<label>Trạng thái:</label> <input type="number"
								class="form-control" readonly="readonly" value="1"
								required="required" name="status">
						</div>
						<button type="submit" class="btn btn-primary">Hoàn tất</button> <a class="btn btn-danger" href="index.jsp" style="margin-left:64px;">Quay về trang chủ</a>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>