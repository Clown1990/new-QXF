/**
 * Created by cj on 16/4/3.
 */
/**
 * Created by cj on 16/3/31.
 */
// 添加系列
function addOrder() {
    var addOrder = $('#OrderAddForm').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: addOrder,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//删除系列号
function deleteOrder(orderId) {
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {orderId:orderId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改管系列-获取当前选中行信息
function updateGetOrder(orderId){
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {orderId:orderId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改系列
function updateOrder(){
    var updateOrder = $('#OrderAddForm1').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: updateOrder,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//查询系列
function selectOrder(){
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