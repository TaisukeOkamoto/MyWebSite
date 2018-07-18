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
              <p class="text-danger text-center font-weight-bold">${LikeSetMsg}${LikeAlreadyMsg}</p>
            <div class="mypage_like_area">
              <div class="row">
                <div class="col-3">
                  <ul>
                    <li><a href="mypage_top.html">マイページトップ</a></li>
                    <li><a href="mypage_history.html">購入履歴</a></li>
                    <li><a href="mypage_update.html">登録情報変更</a></li>
                    <li><a href="MypageLike">お気に入り商品</a></li>
                    <li><a href="mypage_unsubscribe.html">退会手続き</a></li>
                    <li><a href="index.html">ログアウト</a></li>
                  </ul>
                </div>
                <div class="col-9">
                  <div class="row">
                    <div class="col text-left">お気に入り商品</div>
                    <div class="col">ようこそ&nbsp;${user.familyName}${user.firstName}様 ポイント残高：${user.userPoint}ポイント</div>
                  </div>
                  <div class="row">
                  <c:forEach var="likeItem" items="${likeItems}" varStatus="status">
                    <div class="col-4 items"><a href="item_detail.html"><img src="images/${likeItem.fileName}" alt="${likeItem.itemName}"></a><br>
                      <p class="item_ttl">${likeItem.itemName}</p>
			          <p class="price_before">
			          <%--価格は###,###形式でフォーマット --%>
			           <span class="line_through"><fmt:formatNumber value="${likeItem.priceWithTax}" pattern="###,###" /><span class="tax">（税込）</span></span>
			           <span class="discount">${likeItem.rate}%OFF</span>
			          </p>
			          <%--割引価格は切り捨て、価格は###,###形式でフォーマット --%>
                      <p class="price_after mb-3"><fmt:formatNumber value="${Math.round(Math.floor(likeItem.priceWithTax*(1 - likeItem.rate/100)))}" pattern="###,###" />円<span class="tax">（税込）</span></p>
                      <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete_item">削除</button>
                    </div>
                    </c:forEach>
                  </div>
                  </div>
                </div>
              </div>
            </div>
          </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>