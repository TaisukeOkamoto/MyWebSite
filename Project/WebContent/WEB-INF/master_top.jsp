<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="include/master_header.jsp"%>
 <main role="main" class="container">
  <div class="site_ttl"><h1><a href="Master"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
   <div class="sub_ttl">
     <h3>管理者ページ</h3></div>
     <p class="text-danger text-center font-weight-bold">
     ${itemDeleteCompleteMsg}
     ${itemRegistrationCompleteMsg}
     ${itemUpdateCompleteMsg}
     ${userDeleteCompleteMsg}
     </p>
   <div class="row">
     <div class="col-3">
       <ul>
         <li><a href="Master">管理者ページトップ</a></li>
         <li><a href="MasterAllItemList">全商品一覧</a></li>
         <li><a href="MasterItemRegistration">新規商品登録</a></li>
         <li><a href="MasterUserList">ユーザ一覧</a></li>
         <li><a href="Logout">ログアウト</a></li>
       </ul>
     </div>
     <div class="col text-left">管理者ページトップ</div>
     <div class="col">ようこそ管理者様</div>
   </div>
 </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>