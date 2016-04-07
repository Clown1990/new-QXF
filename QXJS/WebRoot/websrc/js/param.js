/**
 * Created by cj on 16/4/1.
 */
/**
 * Created by cj on 16/3/31.
 */
// 添加组合
function addParam() {
    var addParam = $('#addParamForm').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: addParam,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//删除组合
function deleteParam(paramId) {
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {paramId:paramId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改管系列-获取当前选中行信息
function updateGetParam(paramId){
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {paramId:paramId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改系列
function updateParam(){
    var updateParam = $('#updateParamForm').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: updateParam,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//查询系列
function selectParam(){
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