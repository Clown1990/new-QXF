/**
 * Created by cj on 16/4/1.
 */
/**
 * Created by cj on 16/3/31.
 */
// 添加组合
function addGroup() {
    var addSeries = $('#addGroupForm').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: addSeries,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//删除组合
function deleteGroup(groupId) {
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {groupId:groupId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改管系列-获取当前选中行信息
function updateGetGroup(groupId){
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: {groupId:groupId},
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//修改系列
function updateGroup(){
    var updateGroup = $('#updateGroupForm').serialize();
    var url = url;
    $.ajax({
        type: 'POST',
        url: url,
        data: updateGroup,
        success: function (data) {
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}
//查询系列
function selectGroup(){
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