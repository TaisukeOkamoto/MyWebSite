<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ include file="include/master_header.jsp"%>
		<div class="site_ttl"><h1><a href="Master"><img src="images/logo.svg" alt="fashion center ウニクロ"></a></h1></div>
          <main role="main" class="container">
            <div class="sub_ttl">
              <h3>ユーザ一覧</h3></div>
            <form class="" action="master_user_list.html" method="post">
              <div class="form-group row user_search_form mb-5">
                <label for="inputUserName" class="col-3 col-form-label text-right">名前</label>
                <div class="col-9 mb-3">
                  <input type="text" class="form-control" id="inputUserName" placeholder="名前">
                </div>
                <label for="inputUserMail" class="col-3 col-form-label text-right">メールアドレス</label>
                <div class="col-9 mb-3">
                  <input type="text" class="form-control" id="inputUserMail" placeholder="メールアドレス">
                </div>
                <label for="selectUserGender" class="col-3 col-form-label text-right">性別</label>
                <div class="col-9 mb-3">
                  <select class="custom-select">
              <option selected>選択してください</option>
              <option value="男">男</option>
              <option value="女">女</option>
            </select>
                </div>
                <label for="selectUserGender" class="col-3 col-form-label text-right">生年月日</label>
                <div class="col-9 mb-3">
                  <div class="form-group row">
                    <div class="form-group col">
                      <select id="selectYearFrom" class="form-control">
                      <option selected>年</option>
                      <option>1111</option>
                    </select>
                    </div>
                    <div class="form-group col">
                      <select id="selectMonthFrom" class="form-control">
                      <option selected>月</option>
                      <option>1111</option>
                    </select>
                    </div>
                    <div class="form-group col">
                      <select id="selectDateFrom" class="form-control">
                      <option selected>日</option>
                      <option>1111</option>
                    </select>
                    </div>
                  </div>
                  <p class="text-center"><span class="rotate180">~</span></p>
                  <div class="form-group row">
                    <div class="form-group col">
                      <select id="selectYearTo" class="form-control">
                      <option selected>年</option>
                      <option>1111</option>
                    </select>
                    </div>
                    <div class="form-group col">
                      <select id="selectMonthTo" class="form-control">
                      <option selected>月</option>
                      <option>1111</option>
                    </select>
                    </div>
                    <div class="form-group col">
                      <select id="selectDateTo" class="form-control">
                      <option selected>日</option>
                      <option>1111</option>
                    </select>
                    </div>
                  </div>
                </div>
                <div class="col text-center"><button type="submit" class="btn btn-primary">検索する</button></div>
              </div>
            </form>
            <div class="row mb-3">
              <div class="col text-center">番号</div>
              <div class="col text-center">名前</div>
              <div class="col-3 text-center">メールアドレス</div>
              <div class="col text-center">性別</div>
              <div class="col text-center">詳細</div>
              <div class="col text-center">更新</div>
              <div class="col text-center">削除</div>
            </div>

			<c:forEach var="user" items="${userList}" varStatus="loop">
            <div class="row mb-3">
              <div class="col text-center">${loop.count}</div>
              <div class="col text-center">${user.familyName}${user.firstName}</div>
              <div class="col-3">${user.mail}</div>
              <div class="col text-center">${user.gender}</div>
              <div class="col text-center"><a href="MasterUserDetail?id=${user.id}"><button type="button" class="btn btn-info">詳細</button></a></div>
              <div class="col text-center"><a href="MasterUserUpdate?id=${user.id}"><button type="button" class="btn btn-primary">更新</button></a></div>
              <div class="col text-center"><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete_user">削除</button></div>
            </div>
			</c:forEach>
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