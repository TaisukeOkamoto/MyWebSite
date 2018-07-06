//ナビスライドトグル
$(function(){
  $('.menu_wrap .list-group-item').click(function(){
    $(this).next().slideToggle('fast');
  });
});
$(function(){
$('.menu_wrap .category-3').click(function(){
  $(this).next().slideToggle('fast');
});
});
//画面遷移エフェクト
