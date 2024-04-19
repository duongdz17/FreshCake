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
List<Product> products = productDAO.getNewProduct();
%>
<%
	ArrayList<Cart> cart_list = (ArrayList<Cart>)session.getAttribute("carts");
	if (cart_list != null){
		request.setAttribute("cart_list", cart_list);
	}
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

	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="hero__slider owl-carousel">
			
			<div class="hero__item set-bg"
				data-setbg="${url}/img/hero/hero-1.jpg">
				<div class="container">
					<div class="row d-flex justify-content-center">
						<div class="col-lg-8">
							<div class="hero__text">
								<h2>Welcome!</h2>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<!-- About Section Begin -->
	<section class="about spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="about__text">
						<div class="section-title">
							<span>About Cake shop</span>
							<h2>Cakes and bakes from the house of Queens!</h2>
						</div>
						<p>The "Cake Shop" is a Jordanian Brand that started as a
							small family business. The owners are Dr. Iyad Sultan and Dr.
							Sereen Sharabati, supported by a staff of 80 employees.</p>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="about__bar">
						<div class="about__bar__item">
							<p>Cake design</p>
							<div id="bar1" class="barfiller">
								<div class="tipWrap">
									<span class="tip"></span>
								</div>
								<span class="fill" data-percentage="95"></span>
							</div>
						</div>
						<div class="about__bar__item">
							<p>Cake Class</p>
							<div id="bar2" class="barfiller">
								<div class="tipWrap">
									<span class="tip"></span>
								</div>
								<span class="fill" data-percentage="80"></span>
							</div>
						</div>
						<div class="about__bar__item">
							<p>Cake Recipes</p>
							<div id="bar3" class="barfiller">
								<div class="tipWrap">
									<span class="tip"></span>
								</div>
								<span class="fill" data-percentage="90"></span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- About Section End -->

	<!-- Categories Section Begin -->
	<div class="categories">
		<div class="container">
			<div class="row">
				<div class="categories__slider owl-carousel">
					<div class="categories__item">
						<div class="categories__item__icon">
							<span class="flaticon-029-cupcake-3"></span>
							<h5>Cupcake</h5>
						</div>
					</div>
					<div class="categories__item">
						<div class="categories__item__icon">
							<span class="flaticon-034-chocolate-roll"></span>
							<h5>Butter</h5>
						</div>
					</div>
					<div class="categories__item">
						<div class="categories__item__icon">
							<span class="flaticon-005-pancake"></span>
							<h5>Red Velvet</h5>
						</div>
					</div>
					<div class="categories__item">
						<div class="categories__item__icon">
							<span class="flaticon-030-cupcake-2"></span>
							<h5>Biscuit</h5>
						</div>
					</div>
					<div class="categories__item">
						<div class="categories__item__icon">
							<span class="flaticon-006-macarons"></span>
							<h5>Donut</h5>
						</div>
					</div>
					<div class="categories__item">
						<div class="categories__item__icon">
							<span class="flaticon-006-macarons"></span>
							<h5>Cupcake</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Categories Section End -->

	<!-- Product Section Begin -->
	<section class="product spad">
		<div class="container">
			<div class="row">
				<%
				for (Product product : products) {
				%>
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="product__item">
						<div class="product__item__pic set-bg"
							data-setbg="${url}/img/shop/<%=product.getThumbnail()%>">
							<div class="product__label">
								<span><%=product.getCategory_id()%></span>
							</div>
						</div>
						<div class="product__item__text">
							<h6>
								<a href="#"><%=product.getName()%></a>
							</h6>
							<div class="product__item__price"><%=product.getPrice()%>VND</div>
							<div class="cart_add">
								<a href="shopdetail.jsp?id=<%=product.getId()%>">Shop
									Detail</a>
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
	<!-- Product Section End -->

	<!-- Instagram Section Begin -->
	<section class="instagram spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 p-0">
					<div class="instagram__text">
						<div class="section-title">
							<span>Follow us on instagram</span>
							<h2>Sweet moments are saved as memories.</h2>
						</div>
						<h5>
							<i class="fa fa-instagram"></i> @sweetcake
						</h5>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="row">
						<div class="col-lg-4 col-md-4 col-sm-4 col-6">
							<div class="instagram__pic">
								<img src="${url}/img/instagram/instagram-1.jpg" alt="">
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-6">
							<div class="instagram__pic middle__pic">
								<img src="${url}/img/instagram/instagram-2.jpg" alt="">
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-6">
							<div class="instagram__pic">
								<img src="${url}/img/instagram/instagram-3.jpg" alt="">
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-6">
							<div class="instagram__pic">
								<img src="${url}/img/instagram/instagram-4.jpg" alt="">
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-6">
							<div class="instagram__pic middle__pic">
								<img src="${url}/img/instagram/instagram-5.jpg" alt="">
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-6">
							<div class="instagram__pic">
								<img src="${url}/img/instagram/instagram-3.jpg" alt="">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Instagram Section End -->

	<!-- Map Begin -->
	<div class="map">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-7">
					<div class="map__inner">
						<h6>Fresh Cake</h6>
						<ul>
							<li>194 Giải Phóng, Phương Liệt, Thanh Xuân, Hà Nội</li>
							<li>caovanhuy2710@gmail.con</li>
							<li>+84-86296-9049</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="map__iframe">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.982844559622!2d105.8377940750238!3d20.99332478899509!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ac6580ff4825%3A0x751133da59af8d9e!2zTmcuIDE5NCBHaeG6o2kgUGjDs25nLCBQaMawxqFuZyBMaeG7h3QsIFRoYW5oIFh1w6JuLCBIw6AgTuG7mWksIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1697000353935!5m2!1svi!2s"
				width="600" height="350" style="border: 0;" allowfullscreen=""
				loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
		</div>
	</div>
	<!-- Map End -->

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