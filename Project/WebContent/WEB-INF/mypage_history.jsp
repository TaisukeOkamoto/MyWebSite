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
                    <div class="col-3 text-left">購入履歴</div>
                    <div class="col-9 text-right">ようこそ&nbsp;${user.familyName}${user.firstName}様 ポイント残高：${user.userPoint}ポイント</div>
                  </div>
                  <div class="row">
                    <div class="col-2 text-center"></div>
                    <div class="col-4 text-center font-weight-bold">購入日時</div>
                    <div class="col-3 text-center font-weight-bold">配送方法</div>
                    <div class="col-3 text-center font-weight-bold">購入金額</div>
                  </div>
                  <div class="row align-items-center">
                    <c:forEach var="bib" items="${bibList}" varStatus="status">
                    <div class="col-2 text-left mb-3"><a href="MypageHistoryDetail?buyId=${bib.id}"><button type="button" class="btn btn-primary">詳細</button></a></div>
                    <div class="col-4 text-center mb-3"><fmt:formatDate value="${bib.buyDate}" pattern="yyyy年MM月dd日 HH:mm:ss" /></div>
                    <div class="col-3 text-center mb-3">${bib.deliveryName}</div>
                    <div class="col-3 text-center mb-3"><fmt:formatNumber value="${bib.totalPrice+bib.deliveryPrice}" pattern="###,###" />円</div>
                    </c:forEach>
                  </div>
                </div>
              </div>
            </div>
          </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>