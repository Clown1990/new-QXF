///**
// * Created by cj on 16/4/5.
// */
$(function(){
    $('#submit').click(function(){
        login();
    })

})
function login() {
    var logindata = $('#login').serialize();
    var url = "/spring/user/loginControl";
    $.ajax({
        type: 'get',
        url: url,
        data: logindata,
        success: function (data) {
            if(data.result =="SUCCESS"){
                //window.open("http://www.baidu.com");
                window.location.href = "user/userManage.html";
                //for(user in data){
                //    user['id']
                //}
                //var table="<div>.....+<onclick
            }else {
                return false;
            }

        },
        error: function () {
            alert("异常！");
        }
    })
}