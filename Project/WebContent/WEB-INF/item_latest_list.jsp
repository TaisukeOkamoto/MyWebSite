<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
              <h3>新商品一覧</h3></div>
            <div class="sale_item_list_area">
				<div class="row">
					<%--最新商品を30件まで表示--%>
					<c:forEach var="latestitem" items="${latestItemList}" varStatus="status" begin="0" end="29">
		                <div class="col-6 col-md-3 items mb-3">
		                  <a href="ItemDetail?itemid=${latestitem.id}"><img src="images/${latestitem.fileName}" alt="${latestitem.itemName}"></a>
		                  <p class="item_ttl">${latestitem.itemName}</p>
		                  <p class="price_before">
		                  <%--割引が0でない時のみ表示。価格は###,###形式でフォーマット--%>
		                  	<c:if test="${latestitem.rate != 0}">
			                    <span class="line_through"><fmt:formatNumber value="${latestitem.priceWithTax}" pattern="###,###" /><span class="tax">円（税込）</span></span>
			                    <span class="discount">${latestitem.rate}%OFF</span>
		                    </c:if>
		                  </p>
		                  <%--割引価格は切り捨て、価格は###,###形式でフォーマット --%>
		                  <p class="price_after"><fmt:formatNumber value="${Math.round(Math.floor(latestitem.priceWithTax*(1 - latestitem.rate/100)))}" pattern="###,###" />円<span class="tax">（税込）</span></p>
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