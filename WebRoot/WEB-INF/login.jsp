<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


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
	<div align="center">
		<s:a href="toRegister.action">
			<font color="#67B0DB">
				<h5><big>点击这里注册新账户</big></h5>
			</font>
		</s:a>	
	</div>
	<div  align="center">
		<s:form action="Login.action" method="post">
			<%-- <s:fielderror fieldName="password" cssStyle="color:red"></s:fielderror> --%>
			<s:textfield name="userName" label="用户名" onclick="JavaScript:this.value=''"></s:textfield>
			<br>
			<s:password name="password" label="密码" onclick="JavaScript:this.value=''"></s:password>
			<br>
			<s:submit value="登录" align="center">
			</s:submit>
			
			
		</s:form>
	</div>
	<br><br><br>
    </td>
    </tr>
</table>
  </body>
</html>
