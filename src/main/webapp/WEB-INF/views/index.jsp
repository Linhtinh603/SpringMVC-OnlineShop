<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cửa hàng linh kiện điện tử - Trang Chủ</title>
<link href=<c:out value="resources/css/bootstrap.css"></c:out> rel="stylesheet">
<link href=<c:out value="http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100"></c:out> rel='stylesheet' type='text/css'>
<link href=<c:out value="resources/css/font-awesome.min.css"></c:out> rel="stylesheet">
<link rel="stylesheet" href=<c:out value="resources/css/flexslider.css"></c:out> type="text/css" media="screen" />
<link href=<c:out value="resources/css/sequence-looptheme.css"></c:out> rel="stylesheet" media="all" />
<link href=<c:out value="resources/css/style.css"></c:out> rel="stylesheet">
</head>
<body id="home">
	<div class="wrapper">
         <div class="header">
            <!-- header -->>
             <%@ include file="header.jsp" %>
         </div>
         <div class="clearfix"></div>
         <!-- Slider -->
         <%@ include file="slider.jsp" %>
         <div class="clearfix"></div>
		    
         <div class="container_fullwidth">
            <div class="container">
            	
            	<!-- Doan code hien thi san pham -->
            	<c:if test="${not empty tenDanhMuc }">
            	<h3 style="text-align:center; color:blue; ">Sản phẩm thuộc danh mục <c:out value="${tenDanhMuc}"></c:out></h3>
            	</c:if>
            	
            	<div class="row">
            	<c:forEach items="${dssp}" var="dssp">
            		<div class="col-md-3 col-sm-6">
                              <div class="products">
                              	
                                 <div class="thumbnail"><a href="ChiTietSanPham?id=<c:out value="${dssp.maSanPham}"/>"><img src="<c:out value="${dssp.hinh}"></c:out>" alt="Product Name"></a></div>
                                 <div class="productname"><c:out value="${dssp.tenSanPham}"></c:out></div>
                                 <h4 class="price"><c:out value="${dssp.gia}" /></h4>
                                 <div class="button_group">
	                                 	<a href="ThemGioHang?id=<c:out value="${dssp.maSanPham}"/>"> 
	                                 	<button class="button add-cart" type="button">Thêm vào giỏ
	                                 </button>
	                                 </a>
                                 </div>
                              </div>
                    </div>
                    </c:forEach>
            	</div>
            	
 
               <!-- footer -->
         </div>
         <div class="clearfix"></div>
         <%@ include file="fotter.jsp" %>
      </div>
      '<c:out value="" />'
      <!-- Bootstrap core JavaScript==================================================-->
	  <script type="text/javascript" src=<c:out value="resources/js/jquery-1.10.2.min.js" />></script>
	  <script type="text/javascript" src=<c:out value="resources/js/jquery.easing.1.3.js" />></script>
	  <script type="text/javascript" src=<c:out value="resources/js/bootstrap.min.js" />></script>
	  <script type="text/javascript" src=<c:out value="resources/js/jquery.sequence-min.js" />></script>
	  <script type="text/javascript" src=<c:out value="resources/js/jquery.carouFredSel-6.2.1-packed.js" />></script>
	  <script defer src=<c:out value="resources/js/jquery.flexslider.js" />></script>
	  <script type="text/javascript" src=<c:out value="resources/js/script.min.js" />></script>
</body>
</html>