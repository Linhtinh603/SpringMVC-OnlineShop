<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý đơn hàng</title>
<link rel="shortcut icon" href="resources/images/favicon.png">

<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100' rel='stylesheet' type='text/css'>
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/flexslider.css" type="text/css" media="screen" />
<link href="resources/css/styleQuanLyDonHang.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">
      <div class="header">
        <div class="container">
          <div class="row">
            <div class="col-md-2 col-sm-2">
              <div class="logo">
                <a href="QuanLyDonHang">
                  <img src="resources/images/HinhWebsite/logo.png" alt="Logo">
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
                    <li class="active dropdown">
                      <a href="QuanLyDonHang">
                        Quản lý đơn hàng
                      </a>
                    </li>
                    <li >
                      <a href="QuanLySanPham">
                        Quản lý sản phẩm
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
              <h2>Đơn hàng mới</h2>
              <table class="shop-table ">
                <thead>
                  <tr>
                    <th>
                      Mã
                    </th>
                    <th>
                      Danh sách sản phẩm
                      <table class="tablemini">
                      	<tr>
                      		<th>Tên</th>
                      		<th>Số lượng</th>
                      		<th>Giá</th>
                      		<th>Hình</th>
                      	</tr>
                      </table>
                    </th>
                    <th>
                    	Tên người dùng
                    </th>
                    <th>
                    	Ngày Tạo
                    </th>
                    <th>
                       Hủy đơn hàng
                    </th>
                    <th>
                     	Xác nhận đơn hàng
                    </th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${dsdhfalse}" var="dh">
                  <tr>
                    <td>
						<h5> <c:out value="${dh.maDonHang}"></c:out> </h5>
                    </td>
                    <td>
	                    <table class="tablemini">
	                      	<c:forEach items="${dh.chiTietDonHangList}" var="listctdh">
		                      	<tr>
		                      		<th><h5><c:out value="${listctdh.sanPham.tenSanPham}" /></h5></th>
		                      		<th><h5><c:out value="${listctdh.soLuongSanPham}" /></h5></th>
		                      		<th><h5><c:out value="${listctdh.giaSanPham}" /></h5></th>
		                      		<th><img alt="" src="<c:out value="${listctdh.sanPham.hinh}" />"></th>
		                      	</tr>
	                      	</c:forEach>
                      </table>
                    </td>
                    <td>
                      	<h5><c:out value="${dh.maNguoiDung.tenNguoiDung}"></c:out></h5>
                    </td>
                    <td>
                       <h5><c:out value="${dh.ngayTaoDonHang}"></c:out></h5>
                    </td>
                    
                    <td>
                    	<form:form action="QuanLyDonHangHuy?ma=${dh.maDonHang}" method="post" >
                    		<input type="submit" value="Hũy" class="btn btn-danger">
                    	</form:form>
                    </td>
                    <td>
                    	<form:form action="QuanLyDonHangXacNhan?ma=${dh.maDonHang}" method="post" >
                    		<input type="submit" value="Xác Nhận" class="btn btn-success">
                    	</form:form>
                    </td>
                    
                  </tr>
                  
                  </c:forEach>
                
                </tbody>
     
	 </table>
	 
              <div class="clearfix">
              </div>
              <div class="row">
                    <div class="subtotal">
                      
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
          <hr>
         <!-- -------------- ket thúc table 1-------------------------------------------------------------------------------------------------------- -->
         
         <div class="container shopping-cart">
          <div class="row">
          	
            <div class="col-md-12">
              
              <div class="clearfix">
              </div>
              <h2>Đơn hàng cũ</h2>
              <table class="shop-table ">
                <thead>
                  <tr>
                    <th>
                      Mã
                    </th>
                    <th>
                      Danh sách sản phẩm
                      <table class="tablemini">
                      	<tr>
                      		<th>Tên</th>
                      		<th>Số lượng</th>
                      		<th>Giá</th>
                      		<th>Hình</th>
                      	</tr>
                      </table>
                    </th>
                    <th>
                    	Tên người dùng
                    </th>
                    <th>
                    	Ngày Tạo
                    </th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${dsdhtrue}" var="dh">
                  <tr>
                    <td>
                       <h5><c:out value="${dh.maDonHang}"></c:out></h5>
                    </td>
                    <td>
	                    <table class="tablemini">
                      	<c:forEach items="${dh.chiTietDonHangList}" var="listctdh">
	                      	<tr>
	                      		<th><h5><c:out value="${listctdh.sanPham.tenSanPham}" /></h5></th>
	                      		<th><h5><c:out value="${listctdh.soLuongSanPham}" /></h5></th>
	                      		<th><h5><c:out value="${listctdh.giaSanPham}" /></h5></th>
	                      		<th><img alt="" src="<c:out value="${listctdh.sanPham.hinh}" />"></th>
	                      	</tr>
                      	</c:forEach>
                      </table>
                    </td>
                    <td>
                      <h5><c:out value="${dh.maNguoiDung.tenNguoiDung}"></c:out></h5>
                    </td>
                    <td>
                       <h5><c:out value="${dh.ngayTaoDonHang}"></c:out></h5>
                    </td>
                  </tr>
                  
                  </c:forEach>
                
                </tbody>
     
	 </table>
	 
              <div class="clearfix">
              </div>
              <div class="row">
                    <div class="subtotal">
                      
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
         
         <!-- -------------- ket thúc table 2-------------------------------------------------------------------------------------------------------- -->
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