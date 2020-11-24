<!-- 功能：图书管理员界面，分为用户信息管理和图书信息管理 -->
<!-- 作者：胡欣蓓 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>图书管理员界面</title>
  </head>
  
<body>
	<table width="100%" border="1" cellspacing="0" cellpadding="0" id="surface">
		<tr >
			<td bgcolor="#AFDBDC" height="150" class="top">  
			<h1 align="center" style="margin-top:40px">图书管理员页面</h1>
			<h2>欢迎图书管理员：<%=session.getAttribute("name")%></h2>
			<button style="float:right;font-size:23px"><a href="<%=basePath%>login.jsp" >退出</a></button>
			</td>
		</tr>
		<tr>
			<td height="600" bgcolor="#E8F7F7" id="surface2"> 
				<table width="100%" border="1" cellspacing="0" cellpadding="0" height="100%" class="center">
				<tr>
					<td width="20%"  align="center" class="left">
						<ul><li style="font-size:30px"><a href="<%=basePath%>Findbookservlet" target="nav">图书信息管理</a></li></ul>
						<ul><li style="font-size:30px"><a href="<%=basePath%>Finduserservlet" target="nav">用户信息管理</a></li></ul>
					</td>	
					<td width="85%" class="right">
						<iframe src="" name="nav" width=100% height="500" frameborder="0" class="nav" >		
						</iframe>
					</td>
				</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>