var currentPage = 1;//当前页号
var totalNumber = 0;//总记录数
var pageSize = 15;//页面大小
var startIndex = 0;//当前页号

var groupId = 0;

/** 判断是否有User登陆**/
const USER_KEY = 'user';
let  user = getStorage(USER_KEY);
user =JSON.parse(user);

function getStorage(key){
	return localStorage.getItem(key)
}
function clearStorage(key){
	localStorage.removeItem(key);
}
if(user){
	$('.dropdown span').text(`您好! ${user}`)
}else{
	window.location.href = "../login.html";
}
/*退出清除localStorage*/
$('.dropout').click(function(){
	clearStorage(USER_KEY);
	location.reload();
});



/** 初始化照片信息表 **/
function init(){
	$.ajax({
		type : "GET",
		url : "/QXJS/photo/selectControl?type=7",
		dataType : "json",
		contentType : "application/json",
		data : {"productCd":fuzzyProductCd, "currentPage":(currentPage-1), "pageSize":pageSize},
		success : function(msg) {
			var list = msg.list;
			console.log(list);
			var result = msg.result;
			initPhotoTable(list, result);
			listenCheckbox();
		},
		error: function () {
            alert("异常！");
        }
	});
}
function initPhotoTable(list, result){
	if(result == "SUCCESS"){
		var photoTableStr = "<tr><th>全选<input type='checkbox' class='checkboxAll' id='checkAll'></th>" +
			"<th>ID</th><th hidden='true'>userId</th><th>用户名称</th><th hidden='true'>productId</th><th>产品编号</th>" +
			"<th>图片</th><th>备注</th><th hidden='true'>审核状态Id</th><th>审核状态</th><th>操作</th></tr>";
		for(var i = 0;i < list.length;i++){
			photoTableStr += "<tr><td><input type='checkbox' name='checkNum'></td>" +
							"<td>"+ list[i].photoId +"</td>" +
							"<td hidden='true'>"+ list[i].userId +"</td>" +
							"<td>"+ list[i].userName +"</td>" +
							"<td hidden='true'>"+ list[i].productId +"</td>" +
							"<td>"+ list[i].productCd +"</td>" +
							"<td> <a class='example2' href='/QXJS/source/userUploadImg/"+list[i].path+"'><img src='/QXJS/source/userUploadImg/"+list[i].path+"' /></a></td>" +
							"<td>"+ list[i].comment +"</td>" +
							"<td hidden='true' id='state'>"+ list[i].enable +"</td>" +
							"<td id='show'>"+ changeState(list[i].enable) +"</td>" +
							"<td>" +
								"<button type='button' class='btn btn-danger btnSize' data-toggle='modal' onclick='photoInfoHandle("+ (i+1) +",this,\"deletePhoto\");' " +
								">删除</button>&nbsp;&nbsp;&nbsp;" +"<button type='button' class='btn btn-info btnSize'  onclick='pass(event);'>审核通过</button>&nbsp;&nbsp;&nbsp;"+"<button type='button' class='btn btn-danger btnSize'  onclick='pass(event);'>审核不通过</button>"+
				"</td></tr>";
		}
		$("#photoTable").html(photoTableStr);
	}else
		alert("init photo table fail.");
}
function pass(event) {
	var e = event || window.event;
	var enable = e.target.find('#state').text();
	if(enable == 1)
		return $('#show').text("审核通过");
	else return $('#show').text("审核失败");
}

function changeState(state){
	if(state == 1) return "审核通过";
	else return "审核失败";
}
/** 照片信息操作 **/
function photoInfoHandle(num,obj,action){
	if(action == "addPhoto"){
		$("#comment").val("");
		$("#enable").val("");
		document.getElementById("productId").selectedIndex = 0;
	}else if(action == "updatePhoto"){
		var photoID = $("table").find("tr").eq(num).find("td").eq(1).text();
		var userId = $("table").find("tr").eq(num).find("td").eq(2).text();
		var productId = $("table").find("tr").eq(num).find("td").eq(4).text();
		var productCd = $("table").find("tr").eq(num).find("td").eq(5).text();
		var comment = $("table").find("tr").eq(num).find("td").eq(7).text();
		var enable = $("table").find("tr").eq(num).find("td").eq(8).text();
		$("#updatePhotoId").val(photoID);
		$("#updateProductId").val(productId);
		$("#updateProductCd").val(productCd);
		$("#updateComment").val(comment);
		$("#updateEnable").val(enable);
	}else if(action == "deletePhoto"){
		var photoID = $("table").find("tr").eq(num).find("td").eq(1).text();
		deletePhotoControl(photoID);
	}
}
function selectProductInfo(){
	$.ajax({
		type : "GET",
		url : "/QXJS/product/downloadData",
		dataType : "json",
		contentType : "application/json",
		success : function(msg) {
			var result = msg.result;
			var list = msg.list;
			var productStr = "";
			for(var i = 0; i < list.length;i++){
				productStr += "<option value='"+ list[i].productId +"'>"+ list[i].productCd +"</option>";
			}
			$("#productId").html(productStr);
			$("#updateProductId").html(productStr);
		},
		error: function () {
            alert("异常！");
        }
	});
}
function selectUserInfo(){
	$.ajax({
		type : "GET",
		url : "/QXJS/user/downloadData",
		dataType : "json",
		contentType : "application/json",
		success : function(msg) {
			var result = msg.result;
			var list = msg.list;
			var userStr = "";
			for(var i = 0; i < list.length;i++){
				userStr += "<option value='"+ list[i].userId +"'>"+ list[i].username +"</option>";
			}
			$("#userId").html(userStr);
			$("#updateUserId").html(userStr);
		},
		error: function () {
            alert("异常！");
        }
	});
}

