$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    CKEDITOR.replace('news_content');
});
var dataUrl = "/news/getNewsList";
var dataColumns = [
    {
        title: '新闻编号',//表的列名
        field: 'id',//json数据中rows数组中的属性名
        align: 'center'//水平居中
    },
    {
        title: '新闻标题',
        field: 'title',
        align: 'center'
    },
    {
        title: '新闻缩略图',
        field: 'imgUrl',
        align: 'center',
        formatter: function (value, row, index) {
            return '<img src="' + row.imgUrl + '" style="width:200px;height: 50px;"/>';
        }
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
        title: '新闻排序',
        field: 'displayOrder',
        align: 'center',
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
        $("#myModalLabel").html("新建新闻");
    } else {
        $("#myModalLabel").html("编辑新闻");
    }
    console.info(index);
    if (operation == 1) {
        var list_index_value = list[index];
        console.info(list_index_value);
        $("#news_title").val(list_index_value.title);
        $("[name='news_state']").each(function () {
            if ($(this).val() == list_index_value.state) {
                //改变元素的boolean类型属性用prop才能生效
                $(this).prop("checked", true);
            }
        });
        $("#news_display_order").val(list_index_value.displayOrder);
        $("[type='file']").val("");
        $("#preview_image_div").find("img").attr("src", list_index_value.imgUrl).show();
        $("#preview_image_div").show();
        CKEDITOR.instances.news_content.setData(list_index_value.content);
        $("#news_id").val(list_index_value.id);
    } else {
        clearForm();
    }
    $("#myModal").modal();
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
    var title = $("#news_title").val();
    var state = $("[name='news_state']:checked").val();
    var order = $("#news_display_order").val();
    var imgUrl = $("#preview_image_div").find("img").attr("src");
    var content = CKEDITOR.instances.news_content.getData();
    if (!checkForm(title, state, order, imgUrl, content)) {
        return false;
    }
    // js 获取文件对象
    var id = $("#news_id").val();
    var fileObj = document.getElementById("news_img_url").files[0];
    var param = new FormData();
    param.append("optType", optType);
    param.append("title", title);
    param.append("state", state);
    param.append("order", order);
    param.append("content", content);
    if (optType == 0) {
        param.append("newsfile", fileObj);
        param.append("id", null);
    } else {
        if (fileObj != undefined) {
            param.append("newsfile", fileObj);
        }
        param.append("id", id);
    }
    $.ajax(
        {
            url: "/news/addAndUpdateNews",
            contentType: "application/json;charset=UTF-8",
            type: "POST",
            data: param,
            dataType: "json",
            contentType: false,// 告诉jQuery不要去设置Content-Type请求头
            processData: false,// 告诉jQuery不要去处理发送的数据
            beforeSend:function(){
                console.log("正在进行，请稍候");
            },
            success: function (result) {
                if (result.resultInfo.status == '000') {
                    alert(result.resultInfo.message);
                } else {
                    alert(result.resultInfo.message);
                }
            },
            error : function(result) {
                alert("请求失败，请稍后再试");
            }
        }
    );
    // $.post("/news/addAndUpdateNews", param, function (result) {
    //     if (result.status == 200) {
    //         alert(result.message);
    //     } else {
    //         alert(result.message);
    //     }
    // });
    return false;
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