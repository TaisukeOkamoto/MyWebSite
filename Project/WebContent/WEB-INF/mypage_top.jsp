<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ include file="include/user_header.jsp"%>
          <div class="site_ttl"><h1><a href="Index"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
          <main role="main" class="container">
            <div class="sub_ttl">
              <h3>マイページ</h3></div>
     		<p class="text-center"><span class="alert-success <c:if test="${UserUpdateMsg != null}">p-2</c:if>">${UserUpdateMsg}</span></p>
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
              <div class="col text-left">マイページトップ</div>
              <div class="col">ようこそ&nbsp;${user.familyName}${user.firstName}様 ポイント残高：${user.userPoint}ポイント</div>
            </div>
          </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>