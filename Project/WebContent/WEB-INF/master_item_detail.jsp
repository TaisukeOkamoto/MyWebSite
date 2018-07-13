<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%@ include file="include/master_header.jsp"%>
 <main role="main" class="container">
   <div class="site_ttl"><h1><a href="Master"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
   <div class="sub_ttl">
     <h3>管理者ページ</h3>
   </div>
   <div class="wrapping">
     <p class="font-weight-bold">商品名</p>
     <p class="mb-5">${item.itemName}</p>
     <p class="font-weight-bold">商品画像</p>
     <div class="mb-5"><div class="items"><img src="images/${item.fileName}" alt="${item.itemName}"></div></div>
     <p class="font-weight-bold">商品の税込価格</p>
       <p class="mb-5"><fmt:formatNumber value="${item.priceWithTax}" pattern="###,###" />円</p>
     <p class="font-weight-bold">商品の割引率</p>
       <p class="mb-5">${item.rate}%</p>
     <p class="font-weight-bold">商品のカテゴリー</p>
     <p class="mb-5">${item.categoryId}</p>
     <p class="font-weight-bold">商品の税込割引後金額</p>
     <p class="mb-5"><fmt:formatNumber value="${Math.round(Math.floor(item.priceWithTax*(1 - item.rate/100)))}" pattern="###,###" />円</p>
     <div class="text-center">
       <a href="Master"><button type="submit" class="btn btn-primary">管理者TOPへ戻る</button></a>
     </div>
   </div>
 </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>