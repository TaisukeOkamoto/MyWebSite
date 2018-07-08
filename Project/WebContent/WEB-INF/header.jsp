<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Fashion Center ウニクロ</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="css/bootstrap_edit.css" rel="stylesheet">
    <link href="css/pure-drawer.css" rel="stylesheet">
    <link href="css/pure-drawer_edit.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous" rel="stylesheet" >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="js/footerFixed.js" type="text/javascript"></script>
</head>
  <body>
    <div class="pure-container" data-effect="pure-effect-slide">
      <input type="checkbox" id="pure-toggle-left" class="pure-toggle" data-toggle="left"/>
      <label class="pure-toggle-label" for="pure-toggle-left" data-toggle-label="left"><span class="pure-toggle-icon"></span></label>
      <nav class="pure-drawer" data-position="left">
        <div class="menu_wrap">
          <div class="list-group list-group-flush">
            <a href="" class="list-group-item text-dark">All</a>
            <div class="list-group-item gothic pointer">Men</div>
            <ul class="list-group none p-3">
              <li><a href="" class="text-site">商品一覧</a></li>
              <li class="category-3 pointer">インナー</li>
              <ul class="none">
                <li><a href="" class="text-site">商品一覧</a></li>
                <li><a href="" class="text-site">シャツ</a></li>
              </ul>
              <li class="category-3 pointer">アウター</li>
              <ul class="none">
                <li><a href="" class="text-site">商品一覧</a></li>
                <li><a href="" class="text-site">ジャケット</a></li>
                <li><a href="" class="text-site">コート</a></li>
              </ul>
              <li class="category-3 pointer">ボトムス・靴</li>
              <ul class="none">
                <li><a href="" class="text-site">商品一覧</a></li>
                <li><a href="" class="text-site">ジーンズ</a></li>
                <li><a href="" class="text-site">靴</a></li>
              </ul>
              <li class="category-3 pointer">アクセリー</li>
              <ul class="none">
                <li><a href="" class="text-site">商品一覧</a></li>
                <li><a href="" class="text-site">ネックレス</a></li>
                <li><a href="" class="text-site">時計</a></li>
                <li><a href="" class="text-site">ベルト</a></li>
              </ul>
            </ul>
            <div class="list-group-item gothic pointer">Women</div>
            <ul class="list-group none p-3">
              <li><a href="" class="text-site">商品一覧</a></li>
              <li class="category-3 pointer">インナー</li>
              <ul class="none">
                <li><a href="" class="text-site">商品一覧</a></li>
                <li><a href="" class="text-site">シャツ</a></li>
              </ul>
              <li class="category-3 pointer">アウター</li>
              <ul class="none">
                <li><a href="" class="text-site">商品一覧</a></li>
                <li><a href="" class="text-site">ジャケット</a></li>
                <li><a href="" class="text-site">コート</a></li>
              </ul>
              <li class="category-3 pointer">ボトムス・靴</li>
              <ul class="none">
                <li><a href="" class="text-site">商品一覧</a></li>
                <li><a href="" class="text-site">靴</a></li>
                <li><a href="" class="text-site">ジーンズ</a></li>
              </ul>
              <li class="category-3 pointer">アクセリー</li>
              <ul class="none">
                <li><a href="" class="text-site">商品一覧</a></li>
                <li><a href="" class="text-site">ネックレス</a></li>
                <li><a href="" class="text-site">時計</a></li>
                <li><a href="" class="text-site">ベルト</a></li>
              </ul>
            </ul>
            <div class="list-group-item gothic pointer">Kids</div>
            <ul class="list-group none p-3">
              <li><a href="" class="text-site">商品一覧</a></li>
              <li class="category-3 pointer">インナー</li>
              <ul class="none">
                <li><a href="" class="text-site">商品一覧</a></li>
                <li><a href="" class="text-site">シャツ</a></li>
              </ul>
              <li class="category-3 pointer">アウター</li>
              <ul class="none">
                <li><a href="" class="text-site">商品一覧</a></li>
                <li><a href="" class="text-site">ジャケット</a></li>
                <li><a href="" class="text-site">コート</a></li>
              </ul>
              <li class="category-3 pointer">ボトムス・靴</li>
              <ul class="none">
                <li><a href="" class="text-site">商品一覧</a></li>
                <li><a href="" class="text-site">靴</a></li>
                <li><a href="" class="text-site">ジーンズ</a></li>
              </ul>
              <li class="category-3 pointer">アクセリー</li>
              <ul class="none">
                <li><a href="" class="text-site">商品一覧</a></li>
                <li><a href="" class="text-site">ネックレス</a></li>
                <li><a href="" class="text-site">時計</a></li>
                <li><a href="" class="text-site">ベルト</a></li>
              </ul>
            </ul>
            <form class="form-inline list-group-item" action="item_search_result.html">
              <input class="form-control col-10" type="text" placeholder="キーワード検索" aria-label="Search">
              <button class="btn bg-site col-2 keysearch" type="submit"><i class="fas fa-search"></i></button>
            </form>
          </div>
        </div>
      </nav>
    <div class="pure-pusher-container">
      <div class="pure-pusher">
        <div class="inner">
          <header class="bg-site">
            <div class="container pt-3 pb-3">
              <ul class="nav justify-content-end font-weight-bold">
                <li>
                  <a class="nav-link active text-white" href="Registration">新規登録</a>
                </li>
                <li>
                  <a class="nav-link active gothic text-white" href="" data-toggle="modal" data-target="#myModal">ログイン</a>
                </li>
                <li>
                  <a class="nav-link active gothic cart text-white" href="cart.html"><i class="fas fa-cart-arrow-down"></i></a>
                </li>
              </ul>
            </div>
          </header>