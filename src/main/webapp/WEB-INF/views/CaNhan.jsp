<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100' rel='stylesheet' type='text/css'>
	<link href="resources/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/flexslider.css" type="text/css" media="screen" />
	<link href="resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="header">
		<!-- header -->
		>
		<%@ include file="header.jsp"%>
	</div>
	<table class="shop-table ">
		<tr>
			<td><h5> Họ tên: </h5></td>
			<td><h5> <c:out value="${canhan.tenNguoiDung }"> </c:out></h5></td>
		</tr>
		<tr>
			<td><h5> Username: </td>
			<td><h5> <c:out value="${canhan.username }"> </c:out></h5></td>
		</tr>
		<tr>
			<td><h5> Địa chỉ: </h5></td>
			<td><h5> <c:out value="${canhan.diaChi }"> </c:out></h5></td>
		</tr>
		<tr>
			<td><h5> Email: </h5></td>
			<td><h5> ${canhan.email }</h5></td>
		</tr>
		<tr>
			<td><h5> Số điện thoại: </h5></td>
			<td><h5> ${canhan.soDienThoai }</h5></td>
		</tr>
	</table>
	<a href="ThayDoiThongTin"><button class="pull-left">Chỉnh sửa thông tin</button></a>
	<a href="DonHangCuaToi"><button class="pull-left">Xem lịch sử đơn hàng</button></a>
	<div class="clearfix"></div>
         <%@ include file="fotter.jsp" %>
</body>
</html>