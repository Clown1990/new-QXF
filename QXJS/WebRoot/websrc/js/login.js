///**
// * Created by cj on 16/4/5.
// */
$(function(){
    $('#submit').click(function(){
        login();
    });

});
// const USER_KEY = 'user';
// let  user = getStorage(USER_KEY);
// user =JSON.parse(user);
//
// function getStorage(key){
//     return localStorage.getItem(key)
// }
//
// function setStorage(key,value) {
//     return localStorage.setItem(key,value)
// }

function login() {
    var logindata = $('#login').serialize();
    //alert(logindata);
    var url = "/QXJS/user/loginControl";
    $.ajax({
        type: 'GET',
        url: url,
        data: logindata,
        success: function (data) {
        	var list = data.list;
            console.log(data,list);
            // if(data.result =="SUCCESS"){
            // 	window.location.href = "user/userManage.html";
            //     setStorage(USER_KEY,JSON.stringify(list.username));
            //
            // }else {
            //     window.location.href = "login.html";
            //     return false;
            // }
        },
        error: function () {
            alert("异常！");
        }
    });
}