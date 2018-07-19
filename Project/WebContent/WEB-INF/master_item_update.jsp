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
            <form class="registration_form" action="MasterItemUpdate" method="post">
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
              <p>商品のカテゴリーを選択してください</p><%--初期値はJSで制御します --%>
              <div class="form-group mb-5 ">
				<select class="form-control" name="userType" id="area1" required>
				    <option data-subgroup="male" value="1">メンズ</option>
				    <option data-subgroup="female" value="2">レディース</option>
				    <option data-subgroup="kids" value="3">キッズ</option>
				</select>
				<select class="form-control" name="lCategory" id="area2" required>
				    <option data-group="male" data-subgroup="maleInner" value="1">インナー</option>
				    <option data-group="male" data-subgroup="maleOuter" value="2">アウター</option>
				    <option data-group="male" data-subgroup="maleBottomsShoes" value="3">ボトムス・靴</option>
				    <option data-group="male" data-subgroup="maleAccessories" value="4">アクセサリー</option>
				    <option data-group="female" data-subgroup="femaleInner" value="1">インナー</option>
				    <option data-group="female" data-subgroup="femaleOuter" value="2">アウター</option>
				    <option data-group="female" data-subgroup="femaleBottomsShoes" value="3">ボトムス・靴</option>
				    <option data-group="female" data-subgroup="femaleAccessories" value="4">アクセサリー</option>
				    <option data-group="kids" data-subgroup="kidsInner" value="1">インナー</option>
				    <option data-group="kids" data-subgroup="kidsOuter" value="2">アウター</option>
				    <option data-group="kids" data-subgroup="kidsBottomsShoes" value="3">ボトムス・靴</option>
				    <option data-group="kids" data-subgroup="kidsAccessories" value="4">アクセサリー</option>
				</select>
				<select class="form-control" name="sCategory" id="area3" required>
				    <option data-group="maleInner" value="1">シャツ</option>
				    <option data-group="maleInner" value="2">セーター</option>
				    <option data-group="maleOuter" value="3">ジャケット</option>
				    <option data-group="maleOuter" value="4">コート</option>
				    <option data-group="maleBottomsShoes" value="5">ジーンズ</option>
				    <option data-group="maleBottomsShoes" value="6">靴</option>
				    <option data-group="maleAccessories" value="7">ネックレス</option>
				    <option data-group="maleAccessories" value="8">時計</option>
				    <option data-group="maleAccessories" value="9">ベルト</option>
				    <option data-group="femaleInner" value="1">シャツ</option>
				    <option data-group="femaleInner" value="2">セーター</option>
				    <option data-group="femaleOuter" value="3">ジャケット</option>
				    <option data-group="femaleOuter" value="4">コート</option>
				    <option data-group="femaleBottomsShoes" value="5">ジーンズ</option>
				    <option data-group="femaleBottomsShoes" value="6">靴</option>
				    <option data-group="femaleAccessories" value="7">ネックレス</option>
				    <option data-group="femaleAccessories" value="8">時計</option>
				    <option data-group="femaleAccessories" value="9">ベルト</option>
				    <option data-group="kidsInner" value="1">シャツ</option>
				    <option data-group="kidsInner" value="2">セーター</option>
				    <option data-group="kidsOuter" value="3">ジャケット</option>
				    <option data-group="kidsOuter" value="4">コート</option>
				    <option data-group="kidsBottomsShoes" value="5">ジーンズ</option>
				    <option data-group="kidsBottomsShoes" value="6">靴</option>
				    <option data-group="kidsAccessories" value="7">ネックレス</option>
				    <option data-group="kidsAccessories" value="8">時計</option>
				    <option data-group="kidsAccessories" value="9">ベルト</option>
				</select>
              </div>
              <div class="text-center">
                <button type="submit" class="btn btn-danger">上記の内容で商品を登録します</button>
              </div>
            </form>
          </main>
<%@ include file="include/master_footer.jsp"%>
  <script>
//地域セレクトボックスイベント設定
  setHierarchySelectEvent('#area1', '#area2');
  setHierarchySelectEvent('#area2', '#area3');
  $('#area1').val(<c:if test="${item.userType == 1}">1</c:if><c:if test="${item.userType == 2}">2</c:if><c:if test="${item.userType == 3}">3</c:if>).change();
  $('#area2').val(<c:if test="${item.lCategory == 1}">1</c:if><c:if test="${item.lCategory == 2}">2</c:if><c:if test="${item.lCategory == 3}">3</c:if><c:if test="${item.lCategory == 4}">4</c:if>).change();
  $('#area3').val(<c:if test="${item.sCategory == 1}">1</c:if><c:if test="${item.sCategory == 2}">2</c:if><c:if test="${item.sCategory == 3}">3</c:if><c:if test="${item.sCategory == 4}">4</c:if><c:if test="${item.sCategory == 5}">5</c:if><c:if test="${item.sCategory == 6}">6</c:if><c:if test="${item.sCategory == 7}">7</c:if><c:if test="${item.sCategory == 8}">8</c:if><c:if test="${item.sCategory == 9}">9</c:if>).change;
  /**
   * 階層のあるプルダウンのイベントを設定します.
   * 親のselectタグには属性data-subgroupが設定されている必要があります。
   * 子のselectタグには属性data-groupが設定されている必要があります。
   * @param parentSelect 親となるselectタグのセレクタ
   * @param childSelect 子となるselectタグのセレクタ
   */
  function setHierarchySelectEvent(parentSelect, childSelect){
      var initCategorySmallHtml = $(childSelect).html();
      $(parentSelect).change(function(){
          if( 1 < $(this).find('option:selected').length ){
              $(childSelect).find("option").each(function(index, element){
                  $(element).remove();
              });
          }else{
              var subgroup =  $(this).find('option:selected').attr('data-subgroup');
              $(childSelect).html(initCategorySmallHtml);
              $(childSelect).find("option").each(function(index, element){
                  var group = $(element).attr('data-group');
                  if( group ){
                      if( subgroup == group ){
                          //$(element).css('display', 'block');//IEではoptionタグに対してdisplayは効かないため
                      }else{
                          //$(element).css('display', 'none');//IEではoptionタグに対してdisplayは効かないため
                          $(element).remove();
                      }
                  }
              });
          }
          $(childSelect).val('').change();//未選択時の値は''じゃない場合は書き換えてね
      });
  }
  </script>
  </body>
</html>