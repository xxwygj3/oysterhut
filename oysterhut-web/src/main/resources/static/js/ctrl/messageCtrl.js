$(function () {
    /** jsrender converts * */
    $.views.converters("dateFormat", function(val) {
        if (val == '' || val == null || val == undefined) return "";
        var datetime = new Date();
        datetime.setTime(val);
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
        var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
        var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
        var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
        var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
        return year + "-" + month + "-" + date + "- " + hour + ":" + minute + ":" + second;
    });
    var random = Math.random();
    $("#vcodeImg").attr("src", '/getJpgCode?' + random);
    $("#changeImgA").click(function () {
        random = Math.random();
        $("#vcodeImg").attr("src", '/getJpgCode?' + random);
    });
    var current = 1;
    var size = 10;
    getCommentList(current,size);
});
//分布查询留言
function getCommentList(current,size) {
    var query = {
        "current":current,
        "size":size
    };
    $.ajax({
        url: "/comment/getCommentList",
        type: "GET",
        data: query,
        dataType: "json",
        beforeSend: function () {
            console.log("正在进行，请稍候");
        },
        success: function (result) {
            if (result.resultInfo.status == "000") {
                var countList = result.resultMap;
                var maxCount = countList.total;
                $("#comment_count").html(maxCount);
                if(!maxCount || maxCount == 0){
                    $('#hotCommitListContainer').hide();
                }else{
                    $("#hotCommitList").html($("#hotCommitListJs").render(result.resultMap.rows));
                    $("[name='change_current']").html("第"+current+"页，");
                    $("#hotCommitListContainer").pagination({
                        items: maxCount,//用来计算页数的项目总数。
                        currentPage:current,//选择的页面。
                        itemsOnPage: 10,//每个页面显示的项目数。
                        edges: 1,//当页面数量比较多的时候，在最后Prev后和Next前的页面数（如上图light-theme和compact-theme是2，dark-theme是3）。
                        prevText: '上一页',//“上一页”显示的文字。
                        nextText: '下一页',//“下一页”显示的文字。
                        cssStyle: 'compact-theme',
                        onPageClick: function changePage(idx){
                            getCommentList(idx,10);
                        }
                    });
                }
            } else {
                alert(result.resultInfo.message);
            }
        },
        error: function (result) {
            alert("请求失败，请稍后再试");
        }
    });
}

//评论
function submitForm() {
    var nickName = $("#comment_nick_name").val();
    var email = $("#comment_email").val();
    var content = $("#comment_content").val();
    var vcode = $("#comment_vcode").val();
    if (!checkForm(content, vcode)) {
        return false;
    }
    $("#erro").hide();
    var param = {
        "topicId":"留言",
        "topicType":"1",
        "nickName": nickName,
        "email": email,
        "content":content,
        "vcode":vcode
    };
    $.ajax(
        {
            url: "/comment/createComment",
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
                }
            },
            error: function (result) {
                alert("请求失败，请稍后再试");
            }
        }
    );
    return false;
}

function checkForm(content, vcode) {
    if (!content) {
        $("#erro").html("请输入留言内容！");
        return false;
    }
    if (!vcode) {
        $("#erro").html("请输入验证码！");
        return false;
    }
    return true;
}