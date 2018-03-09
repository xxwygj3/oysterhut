$(function () {
    $("#checkForm").click(function () {
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
        $.post("/loginIn", {
            "username": username,
            "password": password,
            "vcode": vcode,
            /*"rememberMe": rememberMe*/
        }, function (result) {
            if (result.status == 200) {
                location.href = "/index.html";
            } else {
                $("#erro").html(result.message);
            }
        });
    });
    var random = Math.random();
    $("#vcodeImg").attr("src", '/getJpgCode?' + random);
    $("#changeImgA").click(function () {
        random = Math.random();
        $("#vcodeImg").attr("src", '/getJpgCode?' + random);
    });
});