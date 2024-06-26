<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<c:url value="/views/admin/assets" var="url"></c:url>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
<meta name="author" content="AdminKit">
<meta name="keywords"
	content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="shortcut icon" href="${url}/img/icons/icon-48x48.png" />

<link rel="canonical"
	href="https://demo-basic.adminkit.io/pages-sign-in.html" />

<title>Sign In | AdminKit Demo</title>

<link href="${url}/css/app.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap"
	rel="stylesheet">
</head>

<body>
	<main class="d-flex w-100">
		<div class="container d-flex flex-column">
			<div class="row vh-100">
				<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
					<div class="d-table-cell align-middle">

						<div class="text-center mt-4">
							<h1 class="h2">Welcome back, Huy Cao</h1>
							<p class="lead">Đăng nhập để tiếp tục</p>
						</div>

						<div class="card">
							<div class="card-body">
								<div class="m-sm-4">
									<c:if test="${not empty succMsg }">
										<p class="alert alert-success text-center" role="alert">${succMsg}</p>
										<c:remove var="succMsg" scope="session" />
									</c:if>
									<c:if test="${not empty failedMsg }">
										<p class="alert alert-success text-center" role="alert">${failedMsg}</p>
										<c:remove var="failedMsg" scope="session" />
									</c:if>
									<form action="../../loginAdmin" method="post">
										<div class="mb-3">
											<label class="form-label">Tên tài khoản</label> <input
												class="form-control form-control-lg" type="text"
												name="username" placeholder="Nhập tên tài khoản" required />
										</div>
										<div class="mb-3">
											<label class="form-label">Mật khẩu</label> <input
												class="form-control form-control-lg" type="password"
												name="password" placeholder="Nhập mật khẩu" required />
										</div>
										<div class="mb-3" hidden="">
											<label>Role</label> <input type="password"
												class="form-control" required="required" value="1"
												name="role_id">
										</div>
										<div class="text-center mt-3">
											<button type="submit" class="btn btn-lg btn-primary">Đăng
												nhập</button>
										</div>
									</form>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</main>

	<script src="${url}/js/app.js"></script>

</body>

</html>