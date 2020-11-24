<!-- 功能：查看图书信息
	   作者：胡欣蓓 -->
<%@ page language="java" import="java.util.*,com.ie.dao.*,com.ie.bean.*"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>My JSP 'booklist.jsp' starting page</title>

</head>
<body>
	<div style="padding: 10px; margin-left: 5%;">
		<div style="width: 95%; float: center">
			<form action="<%=basePath%>manager/queryuser.jsp" method="post">
				<div style="width: 90%; float: left">
					<div style="float: right; padding: 30px; margin-top: 10px;">
						<span style="float: center; font-size: 16px;">用户查询：</span> 
						<select
							name="condition"
							style="width: 100px; height: 35px; float: center;">

							<option value="username">用户名</option>
							<option value="userdept">院系</option>
						</select> <input type="text" name="querykey"
							style="width: 200px; height: 30px; float: center;">
						<button type="submit"
							style="width: 100px; height: 35px">检索</button>
					</div>
				</div>
				`
			</form>
		</div>
		<div style="width: 100%;" align="center">
			<table style="text-align: center; width: 100%; height:100%;font-size: 17px"
				border="1px" align="center" cellspacing="0px" cellpadding="4">
				<tr height="50px">
					<td><span class="STYLE1">用户id</span></td>
					<td><span class="STYLE1">用户姓名</span></td>
					<td><span class="STYLE1">用户密码</span></td>
					<td><span class="STYLE1">联系电话</span></td>
					<td><span class="STYLE1">性别</span></td>
					<td><span class="STYLE1">院系</span></td>
					<td><span class="STYLE1">用户删除</span></td>
					<td><span class="STYLE1">用户修改</span></td>
				</tr>
				<%
					// 获取用户信息集合
					List<User> list = (List<User>) request.getAttribute("list");
					// 判断集合是否有效
					if (list == null || list.size() < 1) {
						out.print("没有用户！");
					} else {
						// 遍历图书集合中的数据
						for (User user : list) {
				%>

				<tr height="50px">
					<td><%=user.getUserid()%></td>
					<td><%=user.getUsername()%></td>
					<td><%=user.getUserpwd()%></td>
					<td><%=user.getUserphone()%></td>
					<td><%=user.getUsersex()%></td>
					<td><%=user.getUserdept()%></td>

					<td><a href="Deleteuserservlet?id=<%=user.getUserid()%>">删除</a></td>
					<td><a
						href="<%=basePath%>manager/updateuser.jsp?id=<%=user.getUserid()%>">修改</a></td>
				</tr>
				<%
					}
					}
				%>
				<tr>
					<td align="center" colspan="8" bgcolor="white"><%=request.getAttribute("bar")%>
					</td>
				</tr>
			</table>
		</div>
		<div>
				<a href="manager/adduser.jsp" target="nav">
					<button type="submit"
						style="width:100px; height: 35px ;margin-left:380px;margin-top:20px">添加用户</button>
				</a>
		</div>
</body>
</html>