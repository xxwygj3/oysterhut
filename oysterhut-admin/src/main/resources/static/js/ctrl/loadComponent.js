$(function () {
    $("#headerComponent").load("/components/header.html");
    $("#leftComponent").load("/components/left.html");
});
function logout(){
    $.get("/logoutSystem", {}, function (result) {
        if (result.resultInfo.status == '000') {
            location.href = "/login.html";
        } else {
            console.info(result.resultInfo.message);
        }
    });
}
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