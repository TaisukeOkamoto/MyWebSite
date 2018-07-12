<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="beans.UserInfoBeans" %>
<!DOCTYPE html>
<%@ include file="include/master_header.jsp"%>
          <div class="site_ttl"><h1><a href="Master"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
          <main role="main" class="container">
            <div class="sub_ttl">
              <h3>管理者ページ</h3>
            </div>
              <p class="text-danger text-center font-weight-bold">
              ${intItemPriceErr}
              </p>
            <form class="registration_form" action="MasterItemRegistration" method="post">
              <p>商品名を選択してください</p>
              <p class="mb-5"><input Name="itemName" type="text" class="form-control" placeholder="商品名"></p>
              <p>商品の説明を入力してください</p>
              <p class="mb-5"><textarea Name="itemDetail" class="form-control" placeholder="商品の説明"></textarea></p>
              <p>商品画像を選択してください</p>
              <div class="form-group mb-5">
                <input Name="fileName" type="file" class="form-control-file" id="File">
              </div>
              <p>商品の税込価格を入力してください</p>
              <div class="row">
                <p class="mb-5 col"><input Name="priceWithTax" type="text" class="form-control" placeholder="商品の税込価格"></p>
                <p class="col p-0">円</p>
              </div>
              <p>商品の割引率を選択してください</p>
              <div class="form-group mb-5">
	              <div class="row">
	              <div class="col">
	                <select Name="rate" class="form-control" id="exampleFormControlSelect1">
	                	<option value="0">0</option>
			            <option value="10">10</option>
			            <option value="20">20</option>
			            <option value="30">30</option>
			            <option value="40">40</option>
			            <option value="50">50</option>
	          		</select>
	          		</div>
	             	 <p class="col p-0">%</p>
	              </div>
              </div>
              <p>商品のカテゴリーを選択してください</p>
              <div class="form-group mb-5 ">
                <select Name="categoryId" class="form-control" id="exampleFormControlSelect1">
		            <option value="1">シャツ</option>
		            <option value="2">セーター</option>
		            <option value="3">ジャケット</option>
		            <option value="4">コート</option>
		            <option value="5">ジーンズ</option>
		            <option value="6">靴</option>
		            <option value="7">ネックレス</option>
		            <option value="8">時計</option>
		            <option value="9">ベルト</option>
          		</select>
              </div>
              <p>商品の税込割引後金額（自動入力）</p>
              <p class="mb-5">〇〇〇〇円</p>
              <div class="text-center">
                <button type="submit" class="btn btn-danger">上記の内容で商品を登録します</button>
              </div>
            </form>
          </main>
<%@ include file="include/footer.jsp"%>