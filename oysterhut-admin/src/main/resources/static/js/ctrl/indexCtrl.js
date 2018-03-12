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
function previewFile(obj) {
    var preview = $("#news_img_url_preview");
    var file = obj.files[0];
    var reader  = new FileReader();
    reader.onload = function (e) {
        var img = $("<img />");
        img.attr("src", e.target.result);
        preview.src(img);
    }
    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.src = "";
    }
}