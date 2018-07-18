<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%@ include file="include/user_header.jsp"%>
          <div class="site_ttl"><h1><a href="Index"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
          <main role="main" class="container">
            <div class="sub_ttl">
              <h3>マイページ</h3></div>
            <div class="mypage_area">
                  <div class="row">
                    <div class="col text-center font-weight-bold">購入日時</div>
                    <div class="col text-center font-weight-bold">配送方法</div>
                    <div class="col text-center font-weight-bold">合計金額</div>
                  </div>
                  <div class="row align-items-center">
                    <div class="col text-center mb-3"><fmt:formatDate value="${bib.buyDate}" pattern="yyyy年MM月dd日 HH:mm:ss" /></div>
                    <div class="col text-center mb-3">${bib.deliveryName}</div>
                    <div class="col text-center mb-3"><fmt:formatNumber value="${bib.totalPrice+bib.deliveryPrice}" pattern="###,###" />円</div>
                  </div>
                  <div class="row">
                    <div class="col text-center font-weight-bold">商品名</div>
                    <div class="col text-center font-weight-bold">数量</div>
                    <div class="col text-center font-weight-bold">単価</div>
                  </div>
                  <c:forEach var="bdl" items="${buyDetailItemList}" varStatus="status">
                  <div class="row">
                    <div class="col text-center">${bdl.itemName}</div>
                    <div class="col text-center">${bdl.amount}</div>
                    <%--割引価格は切り捨て、価格は###,###形式でフォーマット --%>
                    <div class="col text-center"><fmt:formatNumber value="${Math.round(Math.floor(bdl.priceWithTax*(1 - bdl.rate/100)))}" pattern="###,###" /></div>
                  </div>
                  </c:forEach>
                  <div class="row">
                    <div class="col text-center">${bib.deliveryName}</div>
                    <div class="col text-center">1</div>
                    <%--割引価格は切り捨て、価格は###,###形式でフォーマット --%>
                    <div class="col text-center">${bib.deliveryPrice}円</div>
                  </div>
            </div>
          </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>