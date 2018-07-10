<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<%@ include file="include/header.jsp"%>
          <div class="site_ttl"><h1><a href="Index"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
          <main role="main" class="container">
            <div class="sub_ttl">
              <h3>入力内容確認</h3></div>
            <div class="confirm_area">
              <div class="row">
                <div class="col text-left">名前</div>
                <div class="col">${user.familyName}${user.firstName}</div>
              </div>
              <div class="row">
                <div class="col text-left">郵便番号</div>
                <div class="col">${user.address}</div>
              </div>
              <div class="row">
                <div class="col text-left">住所</div>
                <div class="col">${user.prefecture}${user.city}${user.street}</div>
              </div>
              <div class="row">
                <div class="col text-left">電話番号</div>
                <div class="col">${user.phoneNumber}</div>
              </div>
              <div class="row">
                <div class="col text-left">生年月日</div>
                <div class="col">${user.birthYear}年${user.birthMonth}月${user.birthDay}日</div>
              </div>
              <div class="row">
                <div class="col text-left">性別</div>
                <div class="col">${user.gender}</div>
              </div>
              <div class="row">
                <div class="col text-left">メールアドレス</div>
                <div class="col">${user.mail}</div>
              </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-primary"><a href="Registration" style="color:#fff;text-decoration:none;">修正する</a></button>
                  <button type="submit" class="btn btn-primary"><a href="RegistrationDone" style="color:#fff;text-decoration:none;">送信</a></button>
                </div>
            </div>
          </main>
<%@ include file="include/footer.jsp"%>