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
            <div class="sale_item_list_area">
				<div class="row"><%--全割引商品を表示--%>
					<c:forEach var="discountitem" items="${discountItemList}" varStatus="status">
		                <div class="col-6 col-md-3 items mb-3">
		                  <a href="ItemDetail?itemid=${discountitem.id}"><img src="images/${discountitem.fileName}" alt="${discountitem.itemName}"></a>
		                  <p class="item_ttl">${discountitem.itemName}</p>
		                  <p class="price_before">
		                  <%--価格は###,###形式でフォーマット --%>
		                    <span class="line_through"><fmt:formatNumber value="${discountitem.priceWithTax}" pattern="###,###" />円<span class="tax">（税込）</span></span>
		                    <span class="discount">${discountitem.rate}%OFF</span>
		                  </p>
		                  <%--割引価格は切り捨て、価格は###,###形式でフォーマット --%>
		                  <p class="price_after"><fmt:formatNumber value="${Math.round(Math.floor(discountitem.priceWithTax*(1 - discountitem.rate/100)))}" pattern="###,###" />円<span class="tax">（税込）</span></p>
		                </div>
	                </c:forEach>
                </div>
            </div>
            <nav aria-label="...">
              <ul class="pagination justify-content-center">
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="前">
                  <span aria-hidden="true">&laquo;</span>
                  <span class="sr-only">前</span>
                </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="次">
                  <span aria-hidden="true">&raquo;</span>
                  <span class="sr-only">次</span>
                </a>
                </li>
              </ul>
            </nav>
          </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>