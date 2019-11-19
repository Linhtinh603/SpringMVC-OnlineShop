<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quản lý người dùng</title>
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
                <a href="QuanLyNguoiDung">
                  <img src="resources/images/HinhWebsite/logo.png" alt="Trang chu">
                </a>
              </div>
            </div>
            <div class="col-md-10 col-sm-10">
              <div class="header_top">
                <div class="header_top">
                        <div class="row">
                           <div class="col-md-3">
                              
                           </div>
                           <div class="col-md-6">
 							<strong><p class="white">Nhóm 13: Huỳnh Cao Hữu Linh - Nguyễn Anh Tú - Trịnh Đức Đạt</p></strong>
                           </div>
                           <div class="col-md-3">
                           <%if (session.getAttribute("user") != null) {%>
                           <ul class="usermenu">
                           	<li> 
                           	<div><p style="color: white;">Admin :
                           	<strong style="color: blue;"><%=session.getAttribute("user") %></strong></p> 
                           	</div>
                           	</li>
                           	<li><a href="DangXuat" class="log">Đăng xuất</a></li>
                           	</ul>
                           	<%} else{ %>
                              <ul class="usermenu">
                                 <li><a href="DangNhap" class="log">Đăng Nhập</a></li>
                                 <li><a href="DangKy" class="reg">Đăng ký</a></li>
                              </ul>
                              <%} %>
                           </div>
                        </div>
                     </div>
              </div>
              <div class="clearfix">
              </div>
              <div class="header_bottom">
               
     <!-- ======================================================================= MENU ================================================================================== -->
                <div class="navbar-collapse collapse">
                  <ul class="nav navbar-nav">
                    <li >
                      <a href="QuanLyDonHang" >
                        Quản lý đơn hàng
                      </a>
                    </li>
                    <li >
                      <a href="QuanLySanPham">
                        Quản lý sản phẩm
                      </a>
                    </li>
                    <li class="active dropdown">
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
        
      </div>
      <div class="clearfix">
      </div>
      
      
      <!-- ------------------------------------------------------- Code hien thi san pham -------------------------------------------------->
      
      
      <div class="container_fullwidth">
      
        <div class="container shopping-cart">
          <div class="row">
          	
            <div class="col-md-12">
              
              <div class="clearfix">
              </div>
              <table class="shop-table ">
                <thead>
                  <tr>
                    <th>
                      Mã
                    </th>
                    <th>
                      Tên người dùng
                    </th>
                    <th>
                      Địa chỉ
                    </th>
                    <th>
                      Email
                    </th>
                    <th>
                      Số điện thoại
                    </th>
                    <th>
                      Tài khoảng
                    </th>
                    
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${dsnd}" var="nd">
                  <tr>
                    <td>
                      <h5>
                       <c:out value="${nd.maNguoiDung}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${nd.tenNguoiDung}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${nd.diaChi}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${nd.email}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${nd.soDienThoai}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${nd.username}"></c:out>
                      </h5>
                    </td>
                    
                  </tr>
                  </c:forEach>
                
                </tbody>
              </table>
               
		  
	
	 <!-- -------------------------------------------------------------------------------------------------------------------- Modal -->
              <div class="clearfix">
              </div>
              <div class="row">
                    <div class="subtotal">
                      
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
         <!-- ----------------------------------------------------------------------------------------------------------------------- -->
        </div>
      </div>
      <div class="clearfix">
      </div>
       <%@ include file="fotter.jsp" %>
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