$(function () {
    //隐藏Modal
    //$("#myModal").modal('hide');
    //loadNews();

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
            // var dateVal = row.createTime;
            // var date = new Date(dateVal);
            // var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            // var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
            // var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
            // var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
            // var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
            // return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
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

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#table_server').bootstrapTable({
            method: 'post',
            url: dataUrl,
            dataType: "json",
            striped: true,     //使表格带有条纹
            pagination: true,    //在表格底部显示分页工具栏
            pageSize: 10,
            pageNumber: 1,
            pageList: [10, 20, 50, 100, 200, 500],
            idField: "id",  //标识哪个字段为id主键
            showToggle: false,   //名片格式
            cardView: false,//设置为True时显示名片（card）布局
            showColumns: true, //显示隐藏列
            showRefresh: true,  //显示刷新按钮
            singleSelect: true,//复选框只能选择一条记录
            search: false,//是否显示右上角的搜索框
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
                if (res.code == 1) {
                    return {
                        "total": res.data.total,//总页数
                        "rows": res.data.rows   //数据
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

//分页加载新闻
// function loadNews() {
//     $.get("/news/all", {}, function (result) {
//         if (result.status == 200) {
//             var dataList = result.page;
//             $("#renderTbody").html($("#newsList").render(dataList));
//         } else {
//             alert(result.message);
//         }
//     });
// }

// function loadNews() {
//     var page ={current:1,size:5};
//     $.get("/news/all",page,function (result) {
//         if(result.resultInfo.status == 200){
//             var datalist = result.resultMap.newsList;
//             list = datalist.records;
//             $("#table_server").bootstrapTable({
//                 url: '/news/all',
//                 method: 'get',
//                 data:datalist.records,
//                 dataType: "json",
//                 data_local: "zh-US",//表格汉化
//                 cache: false,//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
//                 striped: true,//设置为 true 会有隔行变色效果
//                 undefinedText: "",//当数据为 undefined 时显示的字符
//
//                 pagination: true, //分页
//                 // paginationLoop:true,//设置为 true 启用分页条无限循环的功能。
//                 showToggle: "true",//是否显示 切换试图（table/card）按钮
//                 showColumns: "true",//是否显示 内容列下拉框
//                 pageNumber: 1,//如果设置了分页，首页页码
//                 // showPaginationSwitch:true,//是否显示 数据条数选择框
//                 pageSize: 5,//如果设置了分页，页面数据条数
//                 pageList: [5, 10, 20, 40],  //如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
//                 paginationPreText: '‹',//指定分页条中上一页按钮的图标或文字,这里是<
//                 paginationNextText: '›',//指定分页条中下一页按钮的图标或文字,这里是>
//                 // singleSelect: false,//设置True 将禁止多选
//                 search: false, //显示搜索框
//                 data_local: "zh-US",//表格汉化
//                 sidePagination: "server", //服务端处理分页
//                 queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的
//                     return {//这里的params是table提供的
//                         offset: params.offset,//从数据库第几条记录开始
//                         size: params.limit//找多少条
//                     };
//                 },
//                 idField: "id",//指定主键列
//                 columns: [
//                     {
//                         title: '新闻编号',//表的列名
//                         field: 'id',//json数据中rows数组中的属性名
//                         align: 'center'//水平居中
//                     },
//                     {
//                         title: '新闻标题',
//                         field: 'title',
//                         align: 'center'
//                     },
//                     {
//                         title: '新闻缩略图',
//                         field: 'imgUrl',
//                         align: 'center',
//                         formatter: function (value, row, index){
//                             return '<img src="'+row.imgUrl+'" style="width:200px;height: 50px;"/>';
//                         }
//                     },
//                     {
//                         title: '创建时间',
//                         field: 'createTime',
//                         align: 'center',
//                         formatter: function (value, row, index){
//                             var dateVal = row.createTime;
//                             var date = new Date(dateVal);
//                             var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
//                             var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
//                             var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
//                             var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
//                             var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
//                             return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
//                         }
//                     },
//                     {
//                         title:'新闻排序',
//                         field:'displayOrder',
//                         align:'center',
//                     },
//                     {
//                         title: '状态',
//                         field: 'state',
//                         align: 'center',
//                         formatter: function (value, row, index) {//自定义显示，这三个参数分别是：value该行的属性，row该行记录，index该行下标
//                             return row.state == 8 ? "显示" : "关闭";
//                         }
//
//                     },
//                     {
//                         title: '操作',
//                         field: 'id',
//                         align: 'center',
//                         formatter: function (value, row, index) {
//                             return '<button class="btn btn-primary btn-lg" data-toggle="modal" data-zdy="'+row.id+'" id="modalid'+row.id+'" onclick="showModel(1,'+index+');">编辑</button> ';
//                         }
//                     }
//                 ]
//             }).on('load-success.bs.table', function (data) {//table加载成功后的监听函数
//                 console.log("load success");
//                 $(".pull-right").css("display", "block");
//             });
//         }
//     })
// }
//全局
var list = undefined;

//modal显示
function showModel(operation, index) {
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
        "newsfile": fileObj,
        "content": content
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