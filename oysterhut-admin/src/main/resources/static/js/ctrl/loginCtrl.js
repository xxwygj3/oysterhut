$(function () {
    var random = Math.random();
    $("#vcodeImg").attr("src", '/getJpgCode?' + random);
    $("#changeImgA").click(function () {
        random = Math.random();
        $("#vcodeImg").attr("src", '/getJpgCode?' + random);
    });
});
function login() {
    var username = $("#username").val();
    var password = $("#password").val();
    var vcode = $("#vcode").val();
    // var rememberMe = $('#rememberMe').is(':checked');
    if (!username) {
        $("#erro").html("用户名不能为空！");
        return;
    }
    if (!password) {
        $("#erro").html("密码不能为空！");
        return;
    }
    if (!vcode) {
        $("#erro").html("验证码不能为空！");
        return;
    }
    $.post("/loginSystem", {
        "username": username,
        "password": password,
        "vcode": vcode,
        /*"rememberMe": rememberMe*/
    }, function (result) {
        if (result.resultInfo.status == '000') {
            location.href = "/index.html";
        } else {
            $("#erro").html(result.resultInfo.message);
        }
    });
}
var submitOrHidden = function(evt) {
    evt = window.event || evt;
    if (evt.keyCode == 13) {
        login();
    }
};
window.document.onkeydown = submitOrHidden;