$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});
var dataUrl = "/comment/getCommentList";
var dataColumns = [
    {
        title: 'ID',
        field: 'id',
        align: 'center'
    },
    {
        title: '编号',//表的列名
        field: 'cmtCode',//json数据中rows数组中的属性名
        align: 'center'//水平居中
    },
    {
        title: '时间',
        field: 'cmtTime',
        align: 'center',
        formatter: function (value, row, index) {
            return formatDate(row.cmtTime);
        }
    },
    {
        title: '类型',//表的列名
        field: 'Type',//json数据中rows数组中的属性名
        align: 'center',
        formatter: function (value, row, index) {
            if (row.cmtType == 1) {
                return "评论";
            } else if (row.cmtType == 2) {
                return "回复";
            } else {
                return "-";
            }
        }
    },
    {
        title: '主题ID',
        field: 'topicId',
        align: 'center'
    },
    {
        title: '主题类型',
        field: 'topicType',
        align: 'center'
    },
    {
        title: '内容',
        width: '250px',
        field: 'content',
        align: 'center'
    },
    {
        title: '状态',
        width: '60px',
        field: 'state',
        align: 'center',
        formatter: function (value, row, index) {//自定义显示，这三个参数分别是：value该行的属性，row该行记录，index该行下标
            if (row.state == "7") {
                return "待审";
            } else if (row.state == "8") {
                return "通过";
            } else if (row.state == "9") {
                return "删除";
            }
        }
    },
    {
        title: '客服回复状态',
        field: 'serviceState',
        align: 'center',
        formatter: function (value, row, index) {//自定义显示，这三个参数分别是：value该行的属性，row该行记录，index该行下标
            if (row.serviceState == "7") {
                return "未回复";
            } else if (row.serviceState == "8") {
                return "已回复";
            } else {
                return "-";
            }
        }
    },
    {
        title: '评论人用户编号',
        field: 'cmtUcode',
        align: 'center'
    },
    {
        title: '回复评论编号',
        field: 'replyCode',
        align: 'center'
    },
    {
        title: '回复人用户编号',
        field: 'replyUcode',
        align: 'center'
    },
    {
        title: '操作',
        field: 'id',
        align: 'center',
        formatter: function (value, row, index) {
            return '<button class="btn btn-primary btn-lg" data-toggle="modal" data-zdy="' + row.id + '" id="modalid' + row.id + '" onclick="showModel(' + index + ');">查看</button> ';
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

//modal显示
function showModel(index) {
    console.info(index);
    var list_index_value = list[index];
    console.info(list_index_value);
    $("#comment_content").html(list_index_value.content);
    $("#comment_time").html(formatDate(list_index_value.cmtTime));
    var cmtType = list_index_value.cmtType;
    if (cmtType == "1") {
        $("#comment_type").html("评论");
    } else if (cmtType == "2") {
        $("#comment_type").html("回复");
    } else {
        $("#comment_type").html("-");
    }
    var state = list_index_value.state;
    if (state == "7") {
        $("#comment_state").html("待审");
    } else if (state == "8") {
        $("#comment_state").html("通过");
    } else if (state == "9") {
        $("#comment_state").html("删除");
    } else {
        $("#comment_state").html("-");
    }
    var serviceState = list_index_value.serviceState;
    if(serviceState == "7"){//客服未回复
        var htmlVal = "<input type='text' id='service_content'/><button onclick='submitContent()'>提交</button>";
        $("#comment_service_content").html(htmlVal);
        $("#comment_service_time_div").hide();
    }else if(serviceState == "8"){//客服已回复
        $("#comment_service_content").html(list_index_value.serviceContent);
        $("#comment_service_time").html(list_index_value.serviceTime);
        $("#comment_service_time_div").show();
    }
    $("#comment_id").val(list_index_value.id);
    $("#myModal").modal();
}

function submitContent(){
    var id = $("#comment_id").val();
    var serviceContent = $("#service_content").val();
    if(!serviceContent){
        $("#error").html("请输入客服回复内容！").show();
        return false;
    }
    $("#error").hide();
    $.post("/comment/replayComment", {
        "id": id,
        "serviceContent": serviceContent
    }, function (result) {
        if (result.resultInfo.status == '000') {
            alert(result.resultInfo.message);
        } else {
            $("#error").html(result.resultInfo.message).show();
        }
    });
}

//清空表单
function clearForm() {
    $("#comment_content").html("");
    $("#comment_time").html("");
    $("#comment_type").html("");
    $("#comment_state").html("");
    $("#comment_service_content").html("");
    $("#comment_service_time").html("");
}

//提交表单
function submitForm() {
    var type = $("#news_type_select").val();
    var title = $("#news_title").val();
    var tag = $("#news_tag_val").val();
    var summary = $("#news_summary").val();
    var state = $("[name='news_state']:checked").val();
    var order = $("#news_display_order").val();
    var imgUrl = $("#preview_image_div").find("img").attr("src");
    var sourceType = $("#news_source_type").val();
    var sourceDesc = $("#news_source_desc").val();
    if (!checkForm(type, title, tag, summary, state, order, imgUrl, sourceType, sourceDesc, content)) {
        return false;
    }
    // js 获取文件对象
    var id = $("#news_id").val();
    var fileObj = document.getElementById("news_img_url").files[0];
    var param = new FormData();
    param.append("optType", optType);
    param.append("type", type);
    param.append("title", title);
    param.append("tag", tag);
    param.append("summary", summary);
    param.append("state", state);
    param.append("order", order);
    param.append("sourceType", sourceType);
    param.append("sourceDesc", sourceDesc);
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
function checkForm(type, title, tag, summary, state, order, imgUrl, sourceType, sourceDesc, content) {
    if (!sourceType) {
        alert("请选择类型！");
        return false;
    }
    if (!title) {
        alert("请输入标题！");
        return false;
    }
    if (!title) {
        alert("请输入标签！");
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
    if (!sourceType) {
        alert("请选择来源类型！");
        return false;
    }
    if (!content) {
        alert("请填写内容！");
        return false;
    }
    return true;
}