<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%@ include file="include/master_header.jsp"%>
		<div class="site_ttl"><h1><a href="Master"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
          <main role="main" class="container">
            <div class="sub_ttl">
              <h3>管理者ページ</h3></div>
            <div class="confirm_area">
              <div class="row">
                <div class="col-6 text-left">名前</div>
                <div class="col-6 mb-3">${user.familyName}${user.firstName}</div>
                <div class="col-6 text-left">郵便番号</div>
                <div class="col-6 mb-3">${user.address}</div>
                <div class="col-6 text-left">都道府県</div>
                <div class="col-6 mb-3">${user.prefecture}</div>
                <div class="col-6 text-left">市区町村</div>
                <div class="col-6 mb-3">${user.city}</div>
                <div class="col-6 text-left">町名番地</div>
                <div class="col-6 mb-3">${user.street}</div>
                <div class="col-6 text-left">電話番号</div>
                <div class="col-6 mb-3">${user.phoneNumber}</div>
                <div class="col-6 text-left">生年月日</div>
                <div class="col-6 mb-3"><fmt:formatDate value="${user.birthDate}" pattern="yyyy年MM月dd日" /></div>
                <div class="col-6 text-left">性別</div>
                <div class="col-6 mb-3">${user.gender}</div>
                <div class="col-6 text-left">メールアドレス</div>
                <div class="col-6">${user.mail}</div>
              </div>
              <div class="text-center">
                <a href="MasterUserList"><button type="submit" class="btn btn-primary">ユーザ一覧へ</button></a>
              </div>
            </div>
          </main>
<%@ include file="include/master_footer.jsp"%>
  </body>
</html>