<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户管理</title>
    <style type="text/css">
    body {
    	background-color: #67B0DB;
    }
    h1 {
    	text-align: center;
    	color:white;
    }
   
    </style>
    <script type="text/javascript">
    function jPage(current){
    	document.location.href="UserAdmin.action?currentPage="+current;
    }
    function jump(){
    	var currentPage = document.getElementById("currentPage").value;
    	jPage(currentPage);
    }
    </script>
  </head>
  
  <body>
  <br><br><br><br><br><br>
  	 <div style="height: 60px; background-color: #67B0DB"><h1>用户信息管理系统</h1></div>
  	<table width="649" height="200" align="center" bgcolor="white" border="1px" >
  		<tr>
  			<th>序号</th>
  			<th>用户名</th>
  			<th>密码</th>
  			<th>性别</th>
  			<th>邮箱</th>
  			<th>电话</th>
  			<th>操作</th>
  		</tr>
  		<tbody>
  		<s:iterator value="listUsers" var="user" status="index">
  		<tr>
  		<td><s:property value="#index.index+1"/> </td>
  		<td><s:property value="#user.userName"/> </td>
  		<td><s:property value="#user.password"/> </td>
  		<td><s:property value="#user.sex"/> </td>
  		<td><s:property value="#user.email"/> </td>
  		<td><s:property value="#user.phone"/> </td>
  		<td><a href="toModify.action?modifyId=<s:property value="#user.id"/>">修改</a>&nbsp;&nbsp;<a href="deleteUser.action?deletId=<s:property value="#user.id"/>">删除</a> </td>
  		</tr>
		</s:iterator>
  		</tbody>
  	</table>
  	第<input id="currentPage" name="currentPage" style="width: 30px" value="${currentPage }">页 &nbsp;共${totalPage }页 &nbsp;
  	<s:if test="currentPage>1"><button onclick="jPage(1)">首页</button></s:if>
  	<s:if test="currentPage!=1"><button onclick="jPage(${currentPage}-1)">上一页</button></s:if>
  	<s:if test="currentPage!=totalPage"><button onclick="jPage(${currentPage}+1)">下一页</button></s:if>
  	<s:if test="currentPage<totalPage"><button onclick="jPage(${totalPage })">尾页</button></s:if>
  	<button onclick="jump()">跳转</button>
  </body>
</html>
