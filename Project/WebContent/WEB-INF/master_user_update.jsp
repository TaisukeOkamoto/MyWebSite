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
              <p class="text-danger text-center font-weight-bold">
              ${memberCheckErr}
              ${emptyInputErr}
              ${emptyBitrhDayErr}
              ${differentPasswordErr}
              ${differentMailErr}
              ${StringPhoneNumberErr}
              ${StringAddressNumberErr}
             ${OverlapMailErr}
              </p>
            <div class="sub_ttl">
              <h3>新規会員登録</h3></div>
            <form class="registration_form" action="MasterUserUpdate" method="post">
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">名前</label>
                <div class="col">
                  <input name="familyName" type="text" class="form-control" placeholder="姓" value="${user.familyName}" required>
                </div>
                <div class="col">
                  <input name="firstName" type="text" class="form-control" placeholder="名" value="${user.firstName}" required>
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">郵便番号</label>
                <div class="col">
                  <input name="address" type="text" class="form-control" value="${user.address}" maxlength="7" required>
                </div>
                <div class="col">
                  <button type="button" class="btn btn-primary rounded-0">郵便番号から住所を反映</button>
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">住所</label>
                <div class="col-sm-9 form-space">
                  <select name="prefecture" class="custom-select" value="${user.prefecture}" required>
		              <option value="">都道府県を選択</option>
		              <option value="北海道" <c:if test="${user.prefecture.equals('北海道')}">selected</c:if>>北海道</option>
		              <option value="青森県" <c:if test="${user.prefecture.equals('青森県')}">selected</c:if>>青森県</option>
		              <option value="岩手県" <c:if test="${user.prefecture.equals('岩手県')}">selected</c:if>>岩手県</option>
		              <option value="宮城県" <c:if test="${user.prefecture.equals('宮城県')}">selected</c:if>>宮城県</option>
		              <option value="秋田県" <c:if test="${user.prefecture.equals('秋田県')}">selected</c:if>>秋田県</option>
		              <option value="山形県" <c:if test="${user.prefecture.equals('山形県')}">selected</c:if>>山形県</option>
		              <option value="福島県" <c:if test="${user.prefecture.equals('福島県')}">selected</c:if>>福島県</option>
		              <option value="茨城県" <c:if test="${user.prefecture.equals('茨城県')}">selected</c:if>>茨城県</option>
		              <option value="栃木県" <c:if test="${user.prefecture.equals('栃木県')}">selected</c:if>>栃木県</option>
		              <option value="埼玉県" <c:if test="${user.prefecture.equals('埼玉県')}">selected</c:if>>埼玉県</option>
		              <option value="千葉県" <c:if test="${user.prefecture.equals('千葉県')}">selected</c:if>>千葉県</option>
		              <option value="東京都" <c:if test="${user.prefecture.equals('東京都')}">selected</c:if>>東京都</option>
		              <option value="神奈川県" <c:if test="${user.prefecture.equals('神奈川県')}">selected</c:if>>神奈川県</option>
		              <option value="新潟県" <c:if test="${user.prefecture.equals('新潟県')}">selected</c:if>>新潟県</option>
		              <option value="富山県" <c:if test="${user.prefecture.equals('富山県')}">selected</c:if>>富山県</option>
		              <option value="石川県" <c:if test="${user.prefecture.equals('石川県')}">selected</c:if>>石川県</option>
		              <option value="福井県" <c:if test="${user.prefecture.equals('福井県')}">selected</c:if>>福井県</option>
		              <option value="山梨県" <c:if test="${user.prefecture.equals('山梨県')}">selected</c:if>>山梨県</option>
		              <option value="長野県" <c:if test="${user.prefecture.equals('長野県')}">selected</c:if>>長野県</option>
		              <option value="岐阜県" <c:if test="${user.prefecture.equals('岐阜県')}">selected</c:if>>岐阜県</option>
		              <option value="静岡県" <c:if test="${user.prefecture.equals('静岡県')}">selected</c:if>>静岡県</option>
		              <option value="愛知県" <c:if test="${user.prefecture.equals('愛知県')}">selected</c:if>>愛知県</option>
		              <option value="三重県" <c:if test="${user.prefecture.equals('三重県')}">selected</c:if>>三重県</option>
		              <option value="滋賀県" <c:if test="${user.prefecture.equals('滋賀県')}">selected</c:if>>滋賀県</option>
		              <option value="京都府" <c:if test="${user.prefecture.equals('京都府')}">selected</c:if>>京都府</option>
		              <option value="大阪府" <c:if test="${user.prefecture.equals('大阪府')}">selected</c:if>>大阪府</option>
		              <option value="兵庫県" <c:if test="${user.prefecture.equals('兵庫県')}">selected</c:if>>兵庫県</option>
		              <option value="奈良県" <c:if test="${user.prefecture.equals('奈良県')}">selected</c:if>>奈良県</option>
		              <option value="鳥取県" <c:if test="${user.prefecture.equals('鳥取県')}">selected</c:if>>鳥取県</option>
		              <option value="島根県" <c:if test="${user.prefecture.equals('島根県')}">selected</c:if>>島根県</option>
		              <option value="岡山県" <c:if test="${user.prefecture.equals('岡山県')}">selected</c:if>>岡山県</option>
		              <option value="広島県" <c:if test="${user.prefecture.equals('広島県')}">selected</c:if>>広島県</option>
		              <option value="山口県" <c:if test="${user.prefecture.equals('山口県')}">selected</c:if>>山口県</option>
		              <option value="徳島県" <c:if test="${user.prefecture.equals('徳島県')}">selected</c:if>>徳島県</option>
		              <option value="香川県" <c:if test="${user.prefecture.equals('香川県')}">selected</c:if>>香川県</option>
		              <option value="愛媛県" <c:if test="${user.prefecture.equals('愛媛県')}">selected</c:if>>愛媛県</option>
		              <option value="高知県" <c:if test="${user.prefecture.equals('高知県')}">selected</c:if>>高知県</option>
		              <option value="福岡県" <c:if test="${user.prefecture.equals('福岡県')}">selected</c:if>>福岡県</option>
		              <option value="佐賀県" <c:if test="${user.prefecture.equals('佐賀県')}">selected</c:if>>佐賀県</option>
		              <option value="長崎県" <c:if test="${user.prefecture.equals('長崎県')}">selected</c:if>>長崎県</option>
		              <option value="熊本県" <c:if test="${user.prefecture.equals('熊本県')}">selected</c:if>>熊本県</option>
		              <option value="大分県" <c:if test="${user.prefecture.equals('大分県')}">selected</c:if>>大分県</option>
		              <option value="宮崎県" <c:if test="${user.prefecture.equals('宮崎県')}">selected</c:if>>宮崎県</option>
		              <option value="鹿児島県" <c:if test="${user.prefecture.equals('鹿児島県')}">selected</c:if>>鹿児島県</option>
		              <option value="沖縄県" <c:if test="${user.prefecture.equals('沖縄県')}">selected</c:if>>沖縄県</option>
            	</select>
                </div>
                <div class="col-sm-9 ml-auto form-space">
                  <input name="city" type="text" class="form-control" placeholder="市区町村" value="${user.city}" required>
                </div>
                <div class="col-sm-9 ml-auto form-space">
                  <input name="street" type="text" class="form-control" placeholder="町名番地" value="${user.street}" required>
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">電話番号</label>
                <div class="col">
                  <input name="phoneNumber" type="text" class="form-control" value="${user.phoneNumber}" maxlength="10" required>
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">生年月日</label>
               	  <%
               	  	UserInfoBeans user = (UserInfoBeans)session.getAttribute("user");
               	  %>
                <div class="form-group col-sm-3">
                  <select name="year" id="year" class="form-control" required>
		              <option value="">年</option>
		              <%-- 1900年から現在年までを取得 --%>
		              <%
		              Calendar calendar = Calendar.getInstance();
		              int calenderYear = calendar.get(Calendar.YEAR);
		              String strYear;
		              for(int i = 1900; i <= calenderYear; i++){
		            	  strYear = String.valueOf(i);
		              %>
		              	<%-- 再入力時は一度選択した値を保持しておく --%>
		            	<option <% if(user != null && user.getBirthYear().equals(strYear)) {%> selected<%}%> value="<%= i %>"><%= i %></option>
		              <%}%>
            	  </select>
                </div>
                <div class="form-group col-sm-3">
                  <select name="month" id="inputState" class="form-control" required>
		              <option value="">月</option>
		              <%-- 01〜12までを取得 --%>
		              <%
	              		String strMonth;
	              	  	for(int i = 1; i <= 12; i++){
	              		strMonth = String.valueOf(i);
		              %>
		              <% if(i < 10){%><%-- 再入力時は一度選択した値を保持しておく --%>
		              <option <% if(user != null && user.getBirthMonth().equals("0"+strMonth)){%>selected<%}%> value="0<%=i %>">0<%=i %></option>
		              <% }else{%><%-- 再入力時は一度選択した値を保持しておく --%>
		              <option <% if(user != null && user.getBirthMonth().equals(strMonth)){%>selected<%}%> value="<%=i %>"><%=i %></option>
		              <%}} %>
            	  </select>
                </div>
                <div class="form-group col-sm-3">
                  <select name="day" id="inputState" class="form-control" required>
              		  <option value="">日</option>
              		  <%-- 01〜31までを取得 --%>
		              <%
		             	String strDay;
		              	for(int i = 1; i <= 31; i++){
		              	strDay = String.valueOf(i);
		              %>
		              <% if(i < 10){%><%-- 再入力時は一度選択した値を保持しておく --%>
		              <option <% if(user != null && user.getBirthDay().equals("0"+strDay)){%>selected<%}%> value="0<%=i %>">0<%=i %></option>
		              <% }else{%><%-- 再入力時は一度選択した値を保持しておく --%>
		              <option <% if(user != null && user.getBirthDay().equals(strDay)){%>selected<%}%> value="<%=i %>"><%=i %></option>
		              <%}} %>
            	 </select>
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">性別</label>
                <div class="col">
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="Radio1" value="男" <c:if test="${user.gender.equals('男')}">checked</c:if> required>
                    <label class="form-check-label" for="Radio1">男</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="Radio2" value="女" <c:if test="${user.gender.equals('女')}">checked</c:if> required>
                    <label class="form-check-label" for="Radio2">女</label>
                  </div>
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">メールアドレス</label>
                <div class="col">
                  <input name="mail" type="mail" class="form-control" placeholder="メールアドレス" value="${user.mail}" required>
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">確認用メールアドレス</label>
                <div class="col">
                  <input name="mailConfirm" type="mail" class="form-control" placeholder="確認用メールアドレス" required>
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">パスワード</label>
                <div class="col">
                  <input name="password" type="password" class="form-control" placeholder="パスワード" required>
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">確認用パスワード</label>
                <div class="col">
                  <input name="passwordConfirm" type="password" class="form-control" placeholder="確認用パスワード" required>
                </div>
              </div>
              </div>
              <div class="text-center">
                <button type="submit" class="btn btn-primary">変更を保存</button>
              </div>
            </form>
          </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>