$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    //初始化日期控件
    $("#rotate_pic_expire_time").datetimepicker({
        language: 'zh-CN',//显示中文
        format: 'yyyy-mm-dd hh:ii:ss',//显示格式
        startDate: new Date(),
    });
});
var dataUrl = "/rotatePic/getRotatePicList";
var dataColumns = [
    {
        title: '轮换图编号',//表的列名
        field: 'id',//json数据中rows数组中的属性名
        align: 'center'//水平居中
    },
    {
        title: '轮换图名称',
        field: 'name',
        align: 'center'
    },
    {
        title: '轮换图缩略图',
        field: 'imgUrl',
        align: 'center',
        formatter: function (value, row, index) {
            return '<img src="' + row.imgUrl + '" style="width:200px;height: 50px;"/>';
        }
    },
    {
        title: '轮换图链接地址',
        field: 'linkUrl',
        align: 'center'
    },
    {
        title: '创建时间',
        field: 'createTime',
        align: 'center',
        formatter: function (value, row, index) {
            return formatDate(row.createTime);
        }
    },
    {
        title: '轮换图排序',
        field: 'displayOrder',
        align: 'center',
    },
    {
        title: '过期时间',
        field: 'expireTime',
        align: 'center',
        formatter: function (value, row, index) {
            return formatDate(row.expireTime);
        }
    },
    {
        title: '状态',
        field: 'state',
        align: 'center',
        formatter: function (value, row, index) {//自定义显示，这三个参数分别是：value该行的属性，row该行记录，index该行下标
            return row.state == 8 ? "显示" : "关闭";
        }

    },
    {
        title: '操作',
        field: 'id',
        align: 'center',
        formatter: function (value, row, index) {
            return '<button class="btn btn-primary btn-lg" data-toggle="modal" data-zdy="' + row.id + '" id="modalid' + row.id + '" onclick="showModel(1,' + index + ');">编辑</button> ';
        }
    }
]

//查询参数
function dataQueryParams(params) {
    return {
        _size: params.limit,  //页面大小
        _index: params.offset, //页码
    };
}

//日期格式化
function formatDate(time) {
    if (time == '' || time == null || time == undefined) return '';
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "年" + month + "月" + date + "日 " + hour + ":" + minute + ":" + second;
}

//全局
var list = undefined;
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#table_server').bootstrapTable({
            method: 'get',
            url: dataUrl,
            dataType: "json",
            striped: true,     //使表格带有条纹
            pagination: true,    //在表格底部显示分页工具栏
            pageSize: 10,
            pageNumber: 1,
            pageList: [10],
            idField: "id",  //标识哪个字段为id主键
            showToggle: false,   //名片格式
            cardView: false,//设置为True时显示名片（card）布局
            showColumns: true, //显示隐藏列
            showRefresh: false,  //显示刷新按钮
            singleSelect: true,//复选框只能选择一条记录
            search: false,//是否显示右上角的搜索框，此搜索是客户端搜索，不会进服务端
            clickToSelect: true,//点击行即可选中单选/复选框
            sidePagination: "server",//表格分页的位置
            queryParamsType: "limit", //参数格式,发送标准的RESTFul类型的参数请求
            toolbar: "#toolbar", //设置工具栏的Id或者class
            columns: dataColumns, //列
            silent: true,  //刷新事件必须设置
            formatLoadingMessage: function () {
                return "请稍等，正在加载中...";
            },
            formatNoMatches: function () {  //没有匹配的结果
                return '无符合条件的记录';
            },
            onLoadSuccess: function () {

            },
            onLoadError: function (data) {
                //$('#reportTable').bootstrapTable('removeAll');
            },
            onClickRow: function (row) {
                //window.location.href = "/qStock/qProInfo/" + row.ProductId;
            },
            responseHandler: function (res) {
                if (res.resultInfo.status == '000') {
                    list = res.resultMap.rows;
                    return {
                        "total": res.resultMap.total,//总页数
                        "rows": res.resultMap.rows   //数据
                    };
                } else {
                    list = [];
                    return {
                        "total": 0,//总页数
                        "rows": []   //数据
                    };
                }
            }
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        return dataQueryParams(params);
    };
    return oTableInit;
};
var optType = undefined;

//modal显示
function showModel(operation, index) {
    optType = operation;
    if (operation == 0) {
        $("#myModalLabel").html("新建轮换图");
    } else {
        $("#myModalLabel").html("编辑轮换图");
    }
    console.info(index);
    if (operation == 1) {
        var list_index_value = list[index];
        console.info(list_index_value);
        $("#rotate_pic_name").val(list_index_value.name);
        $("[name='rotate_pic_state']").each(function () {
            if ($(this).val() == list_index_value.state) {
                //改变元素的boolean类型属性用prop才能生效
                $(this).prop("checked", true);
            }
        });
        $("#rotate_pic_expire_time").val(timetrans(list_index_value.expireTime));
        $("#rotate_pic_display_order").val(list_index_value.displayOrder);
        $("[type='file']").val("");
        $("#preview_image_div").find("img").attr("src", list_index_value.imgUrl).show();
        $("#preview_image_div").show();
        $("#rotate_pic_link_url").val(list_index_value.linkUrl);

        $("#rotate_pic_id").val(list_index_value.id);
    } else {
        clearForm();
    }
    $("#myModal").modal();
}

