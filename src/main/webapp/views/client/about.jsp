<%@page import="model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/views/client/assets" var="url"></c:url>
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

	<!-- Breadcrumb Begin -->
	<div class="breadcrumb-option">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="breadcrumb__text">
						<h2>Giới thiệu</h2>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="breadcrumb__links">
						<a href="/FreshCake/views/client/index.jsp">Home</a> <span>Blog</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Blog Section Begin -->
	<section class="blog spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="blog__item">
						<div class="blog__item__pic set-bg"
							data-setbg="${url}/img/about/about1.jpg">
							<div class="blog__pic__inner">
								<div class="label">Câu chuyện thương hiệu</div>
							</div>
						</div>
						<div class="blog__item__text">
							<p>Thành lập vào tháng 12/2010 từ tình yêu với những chiếc
								bánh, Fresh Garden khởi nguồn cùng slogan “Bánh tươi mỗi ngày”
								và sứ mệnh xuyên suốt về mang tới những sản phẩm thơm ngon nhất.
								Những năm đầu, sản phẩm chủ lực của Fresh Garden là bánh kem và
								bánh mì tươi. Trong mỗi dịp lễ hay sinh nhật, bánh kem của Fresh
								Garden luôn là một trong những lựa chọn hàng đầu, bởi độ ngọt
								vừa phải, mẫu bánh đẹp, giá thành hợp lý. Bên cạnh đó, đồng hành
								mỗi ngày của khách hàng là các sản phẩm bánh mì tươi dinh dưỡng,
								thơm ngon.</p>
						</div>
						<div class="blog__item__pic set-bg"
							data-setbg="${url}/img/about/about2.jpg">
							<div class="blog__pic__inner">
								<div class="label">Dấu ấn hành trình</div>
							</div>
						</div>
						<div class="blog__item__text">
							<p>Với hơn 100 cửa hàng và đại lý phân phối phủ khắp các tỉnh
								phía Bắc, Fresh Garden tự hào là thương hiệu bánh tươi uy tín
								bậc nhất với dây chuyền sản xuất tiên tiến hiện đại cùng gần
								1000 nhân sự làm việc chăm chỉ không ngừng sáng tạo. Với tín đồ
								của bánh ngọt, mặn, bánh kem thì thật sự Fresh Garden chính là
								một "thế giới thu nhỏ" của bánh trái, chiều lòng bất kì vị khách
								nào ghé ngang. Trải qua một thập kỷ với những cung bậc sáng tạo,
								Fresh Garden không chỉ ghi dấu bởi chất lượng mà còn vì sự tinh
								tế trong từng nấc hương vị, đa dạng bánh Âu, Á và dần trở thành
								thói quen trong văn hóa tiêu dùng của những tín đồ yêu bánh. Thế
								mạnh của Fresh Garden nằm ở những dòng bánh kem tươi mềm mịn
								ngọt dịu tươi mới, bánh mì nướng đặc biệt giòn thơm, bánh cuộn
								chuẩn Nhật với lớp kem sữa Hokkaido… rất được ưa chuộng. Trong
								mỗi dịp lễ hay sinh nhật, bánh kem của Fresh Garden luôn là một
								lựa chọn hàng đầu, bởi độ ngọt vừa phải, mẫu bánh đẹp, giá thành
								hợp lý. Bên cạnh đó, đồng hành với khách hàng mỗi ngày là các
								sản phẩm bánh mì tươi – bánh mỳ kẹp tiện lợi, dinh dưỡng.</p>
						</div>
						<div class="blog__item__pic set-bg"
							data-setbg="${url}/img/about/about3.jpg">
							<div class="blog__pic__inner">
								<div class="label">Sứ mệnh và tầm nhìn</div>
							</div>
						</div>
						<div class="blog__item__text">
							<p>Đằng sau Fresh Garden là đội ngũ nhân viên, chuyên gia đầu
								bếp luôn nỗ lực sáng tạo, không ngừng đam mê để có thể đưa ra
								những sản phẩm ngon, chất lượng, đẹp mắt và an toàn cho sức khỏe
								khách hàng. Đi cùng quy trình làm bánh nghiêm ngặt, khép kín,
								đòi hỏi nhân viên phải cẩn thận, tỉ mỉ và chăm chút trong từng
								công đoạn nhỏ nhất. Fresh Garden cam kết mang đến những sản phẩm
								đạt chất lượng cao nhất như một lời tri ân đối với sự yêu mến và
								tin dùng.</p>
						</div>
						<div class="blog__item__pic set-bg"
							data-setbg="${url}/img/about/about4.jpg">
							<div class="blog__pic__inner">
								<div class="label">Những giá trị tạo nên Fresh Garden</div>
							</div>
						</div>
						<div class="blog__item__text">
							<p>Từng sản phẩm Fresh Garden được đầu tư rất kỹ ngay từ khâu
								chọn nguyên liệu, đó là những thành phần tươi mới nhất và chủ
								yếu đang sử dụng đều đến từ những nhãn hiệu có uy tín như
								Anchor, Vivo, Meiji, Komplet… Một số dòng sốt của Ý như sốt
								pizza, sốt mayonaise cũng được nhập trực tiếp từ Ý.
								Đến với Fresh Garden là đến với hàng trăm hương, vị bánh đa chủng loại Á
								– Âu: bánh ngọt, bánh mì tươi, các dòng bánh kem sinh nhật, sự
								kiện, theo mùa… Các loại bánh luôn được chú trọng sản xuất sao
								cho đảm bảo hương vị thơm ngon tuyệt vời mà còn an
								toàn, đảm bảo cho sức khoẻ. Mỗi chiếc bánh ra đời là đam mê
								của một tập thể tâm huyết với nghề, mỗi sẩn phẩm trao tay là tận
								tâm của đội ngũ nhân viên với khách hàng.Tất cả những điều
								đó, bạn sẽ cảm nhận được khi thưởng thức từng dòng
								bánh tuyệt hảo – ý nghĩa – tiện lợi mà Fresh Garden đặc biệt
								tạo nên.</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="blog__sidebar">
						<div class="blog__sidebar__item">
							<h5>Follow me</h5>
							<div class="blog__sidebar__social">
								<a href="https://www.facebook.com/huy.cao.2710/"><i class="fa fa-facebook"></i></a> <a href="https://www.instagram.com/_huy.cao/"><i
									class="fa fa-instagram"></i></a> <a href="https://www.youtube.com/channel/UC4t7n_UUgbAlpoJLjG_dYXQ"><i
									class="fa fa-youtube-play"></i></a> <a href="https://twitter.com/huycao2710"><i
									class="fa fa-twitter"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Blog Section End -->

	<!-- Footer Section Begin -->
	<%@include file="layout/footer.jsp"%>
	<!-- Footer Section End -->

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