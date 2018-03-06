$(function () {
    $("#ajaxLogin").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        var vcode = $("#vcode").val();
        var rememberMe = $('#rememberMe').is(':checked');
        $.post("/loginIn", {
            "username": username,
            "password": password,
            "vcode": vcode,
            "rememberMe": rememberMe
        }, function (result) {
            if (result.status == 200) {
                location.href = "/index.html";
            } else {
                $("#erro").html(result.message);
            }
        });
    });
    $("#vcodeImg").attr("src", '/getJpgCode');
});