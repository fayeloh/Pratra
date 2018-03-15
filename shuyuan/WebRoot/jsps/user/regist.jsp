<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css"> 
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/user/regist.css'/>">
	
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsps/js/user/regist.js'/>"></script>
  </head>
  
  <body>
  <div id="divMain">
  	<div id="divTitle">
  		<span id="spanTitle">新用户注册</span>
  	</div>
  	<div id="divBody">
  <form action="<c:url value='/UserServlet'/>" method="post" id="registForm">
  	<input type="hidden" name="method" value="regist">
  		<table id="tableForm">
  			<tr>
  				<td class="tdText">用户名</td>
  				<td class="tdInput">
  					<input class="inputClass" id="loginname" type="text" name="loginname" value="${form.loginname}">
  				</td>
  				<td class="tdLabel">
  					<label class="errorClass" id="loginnameError">${errors.loginname}</label>
  				</td>
  			</tr>
  			<tr>
  				<td class="tdText">用户密码</td>
  				<td class="tdInput">
  					<input class="inputClass" id="loginpass" type="password" name="loginpass" value="${form.loginpass}">
  				</td>
  				<td>
  					<label class="errorClass" id="loginpassError">${errors.loginpass}</label>
  				</td>
  			</tr>
  			<tr>
  				<td class="tdText">确认密码</td>
  				<td class="tdInput">
  					<input class="inputClass" id="repassword" type="password" name="repassword" value="${form.repassword}">
  				</td>
  				<td>
  					<label class="errorClass" id="repasswordError">${errors.repassword}</label>
  				</td>
  			</tr>
  			<tr>
  				<td class="tdText">email</td>
  				<td class="tdInput">
  					<input class="inputClass" id="email" type="text" name="email" value="${form.email}">
  				</td>
  				<td>
  					<label class="errorClass" id="emailError">${errors.email}</label>
  				</td>
  			</tr>
  			<tr>
  				<td class="tdText">验证码</td>
  				<td class="tdInput">
  					<input class="inputClass" id="verifyCode" type="text" name="verifyCode" value="${form.verifyCode}">
  				</td>
  				<td>
  					<label class="errorClass" id="verifyCodeError">${errors.verifyCode}</label>
  				</td>
  			</tr>
  			<tr>
  				<td class="tdText"></td>
  				<td>
  					<div id="divVerifyCode"><img id="verifyCodeImg" src="<c:url value='/VerifyCodeServlet'/>"></div>
  				</td>
  				<td>
  					<label><a href="javascript:_hyz()">换一张</a></label>
  				</td>
  			</tr>
  			<tr>
  				<td class="tdText"></td>
  				<td>
  					<input id="submitBtnImg" type="image" src="<c:url value='/images/regist1.jpg'/>">
  				</td>
  				<td>
  					<label></label>
  				</td>
  			</tr>
  		</table>
  	</form>
  	</div>
  </div>
  </body>
</html>
	