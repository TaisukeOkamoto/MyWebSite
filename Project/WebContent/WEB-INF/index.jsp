<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:choose>
<%--管理者と一般ユーザーは表示させるヘッダーを変更する --%>
<c:when test="${userId != null && userId != 0}">
<%@ include file="include/user_header.jsp"%>
</c:when>
<c:otherwise>
<%@ include file="include/header.jsp"%>
</c:otherwise>
</c:choose>
<link href="css/slick-theme.css" rel="stylesheet">
<link href="css/slick-theme.css" rel="stylesheet">
<link href="css/slick.css" rel="stylesheet">
<div class="site_ttl inviewfadeIn"><h1><a href="Index"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
${LoginErrMsg}
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner inviewfadeIn">
      <div class="carousel-item active">
        <div class="main_img"><img src="images/main01.jpg" alt="メインイメージ"></div>
      </div>
      <div class="carousel-item">
        <div class="main_img"><img src="images/main02.jpg" alt="メインイメージ"></div>
      </div>
      <div class="carousel-item">
        <div class="main_img"><img src="images/main03.jpg" alt="メインイメージ"></div>
      </div>
    </div>
</div><!-- /.carousel -->
   <main role="main" class="container">
     <div class="content_ttl inviewfadeIn"><h2><span class="gothic">Sale Items</span><br>割引商品</h2></div>
     <div class="row">
     <c:forEach var="discountitem" items="${discountItemList}" varStatus="status" begin="0" end="3">
     <%--割引商品4件を表示 --%>
       <div class="col-md col-6 items pb-3 inviewfadeIn"><a href="ItemDetail?itemid=${discountitem.id}"><img src="images/${discountitem.fileName}" alt="${discountitem.itemName}"></a><br>
         <p class="item_ttl">${discountitem.itemName}</p>
         <p class="price_before">
         <%--価格は###,###形式でフォーマット --%>
           <span class="line_through"><fmt:formatNumber value="${discountitem.priceWithTax}" pattern="###,###" /><span class="tax">（税込）</span></span>
           <span class="discount">${discountitem.rate}%OFF</span>
         </p>
         <%--割引価格は切り捨て、価格は###,###形式でフォーマット --%>
         <p class="price_after"><fmt:formatNumber value="${Math.round(Math.floor(discountitem.priceWithTax*(1 - discountitem.rate/100)))}" pattern="###,###" />円<span class="tax">（税込）</span></p>
       </div>
      </c:forEach>
     </div>
     <div class="btn_type01 inviewfadeIn"><a href="sale_item_list.html"><button type="button" class="btn btn-primary">割引商品一覧</button></a></div>
     <!-- <div class="content_ttl"><h2><span class="gothic">News&nbsp;&&nbsp;Topics</span><br>新着情報</h2></div> -->
     <div class="content_ttl inviewfadeIn"><h2><span class="gothic">New Arrival</span><br>新商品</h2></div>
   </main>
   <div class=" inviewfadeIn">
     <ul class="multiple-item">
     <%--最新商品7件を表示 --%>
     <c:forEach var="item7" items="${LatestItem7List}" varStatus="status">
       <li><a href="ItemDetail?itemid=${item7.id}"><img src="images/${item7.fileName}" alt="${item7.itemName}"></a></li>
	</c:forEach>
     </ul>
   </div>
   <main role="main" class="container">
     <div class="btn_type01 inviewfadeIn"><a href="new_item_list.html"><button type="button" class="btn btn-primary">新商品一覧</button></a></div>
   </main>
<%@ include file="include/footer.jsp"%>
  <script>
  $(function() {
     // フェードイン
     $('.inviewfadeIn').on('inview', function(event, isInView, visiblePartX, visiblePartY) {
         if (isInView) {
             $(this).stop().addClass('fade_in');
         } else {
             $(this).stop().removeClass('fade_in');
         }
     });
  });
  </script>
    <script type="text/javascript">
    $(function() {
    	$('.multiple-item').slick({
    		infinite: true,
    		dots:true,
    		slidesToShow: 5,
    		slidesToScroll: 1,
        autoplay: true,
    		responsive: [{
    			breakpoint: 768,
    				settings: {
    					slidesToShow: 3,
    					slidesToScroll: 3,
              autoplay: true,
    			}
    		},{
    			breakpoint: 480,
    				settings: {
    					slidesToShow: 2,
    					slidesToScroll: 2,
              autoplay: true,
    				}
    			}
    		]
    	});
    });
    </script>
<script src="js/slick.min.js"></script>
<script src="js/jquery.inview.min.js"></script>