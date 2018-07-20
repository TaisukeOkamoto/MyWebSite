<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="beans.UserInfoBeans" %>
<!DOCTYPE html>
<c:choose>
<%--管理者と一般ユーザーは表示させるヘッダーを変更する --%>
<c:when test="${userId != null && userId != 0}">
<%@ include file="include/user_header.jsp"%>
</c:when>
<c:otherwise>
<%@ include file="include/header.jsp"%>
</c:otherwise>
</c:choose>
          <div class="site_ttl"><h1><a href="Index"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
          <main role="main" class="container">
            <div class="sub_ttl">
              <h3>割引商品一覧</h3></div>
            <div class="sale_item_list_area">
				<div class="row"><%--全割引商品を表示--%>
					<c:forEach var="discountitem" items="${discountItemList}" varStatus="status" begin="0" end="7">
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
                  <c:if test="${pageNumber -1 > 0}"><%--前のページがあるのはpageNumberが2以上の時 --%>
                  <a class="page-link" href="ItemSaleList?pageNumber=${pageNumber - 1}" aria-label="前">
                  <span aria-hidden="true">&laquo;</span>
                  <span class="sr-only">前</span>
                  </a>
                  </c:if>
                </li>
                <c:if test="${pageNumber -1 > 0}"><%--前のページがあるのはpageNumberが2以上の時 --%>
                <li class="page-item"><a class="page-link" href="ItemSaleList?pageNumber=${pageNumber - 1}">${pageNumber -1}</a></li>
                </c:if>
                <%--現在のページ --%>
                <li class="page-item disabled"><a class="page-link" href="ItemSaleList?pageNumber=${pageNumber}">${pageNumber}</a></li>
                <%--次のページがあるのは取得した商品のリストが8件以上ある時 --%>
                <c:if test="${discountItemList.size() > 8}">
                <li class="page-item"><a class="page-link" href="ItemSaleList?pageNumber=${pageNumber + 1}">${pageNumber + 1}</a></li>
                </c:if>
                <li class="page-item"><%--次のページがあるのは取得した商品のリストが8件以上ある時 --%>
                  <c:if test="${discountItemList.size() > 8}">
                  <a class="page-link" href="ItemSaleList?pageNumber=${pageNumber + 1}" aria-label="次">
                  <span aria-hidden="true">&raquo;</span>
                  <span class="sr-only">次</span>
                  </a>
                  </c:if>
                </li>
              </ul>
            </nav>
          </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>