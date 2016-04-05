/**
 * Created by cj on 16/4/1.
 */
/**
 * Created by cj on 16/3/31.
 */
// 添加组合
function addProduct() {
    var addProduct = $('#addProductForm').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: addProduct,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//删除组合
function deleteProduct(productId) {
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {productId:productId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改管系列-获取当前选中行信息
function updateGetProduct(productId){
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {productId:productId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改系列
function updateProduct(){
    var updateProduct = $('#updateProductForm').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: updateProduct,
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