<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>登录界面</title>
    <style type="text/css">
    body {
    	background-color: #67B0DB;
    }
    h1 {
    	text-align: center;
    	color:white;
    }
    </style>
  </head>
  
  <body>
   
   <br><br><br><br><br><br>
   <div style="height: 60px; background-color: #67B0DB"><h1>用户信息管理系统</h1></div>
	<table width="649" height="200" align="center" bgcolor="white"  >
 <tr>
 <td>
 
	<br><br><br>
	
	<div  align="center">
		<s:form action="Register.action" method="post">
			<%-- <s:fielderror fieldName="password" cssStyle="color:red"></s:fielderror> --%>
		<table>
		<tr>
			<td>
				用户名：
			</td>
			<td>
				<s:textfield name="userName" onclick="JavaScript:this.value=''"></s:textfield>
			</td>
		</tr>
		<tr>
			<td>
				性别：
			</td>
			<td>
				<select name="sex">
					<option value="0">女</option>
					<option value="1">男</option>
				</select>
			</td>
		</tr>	
		<tr>
			<td>
				密码：
			</td>
			<td>
				<s:password name="password"  onclick="JavaScript:this.value=''"></s:password>
			</td>
		</tr>
			<tr>
			<td>
				邮箱：
			</td>
			<td>
				<s:textfield name="email"  onclick="JavaScript:this.value=''"></s:textfield>
			</td>
		</tr>
		<tr>
			<td>
				手机：
			</td>
			<td>
				<s:textfield name="phone"  onclick="JavaScript:this.value=''"></s:textfield>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<s:submit value="注册" align="center">
				</s:submit>
			</td>
		</tr>	
		</table>		
		</s:form>
	</div>
	<br><br><br>
    </td>
    </tr>
</table>
  </body>
</html>
