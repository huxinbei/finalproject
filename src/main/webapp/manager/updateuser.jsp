<!-- 功能：修改用户界面，表单内容提交到Updateuserservlet -->
<!-- 作者：胡欣蓓 -->
<%@ page language="java" import="java.util.*,com.ie.bean.*,com.ie.dao.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>My JSP 'updatebook.jsp' starting page</title>
</head>
<body>
	<%
		int userid = Integer.parseInt(request.getParameter("id"));
		BookUserDao CD = new BookUserDao();
		User user = CD.Queryoneuser(userid);
	%>
	<form action="Updateuserservlet" method="post"
		onsubmit="return check(this);">
		<table border="1px" width="600px" height="400px" align="center" 
			cellpadding="0px" cellspacing="0px" bgcolor="white">
			<tr height="80px">
				<td colspan="2" align="center">
					<h2 size="4">用户修改</h2>
				</td>
			</tr>
			<tr>
				<td>图书编号:</td>
				<td><input type="text" name="userid" style="border:none;height:100%;width:100%"
					value="<%=user.getUserid()%>" size="35px" /></td>
			</tr>
			<tr>
				<td align="left">用户名:</td>
				<td><input type="text" name="username" style="border:none;height:100%;width:100%"
					value="<%=user.getUsername()%>" size="35px" /></td>
			</tr>
			<tr>
				<td align="left">用户密码:</td>
				<td><input type="text" name="userpwd" style="border:none;height:100%;width:100%"
					value="<%=user.getUserpwd()%>" size="35px" /></td>
			</tr>
			<tr>
				<td align="left">联系电话:</td> 
				<td><input type="text" name="userphone" style="border:none;height:100%;width:100%"
					value="<%=user.getUserphone()%>" size="35px" /></td>
			</tr>
			<tr>
				<td align="left">性别:</td>
				<td><input type="text" name="usersex" style="border:none;height:100%;width:100%"
					value="<%=user.getUsersex()%>" size="35px" /></td>
			</tr>
			<tr>
				<td align="left">院系:</td>
				<td><input type="text" name="userdept" style="border:none;height:100%;width:100%"
					value="<%=user.getUserdept()%>" size="35px" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input name="button"
					type="submit" value="修改" class="button1" /></td>
			</tr>
		</table>
	</form>
</body>
</html>