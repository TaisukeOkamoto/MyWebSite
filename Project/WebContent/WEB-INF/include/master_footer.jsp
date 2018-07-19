<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <footer id="footer">
            <div class="bg-site">
              <div class="footer_inner">
                <p class="copy">&copy;Fashion Center ウニクロ All Rights Reserved.</p>
              </div>
            </div>
          </footer>
      <%-- ユーザー削除モーダル --%>
    <div class="modal fade" id="delete_user" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title text-center" id="delete_userLabel">本当にユーザーを削除しますか</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="閉じる">
        <span aria-hidden="true">&times;</span>
      </button>
          </div>
          <div class="modal-body">
            <div class="text-center"><a class="btn btn-danger" href="MasterUserDelete?id=${user.id}" role="button">削除</a></div>
          </div>
        </div>
      </div>
    </div>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/footerFixed.js" type="text/javascript"></script>
  <script src="js/mysite.js"></script>