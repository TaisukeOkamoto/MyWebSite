<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <footer id="footer">
            <div class="bg-site">
              <div class="footer_inner">
                <p class="text-center"><a href="master_top.html" class="text-white">管理者TOP</a></p>
                <p class="copy">&copy;Fashion Center ウニクロ All Rights Reserved.</p>
              </div>
            </div>
          </footer>
        </div>
      </div>
    </div>
    <label class="pure-overlay" for="pure-toggle-left" data-overlay="left"></label>
    <!-- ログインモーダル -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title text-center" id="exampleModalLabel">ログイン</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="閉じる">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
          <form action="Login" method="post">
            <ul class="login">
              <li><input type="text" name="mail" placeholder="ご登録メールアドレス"></li>
              <li><input type="password" name="password" placeholder="パスワード"></li>
            </ul>
            <div class="text-center"><button class="btn btn-primary" role="button">ログイン</button></div>
           </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/mysite.js"></script>
  </body>
</html>