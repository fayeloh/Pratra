$(function(){
	/*
	 * 1.得到所有错误信息，循环遍历之，调用一个方法来确定其显示与否
	 * */
	$(".errorClass").each(function(){
		showError($(this));
	});
	/*
	 * 2.切换注册按钮图片
	 * */
	$("#submitBtnImg").hover(
			function(){
				$("#submitBtnImg").attr("src","/shuyuan/images/regist1.jpg");
			},  //逗号
			function(){
				$("#submitBtnImg").attr("src","/shuyuan/images/regist2.jpg");
			}
	);	
	/*
	 * 3.输入框得到焦点是提示栏信息隐藏
	 * */
	$(".inputClass").focus(function(){
		//得到当前的label的id
		var labelId = $(this).attr("id") +"Error";//通过输入框找到对应Label的id
		$("#"+labelId).text(""); //将label的内容清空
		showError($("#"+labelId));//隐藏没有内容的label
	});
	/*
	 * 4.输入框失去焦点校验
	 * */
	$(".inputClass").blur(function(){
		var id = $(this).attr("id");
		var mName = "validate"+id.substring(0,1).toUpperCase()+id.substring(1)+"()";//构造当前	id的方法名
		eval(mName);//执行方法调用
		});
	/*
	 * 5.表单校验
	 */
	$("#registForm").submit(function(){        //是表单的id，而不是隐藏的输入框id
		var bool = true;
		if(!validateLogin()){
			bool = false;
		}
		if(!validatePass()){
			bool = false;
		}
		if(!validateRepass()){
			bool = false;
		}
		if(!validateEmail()){
			bool = false;
		}
		if(!validateVerifyCode()){
			bool = false;
		}
		return bool;
	});
}); 
/*
 * 登录名校验方法
 */
function validateLoginname() {
	var id = "loginname";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("用户名不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(value.length < 3 || value.length > 20){
		/*
		 * 1.获取对应label
		 * 2.添加错误信息
		 * 3.显示label
		 * */
		$("#"+id+"Error").text("用户名长度必须3~20之间");//showError()的错
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 3. 是否注册校验
	 */
	$.ajax({
		url:"/shuyuan/UserServlet",//要请求的servlet
		data:{method:"ajaxValidateLoginName", loginname:value},//给服务器的参数
		type:"POST",
		dataType:"json",
		async:false,//是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。
		cache:false,
		success:function(result) {
			if(!result) {//如果校验失败
				$("#" + id + "Error").text("用户名已被注册！");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});
	return true;
}
/*用户密码校验*/
function validatePass(){
	var id = "loginpass";
	var value = $("#"+id).val();//得到当前输入框的内容
	/*
	 * 1.非空校验
	 * */
	if(!value){	/*
		 * 1.获取对应label
		 * 2.添加错误信息
		 * 3.显示label
		 * */
		$("#"+id+"Error").text("密码不能为空");
		showError($("#"+id+"Error"));
		return false;
	}
	/*
	 * 2.长度校验
	 * */
	if(value.length < 3 || value.length > 20){
		/*
		 * 1.获取对应label
		 * 2.添加错误信息
		 * 3.显示label
		 * */
		$("#"+id+"Error").text("密码长度必须3~20之间");//showError()的错
		showError($("#" + id + "Error"));
		false;
	}
	return true;
}
/*确认密码校验*/
function validateRepass(){
	var id = "repassword";
	var value = $("#"+id).val();//得到当前输入框的内容
	/*
	 * 1.非空校验
	 * */
	if(!value){
		/*
		 * 1.获取对应label
		 * 2.添加错误信息
		 * 3.显示label
		 * */
		$("#"+id+"Error").text("密码不能为空");
		showError($("#"+id+"Error"));
		return false;
	}
	/*
	 * 2.验证两次输入的密码是否相同
	 * */
	if(value != $("#loginpass").val()){
		/*
		 * 1.获取对应label
		 * 2.添加错误信息
		 * 3.显示label
		 * */
		$("#"+id+"Error").text("两次密码必须相同");
		showError($("#" + id + "Error"));
		false;
	}
	/*
	 * 3.是否注册校验
	 * */
	return true;
}
/*email校验*/
function validateEmail(){
	var id = "email";
	var value = $("#"+id).val();//得到当前输入框的内容
	/*
	 * 1.非空校验
	 * */
	if(!value){
		/*
		 * 1.获取对应label
		 * 2.添加错误信息
		 * 3.显示label
		 * */
		$("#"+id+"Error").text("email不能为空");
		showError($("#"+id+"Error"));
		return false;
	}
	/*
	 * 2.email格式校验
	 * */
	if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(value)){
		/*
		 * 1.获取对应label
		 * 2.添加错误信息
		 * 3.显示label
		 * */
		$("#"+id+"Error").text("email格式错误");
		showError($("#" + id + "Error"));
		false;
	}
	/*
	 * 3.是否注册校验
	 * */
	$.ajax({
		url:"/shuyuan/UserServlet",//要请求的servlet
		data:{method:"ajaxValidateEmail",email:value},//给服务器的参数
		type:"POST",
		dataType:"json",
		async:false,//是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。
		cache:false,
		success:function(result) {
			if(!result) {//如果校验失败
				$("#" + id + "Error").text("email已被注册！");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});
	return true;
}
/*验证码校验*/
function validateVerifyCode(){
	var id = "verifyCode";
	var value = $("#"+id).val();//得到当前输入框的内容
	/*
	 * 1.非空校验
	 * */
	if(!value){
		/*
		 * 1.获取对应label
		 * 2.添加错误信息
		 * 3.显示label
		 * */
		$("#"+id+"Error").text("验证码不能为空");
		showError($("#"+id+"Error"));
		return false;
	}
	/*
	 * 2.验证码长度校验
	 * */
	if(value.length!=4){
		/*
		 * 1.获取对应label
		 * 2.添加错误信息
		 * 3.显示label
		 * */
		$("#"+id+"Error").text("验证码长度必须等于4");
		showError($("#"+id+"Error"));
		false;
	}
	/*
	 * 3.是否注册校验
	 * */
	$.ajax({
		url:"/shuyuan/UserServlet",//要请求的servlet
		data:{method:"ajaxValidateVerifyCode", verifyCode:value},//给服务器的参数
		type:"POST",
		dataType:"json",
		async:false,//是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。
		cache:false,
		success:function(result) {
			if(!result) {//如果校验失败
				$("#" + id + "Error").text("验证码错误");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});
	return true;
}
/*
 * 判断是否有内容，存在则显示，不存在则隐藏
 */
function showError(ele){
	var text = ele.text();//获取元素内容
	if(!text){//不存在内容
		ele.css("display","none");//隐藏
	}else{//存在内容
		ele.css("display","");//显示
	}
	
}
//验证码的换一张功能的方法
function _hyz(){
	/*
	 * 1.获取（img）元素
	 * 2.替换src的内容
	 * 3.用毫秒来增加参数
	 * */
	$("#verifyCodeImg").attr("src","/shuyuan/VerifyCodeServlet?a="+new Date().getTime());
}