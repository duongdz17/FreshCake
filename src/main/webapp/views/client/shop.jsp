<%@page import="model.User"%>
<%@page import="model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDAO"%>
<%@page import="model.Category"%>
<%@page import="java.util.List"%>
<%@page import="dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/views/client/assets" var="url"></c:url>
<%
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categories = categoryDAO.getAll();
	%>
<%
	ProductDAO productDAO = new ProductDAO();
	String category_id = request.getParameter("category");
	List<Product> products = productDAO.getAll();
	%>
<%
	ArrayList<Cart> cart_list = (ArrayList<Cart>)session.getAttribute("carts");
	if (cart_list != null){
		request.setAttribute("cart_list", cart_list);
	}
%>
<%
	User user =(User)session.getAttribute("userobj");
	
	%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Cake Template">
<meta name="keywords" content="Cake, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Fresh Cake</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500;600;700;800;900&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="${url}/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/flaticon.css" type="text/css">
<link rel="stylesheet" href="${url}/css/barfiller.css" type="text/css">
<link rel="stylesheet" href="${url}/css/magnific-popup.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="${url}/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/style.css" type="text/css">
</head>

<body>
	<%@include file="layout/header.jsp"%>

	<!-- Breadcrumb Begin -->
	<div class="breadcrumb-option">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="breadcrumb__text">
						<h2>Shop</h2>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="breadcrumb__links">
						<a href="/FreshCake/views/client/index.jsp">Home</a> <span
							href="/FreshCake/views/client/shop.jsp">Shop</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Shop Section Begin -->
	<section class="shop spad">
		<div class="container">
<div class="shop__option">
				<div class="row">
					<div class="col-lg-9 col-md-9">
						<div class="shop__option__search">
							<form action="search.jsp">
								<select name="category" class="form-control">
									<option value="all">Danh mục</option>
									<%
									for(Category category : categories) {
									%>
									<option value="<%=category.getId()%>"><%=category.getName()%></option>
									<%} %>
								</select> <input type="text" placeholder="Search">
								<button type="submit">
									<i class="fa fa-search"></i>
								</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<%for(Product product : products) {%>
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="product__item">
						<div class="product__item__pic set-bg"
							data-setbg="${url}/img/shop/<%=product.getThumbnail()%>">
							<div class="product__label">
								<span><%=product.getCategory_id() %></span>
							</div>
						</div>
						<div class="product__item__text">
							<h6>
								<a href="#"><%=product.getName() %></a>
							</h6>
							<div class="product__item__price"><%=product.getPrice() %></div>
							<div class="cart_add">
								<%
								if (user == null) {
								%>
								<a href="loginUser.jsp">Add to cart</a>|
								<%
								} else {
								%>
								<a href="../../add-to-cart?id=<%=product.getId() %>">Add to cart</a>|
								<%
								}
								%>
								<a href="shopdetail.jsp?id=<%=product.getId()%>">Shop Detail</a> 
							</div>
						</div>
					</div>
				</div>
				<%
            		}
                %>
			</div>

		</div>
	</section>
	<!-- Shop Section End -->

	<%@include file="layout/footer.jsp"%>

	<!-- Search Begin -->
	<div class="search-model">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-switch">+</div>
			<form class="search-model-form">
				<input type="text" id="search-input" placeholder="Search here.....">
			</form>
		</div>
	</div>
	<!-- Search End -->

	<!-- Js Plugins -->
	<script src="${url}/js/jquery-3.3.1.min.js"></script>
	<script src="${url}/js/bootstrap.min.js"></script>
	<script src="${url}/js/jquery.nice-select.min.js"></script>
	<script src="${url}/js/jquery.barfiller.js"></script>
	<script src="${url}/js/jquery.magnific-popup.min.js"></script>
	<script src="${url}/js/jquery.slicknav.js"></script>
	<script src="${url}/js/owl.carousel.min.js"></script>
	<script src="${url}/js/jquery.nicescroll.min.js"></script>
	<script src="${url}/js/main.js"></script>
</body>

</html>