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
              <h3>「${param.keyword}」の検索結果</h3></div>
            <div class="sale_item_list_area">
				<div class="row"><%--全割引商品を表示--%>
					<c:forEach var="item" items="${KeywordSearchItemList}" varStatus="status">
		                <div class="col-6 col-md-3 items mb-3">
		                  <a href="ItemDetail?itemid=${item.id}"><img src="images/${item.fileName}" alt="${item.itemName}"></a>
		                  <p class="item_ttl">${item.itemName}</p>
		                  <p class="price_before">
		                  <%--価格は###,###形式でフォーマット --%>
		                    <span class="line_through"><fmt:formatNumber value="${item.priceWithTax}" pattern="###,###" />円<span class="tax">（税込）</span></span>
		                    <span class="discount">${item.rate}%OFF</span>
		                  </p>
		                  <%--割引価格は切り捨て、価格は###,###形式でフォーマット --%>
		                  <p class="price_after"><fmt:formatNumber value="${Math.round(Math.floor(item.priceWithTax*(1 - item.rate/100)))}" pattern="###,###" />円<span class="tax">（税込）</span></p>
		                </div>
	                </c:forEach>
                </div>
            </div>
          </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>