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
			list.add(new Manager(user.getmid(), user.getmname(),user.getmpwd(),user.getmroot()));
			request.setAttribute("list", list);
		}
	%>
	<h1 style="margin-left:380px">管理员权限设置</h1>
	<table
		style="text-align: center; width: 90%; height: 50%; font-size: 17px"
		border="1px" align="center" cellspacing="0px" cellpadding="4">
		<tr>
			<th>id</th>
			<th>姓名</th>
			<th>权限</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="data">
			<tr>
				<td>${data.mid}</td>
				<td>${data.mname}</td>
				<td>${data.mroot}</td>
				<td><a href="rootedit?mid=${data.mid}">赋予权限</a> <a
					href="rootdele?mid=${data.mid}">取消权限</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>