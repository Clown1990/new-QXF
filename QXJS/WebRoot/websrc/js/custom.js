/**
 * Created by cj on 16/3/31.
 */
// 添加客户管理
function addCustom() {
    var addCustom = $('#customAddForm').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: addCustom,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//删除客户管理
function deleteCustom(customId) {
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {customId:customId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改管系列-获取当前选中行信息
//function updateGetSeries(seriesId){
//    var url = url;
//    $.ajax({
//        type: 'POST',
//        url: url,
//        data: {seriesId:seriesId},
//        success: function (data) {
//            console.log(data);
//        },
//        error: function () {
//            alert("异常！");
//        }
//    })
//}
//修改客户管理
function updateCustom(){
    var updateCustom = $('#customAddForm1').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: updateSeries,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//查询客户管理
function selectCustom(){
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}