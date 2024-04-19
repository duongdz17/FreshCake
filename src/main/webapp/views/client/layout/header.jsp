<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!-- Page Preloder -->
<div id="preloder">
	<div class="loader"></div>
</div>

<!-- Offcanvas Menu Begin -->
<div class="offcanvas-menu-overlay"></div>
<div class="offcanvas-menu-wrapper">
	<div class="offcanvas__cart">
		<div class="offcanvas__cart__links">
			<a href="#" class="search-switch"><img
				src="${url}/img/icon/search.png" alt=""></a> <a href="#"><img
				src="${url}/img/icon/heart.png" alt=""></a>
		</div>
		<div class="offcanvas__cart__item">
			<a href="#"><img src="${url}/img/icon/cart.png" alt=""> <span>0</span></a>
			<div class="cart__price">
				Cart: <span>$0.00</span>
			</div>
		</div>
	</div>
	<div class="offcanvas__logo">
		<a href="./index.html"><img src="${url}/img/logo.png" alt=""></a>
	</div>
	<div id="mobile-menu-wrap"></div>
	<div class="offcanvas__option">
		<ul>
			<li>USD <span class="arrow_carrot-down"></span>
				<ul>
					<li>EUR</li>
					<li>USD</li>
				</ul>
			</li>
			<li>ENG <span class="arrow_carrot-down"></span>
				<ul>
					<li>Spanish</li>
					<li>ENG</li>
				</ul>
			</li>
			<li>
			<c:if test="${not empty userobj }">
               <a href="#">${userobj.fullname}</a> <span class="arrow_carrot-down"></span>
               <a href="../../userLogout">Đăng xuất</a> <span class="arrow_carrot-down"></span>
                </c:if>
                <c:if test="${empty userobj }">
               <a href="loginUser.jsp">Đăng nhập</a> <span class="arrow_carrot-down"></span>
               <a href="registerUser.jsp">Đăng ký</a> <span class="arrow_carrot-down"></span>
                </c:if></li>
		</ul>
	</div>
</div>
<!-- Offcanvas Menu End -->

<!-- Header Section Begin -->
<header class="header">
	<div class="header__top">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="header__top__inner">
						<div class="header__top__left">
							<ul>
								<li>USD <span class="arrow_carrot-down"></span>
									<ul>
										<li>EUR</li>
										<li>USD</li>
									</ul>
								</li>
								<li>ENG <span class="arrow_carrot-down"></span>
									<ul>
										<li>Spanish</li>
										<li>ENG</li>
									</ul>
								</li>
								<li>
								<c:if test="${not empty userobj }">
               <a href="#">${userobj.fullname }</a> <span class="arrow_carrot-down"></span>
               <a href="../../userLogout">Đăng xuất</a> <span class="arrow_carrot-down"></span>
                </c:if>
                <c:if test="${empty userobj }">
               <a href="loginUser.jsp">Đăng nhập</a> <span class="arrow_carrot-down"></span>
               <a href="registerUser.jsp">Đăng ký</a> <span class="arrow_carrot-down"></span>
                </c:if>
								</li>
							</ul>
						</div>
						<div class="header__logo">
<a href="./index.html"><img src="${url}/img/logo.png" alt=""></a>
						</div>
						<div class="header__top__right">
							<div class="header__top__right__links">
								<a href="#" class="search-switch"><img
									src="${url}/img/icon/search.png" alt=""></a> <a href="#"><img
									src="${url}/img/icon/heart.png" alt=""></a>
							</div>
							<div class="header__top__right__cart">
								<c:if test="${not empty userobj }">
									<a href="/FreshCake/views/client/cart.jsp"><img
										src="${url}/img/icon/cart.png" alt=""> <span class="qty">${cart_list.size()}</span></a>
								</c:if>
								<c:if test="${empty userobj }">
									<a href="/FreshCake/views/client/cart.jsp"><img
										src="${url}/img/icon/cart.png" alt=""> <span class="qty">0</span></a>
									</c:if>
									
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="canvas__open">
				<i class="fa fa-bars"></i>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<nav class="header__menu mobile-menu">
					<ul>
						<li><a href="/FreshCake/views/client/index.jsp">Trang chủ</a></li>
						<li><a href="/FreshCake/views/client/about.jsp">Chi tiết</a></li>
						<li><a href="/FreshCake/views/client/shop.jsp">Shop</a></li>
						<li><a href="/FreshCake/views/client/contact.jsp">Liên hệ</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</header>
<!-- Header Section End -->