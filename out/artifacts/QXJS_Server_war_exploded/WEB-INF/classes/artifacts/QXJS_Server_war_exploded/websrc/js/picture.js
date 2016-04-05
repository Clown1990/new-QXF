/**
 * Created by cj on 16/4/1.
 */
/**
 * Created by cj on 16/3/31.
 */
// 添加组合
function addPicture() {
    var addPicture = $('#addPictureForm').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: addPicture,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//删除组合
function deletePicture(photoId) {
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
function updateGetPicture(photoId){
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {photoId:photoId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改系列
function updatePicture(){
    var updatePicture = $('#updatePictureForm').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: updatePicture,
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