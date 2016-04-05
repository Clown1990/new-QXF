/**
 * Created by cj on 16/4/5.
 */
$(function(){
    $('#submit').click(function(){
        login();
    })

})
function login() {
    var logindata = $('#login').serialize();
    var url = "spring/user/loginControl";
    $.ajax({
        type: 'POST',
        url: url,
        data: logindata,
        success: function (data) {
            alert(data);
            console.log(data);
        },
        error: function () {
            alert("异常！");
        }
    })
}