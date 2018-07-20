<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<c:choose>
<%--管理者と一般ユーザーは表示させるヘッダーを変更する --%>
<c:when test="${userId != null && userId != 0}">
<%@ include file="include/user_header.jsp"%>
</c:when>
<c:otherwise>
<%@ include file="include/header.jsp"%>
</c:otherwise>
</c:choose>
 <div class="site_ttl"><h1><a href="Index"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
 <main role="main" class="container">
   <p class="text-center">商品購入が完了しました。<br>ご注文いただきありがとうございました。お届けまでしばらくお待ちください。<br>
     <span class="text-danger">※サンプルサイトの為、実際に商品は送られません</span>
   </p>
  </main>
<%@ include file="include/footer.jsp"%>
  </body>
</html>