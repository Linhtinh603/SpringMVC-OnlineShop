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
					<p>Cá Nhân - Đơn Hàng Của Tôi</p>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>


		<!-- Code hien thi san pham -->


		<div class="container_fullwidth">
			<div class="container shopping-cart">
				<div class="row">
					<div class="col-md-12">
					<c:if test="${not empty listCTDH }">
					<h3 class="title">Chi tiết đơn hàng (Mã đơn hàng = <c:out value="${maDonHang }"/>)</h3>
					<table class="shop-table">
							<thead>
								<tr>
									<th>Tên sản phẩm</th>
									<th>Giá</th>
									<th>Số lượng</th>
									<th>Thành tiền</th>
								</tr>
							</thead>
							<tbody>
								
									<c:forEach items="${listCTDH}" var="ct">
										<tr>
											<td>
												
												<c:out value="${ct.sanPham.tenSanPham}"></c:out>
													
											</td>
											<td>
												<h5>
													<c:out value="${ct.sanPham.gia}"></c:out>
												</h5>
											</td>
											<td>
												<c:out value="${ct.soLuongSanPham}"></c:out>
											</td>
											<td>
												<h5>
													<strong class="red"> <c:out value="${ct.giaSanPham*ct.soLuongSanPham}"></c:out>
													</strong>
												</h5>
											</td>
										</tr>
									</c:forEach>
							</tbody>
						</table>
					</c:if>
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-md-12">
						<h3 class="title">Danh sách đơn hàng của bạn</h3>
						<div class="clearfix"></div>
						
						<c:if test="${not empty dsdonhang }">
						<table class="shop-table">
							<thead>
								<tr>
									<th>STT</th>
									<th>Thông tin đơn hàng</th>
									<th>Tình Trạng</th>
									<th>Xem chi tiết đơn hàng</th>
								</tr>
							</thead>
							<tbody>
								
									<c:forEach items="${dsdonhang}" var="dh" varStatus="stt">
										<tr>
										<td>
											<c:out value="${stt.count }"></c:out>
										</td>
											<td>
												<div class="shop-details">
													<div class="productname">
													Mã:		<c:out value="${dh.maDonHang}"></c:out>
													Ngày tạo:	<c:out value="${dh.ngayTaoDonHang}"></c:out>
													</div>
												</div>
											</td>
											<td>
												<h5>
												<c:set value="${dh.tinhTrangDonHang}" var="tinhtrang"></c:set>
												<c:if test="${tinhtrang == -1 }">
													Đang chờ xác nhận
												</c:if>
												<c:if test="${tinhtrang == 1}">
													Đã xác nhận
												</c:if>
												<c:if test="${tinhtrang == 0}">
													Đã hủy
												</c:if>
												
												</h5>
											</td>
											<td><a
												href="XemChiTietDonHang?id=<c:out value="${dh.maDonHang}"></c:out>">
													Xem
											</a></td>
										</tr>
									</c:forEach>
									<tfoot>
										<tr>
											<td colspan="">
												<a href="<c:url value="/"/>"><button class="pull-left">Trang chủ</button></a>
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
		
		<c:if test="${empty dsdonhang }">
		<div class="col-md-12">
			<div class="col-md-3"> </div>
			<div class="col-md-6">
				<h5>
					<strong class="red"> Bạn chưa có đơn hàng nào. <br> Quay lại
						trang chủ để chọn sản phẩm vào giỏ hàng.
					</strong>
				</h5><br>
				<a href="/nhom13"><button class="pull-left">Quay lại mua sắm</button></a>
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