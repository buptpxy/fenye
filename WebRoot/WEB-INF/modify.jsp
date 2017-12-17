<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改用户信息</title>
<style>
	body{
	background-color: #67B0DB;
	}
	 h1{
    	text-align: center;	
    	color:white;
    }
   
</style>

</head>

<body>
<br><br><br><br><br><br>
	<form action="modify.action">
	<input name="id" value="${user.id}" style="display: none">
	 <div style="height: 60px; background-color: #67B0DB"><h1>用户信息管理系统</h1></div>
		<table width="649" height="200" align="center" bgcolor="white" >
			<tr>
				<td>用户名：</td>
				<td><input name="userName" value="${user.userName}"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input name="password" value="${user.password}"></td>
			</tr>
			<tr>
			
				<td>性别：</td>
				<td>
				
				<s:if test='user.sex=="女"'>
				<select name="sex">
						<option value="0" selected="selected">女</option>
						<option value="1">男</option>
				</select>
				</s:if>
				<s:if test='user.sex =="男"'>
				<select name="sex">
						<option value="0" >女</option>
						<option value="1" selected="selected">男</option>
				</select>
				</s:if>
				</td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input name="email" value="${user.email}"></td>
			</tr>
			<tr>
				<td>手机：</td>
				<td><input name="phone"  value="${user.phone}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="确定"></td>
				<td><input type="button" value="返回"></td>
			</tr>
		</table>
	</form>
</body>
</html>
