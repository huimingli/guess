<%@page import="org.androidpn.server.model.Driver"%>
<%@page import="java.util.List"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Admin Console</title>
<meta name="menu" content="user" />
<link rel="stylesheet" type="text/css" href="<c:url value='/styles/tablesorter/style.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/jquery.tablesorter.js'/>"></script>
</head>

<body>

<h1>Users</h1>
<a href="<%=request.getContextPath() %>/add.jsp">+添加</a>
<table id="tableList" class="tablesorter" cellspacing="1">
	<thead>
		<tr>
			<%--
			<th width="5%">Online</th>
			<th width="30%">Username</th>
			<th width="20%">Name</th>
			<th width="20%">Email</th>
			<th width="25%">Created</th>
			--%>
			<th>头像</th>
			<th>名字</th>
			 
			<th>年龄</th>
			<th>票数</th>
		</tr>
	</thead>
	<tbody>
	 
		<c:forEach var="driver" items="${driverList}">
			<tr>
				<td align="center">				 			
					<img src="${driver.face}" height="100" width="100"/>						 
				</td>
				<td><c:out value="${driver.name}" /></td>
				<td><c:out value="${driver.age}" /></td>
				<td><c:out value="${driver.count}" /></td>
				 </tr>
		</c:forEach>
	</tbody>
</table>

<script type="text/javascript">
//<![CDATA[
$(function() {
	$('#tableList').tablesorter();
	//$('#tableList').tablesorter( {sortList: [[0,0], [1,0]]} );
	//$('table tr:nth-child(odd)').addClass('odd');
	$('table tr:nth-child(even)').addClass('even');	 
});
//]]>
</script>

</body>
</html>
