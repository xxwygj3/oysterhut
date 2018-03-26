$(function () {
    $("#headerComponent").load("/components/header.html");
    $("#footerComponent").load("/components/footer.html");
});
//等到整个window加载完成执行方法体
window.onload = function(){
    $("#headerComponent ul li.active").removeClass("active");
    var url = location.pathname;
    $("#headerComponent ul li a").each(function(){
        var href = $(this).attr("href");
        if(href == url){
            $(this).parent("li").addClass("active");
            return;
        }else if((url == "/worth.html"||url == "/worthDet.html") && href == "/muli.html"){
            $(this).parent("li").addClass("active");
            return;
        }
    });
}