<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<script type="text/javascript">
	$().ready(
			function() {
				//点击图片更换验证码
				$("#Verify").click(
						function() {
							$(this).attr(
									"src",
									"SecurityCodeImageAction.do?timestamp="
											+ new Date().getTime());
						});
			});
</script>
<html>
<head>
<title>登录界面</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/CheckForm.js"></script>
</head>
<body
	 >
	<div class="lightbox" id="LoginBox">
		<div style="position: relative;top:35%;left:50%">
			<form
				action="admin.do?action=send"
				method="post"
				enctype="multipart/form-data"
				style="position: absolute;width:220px;height:200px;margin:-100px 0 0 -110px">
				<div style="text-align: center">
					  
				</div>
				<input class="textbox" type="text" name="name"
					placeholder="输入用户名" required="required" /><br /> <input
					class="textbox" type="password" name="password" placeholder="输入密码"
					required="required" /><br />
				<!-- <div class="clearfix">
					<input class="textbox floatLeft"
						style="width:70px;margin-right: 5px" type="text"
						name="securityCode" placeholder="输入验证码" required="required" /><img
						class="floatLeft" src="/SecurityCodeImageAction.do" id="Verify"
						alt="看不清，换一张" />
				</div> -->
				<div class="red font14">
					<s:property value="%{ #message }"></s:property>
				</div>
				<input type="checkbox" name="autoLogin" />&nbsp;&nbsp;<span
					class="blacksliver">记住密码，下次自动登录</span><br />
				<div style="text-align: center">
					<input type="submit" value="登陆" class="button"
						style="width:80px;height: 30px" />&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="reset" value="重置" class="button" id="reset"
						style="width:80px;height: 30px" />
				</div>
			</form>
		</div>
		<div style="position: absolute;bottom:10px;right:20px">
			<a href="/index_index.do">返回主页>></a>
		</div>
	</div>

</body>
</html>
