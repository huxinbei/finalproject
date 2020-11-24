<!-- 功能：查看图书管理员信息，删除管理员
             作者：朱海潮 -->
<%@ page language="java" import="java.util.*,com.ie.dao.*,com.ie.bean.*"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<style type="text/css">
table {
	width: 600px;
	height: 300px;
}

td {
	text-align: center;
}
</style>
</head>

<body>
	<%
		DBconnect t = new DBconnect();
		ArrayList<Manager> list1 = t.queryAllUserAL();
		List<Manager> list = new ArrayList<Manager>();
		for (int i = 0; i < list1.size(); i++) {
			Manager user = new Manager();
			user = list1.get(i);
			list.add(new Manager(user.getmid(), user.getmname(), user.getmpwd(),user.getmroot()));
			request.setAttribute("list", list);
		}
	%>
	<h1 style="margin-left:380px">管理员信息</h1>
	<table
		style="text-align: center; width: 90%; height: 50%; font-size: 17px"
		border="1px" align="center" cellspacing="0px" cellpadding="4">
		<tr>
			<th>id</th>
			<th>姓名</th>
			<th>密码</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="data">
			<tr>
				<td>${data.mid}</td>
				<td>${data.mname}</td>
				<td>${data.mpwd}</td>
				<td><a href="supermanager/smedit.jsp?mid=${data.mid}">修改</a> <a
					href="SMdelete?mid=${data.mid}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="supermanager/smadd.jsp"> <button type="submit"
						style="width:140px; height: 35px ;margin-left:380px;margin-top:20px">添加图书管理员</button></a>
	</div>
</body>
</html>