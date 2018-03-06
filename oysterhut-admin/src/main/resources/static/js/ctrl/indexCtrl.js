$(function () {
    $("#loginoutA").click(function () {
        $.get("/loginOut", {}, function (result) {
            if (result.status == 200) {
                location.href = "/login.html";
            } else {
                alert("result.message");
            }
        });
    });
});