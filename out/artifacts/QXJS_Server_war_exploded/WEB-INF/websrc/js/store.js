/**
 * Created by cj on 16/4/1.
 */
/**
 * Created by cj on 16/3/31.
 */
// 添加系列
function addStore() {
    var addStore = $('#addStoreForm').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: addStore,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//删除系列号
function deleteStore(storeId) {
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {storeId:storeId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改管系列-获取当前选中行信息
function updateGetStore(storeId){
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {storeId:storeId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改系列
function updateStore(){
    var updateStore = $('#updateStoreForm').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: updateStore,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//查询系列
function selectSeries(){
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