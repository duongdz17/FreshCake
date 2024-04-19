<%@page import="dao.ProductDAO"%>
<%@page import="model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/views/client/assets" var="url"></c:url>
<%
	ArrayList<Cart> cart_list = (ArrayList<Cart>)session.getAttribute("carts");
if (cart_list != null){
	ProductDAO productDAO = new ProductDAO();
	double total= productDAO.getTotal(cart_list);
	request.setAttribute("cart_list", cart_list);
	request.setAttribute("total", total);
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
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500;600;700;800;900&display=swap"
    rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${url}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/flaticon.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/barfiller.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/slicknav.min.css" type="text/css">
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
                        <h2>Checkout</h2>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__links">
                        <a href="./index.html">Home</a>
                        <span>Checkout</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="/FreshCake/order" method="post">
                    <div class="row">
                        <div class="col-lg-7 col-md-5">
                            <h6 class="checkout__title">Thông tin hoá đơn</h6>
                            <div class="checkout__input" hidden="" >
                                <p>ID<span>*</span></p>
                                <input type="number" name="id">
                            </div>
                            <div class="checkout__input">
                                <p>Họ tên khách hàng<span>*</span></p>
                                <input type="text" name="fullname">
                            </div>
                            <div class="checkout__input">
                                <p>Email<span>*</span></p>
                                <input type="email" name="email" >
                            </div>
                            <div class="checkout__input">
                                <p>Số điện thoại<span>*</span></p>
                                <input type="number" name="phonenumber" >
                            </div>
                            <div class="checkout__input">
                                <p>Địa chỉ<span>*</span></p>
                                <input type="text" name="address" >
                            </div>
                            <div class="checkout__input">
                                <p>Ghi chú<span>*</span></p>
                                <input type="text" name="note" >
                            </div>
                            <div class="checkout__input">
                                <p>Ngày đặt<span>*</span></p>
                                <input type="date" name="orderdate" >
                            </div>
                            <div class="checkout__input" hidden="">
                                <p>Trạng thái<span>*</span></p>
                                <input type="number" name="status" value="1" >
                            </div>
                            <div class="checkout__input" hidden="" class="total">
                                <p>Total<span>*</span></p>
                                <input type="number" name="total" value="${total }">
                            </div>
                            <div class="checkout__input" hidden="">
                                <p>Mã khách hàng<span>*</span></p>
                                <input type="number" name="user_id">
                            </div>
                        </div>
                        <div class="col-lg-5 col-md-7">
                            <div class="checkout__order">
                                <h6 class="order__title">Đơn hàng của bạn</h6>
                                <div class="checkout__order__products">Sản phẩm</div>
                                <c:forEach items="${requestScope.cart_list}" var="cart">
                                <ul class="checkout__total__products">
                                    <li>${cart.getName()}</li>
                                </ul>
                                </c:forEach>
                                <ul class="checkout__total__all">
                                	<li class="total" >Price <span>${total } VND</span></li>
                                    <li>Total <span>${total } VND</span></li>
                                </ul>
                                <button type="submit" class="site-btn">Đặt hàng</button>
                            </div>
                            
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->

    <%@include file="layout/footer.jsp" %>

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