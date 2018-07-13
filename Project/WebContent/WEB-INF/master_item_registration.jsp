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
            <form class="registration_form" action="MasterItemRegistration" method="post" required>
              <p>商品名を選択してください</p>
              <p class="mb-5"><input Name="itemName" type="text" value="${item.itemName}" class="form-control" placeholder="商品名" required></p>
              <p>商品の説明を入力してください</p>
              <p class="mb-5"><textarea Name="itemDetail" class="form-control" placeholder="商品の説明" required>${item.itemDetail}</textarea></p>
              <p>商品画像を選択してください</p>
              <div class="form-group mb-5">
                <input Name="fileName" type="file" class="form-control-file" id="File" required>
              </div>
              <p>商品の税込価格を入力してください</p>
              <div class="row">
                <p class="mb-5 col"><input Name="priceWithTax" type="text" value="${item.priceWithTax}" class="form-control" placeholder="商品の税込価格" required></p>
                <p class="col p-0">円</p>
              </div>
              <p>商品の割引率を選択してください</p>
              <div class="form-group mb-5">
	              <div class="row">
	              <div class="col">
	                <select Name="rate" class="form-control" id="exampleFormControlSelect1" required>
	                	<option value="0" <c:if test="${item.rate == 0}">selected</c:if>>0</option>
			            <option value="10" <c:if test="${item.rate == 10}">selected</c:if>>10</option>
			            <option value="20" <c:if test="${item.rate == 20}">selected</c:if>>20</option>
			            <option value="30" <c:if test="${item.rate == 30}">selected</c:if>>30</option>
			            <option value="40" <c:if test="${item.rate == 40}">selected</c:if>>40</option>
			            <option value="50" <c:if test="${item.rate == 50}">selected</c:if>>50</option>
	          		</select>
	          		</div>
	             	 <p class="col p-0">%</p>
	              </div>
              </div>
              <p>商品のカテゴリーを選択してください</p>
              <div class="form-group mb-5 ">
                <select Name="categoryId" class="form-control" id="exampleFormControlSelect1" required>
		            <option value="1" <c:if test="${item.categoryId == 1}">selected</c:if>>シャツ</option>
		            <option value="2" <c:if test="${item.categoryId == 2}">selected</c:if>>セーター</option>
		            <option value="3" <c:if test="${item.categoryId == 3}">selected</c:if>>ジャケット</option>
		            <option value="4" <c:if test="${item.categoryId == 4}">selected</c:if>>コート</option>
		            <option value="5" <c:if test="${item.categoryId == 5}">selected</c:if>>ジーンズ</option>
		            <option value="6" <c:if test="${item.categoryId == 6}">selected</c:if>>靴</option>
		            <option value="7" <c:if test="${item.categoryId == 7}">selected</c:if>>ネックレス</option>
		            <option value="8" <c:if test="${item.categoryId == 8}">selected</c:if>>時計</option>
		            <option value="9" <c:if test="${item.categoryId == 9}">selected</c:if>>ベルト</option>
          		</select>
              </div>
              <div class="text-center">
                <button type="submit" class="btn btn-danger">上記の内容で商品を登録します</button>
              </div>
            </form>
          </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>