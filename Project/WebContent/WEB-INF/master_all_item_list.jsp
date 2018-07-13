<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%@ include file="include/master_header.jsp"%>
          <main role="main" class="container">
  			<div class="site_ttl"><h1><a href="Master"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
            <div class="sale_item_list_area">
				<div class="row">
					<%--全商品表示--%>
					<c:forEach var="item" items="${allItemList}" varStatus="status">
		                <div class="col-6 col-md-3 items mb-3">
		                  <a href="MasterItemDetail?itemId=${item.id}"><img src="images/${item.fileName}" alt="${item.itemName}"></a>
		                  <p class="item_ttl">${item.itemName}</p>
		                  <p class="price_before">
		                  <%--割引が0でない時のみ表示。価格は###,###形式でフォーマット--%>
		                  	<c:if test="${item.rate != 0}">
			                    <span class="line_through"><fmt:formatNumber value="${item.priceWithTax}" pattern="###,###" /><span class="tax">円（税込）</span></span>
			                    <span class="discount">${item.rate}%OFF</span>
		                    </c:if>
		                  </p>
		                  <%--割引価格は切り捨て、価格は###,###形式でフォーマット --%>
		                  <p class="price_after mb-2"><fmt:formatNumber value="${Math.round(Math.floor(item.priceWithTax*(1 - item.rate/100)))}" pattern="###,###" />円<span class="tax">（税込）</span></p>
		                  <a href="MasterItemUpdate?itemId=${item.id}"><button type="button" class="btn btn-primary">更新</button></a>&nbsp;
		                  <button id="${item.id}" type="button" class="btn btn-danger passDeleteClass" data-toggle="modal" data-target="#delete_item">削除</button>
		                </div>
	                </c:forEach>
                </div>
            </div>
            <nav aria-label="...">
              <ul class="pagination justify-content-center">
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="前">
                  <span aria-hidden="true">&laquo;</span>
                  <span class="sr-only">前</span>
                </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="次">
                  <span aria-hidden="true">&raquo;</span>
                  <span class="sr-only">次</span>
                </a>
                </li>
              </ul>
            </nav>
          </main>
<%@ include file="include/footer.jsp"%>
    <%-- 商品削除モーダル --%>
    <div class="modal fade" id="delete_item" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title text-center" id="delete_itemLabel">商品を削除しますか</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="閉じる">
        <span aria-hidden="true">&times;</span>
      </button>
          </div>
          <div class="modal-body">
            <div class="text-center" id="deleteButton"><a class="btn btn-danger" href="" role="button">削除</a></div>
          </div>
        </div>
      </div>
  	</div>
  	<script>
  	$('.passDeleteClass').on('click', function() {
		var id =  $(this).attr("id");
		var url = "MasterItemDelete?itemid="+id;
		$("#deleteButton a").attr("href", url)
  	});
  	</script>
  </body>
</html>
