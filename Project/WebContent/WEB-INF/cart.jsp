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
<p class="text-danger text-center font-weight-bold">${CartAlreadyMsg}${itemDeleteMsg}${CartSetMsg}${CartAmountChangeMsg}</p>
  <main role="main" class="container">
    <div class="sub_ttl">
      <h3>ショッピングカート</h3></div>
    <div class="cart_area">
      <div class="row">
        <div class="col text-center">商品画像</div>
        <div class="col text-center">商品名</div>
        <div class="col text-center">数量</div>
        <div class="col text-center">単価（税込）</div>
        <div class="col text-center">削除</div>
      </div>
      <form id="cartForm" action="" method="post">
	<c:forEach var="item" items="${cart}" varStatus="status">
        <div class="row">
          <div class="col text-center"><a href="ItemDetail?itemid=${item.id}"><img src="images/${item.fileName}" alt="${item.itemName}"></a></div>
          <div class="col text-center">${item.itemName}</div>
          <div class="col text-center">
            <select name="itemAmount" class="itemAmount form-control">
		       <option value="1" <c:if test="${item.amount == 1}">selected</c:if>>1</option>
		       <option value="2" <c:if test="${item.amount == 2}">selected</c:if>>2</option>
		       <option value="3" <c:if test="${item.amount == 3}">selected</c:if>>3</option>
		       <option value="4" <c:if test="${item.amount == 4}">selected</c:if>>4</option>
		       <option value="5" <c:if test="${item.amount == 5}">selected</c:if>>5</option>
   			</select>
          </div>
          <%--割引価格は切り捨て、価格は###,###形式でフォーマット --%>
          <div class="col text-center"><fmt:formatNumber value="${Math.round(Math.floor(item.priceWithTax*(1 - item.rate/100)))}" pattern="###,###" />円</div>
          <div class="col text-center"><input name="cartDelete" type="checkbox" value="${item.id}" class="check btn btn-primary"></div>
        </div>
       </c:forEach>
       <%--カートがあるときにだけ表示 --%>
   <c:if test="${cart != null && cart.size() != 0}">
     <div class="text-center">
     <button type="submit" id="${item.id}" onclick="goCartDelete()" class="deletebutton btn btn-primary mr-5" disabled>削除</button>
     <%--ログイン時は購入画面へ、ログインしていない時はログインモーダルを表示 --%>
     <c:if test="${userId != 0 && userId != null}"><button onclick="goPurchase()" type="submit" class="btn btn-danger">購入確認</button></div></c:if>
     <c:if test="${userId == 0 || userId == null}"><button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-danger">購入確認</button></div></c:if>
      </c:if>
      </form>
    </div>
  </main>
<%@ include file="include/footer.jsp"%>
	<%-- チェックボックスにチェックがない時は削除ボタンは無効化する。チェックがある時は有効化する --%>
	<script>
	$('.check').change(function() {
	    // チェックが入っていたら有効化
	    if ( $('.check').is(':checked') ){
	        // ボタンを有効化
	        $('.deletebutton').prop('disabled', false);
	    } else {
	        // ボタンを無効化
	        $('.deletebutton').prop('disabled', true);
	    }
	});
	</script>
	<%--「削除」ボタンと「購入確認」ボタンでformのactionの行き先を変更する --%>
	<script>
	    function goCartDelete(){
	        document.getElementById('cartForm').action="CartDelete";
	    }
	    function goPurchase(){
	        document.getElementById('cartForm').action="Purchase";
	    }
	</script>
	<%--商品個数を変更するとCartChangeAmountへ遷移する --%>
	<script>
	$(function(){
	  $(".itemAmount").change(function(){
		  document.getElementById('cartForm').action="CartChangeAmount";
		  $("#cartForm").submit();
	  });
	});
	</script>
  </body>
</html>