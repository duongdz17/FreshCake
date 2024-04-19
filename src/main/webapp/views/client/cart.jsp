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
    <%@include file="layout/header.jsp" %>

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__text">
                        <h2>Shopping cart</h2>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__links">
                        <a href="./index.html">Home</a>
                        <span>Shopping cart</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="shopping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th>Sản phẩm</th>
                                    <th>Số lượng</th>
                                    <th>Tổng tiền</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${requestScope.cart_list}" var="cart">
                                <tr>
                                    <td class="product__cart__item">
                                        <div class="product__cart__item__pic">
                                            <img src="${url}/img/shop/${cart.getThumbnail()}" alt="" style="width:100px; height:100px;">
                                        </div>
                                        <div class="product__cart__item__text">
                                            <h6>${cart.getName()}</h6>
                                            <h5>${cart.getPrice()}VND</h5>
                                        </div>
                                    </td>
                                    <td class="quantity__item">
    									<div class="quantity" style="display:flex;">
        									<a href="../../updown?action=giam&id=${cart.getId() }" class="btn btn-sm btn-outline-warning btn-minus">
                									<i class="fa fa-minus"></i>
        									</a>
        								<input type="text" name="quantity" class="form-control form-control-sm bg-secondary text-center" value="${cart.getQuantity()}" readonly="readonly" style="width:30px;"/>
        								<a href="../../updown?action=tang&id=${cart.getId() }" class="btn btn-sm btn-outline-warning btn-plus">
                							<i class="fa fa-plus"></i>
            							</a>
   										</div>
									</td>
                                    <td class="cart__price" class="total">${cart.getPrice() * cart.getQuantity()}VND</td>
                                    <td class="cart__close"><a href="../../deletecart?id=${cart.getId()}"><span class="icon_close"></span></a></td>
                                    <c:set var="subTotal" value=" ${subTotal + cart.getPrice()} " />
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="continue__btn update__btn">
                                <a href="/FreshCake/views/client/shop.jsp"><i class="fa fa-spinner"></i>Continue Shopping</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="cart__discount">
                        <h6>Discount codes</h6>
                        <form action="#">
                            <input type="text" placeholder="Coupon code">
                            <button type="submit">Apply</button>
                        </form>
                    </div>
                    <div class="cart__total">
                        <h6>Cart total</h6>
                        <ul>
                            <li>Subtotal<span>${total } VND</span></li>
                            <li>Total <span>${total } VND</span></li>
                        </ul>
                        <a href="/FreshCake/views/client/checkout.jsp" class="primary-btn">Proceed to checkout</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shopping Cart Section End -->

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