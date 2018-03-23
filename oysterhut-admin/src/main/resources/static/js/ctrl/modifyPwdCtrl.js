function submitForm() {
    var pwd = $("#current_password").val();
    var newPwd = $("#new_password").val();
    var repNewPwd = $("#rep_new_password").val();
    if (!checkForm(pwd, newPwd, repNewPwd)) {
        return false;
    }
    $("#erro").hide();
    var param = {
        "oldPwd": pwd,
        "newPwd": newPwd
    };
    $.ajax(
        {
            url: "/user/modifyPwd",
            type: "POST",
            data: param,
            dataType: "json",
            beforeSend: function () {
                console.log("正在进行，请稍候");
            },
            success: function (result) {
                if (result.resultInfo.status == '000') {
                    alert(result.resultInfo.message);
                    location.reload();
                } else {
                    $("#erro").html(result.resultInfo.message).show();
                    //alert(result.resultInfo.message);
                }
            },
            error: function (result) {
                alert("请求失败，请稍后再试");
            }
        }
    );
    return false;
}

function checkForm(pwd, newPwd, repNewPwd) {
    if (!pwd) {
        $("#erro").html("请输入当前密码！");
        return false;
    }
    if (!newPwd) {
        $("#erro").html("请输入新的密码！");
        return false;
    }
    if (!repNewPwd) {
        $("#erro").html("请输入确认新的密码！");
        return false;
    }
    if (newPwd != repNewPwd) {
        $("#erro").html("确认新的密码与新的密码不一致！");
        return false;
    }
    return true;
}