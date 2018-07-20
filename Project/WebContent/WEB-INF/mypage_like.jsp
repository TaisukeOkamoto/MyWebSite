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
              <p class="text-center alert"><span class="alert-danger <c:if test="${LikeAlreadyMsg != null || LikeDeleteMsg != null}">p-2</c:if>">${LikeAlreadyMsg}${LikeDeleteMsg}</span></p>
              <p class="text-center alert"><span class="alert-success <c:if test="${LikeSetMsg != null}">p-2</c:if>">${LikeSetMsg}</span></p>
            <div class="mypage_like_area">
              <div class="row">
                <div class="col-3">
                  <ul>
                  <li><a href="Mypage">マイページトップ</a></li>
                  <li><a href="MypageHistory">購入履歴</a></li>
                  <li><a href="MypageUserUpdate">登録情報変更</a></li>
                  <li><a href="MypageLike">お気に入り商品</a></li>
                  <li><a href="MypageUnsubscribe">退会手続き</a></li>
                  <li><a href="Logout">ログアウト</a></li>
                  </ul>
                </div>
                <div class="col-9">
                  <div class="row">
                    <div class="col text-left">お気に入り商品</div>
                    <div class="col">ようこそ&nbsp;${user.familyName}${user.firstName}様 ポイント残高：${user.userPoint}ポイント</div>
                  </div>
                  <div class="row">
                  <c:forEach var="likeItem" items="${likeItems}" varStatus="status">
                    <div class="col-4 items mb-5"><a href="ItemDetail?itemid=${likeItem.id}"><img src="images/${likeItem.fileName}" alt="${likeItem.itemName}"></a><br>
                      <p class="item_ttl">${likeItem.itemName}</p>
		                  <p class="price_before">
		                  <%--割引が0でない時のみ表示。価格は###,###形式でフォーマット--%>
		                  	<c:if test="${likeItem.rate != 0}">
			                    <span class="line_through"><fmt:formatNumber value="${likeItem.priceWithTax}" pattern="###,###" /><span class="tax">円（税込）</span></span>
			                    <span class="discount">${likeItem.rate}%OFF</span>
		                    </c:if>
		                  </p>
			          <%--割引価格は切り捨て、価格は###,###形式でフォーマット --%>
                      <p class="price_after mb-3"><fmt:formatNumber value="${Math.round(Math.floor(likeItem.priceWithTax*(1 - likeItem.rate/100)))}" pattern="###,###" />円<span class="tax">（税込）</span></p>
                      <button id="${likeItem.id}" type="button" class="btn btn-danger passDeleteClass" data-toggle="modal" data-target="#delete_item">削除</button>
                    </div>
                    </c:forEach>
                  </div>
                  </div>
                </div>
              </div>
            </div>
          </main>
<%@ include file="include/footer.jsp"%>
    <%-- 商品削除モーダル --%>
    <div class="modal fade" id="delete_item" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title text-center" id="delete_itemLabel">商品を削除しますか</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="閉じる">
        <span aria-hidden="true">&times;</span>
      </button>
          </div>
          <div class="modal-body">
            <div class="text-center passDeleteClass" id="deleteButton"><a class="btn btn-danger" href="" role="button">削除</a></div>
          </div>
        </div>
      </div>
  	</div>
  	<%-- 削除ボタンのIDを取得、モーダル内のhrefを商品IDを含めた形式に書き換え --%>
  	<script>
  	$('.passDeleteClass').on('click', function() {
		var id =  $(this).attr("id");
		var url = "MypageLikeDelete?itemid="+id;
		$("#deleteButton a").attr("href", url)
  	});
  	</script>
  </body>
</html>