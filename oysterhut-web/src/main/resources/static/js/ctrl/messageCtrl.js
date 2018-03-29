$(function () {
    var random = Math.random();
    $("#vcodeImg").attr("src", '/getJpgCode?' + random);
    $("#changeImgA").click(function () {
        random = Math.random();
        $("#vcodeImg").attr("src", '/getJpgCode?' + random);
    });
    getCommentList();
});

function getCommentList() {
    var offset = 1;
    var limit = 10;
    query = {};
    query.limit = limit;
    pagingQuery(offset, function (countList) {
        productPaginQuery(countList.total);
    });
}

function productPaginQuery(totalCount) {
    $("#hotCommitListContainer").pagination({
        items: totalCount,
        itemsOnPage: 10,
        edges: 1,
        prevText: '上一页',
        nextText: '下一页',
        cssStyle: 'light-theme',
        onPageClick: function (idx) {
            pagingQuery(idx);
        }
    });
}

function pagingQuery(offset, callback) {
    query.offset = offset || 1;
    $.ajax({
        url: "/comment/getCommentList",
        contentType: "application/json;charset=UTF-8",
        type: "GET",
        data: JSON.stringify(query),
        dataType: "json",
        beforeSend: function () {
            console.log("正在进行，请稍候");
        },
        success: function (result) {
            if (result.resultInfo.status == "000") {
                var countList = result.resultMap;
                var maxCount = countList.total;
                if(!maxCount || maxCount == 0){
                    $('#hotCommitListContainer').hide();
                }else{
                    $("#hotCommitList").html($("#hotCommitListJs").render(result.resultMap.rows));
                    callback && callback(countList);
                }
            } else {
                alert(result.resultInfo.message);
            }
        }
    });
}