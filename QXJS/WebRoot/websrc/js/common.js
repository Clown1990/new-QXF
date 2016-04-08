/**
 * Created by cj on 16/4/8.
 */
$(function(){
    $("#checkAll").click(function() {
        $('input[name="checkNum"]').prop("checked",this.checked);
    });
    var $checkNum = $("input[name='checkNum']");
    $checkNum.click(function(){
        $("#checkAll").prop("checked",$checkNum.length == $("input[name='checkNum']:checked").length ? true : false);
    });
    $(".tcdPageCode").createPage({
        pageCount:6,
        current:1,
        backFn:function(p){
            console.log(p);
        }
    });

})