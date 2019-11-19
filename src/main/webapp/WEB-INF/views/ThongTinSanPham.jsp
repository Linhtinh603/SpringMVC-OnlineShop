<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="resources/images/favicon.png">
    <title>
      Chi tiết sản phẩm
    </title>
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100' rel='stylesheet' type='text/css'>
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/flexslider.css" type="text/css" media="screen"/>
    <link href="resources/css/style.css" rel="stylesheet" type="text/css">
    <!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js">
</script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js">
</script>
<![endif]-->
  </head>
  <body>
    <div class="wrapper">
      <div class="header">
        	<%@ include file="header.jsp" %>
        <div class="clearfix">
        </div>
        <div class="page-index">
          
        </div>
      </div>
      <div class="clearfix">
      </div>
      <div class="container_fullwidth">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
  <!-- ==================================================================Thông tin sản phẩm =================================================================================== -->
  	<c:set value="${ttsp}" var="ttsp"></c:set>
              <div class="products-details">
                <div class="preview_image">
                  <div class="preview-small">
                  	
                    <img id="zoom_03" src="<c:out value="${ttsp.hinh}"></c:out>" data-zoom-image="images/products/Large/products-01.jpg" alt="">
                  </div>
                  
                </div>
                <div class="products-description">
                  <h5 class="name">
                    <c:out value="${ttsp.tenSanPham}"></c:out>
                  </h5>
                  <p>
                    Mô tả: 
                  </p>
                  <p>
                    <c:out value="${ttsp.moTa}"></c:out>
                  </p>
                  <hr class="border">
                  <div class="price">
                    Giá : 
                    <span class="new_price">
                      <c:out value="${ttsp.gia}"></c:out>
                      <sup>
                        VND
                      </sup>
                    </span>
                    <span class="old_price">
                      <c:out value="${ttsp.gia}"></c:out>
                      <sup>
                        VND
                      </sup>
                    </span>
                  </div>
                  <hr class="border">
                  <div class="wided">
                    
                    <div class="button_group">
                    	<a href="ThemGioHang?id=<c:out value="${ttsp.maSanPham}"/>">
                    		<button class="button" >
		                        Thêm vào giỏ hàng
		                      </button>
                    	</a>
                    </div>
                  </div>
                  
                </div>
              </div>
       <!-- ================================================================================================================================== -->     
              <div class="clearfix">
              </div>
              
              </div>
              <div class="clearfix">
              </div>
              <div id="productsDetails" class="hot-products">
                <h3 class="title">
                    Sản phẩm tương tự
                </h3>
                <div class="control">
                  <a id="prev_hot" class="prev" href="#">
                    &lt;
                  </a>
                  <a id="next_hot" class="next" href="#">
                    &gt;
                  </a>
                </div>
                <ul id="hot">
	                <c:forEach items="${dssp}" var="dssp">
	                  <li>
	                    <div class="row">
	                      <div class="col-md-4 col-sm-4">
	                        <div class="products">
	                          <div class="thumbnail">
	                            <a href="ThongTinSanPham?id=<c:out value="${dssp.maSanPham}"/>">
		                           <img src="<c:out value="${dssp.hinh}"></c:out>" alt="Product Name">
		                        </a>
	                          </div>
	                          <div class="productname">
	                            <c:out value="${dssp.tenSanPham}"></c:out>
	                          </div>
	                          <h4 class="price">
	                            <c:out value="${dssp.gia}" />
	                          </h4>
	                          <div class="button_group">
	                            <a href="ThemGioHang?id=<c:out value="${dssp.maSanPham}"/>">
	                                 <button class="button add-cart" type="button"> Thêm vào giỏ </button>
	                            </a>
	                          </div>
	                        </div>
	                      </div>
	                    </div>
	                  </li>
	                </c:forEach> 
                </ul>
              </div>
              <div class="clearfix">
              </div>
            </div>
            
          </div>
          <div class="clearfix">
          </div>
          
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
    <script type="text/javascript" src='resources/js/jquery.elevatezoom.js'>
    </script>
    <script type="text/javascript" src="resources/js/script.min.js" >
    </script>
  </body>
</html>