/** 添加照片 **/
function formSubmitAjax() {
	var reg =/(\.(jpg|png))$/;
	var re = /([^?#&=]+)=([^?#&=]+)/g;
	var data =$('.activityForm input').val();
	var url =`../../../uploadServlet/?imgName=${new Date().getTime() + reg.exec(data)[0]}&type=7`;

	var productId = $('#productId').val();
	var userId  =$('#userId').val();
	var enable = $('#enable').val();
	var path = re.exec(url)[2];
	var comment =$('#comment').val();
	console.log(productId,userId,enable,path);

	var info ={
		productId,
		userId,
		enable,
		path,
		comment
	};
	if(!reg.test(data)){
		alert('仅支持jpg和png格式图片 填写正确格式')
	}
	if(data==''){
		alert('请上传图片！')
	}
	var options ={
		url:url,
		type:'POST',
		data:data,
		dataType:'json',
		async:true,
		success:formSubmitAjaxCallback(info)

	};

	$('.activityForm').ajaxSubmit(options).submit();
}
function formSubmitAjaxCallback(info) {
	var url =`../../../photo/insertControl?userId=${info.userId}&productId=${info.productId}&enable=${info.enable}&path=${info.path}&comment=${info.comment}&type=7`;
	console.log(url);
	$.ajax({
		url:url,
		type:'GET',
		dataType:'json',
		data:info,
		success(result){
			console.log(result)
		}
	})
}


/** 删除产品信息 **/
function deletePhotoControl(photoIdStr){
	$.ajax({
		type : "GET",
		url : "/QXJS/photo/deleteControl",
		dataType : "json",
		contentType : "application/json",
		data : {"photoId":photoIdStr},
		success : function(msg) {
			var result = msg.result;
		},
		error: function () {
            alert("异常！");
        }
	});
	init();
}

$(function(){
	selectTotalNum();
	init();
	selectProductInfo();
	selectUserInfo();
	$(".storeSetAdPhotoImgUB").change(function(){
        var objUrl = getObjectURL(this.files[0]) ;
        console.log("objUrl = "+objUrl) ;
        if (objUrl) {
            $(this).parent().find("img").attr("src", objUrl) ;
        }
    }) ;

    //建立一個可存取到該file的url
    function getObjectURL(file) {
        var url = null ;
        if (window.createObjectURL!=undefined) { // basic
            url = window.createObjectURL(file) ;
        } else if (window.URL!=undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file) ;
        } else if (window.webkitURL!=undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file) ;
        }
        return url ;
    }
});
/** 批量删除**/
function mulitDelete(){
    var tbodyObj = document.getElementById('photoTable');
    var photoIdArr = new Array();
    var photoIdStr = "";
    $("table :checkbox").each(function(key,value){
        if($(value).prop('checked')){
            photoIdArr.push(tbodyObj.rows[key].cells[1].innerHTML);
        }
    });
    for(var i = 0;i < photoIdArr.length;i++){
    	photoIdStr += photoIdArr[i]+",";
    }
    if(photoIdStr.length > 0){
    	photoIdStr = photoIdStr.substring(0, photoIdStr.length-1);
    	photoIdStr = photoIdStr.replace("ID,", "");
    	deletePhotoControl(photoIdStr);
    }
}
var fuzzyProductCd = "";
function fuzzyPictureSearch(){
	fuzzyProductCd = $("#selectProductName").val();
	currentPage = 1;
	$(".tcdPageCode").clearPage({});
	selectTotalNum();
//	if(fuzzyProductname.length == 0) alert("请输入产品名！");return;
	init();
}
function pageControl(){
	 $(".tcdPageCode").createPage({
	        pageCount:totalPage(),
	        current:currentPage,
	        backFn:function(p){
	            console.log(p);
	            setViewByPageVo(p);
	        }
	  });
}
function totalPage(){
	if(totalNumber == 0) return 0;
	var remainder = totalNumber % pageSize;
	if(remainder > 0){
		return (totalNumber-remainder) / pageSize + 1;
	}else{
		return totalNumber / pageSize ;
	}
}
function setViewByPageVo(page){
	currentPage = page;
	init();
}
function listenCheckbox(){
	$("#checkAll").click(function() {
		$('input[name="checkNum"]').prop("checked",this.checked);
	});
	var $checkNum = $("input[name='checkNum']");
	$checkNum.click(function(){
		$("#checkAll").prop("checked",$checkNum.length == $("input[name='checkNum']:checked").length ? true : false);
	});
}
function selectTotalNum(){
	var url ="/QXJS/photo/insertControl";
	console.log(url);
	$.ajax({
		type : "GET",
		url : url,
		dataType : "json",
		contentType : "application/json",
		data : {"photoCd":fuzzyProductCd, "currentPage":(currentPage-1), "pageSize":pageSize},
		success : function(msg) {
			//console.log(msg);
			console.log(msg);
			totalNumber = msg.pageVo.totalNumber;
			pageControl();
		},
		error: function () {
			alert("异常！");
		}
	});
}