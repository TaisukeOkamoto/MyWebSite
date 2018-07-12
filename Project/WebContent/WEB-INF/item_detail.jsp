<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="beans.UserInfoBeans" %>
<!DOCTYPE html>
<%@ include file="include/header.jsp"%>
          <div class="site_ttl"><h1><a href="Index"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
          <main role="main" class="container">
            <div class="sub_ttl">
              <h3>${item.itemName}</h3></div>
            <p><a href="">Home</a>&nbsp;&gt;&nbsp;<a href="">メンズ</a>&nbsp;&gt;&nbsp;<a href="">シャツ</a>&nbsp;&gt;&nbsp;<a href="">半袖</a></p>
            <div class="row">
              <div class="col-sm-6">
                <div class="row">
                  <div class="item_detail_img"><img src="images/${item.fileName}" alt="${item.itemName}"></div>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="display:table;">
                  <p>${item.itemDetail}</p>
                  <p class="price_before">
                  <%--割引が0でない時のみ表示。価格は###,###形式でフォーマット--%>
                  	<c:if test="${item.rate} != 0">
	                    <span class="line_through"><fmt:formatNumber value="${item.priceWithTax}" pattern="###,###" /><span class="tax">（税込）</span></span>
	                    <span class="discount">${item.rate}%OFF</span>
                    </c:if>
                  </p>
                  <%--割引価格は切り捨て、価格は###,###形式でフォーマット --%>
                  <p class="price_after price_large"><fmt:formatNumber value="${Math.round(Math.floor(item.priceWithTax*(1 - item.rate/100)))}" pattern="###,###" />円<span class="tax">（税込）</span></p>
                  <%--ポイントは割引価格を100で割り切り捨て --%>
                  <p>獲得ポイント：${Math.round(Math.floor((item.priceWithTax*(1 - item.rate/100))/100))}ポイント</p>
                  <div class="cart_in">
                    <a href="cart.html"><button type="button" class="btn btn-danger">カートに入れる&nbsp;<i class="fas fa-cart-arrow-down"></i></button></a>
                  </div>
                  <div class="like_plus">
                    <a href="mypage_like.html"><button type="button" class="btn btn-primary">お気に入りに追加する&nbsp;<i class="fas fa-star"></i></button></a>
                  </div>
                </div>
              </div>
            </div>
          </main>
<%@ include file="include/footer.jsp"%>