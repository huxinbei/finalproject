<%@ page language="java" contentType="text/html; UTF-8" import="java.io.*"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改管理员信息</title>
</head>
<% String mid = request.getParameter("mid");%>
<body>
	 <form action="SMedit" method=post>
		<table border="1px" width="600px" height="400px" align="center"
			cellpadding="0px" cellspacing="0px" bgcolor="white">
		<tr height="80px">
			<td colspan="6" align="center">
					<h2 size="4">图书管理员信息修改</h2>
			</td>
		</tr>
		<tr>
		   <td> 请输入id：</td>
		   <td><input name="mid" type="text" style="border:none;height:100%;width:100%" size="35px" value = <%=mid %> readonly="readonly"> </td>
		</tr>
		<tr>
		  <td>请输入姓名：</td>
		  <td><input name="mname" type="text" style="border:none;height:100%;width:100%" size="35px"></td>
		</tr>
		<tr>
		  <td>请输入密码：</td>
		  <td><input name="mpwd" type="password" style="border:none;height:100%;width:100%" size="35px"></td>
		</tr>
		<tr>
		  <td>请再次输入密码：</td>
		  <td><input name="mpwd1" type="password" style="border:none;height:100%;width:100%" size="35px"></td>
		</tr>
		<tr>
		      <td colspan="2" align="center"><input type="submit" name="Submit" value="修改" /></td>    
		</tr>
		</table>
	 </form>
</body>
</html> 