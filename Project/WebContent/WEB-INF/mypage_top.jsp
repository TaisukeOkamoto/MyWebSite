<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ include file="include/user_header.jsp"%>
          <div class="site_ttl"><h1><a href="Index"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
          <main role="main" class="container">
            <div class="sub_ttl">
              <h3>マイページ</h3></div>
            <div class="row">
              <div class="col-3">
                <ul>
                  <li><a href="Mypage">マイページトップ</a></li>
                  <li><a href="mypage_history.html">購入履歴</a></li>
                  <li><a href="mypage_update.html">登録情報変更</a></li>
                  <li><a href="mypage_like.html">お気に入り商品</a></li>
                  <li><a href="mypage_unsubscribe.html">退会手続き</a></li>
                  <li><a href="Logout">ログアウト</a></li>
                </ul>
              </div>
              <div class="col text-left">マイページトップ</div>
              <div class="col">ようこそ〇〇〇〇様 ポイント残高：〇〇〇ポイント</div>
            </div>
          </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>