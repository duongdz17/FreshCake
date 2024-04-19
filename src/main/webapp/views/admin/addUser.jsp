<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	href="https://demo-basic.adminkit.io/ui-buttons.html" />

<title>Thêm mới người dùng</title>

<link href="${url}/css/app.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.css" />
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.js"></script>
</head>

<body>
	<div class="wrapper">
		<%@include file="layout/sidebar.jsp"%>

		<div class="main">
			<%@include file="layout/header.jsp"%>

			<main class="content">
				<div class="container-fluid p-0">

					<div class="mb-3">
						<h1 class="h3 d-inline align-middle">Danh sách Người dùng</h1>
					</div>
					<div class="row">
						<div class="card">
							<div class="card-body">
								<form action="/FreshCake/add-user" class="row g-3"
									method="post">
									<div class="col-12">
										<label>Mã người dùng</label> <input type="number" name="id"
											class="form-control" />
									</div>
									<div class="col-12">
										<label>Họ và tên</label> <input type="text"
											name="fullname" class="form-control" />
									</div>
									<div class="col-12">
										<label>Tên tài khoản</label> <input type="text"
											name="username" class="form-control" />
									</div>
									<div class="col-12">
										<label>Mật khẩu</label> <input type="password"
											name="password" class="form-control" />
									</div>
									<div class="col-12">
										<label>Email</label> <input type="email"
											name="email" class="form-control" />
									</div>
									<div class="col-12">
										<label>Số điện thoại</label> <input type="tel"
											name="phonenumber" class="form-control" />
									</div>
									<div class="col-12">
										<label>Địa chỉ</label> <input type="text"
											name="address" class="form-control" />
									</div>
									<div class="col-12">
										<label>Mã quyền</label> <input type="number"
											name="role_id" class="form-control" />
									</div>
									<div class="col-12">
										<label>Trạng thái</label> <input type="number"
											name="status" class="form-control" />
									</div>
									<div class="col-12">
										<button type="submit" class="btn btn-primary">Thêm
											mới</button>
									</div>
								</form>
							</div>
						</div>
					</div>

				</div>
			</main>

			<%@include file="layout/footer.jsp"%>
		</div>
	</div>

	<script src="${url}/js/app.js"></script>
</body>

</html>