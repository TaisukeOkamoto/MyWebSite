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
          <p class="text-danger text-center font-weight-bold">${CartAlreadyMsg}${itemDeleteMsg}${CartSetyMsg}</p>
          <main role="main" class="container">
          <form id="purchaseForm" action="PurchaseComplete" method="post">
            <div class="sub_ttl">
              <h3>商品購入</h3></div>
            <div class="purchase_area">
              <div class="row">
                <div class="col text-center">商品画像</div>
                <div class="col text-center">商品名</div>
                <div class="col text-center">数量</div>
                <div class="col text-center">単価（税込）</div>
                <div class="col-2 text-center">配送方法</div>
              </div>
              <div class="row align-items-center">
                <div class="col text-center">
                <c:forEach var="item" items="${cart}" varStatus="status">
                  <div class="row align-items-center">
                    <div class="col text-center"><img src="images/${item.fileName}" alt="${item.itemName}"></div>
                    <div class="col text-left">${item.itemName}</div>
                    <div class="col text-center">${item.amount}</div>
                    <%--割引価格は切り捨て、価格は###,###形式でフォーマット --%>
                    <div class="col text-center"><fmt:formatNumber value="${Math.round(Math.floor(item.priceWithTax*(1 - item.rate/100)))}" pattern="###,###" />円</div>
                  </div>
                </c:forEach>
                </div>
                <div class="col-2 text-center">
                  <div class="form-group">
                    <select name="DeliveryMethodChange" class="form-control" id="DeliveryMethodChange">
		              <option <c:if test="${dmib.id == 1}">selected</c:if> value="1">通常配送</option>
		              <option <c:if test="${dmib.id == 2}">selected</c:if> value="2">日時指定配送</option>
		              <option <c:if test="${dmib.id == 3}">selected</c:if> value="3">お急ぎ便</option>
            		</select>
                  </div>
                </div>
              </div>
            </div>
            <div class="purchase_table">
              <table class="table table-bordered">
                <tr>
                  <th>小計</th>
                  <%--価格は###,###形式でフォーマット --%>
                  <td><fmt:formatNumber value="${bib.totalPrice}" pattern="###,###" />円</td>
                </tr>
                <tr>
                  <th>配送料</th>
                  <%--配送料データが無ければ（通常配送なら）0円、あれば配送料を取得 --%>
                  <td>${dmib.deliveryPrice == null?0:dmib.deliveryPrice}円</td>
                </tr>
                <tr>
                  <th>合計金額</th>
                  <%--価格は###,###形式でフォーマット --%>
                  <%--配送料データが無ければ（通常配送なら）0円 + 小計金額、あれば配送料+小計金額--%>
                  <td><fmt:formatNumber value="${dmib.deliveryPrice == null?0 + bib.totalPrice:dmib.deliveryPrice + bib.totalPrice}" pattern="###,###" />円</td>
                </tr>
              </table>
            </div>
            <div class="purchase_point_table">
              <table class="table table-bordered">
                <tr>
                  <th>ポイント利用</th>
                  <td>
                    <div class="form-check">
                      <div class="row">
                        <div class="col-6 text-right">
                          <input class="form-check-input" type="radio" name="exampleRadios" id="radio1" value="option1" checked>
                          <label class="form-check-label" for="radio1">
                  ポイントを利用しない
                </label>
                        </div>
                        <div class="col-6 text-left">
                          <input class="form-check-input" type="radio" name="exampleRadios" id="radio2" value="option1">
                          <label class="form-check-label" for="radio2">
                  ポイントを利用
                </label>
                        </div>
                      </div>
                      <div class="row">
                        <div class="text-center col"><input type="text" id="exampleInputPassword1">ポイントを利用</div>
                      </div>
                    </div>
                  </td>
                </tr>
              </table>
            </div>
            <div class="amount_price text-center">
              <%--価格は###,###形式でフォーマット --%>
              <%--配送料データが無ければ（通常配送なら）0円 + 小計金額、あれば配送料+小計金額--%>
              <p>お支払い金額：<fmt:formatNumber value="${dmib.deliveryPrice == null?0 + bib.totalPrice:dmib.deliveryPrice + bib.totalPrice}" pattern="###,###" />円</p>
            </div>
            <div class="text-center"><button type="submit" class="btn btn-danger buy_button">注文を確定する</button></div>
            </form>
          </main>
<%@ include file="include/footer.jsp"%>
	<%--配送方法を変更するとDeliveryMethodChangeへ遷移する --%>
	<script>
	$(function(){
	  $("#DeliveryMethodChange").change(function(){
		  document.getElementById('purchaseForm').action="DeliveryMethodChange";
		  $("#purchaseForm").submit();
	  });
	});
	</script>
  </body>
</html>