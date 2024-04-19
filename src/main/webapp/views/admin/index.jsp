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

<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="shortcut icon" href="${url}/img/icons/icon-48x48.png" />

<link rel="canonical" href="https://demo-basic.adminkit.io/" />

<title>Admin FreshCake</title>

<link href="${url}/css/app.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap"
	rel="stylesheet">
</head>

<body>
	<div class="wrapper">
		<%@include file="layout/sidebar.jsp"%>

		<div class="main">
			<%@include file="layout/header.jsp"%>

			<main class="content">
				<div class="container-fluid p-0">

	<h1 class="h3 mb-3"><strong>Dashboard</strong> </h1>

	<div class="row">
		<div class="col-12 col-md-12 col-xxl-8 d-flex order-3 order-xxl-2">
			<div class="card flex-fill w-100">
				<div class="card-header">

					<h5 class="card-title mb-0">Real-Time</h5>
				</div>
				<div class="card-body px-4">
					<div id="world_map" style="height:350px;"></div>
				</div>
			</div>
		</div>
		<div class="col-12 col-md-6 col-xxl-4 d-flex order-3 order-xxl-2">
			<div class="card flex-fill">
				<div class="card-header">

					<h5 class="card-title mb-0">Calendar</h5>
				</div>
				<div class="card-body d-flex">
					<div class="align-self-center w-100">
						<div class="chart">
							<div id="datetimepicker-dashboard"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
			</main>

			<%@include file="layout/footer.jsp"%>
		</div>
	</div>

	<script src="${url}/js/app.js"></script>

	<script>
	document.addEventListener("DOMContentLoaded", function () {
		var markers = [{
			coords: [21.028511, 105.804817],
			name: "Hanoi"
		}
		];
		var map = new jsVectorMap({
			map: "world",
			selector: "#world_map",
			zoomButtons: true,
			markers: markers,
			markerStyle: {
				initial: {
					r: 9,
					strokeWidth: 7,
					stokeOpacity: .4,
					fill: window.theme.primary
				},
				hover: {
					fill: window.theme.primary,
					stroke: window.theme.primary
				}
			},
			zoomOnScroll: false
		});
		window.addEventListener("resize", () => {
			map.updateSize();
		});
	});
</script>
<script>
	document.addEventListener("DOMContentLoaded", function () {
		var date = new Date(Date.now() - 5 * 24 * 60 * 60 * 1000);
		var defaultDate = date.getUTCFullYear() + "-" + (date.getUTCMonth() + 1) + "-" + date.getUTCDate();
		document.getElementById("datetimepicker-dashboard").flatpickr({
			inline: true,
			prevArrow: "<span title=\"Previous month\">&laquo;</span>",
			nextArrow: "<span title=\"Next month\">&raquo;</span>",
			defaultDate: defaultDate
		});
	});
</script>

</body>

</html>