//时间戳转化成时间
function timetrans(date) {
    if (!date) {
        return;
    }
    var date = new Date(date);
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
    var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
    var m = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
    var s = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
    return Y + M + D + h + m + s;
}

function selectImage(obj) {
    ischeck = true;
    /* 检查图片的格式和大小 */
    var checkFlag = checkImage(obj);
    if (checkFlag || checkFlag == 'true' || checkFlag == 'True') {
        previewImage(obj);
    }
}

//检查图片类型及大小
function checkImage(obj) {
    var maxsize = 3 * 1024 * 1024;// 最大值300K
    var imgFile = obj;
    var pattern = /\.(gif|jpeg|bmp|jpg|png|JPEG|BMP|GIF|JPG|PNG)$/;
    if (!pattern.test(imgFile.value)) {
        alert("系统仅支持jpg/jpeg/png/gif/bmp格式的图片！");
        $(obj).val("");
        imgFile.focus();
        $("#preview_image_div").html("");
        return false;
    }
    var fileSize = 0;
    var objPreviewFake = obj;
    if (imgFile.files && imgFile.files[0]) {
        try {
            fileSize = imgFile.files[0].size;
        } catch (e) {
            var reader = new FileReader();
            reader.onload = function (e) {
                fileSize = imgFile.files[0].size;
            }
        } // Firefox 因安全性问题已无法直接通过 input[file].value 获取完整的文件路径
    } else if (objPreviewFake != null && objPreviewFake.filters) {
        imgFile.select();
        obj.focus();
        var imgSrc = document.selection.createRange().text;
        var img = new Image();
        img.src = imgSrc;
        if (img.complete) {
            return false;
        }
        img.onload = function () {
            fileSize = img.fileSize;
        }
    }
    if (maxsize < fileSize) {
        alert("文件过大，不可大于3MB!");
        $(obj).val("");
        imgFile.focus();
        $("#preview_image_div").html("<img alt='' src='' style='width: 220px;height: 100px;'/>");
        return false;
    }
    return true;
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
        $("#preview_image_div").html("<img id='rotate_pic_img_url_preview' alt='' src='" + path + "' style='width: 220px;height: 100px;'/>");
        $("#preview_image_div").show();
    }
}

//清空表单
function clearForm() {
    $("[type='text']").val("");
    $("[type='hidden']").val("");
    $("[type='file']").val("");
    $("#rotate_pic_img_url_preview").attr("src", "");
    $("#preview_image_div").hide();
    $("[name='rotate_pic_state']").removeAttr('checked');
}

//提交表单
function submitForm() {
    var name = $("#rotate_pic_name").val();
    var state = $("[name='rotate_pic_state']:checked").val();
    var expireTime = $("#rotate_pic_expire_time").val();
    var order = $("#rotate_pic_display_order").val();
    var imgUrl = $("#preview_image_div").find("img").attr("src");
    var linkUrl = $("#rotate_pic_link_url").val();
    if (!checkForm(name, state, order, imgUrl, linkUrl)) {
        return false;
    }
    // js 获取文件对象
    var id = $("#rotate_pic_id").val();
    var fileObj = document.getElementById("rotate_pic_img_url").files[0];
    var param = new FormData();
    param.append("optType", optType);
    param.append("name", name);
    param.append("state", state);
    param.append("order", order);
    param.append("expireTime", expireTime);
    param.append("linkUrl", linkUrl);
    if (optType == 0) {
        param.append("rotatePicfile", fileObj);
        param.append("id", null);
    } else {
        if (fileObj != undefined) {
            param.append("rotatePicfile", fileObj);
        }
        param.append("id", id);
    }
    $.ajax(
        {
            url: "/rotatePic/addAndUpdateRotatePic",
            contentType: "application/json;charset=UTF-8",
            type: "POST",
            data: param,
            dataType: "json",
            contentType: false,// 告诉jQuery不要去设置Content-Type请求头
            processData: false,// 告诉jQuery不要去处理发送的数据
            beforeSend: function () {
                console.log("正在进行，请稍候");
            },
            success: function (result) {
                if (result.resultInfo.status == '000') {
                    alert(result.resultInfo.message);
                    location.reload();
                } else {
                    alert(result.resultInfo.message);
                }
            },
            error: function (result) {
                alert("请求失败，请稍后再试");
            }
        }
    );
    return false;
}

//检查表单非空项
function checkForm(name, state, order, imgUrl, linkUrl) {
    if (!name) {
        alert("请输入名称！");
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
    if (!linkUrl) {
        alert("请输入链接地址！");
        return false;
    }
    return true;
}