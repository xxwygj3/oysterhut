$(function () {
    $("#headerComponent").load("/components/header.html");
    $("#leftComponent").load("/components/left.html");
});
//等到整个window加载完成执行方法体
window.onload = function(){
    $("ul li.active").removeClass("active");
    var url = location.pathname;
    $("ul li a").each(function(){
        var href = $(this).attr("href");
        if(href == url){
            $(this).parent("li").addClass("active");
        }
    });
}