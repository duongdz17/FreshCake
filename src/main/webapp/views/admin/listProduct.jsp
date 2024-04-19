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

<title>Quản lý sản phẩm</title>

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
						<h1 class="h3 d-inline align-middle">Danh sách Sản phẩm</h1>
					</div>
					<div class="row">
						<div class="card">
							<div class="card-body">
								<a class="btn btn-primary mb-2"
									href="/FreshCake/views/admin/addProduct.jsp">Thêm mới sản phẩm</a>
								<table class="table" id="myTable">
									<thead>
										<tr>
											<th>Mã sản phẩm</th>
											<th>Tên sản phẩm</th>
											<th>Mô tả</th>
											<th>Giá tiền</th>
											<th>Giá giảm</th>
											<th>Còn kho</th>
											<th>Ảnh sản phẩm</th>
											<th>Sản phẩm nổi bật</th>
											<th>Trạng thái</th>
											<th>Mã loại sản phẩm</th>
											<th>Ngày nhập</th>
											<th>Ngày cập nhật</th>
											<th>Hành động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${requestScope.products}" var="product">
											<tr>
												<td>${product.id}</td>
												<td>${product.name}</td>
												<td>${product.description}</td>
												<td>${product.price}</td>
												<td>${product.discount}</td>
												<td>${product.quantity}</td>
												<td>${product.thumbnail}</td>
												<td>${product.is_featured}</td>
												<td>${product.status}</td>
												<td>${product.category_id}</td>
												<td>${product.create_at}</td>
												<td>${product.update_at}</td>
												<td><a href="updateProduct?id=${product.id}"><i
														class="fa-solid fa-pen-to-square"></i></a> | <a href="#"
													onclick="deleteProduct('${product.id}')"><i
														class="fa-solid fa-trash"></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
			</main>

			<%@include file="layout/footer.jsp"%>
		</div>
	</div>

	<script src="${url}/js/app.js"></script>
	<script type="text/javascript">
		function deleteProduct(id) {
			let answer = confirm("Bạn có đồng ý xoá?");
			if (answer) {
				window.location = "deleteProduct?id=" + id;
			}
		}
	</script>
	<script>
		$(document).ready( function () {
	    	$('#myTable').DataTable();
		} );
	</script>
</body>

</html>