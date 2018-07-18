<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <li><a href="mypage_top.html">マイページトップ</a></li>
                    <li><a href="MypageHistory">購入履歴</a></li>
                    <li><a href="MypageUserUpdate">登録情報変更</a></li>
                    <li><a href="MypageLike">お気に入り商品</a></li>
                    <li><a href="MypageUnsubscribe">退会手続き</a></li>
                    <li><a href="index.html">ログアウト</a></li>
                  </ul>
                </div>
                <div class="col-9">
                  <div class="row">
                    <div class="col text-left">退会手続き</div>
                    <div class="col">ようこそ&nbsp;${user.familyName}${user.firstName}様 ポイント残高：${user.userPoint}ポイント</div>
                  </div>
                  <div class="row">
                    <div class="col">以下の確認事項に同意の上、問題なければ退会ボタンを押してください。</div>
                  </div>
                  <div class="row">
                    <form class="col" action="MypageUnsubscribe" method="post">
                      <div class="form-check">
                        <input name="unsubscribeCheck1" class="form-check-input" type="checkbox" value="" id="unsubscribeCheckId1" required>
                        <label class="form-check-label" for="unsubscribeCheckId1">
                    保有ポイントは全て削除されます。
                  </label>
                      </div>
                      <div class="form-check">
                        <input name="unsubscribeCheck1" class="form-check-input" type="checkbox" value="" id="unsubscribeCheckId2" required>
                        <label class="form-check-label" for="unsubscribeCheckId2">
                    退会後は登録内容は全て破棄されます。
                  </label>
                      </div>
                      <div class="form-check">
                        <input name="unsubscribeCheck3" class="form-check-input" type="checkbox" value="" id="unsubscribeCheckId3" required>
                        <label class="form-check-label" for="unsubscribeCheckId3">
                    以上2点を確認しましたか。
                  </label>
                      </div>
                      <button type="submit" class="btn btn-primary">送信する</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>