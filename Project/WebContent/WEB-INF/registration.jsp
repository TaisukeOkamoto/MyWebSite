<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp"%>
          <div class="site_ttl"><h1><a href="Index"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
          <main role="main" class="container">
            <div class="sub_ttl">
              <h3>新規会員登録</h3></div>
            <form class="registration_form" action="RegistrationConfirm" method="post">
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">名前</label>
                <div class="col">
                  <input type="text" class="form-control" placeholder="姓">
                </div>
                <div class="col">
                  <input type="text" class="form-control" placeholder="名">
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">郵便番号</label>
                <div class="col">
                  <input type="text" class="form-control">
                </div>
                <div class="col">
                  <button type="button" class="btn btn-primary rounded-0">郵便番号から住所を反映</button>
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">住所</label>
                <div class="col-sm-9 form-space">
                  <select class="custom-select" required>
              <option value="">都道府県を選択</option>
              <option value="1">１</option>
              <option value="2">２</option>
              <option value="3">３</option>
            </select>
                </div>
                <div class="col-sm-9 ml-auto form-space">
                  <input type="text" class="form-control" placeholder="市区町村">
                </div>
                <div class="col-sm-9 ml-auto form-space">
                  <input type="text" class="form-control" placeholder="町名番地">
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">電話番号</label>
                <div class="col">
                  <input type="text" class="form-control">
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">生年月日</label>
                <div class="form-group col-sm-3">
                  <select id="inputState" class="form-control">
              <option selected>年</option>
              <option>1111</option>
            </select>
                </div>
                <div class="form-group col-sm-3">
                  <select id="inputState" class="form-control">
              <option selected>月</option>
              <option>1111</option>
            </select>
                </div>
                <div class="form-group col-sm-3">
                  <select id="inputState" class="form-control">
              <option selected>日</option>
              <option>1111</option>
            </select>
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">性別</label>
                <div class="col">
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                    <label class="form-check-label">男</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                    <label class="form-check-label">女</label>
                  </div>
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">メールアドレス</label>
                <div class="col">
                  <input type="mail" class="form-control" placeholder="メールアドレス">
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">確認用メールアドレス</label>
                <div class="col">
                  <input type="mail" class="form-control" placeholder="確認用メールアドレス">
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">パスワード</label>
                <div class="col">
                  <input type="password" class="form-control" placeholder="パスワード">
                </div>
              </div>
              <div class="form-group row">
                <label for="lgFormGroupInput" class="col-sm-3 col-form-label col-form-label-lg">確認用パスワード</label>
                <div class="col">
                  <input type="password" class="form-control" placeholder="確認用パスワード">
                </div>
              </div>
              <div class="form-group form-check">
                <div class="text-center">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1">会員規約に同意しますか</label>
                  <p><a href="">会員規約（必ずお読みください）</a></p>
                </div>
              </div>
              <div class="text-center">
                <button type="submit" class="btn btn-primary">登録確認</button>
              </div>
            </form>
          </main>
<%@ include file="footer.jsp"%>