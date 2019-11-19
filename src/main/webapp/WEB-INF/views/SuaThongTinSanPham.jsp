<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý sản phẩm</title>
<link rel="shortcut icon" href="resources/images/favicon.png">

<link href="resources/css/bootstrap.css" rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100'
	rel='stylesheet' type='text/css'>
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/flexslider.css" type="text/css"
	media="screen" />
<link href="resources/css/styleQuanLy.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">
      <div class="header">
        <div class="container">
          <div class="row">
            <div class="col-md-2 col-sm-2">
              <div class="logo">
                <a href="QuanLySanPham">
                  <img src="resources/images/HinhWebsite/logo.png" alt="FlatShop">
                </a>
              </div>
            </div>
            <div class="col-md-10 col-sm-10">
              <div class="header_top">
                <div class="row">
                  <div class="col-md-3">
                    
                  </div>
                  <div class="col-md-6">
                    
                  </div>
                  <div class="col-md-3">
                    <ul class="usermenu">
                      <li>
                        <a href="checkout.html" class="log">
                          Login
                        </a>
                      </li>
                      <li>
                        <a href="checkout2.html" class="reg">
                          Register
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div class="clearfix">
              </div>
              <div class="header_bottom">
                <ul class="option">
                  <li id="search" class="search">
                    <form>
                      <input class="search-submit" type="submit" value="">
                      <input class="search-input" placeholder="Enter your search term..." type="text" value="" name="search">
                    </form>
                  </li>
                  <li class="option-cart">
                    <a href="#" class="cart-icon">
                      cart 
                      <span class="cart_no">
                        02
                      </span>
                    </a>
                    <ul class="option-cart-item">
                      <li>
                        <div class="cart-item">
                          <div class="image">
                            <img src="images/products/thum/products-01.png" alt="">
                          </div>
                          <div class="item-description">
                            <p class="name">
                              Lincoln chair
                            </p>
                            <p>
                              Size: 
                              <span class="light-red">
                                One size
                              </span>
                              <br>
                              Quantity: 
                              <span class="light-red">
                                01
                              </span>
                            </p>
                          </div>
                          <div class="right">
                            <p class="price">
                              $30.00
                            </p>
                            <a href="#" class="remove">
                              <img src="images/remove.png" alt="remove">
                            </a>
                          </div>
                        </div>
                      </li>
                      <li>
                        <div class="cart-item">
                          <div class="image">
                            <img src="images/products/thum/products-02.png" alt="">
                          </div>
                          <div class="item-description">
                            <p class="name">
                              Lincoln chair
                            </p>
                            <p>
                              Size: 
                              <span class="light-red">
                                One size
                              </span>
                              <br>
                              Quantity: 
                              <span class="light-red">
                                01
                              </span>
                            </p>
                          </div>
                          <div class="right">
                            <p class="price">
                              $30.00
                            </p>
                            <a href="#" class="remove">
                              <img src="images/remove.png" alt="remove">
                            </a>
                          </div>
                        </div>
                      </li>
                      <li>
                        <span class="total">
                          Total 
                          <strong>
                            $60.00
                          </strong>
                        </span>
                        <button class="checkout" onClick="location.href='checkout.html'">
                          CheckOut
                        </button>
                      </li>
                    </ul>
                  </li>
                </ul>
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">
                      Toggle navigation
                    </span>
                    <span class="icon-bar">
                    </span>
                    <span class="icon-bar">
                    </span>
                    <span class="icon-bar">
                    </span>
                  </button>
                </div>
     <!-- ======================================================================= MENU ================================================================================== -->
                <div class="navbar-collapse collapse">
                  <ul class="nav navbar-nav">
                    <li >
                      <a href="" >
                        Đơn hàng mới
                      </a>
                    </li>
                    <li>
                      <a href="">
                        Danh sách đơn hàng
                      </a>
                    </li>
                    <li class="active dropdown">
                      <a href="QuanLySanPham">
                        Quan lý sản phẩm
                      </a>
                    </li>
                    <li >
                      <a href="QuanLyNguoiDung" >
                       Quản lý người dùng
                      </a>
                    </li>
                  </ul>
                </div>
    <!-- ======================================================================= MENU ================================================================================== -->
              </div>
            </div>
          </div>
        </div>
        <div class="clearfix">
        </div>
        <div class="page-index">
          <div class="container">
            <button class="" data-toggle="modal" data-target="#myModalThem">
                   Thêm mới sản phẩm
             </button>
          </div>
          
        </div>
      </div>
      <div class="clearfix">
      </div>
      
      
      <!-- ------------------------------------------------------- Code hien thi san pham -------------------------------------------------->
      
      
      <div class="container_fullwidth">
      
        <div class="container shopping-cart">
          <div class="row">
            <div class="col-md-12">
            	
              	<h2>Chỉnh sửa thông tin sản phẩm</h2>
              	<c:set value="${ttsp}" var="ttsp"></c:set>
              	<c:set value="${dsdm}" var="dsdm"></c:set>
              	<form action="QuanLySanPham_LuuSanPhamSua?masanpham=<c:out value="${ttsp.maSanPham}"/>" method="post" >
              	
					  <div class="form-group">
					    <h4 >Tên sản phẩm :</h4>
					    <input type="text" class="form-control" name="tensanpham" value="${ttsp.tenSanPham}" required>
					  </div>
					  <div class="form-group">
					    <h4 >Giá:</h4>
					    <input type="text" class="form-control" name="gia" value="${ttsp.gia}" required pattern="^([1-9][0-9]{3,10}|100000000)$">
					  </div>
					  <div class="form-group">
					    <h4 >Số lượng:</h4>
					    <input type="text" class="form-control" name="soluong" value="${ttsp.soLuong}" required pattern="^([1-9][0-9]{0,10}|1000)$">
					  </div>
					  <div class="form-group">
					    <h4 >Mô tả:</h4>
					    <input type="text" class="form-control" name="mota" value="${ttsp.moTa}">
					  </div>
					  <div class="form-group">
					    <h4 >Ảnh:</h4><img src="${ttsp.hinh}" width="100px">
					    <input type="text" class="form-control" name=hinh value="${ttsp.hinh}" pattern="([\w|\s|-|\])*\.(?:jpg|gif|png)"/>
					    <!-- <input type="file" class="form-control" name="multipartFile" accept="image/*" />  -->
					  </div>
					  <div class="form-group">
					    <h4>Danh muc:</h4>
						<select class="form-control" name="madanhmuc">
							<c:forEach items="${dsdm}" var="dsdm">
								<option value="${dsdm.maDanhMuc}"><c:out value="${dsdm.maDanhMuc} | ${dsdm.tenDanhMuc}"></c:out> </option>
							</c:forEach>
						</select>
					  </div>
					  <a href="QuanLySanPham">
					  	<button type="button" class="btn btn-primary" >Hủy</button>
					  </a>
					  <button type="submit" class="btn btn-primary" >Lưu thay đổi</button>
				</form>
             
             </div>
            </div>
          </div>
         <!-- ----------------------------------------------------------------------------------------------------------------------- -->
        </div>
      </div>
      <div class="clearfix">
      </div>
      <div class="footer">
        <div class="footer-info">
          <div class="container">
            <div class="row">
              <div class="col-md-3">
                <div class="footer-logo">
                  <a href="#">
                    <img src="resources/images/logo.png" alt="">
                  </a>
                </div>
              </div>
              <div class="col-md-3 col-sm-6">
                <h4 class="title">
                  Contact 
                  <strong>
                    Info
                  </strong>
                </h4>
                <p>
                  No. 08, Nguyen Trai, Hanoi , Vietnam
                </p>
                <p>
                  Call Us : (084) 1900 1008
                </p>
                <p>
                  Email : michael@leebros.us
                </p>
              </div>
              <div class="col-md-3 col-sm-6">
                <h4 class="title">
                  Customer
                  <strong>
                    Support
                  </strong>
                </h4>
                <ul class="support">
                  <li>
                    <a href="#">
                      FAQ
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      Payment Option
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      Booking Tips
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      Infomation
                    </a>
                  </li>
                </ul>
              </div>
              <div class="col-md-3">
                <h4 class="title">
                  Get Our 
                  <strong>
                    Newsletter 
                  </strong>
                </h4>
                <p>
                  Lorem ipsum dolor ipsum dolor.
                </p>
                <form class="newsletter">
                  <input type="text" name="" placeholder="Type your email....">
                  <input type="submit" value="SignUp" class="button">
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="copyright-info">
          <div class="container">
            <div class="row">
              <div class="col-md-6">
                <p>
                  Copyright © 2012. Designed by 
                  <a href="#">
                    Michael Lee
                  </a>
                  . All rights reseved
                </p>
              </div>
              <div class="col-md-6">
                <ul class="social-icon">
                  <li>
                    <a href="#" class="linkedin">
                    </a>
                  </li>
                  <li>
                    <a href="#" class="google-plus">
                    </a>
                  </li>
                  <li>
                    <a href="#" class="twitter">
                    </a>
                  </li>
                  <li>
                    <a href="#" class="facebook">
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript==================================================-->
    <script type="text/javascript" src="resources/js/jquery-1.10.2.min.js">
    </script>
    <script type="text/javascript" src="resources/js/bootstrap.min.js">
    </script>
    <script defer src="resources/js/jquery.flexslider.js">
    </script>
    <script type="text/javascript" src="resources/js/jquery.carouFredSel-6.2.1-packed.js">
    </script>
    <script type="text/javascript" src="resources/js/script.min.js" >
    </script>
</body>
</html>