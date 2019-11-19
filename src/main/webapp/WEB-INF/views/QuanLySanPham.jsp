<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
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
                  <img src="resources/images/HinhWebsite/logo.png" alt="Trang Chu">
                </a>
              </div>
            </div>
            <div class="col-md-10 col-sm-10">
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
                    <li class="active dropdown">
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
        <div class="page-index">
          <div class="container">
          	<div class="hh" >
          		<div  >
          			<table>
          				<tr>
          					<td align="center" width="20%">
          						<button class="" data-toggle="modal" data-target="#myModalThem"> Thêm mới sản phẩm </button>
					             <p align="left" style="color: red;"><c:out value="${thongbaoloi}"></c:out> </p>
          					</td>
          					<td width="40%" >
          					
          					</td>
          					<td align="right" width="100%">
          						<form action="QuanLySanPham_TimTen" method="post" class="timkiem" >
				             		
				             			<h5>Tìm theo tên SP:
					             			<input type="text" name="tkten" >
					             			<input type="submit" value="Tìm kiếm" class="btn btn-info">
				             			</h5> 
				             		
			             		</form>
			             		<form action="QuanLySanPham_TimDanhMuc" method="post" class="timkiem" >
				             		
				             			<h5>Tìm theo danh mục:
					             			<select name="madanhmuc"">
												<option value="all" >All danh mục</option>
					             				<c:forEach items="${dsdm}" var="dsdm">
													<option value="${dsdm.maDanhMuc}"><c:out value="${dsdm.maDanhMuc} --|-- ${dsdm.tenDanhMuc}"></c:out> </option>
												</c:forEach>
					             			</select>
					             			<input type="submit" value="Tìm kiếm" class="btn btn-info">
				             			</h5>
			             		</form>
          					</td>
          				
          				</tr>
          			</table>
          		</div>
          	</div>
            
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
              
              <div class="clearfix">
              </div>
              <table class="shop-table ">
                <thead>
                  <tr>
                    <th>
                      Mã
                    </th>
                    <th>
                      Tên sản hẩm
                    </th>
                    <th>
                      Giá
                    </th>
                    <th>
                      Số lượng
                    </th>
                    <th>
                      Mô tả
                    </th>
                    <th>
                      Danh mục
                    </th>
                    <th>
                      Hình ảnh
                    </th>
                    <th>
                      Sửa
                    </th>
                    <th>
                      Xóa
                    </th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${dssp}" var="sp">
                  <tr>
                    <td>
                      <h5>
                       <c:out value="${sp.maSanPham}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${sp.tenSanPham}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${sp.gia}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${sp.soLuong}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${sp.moTa}"></c:out>
                      </h5>
                    </td>
                    
                    <td>
                    	<h5>
                       <c:out value="${sp.maDanhMuc.tenDanhMuc}"></c:out>
                      </h5>
                    	
                    </td>
                    <td>
                      <img src='<c:out value="${sp.hinh}"></c:out>' alt="">
                    </td>
                    <td>
                    	<a href="QuanLySanPham_SuaSanPham?id=<c:out value="${sp.maSanPham}"/>">
                    		<input type="button" value="Sửa" class="btn btn-success">
                    	</a>
                    </td>
                    <td>
                    	<a href="XoaSanPham_QuanLy?id=<c:out value="${sp.maSanPham}"/>" >	
                    		<input type="button" value="Xóa" class="btn btn-danger">
                    	</a>
                    </td>
                    
                  </tr>
                  
                  </c:forEach>
                
                </tbody>
     <!-- ---------------------------------------------------------------------- Modal thêm ---------------------------------------->
		  <div class="modal fade" id="myModalThem" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Thêm sản phẩm</h4>
		        </div>
		        <div class="modal-body">
		          <form:form action="ThemSanPham" method="post" enctype="multipart/form-data" modelAttribute="myFile">
					  <div class="form-group">
					    <label >Tên sản phẩm :</label>
					    <input type="text" class="form-control" name="tensanpham" required >
					  </div>
					  <div class="form-group">
					    <label >Giá:</label>
					    <input type="text"" class="form-control" name="gia" required pattern="^([1-9][0-9]{3,10}|100000000)$">
					  </div>
					  <div class="form-group">
					    <label >Số lượng:</label>
					    <input type="text" class="form-control" name="soluong" required pattern="^([1-9][0-9]{0,10}|1000)$">
					  </div>
					  <div class="form-group">
					    <label >Mô tả:</label>
					    <input type="text" class="form-control" name="mota">
					  </div>
					  <div class="form-group">
					    <!--<label >Link ảnh:</label>
					    <input type="text" class="form-control" name="hinh" pattern="([/|\w|\s|-])*\.(?:jpg|gif|png)">-->
					    <!-- test-->
						    <label >Hình ảnh:</label>
						    <input type="file" class="form-control" name="multipartFile" accept="image/*" required/> 
					  </div>
					  <div class="form-group">
					    <label>Danh muc:</label>
						<select class="form-control" name="madanhmuc">
							<c:forEach items="${dsdm}" var="dsdm">
								<option value="${dsdm.maDanhMuc}"><c:out value="${dsdm.maDanhMuc} | ${dsdm.tenDanhMuc}"></c:out> </option>
							</c:forEach>
						</select>
					  </div>
					  <button type="submit" class="btn btn-primary" >Lưu</button>
				</form:form>
		        
      
		    </div>
		  </div>
   
        </div>
      </div>      
          
	
	 <!-- -------------------------------------------------------------------------------------------------------------------- Modal -->
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