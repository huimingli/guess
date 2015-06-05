<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Admin Console</title>
	<meta name="menu" content="notification" />    
</head>

<body>

<h1>Send Notifications</h1>

<%--<div style="background:#eee; margin:20px 0px; padding:20px; width:500px; border:solid 1px #999;">--%>
<div style="margin:20px 0px;">
<form action="driver.do?action=send" method="post" style="margin: 0px;" enctype="multipart/form-data">
<table width="600" cellpadding="4" cellspacing="0" border="0">

<tr id="trUsername">
	<td>同学名:</td>
	<td><input type="text" id="username" name="name" value="" style="width:380px;" /></td>
</tr>
<tr id="trAlias" >
	<td>年龄:</td>
	<td><input type="text" id="alias" name="age" value="" style="width:380px;" /></td>
</tr>
<tr id="trTag">
	<td>票数:</td>
	<td><input type="text" id="tag" name="count" value="" style="width:380px;" /></td>
</tr>
 
<tr>
	<td>头像:</td>
	<td><input type="file" id="image" name="face" value="" style="width:380px;" />
	    <br/><span style="font-size:0.8em">only image</span>
	</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td><input type="submit" value="Submit" /></td>
</tr>
</table> 
</form>
</div>



</body>
</html>
