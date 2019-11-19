<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông tin giỏ hàng</title>
<link rel="shortcut icon" href="resources/images/favicon.png">

<link href="resources/css/bootstrap.css" rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100'
	rel='stylesheet' type='text/css'>
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/flexslider.css" type="text/css"
	media="screen" />
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<%@ include file="header.jsp"%>
			<div class="clearfix"></div>
			<div class="page-index">
				<div class="container">
					<p>Home - Giỏ Hàng</p>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>


		<!-- Code hien thi san pham -->


		<div class="container_fullwidth">
			<div class="container shopping-cart">
				<div class="row">
					<div class="col-md-12">
						<h3 class="title">Thông tin giỏ hàng</h3>
						<div class="clearfix"></div>
						<c:set var="bean" value="${sessionScope.cart}"></c:set>
						<c:if test="${not empty cart }">
						<table class="shop-table">
							<thead>
								<tr>
									<th>Hình ảnh</th>
									<th>Tên sản phẩm</th>
									<th>Giá</th>
									<th>Số lượng</th>
									<th>Thành tiền</th>
									<th>Xóa khỏi giỏ hàng</th>
								</tr>
							</thead>
							<tbody>
								
									<c:forEach items="${bean}" var="ct">
										<tr>
											<td><img src='<c:out value="${ct.sanPham.hinh}"></c:out>'
												alt=""></td>
											<td>
												<div class="shop-details">
													<div class="productname">
														<c:out value="${ct.sanPham.tenSanPham}"></c:out>
													</div>
												</div>
											</td>
											<td>
												<h5>
													<c:out value="${ct.sanPham.gia}"></c:out>
												</h5>
											</td>
											<td>
											
											<a href="CapNhatGioHang?sl=-1&id=<c:out value="${ct.sanPham.maSanPham}"/>"><button class="btn btn-warning">-</button> </a>
											<c:out value="${ct.soLuongSanPham}"></c:out>
											<a href="CapNhatGioHang?sl=1&id=<c:out value="${ct.sanPham.maSanPham}"/>"><button class="btn btn-warning">+</button> </a>
											</td>
											<td>
												<h5>
													<strong class="red"> <c:out value="${ct.giaSanPham*ct.soLuongSanPham}"></c:out>
													</strong>
												</h5>
											</td>
											<td><a
												href="XoaSanPhamGioHang?id=<c:out value="${ct.sanPham.maSanPham}"></c:out>">
													<img src="resources/images/remove.png" alt="">
											</a></td>
										</tr>
									</c:forEach>
									<tfoot>
										<tr>
											<td colspan="">
												<a href="<c:url value="/"/>"><button class="pull-left">Tiếp tục
													mua sắm</button></a>
											</td>
											<td>
											<a href="XacNhanDonHang">
												<button class="btn btn-danger pull-right">Xác nhận đơn hàng</button>
											</td>
											<td>
											<h5>Tổng tiền:</h5>
											</td>
											<td>
												<div  class="grandtotal ">
												
												<span> <c:out value="${tongtien }"/> </span>
											</div>
											</td>
											<td>
												
											</a>
											</td>
										</tr>
									</tfoot>
									
							</tbody>
						</table>
						<div class="clearfix"></div>								
						<div class="row">
							<div  class="grandtotal col-8">
								
							<div class="col-4">
								
							</div>
						</div>
							
								
					</div>
					</div>
				</div>
				</c:if>
					<div class="clearfix"></div>
			</div>
		
		</div>
		
		<c:if test="${empty cart }">
		<div class="col-md-12">
			<div class="col-md-3"> </div>
			<div class="col-md-6">
				<h5>
					<strong class="red"> Giỏ hàng trống. <br> Quay lại
						trang chủ để chọn sản phẩm vào giỏ hàng.
					</strong>
				</h5><br>
				<a href="<c:url value="/" />"><button class="pull-left">Quay lại mua sắm</button></a>
				<div class="clearfix"></div>
			</div>
			<div class="col-md-3"></div>
		</div>
		</c:if>
		
	</div>
	<div class="clearfix"></div>

	<!-- fotter -->
	<%@ include file="fotter.jsp"%>


	<!-- Bootstrap core JavaScript==================================================-->
	<script type="text/javascript" src="resources/js/jquery-1.10.2.min.js">
		
	</script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js">
		
	</script>
	<script defer src="resources/js/jquery.flexslider.js">
		
	</script>
	<script type="text/javascript"
		src="resources/js/jquery.carouFredSel-6.2.1-packed.js">
		
	</script>
	<script type="text/javascript" src="resources/js/script.min.js">
		
	</script>
</body>
</html>