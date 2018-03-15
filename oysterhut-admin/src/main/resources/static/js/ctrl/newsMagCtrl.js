$(function () {
    loadNews();
    CKEDITOR.replace('news_content');
});

//分页加载新闻
function loadNews() {
    $.get("/news/all", {}, function (result) {
        if (result.status == 200) {
            var dataList = result.page;
            $("#renderTbody").html($("#newsList").render(dataList));
        } else {
            alert(result.message);
        }
    });
}

//上传图片显示缩略图
function previewImage(obj) {
    var imgFile = obj;
    var path;
    if (document.all) {//IE浏览器
        imgFile.select();
        path = document.selection.createRange().text;
        var previewImageDivObj = document.getElementById("preview_image_div");
        previewImageDivObj.innerHTML = "";
        previewImageDivObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\""
            + path + "\")";// 使用滤镜效果
        previewImageDivObj.style.display = "block";
    } else {
        path = URL.createObjectURL(imgFile.files[0]);
        $("#preview_image_div").html("");
        $("#preview_image_div").html("<img id='news_img_url_preview' alt='' src='" + path + "' style='width: 220px;height: 100px;'/>");
        $("#preview_image_div").show();
    }
}

//清空表单
function clearForm() {
    $("[type='text']").val("");
    $("[type='hidden']").val("");
    $("[type='file']").val("");
    $("#news_img_url_preview").attr("src", "");
    $("#preview_image_div").hide();
    $("[name='news_state']").removeAttr('checked');
    CKEDITOR.instances.news_content.setData("");
    //改变元素的boolean类型属性用prop才能生效
    //$("[name='news_state'][value='8']").prop("checked",true);
}

//提交表单
function submitForm() {
    alert("ok");
    var title = $("#news_title").val();
    var state = $("[name='news_state']:checked").val();
    var order = $("#news_display_order").val();
    var imgUrl = $("#preview_image_div").find("img").attr("src");
    var content = CKEDITOR.instances.news_content.getData();
    if (!checkForm(title, state, order, imgUrl, content)) {
        return false;
    }
    // js 获取文件对象
    var fileObj = document.getElementById("news_img_url").files[0];
    $.post("/news/add", {
        "title": title,
        "state": state,
        "order": order,
        "newsfile":fileObj,
        "content":content
    }, function (result) {
        if (result.status == 200) {
            alert(result.message);
        } else {
            alert(result.message);
        }
    });
}

//检查表单非空项
function checkForm(title, state, order, imgUrl, content) {
    var title = $("#news_title").val();
    if (!title) {
        alert("请输入标题！");
        return false;
    }
    if (state == undefined) {
        alert("请选择状态！");
        return false;
    }
    if (!order) {
        alert("请输入排序！");
        return false;
    }
    if (!imgUrl || imgUrl == undefined) {
        alert("请选择图片！");
        return false;
    }
    if (!content) {
        alert("请填写内容！");
        return false;
    }
    return true;
}