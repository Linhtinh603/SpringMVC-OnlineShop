<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Đăng ký tài khoản</title>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Icons font CSS-->
<link
	href="resources/dangkypage/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link
	href="resources/dangkypage/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link href="resources/dangkypage/vendor/select2/select2.min.css"
	rel="stylesheet" media="all">
<link href="resources/dangkypage/vendor/datepicker/daterangepicker.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="resources/dangkypage/css/main.css" rel="stylesheet"
	media="all">
</head>
<body>
	<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
		<div class="wrapper wrapper--w680">
			<div class="card card-4">
				<div class="card-body">
					<h2 class="title">Điền thông tin đăng ký</h2>
					<form:form ModelAttribute="nguoidung" method="POST" action="DangKy">
						<p class="text-danger">
							<c:out value="${thongbao}"></c:out>
						</p>
						<div class="col-2">
							<div class="input-group">
								<label class="label">Họ tên</label> <input
									class="input--style-4 validate-input" type="text"
									name="tenNguoiDung" required>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Email</label> <input
										class="input--style-4" type="email" name="email">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Số điện thoại</label> <input
										class="input--style-4 validate-input" type="text"
										name="soDienThoai" pattern="(09|01[2|6|8|9])+([0-9]{8})\b"
										required>
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Địa chỉ</label> <input
										class="input--style-4 " type="text" name="diaChi" required>
								</div>
							</div>
						</div>
						<div class="input-group">
							<label class="label">Tên đăng nhập</label> <input
								class="input--style-4 validate-input" type="text"
								name="username" required>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Mật khẩu</label> <input
										class="input--style-4 validate-input" type="password"
										name="pass" required>
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Gõ lại mật khẩu</label> <input
										class="input--style-4 validate-input" type="password"
										name="passwordconfirm" required>
								</div>
							</div>
						</div>
						<div class="p-t-15">
							<button class="btn btn--radius-2 btn--blue" type="submit">Đăng
								Ký</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Jquery JS-->
	<script src="resources/dangkypage/vendor/jquery/jquery.min.js"></script>
	<!-- Vendor JS-->
	<script src="resources/dangkypage/vendor/select2/select2.min.js"></script>
	<script src="resources/dangkypage/vendor/datepicker/moment.min.js"></script>
	<script src="resources/dangkypage/vendor/datepicker/daterangepicker.js"></script>

	<!-- Main JS-->
	<script src="resources/dangkypage/js/global.js"></script>

</body>
</html>