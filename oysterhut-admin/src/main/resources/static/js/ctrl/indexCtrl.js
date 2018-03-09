$(function () {
    $("#logoutA").click(function () {
        $.get("/logout", {}, function (result) {
            if (result.status == 200) {
                location.href = "/login.html";
            } else {
                $("#erro").html(result.message);
            }
        });
    });
});