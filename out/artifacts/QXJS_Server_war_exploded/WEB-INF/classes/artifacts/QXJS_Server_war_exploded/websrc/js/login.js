/**
 * Created by cj on 16/4/5.
 */
function login() {
    var logindata = $('#login').serialize();
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