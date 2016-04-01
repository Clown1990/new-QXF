/**
 * Created by cj on 16/3/30.
 */
$(function(){

})
// 添加管理员
function AddUserManage() {
    var addManage = $('#addManage').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: addManage,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//删除管理员
function deleteUserManage(userId) {
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {userId:userId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改管理员信息-获取当前选中行信息
function updateGetUserManage(userId){
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {userId:userId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改管理员信息
function updateUserManage(){
    var updateManage = $('#updateManage').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: updateManage,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//登录
function loginIn(){
    var logindata = $('#login').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: logindata,
        success: function (data) {
            console.log(data);
            //location.href = "index.html";
        },
        error: function () {
            alert("异常！");
        }
    })
}

