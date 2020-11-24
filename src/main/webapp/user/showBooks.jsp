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
			<form action="<%=basePath%>manager/querybook.jsp" method="post">
				<div style="width: 90%; float: left">
					<div style="float: right; padding: 30px; margin-top: 10px;">
						<span style="float: center; font-size: 16px;">图书查询：</span> <select
							name="condition"
							style="width: 100px; height: 35px; float: center;">

							<option value="bookname">图书名称</option>
							<option value="author">图书作者</option>
							<option value="category">图书类别</option>
						</select> <input type="text" name="querykey"
							style="width: 200px; height: 30px; float: center;">
						<button type="submit" style="width: 100px; height: 35px">检索</button>
					</div>
				</div>
				`
			</form>
		</div>
		<div style="width: 100%;" align="center">
			<table
				style="text-align: center; width: 100%; height: 100%; font-size: 17px"
				border="1px" align="center" cellspacing="0px" cellpadding="4">
				<tr height="50px">
					<td><span class="STYLE1">图书编号</span></td>
					<td><span class="STYLE1">图书标题</span></td>
					<td><span class="STYLE1">图书库存</span></td>
					<td><span class="STYLE1">图书作者</span></td>
					<td><span class="STYLE1">图书出版社</span></td>
					<td><span class="STYLE1">图书类别</span></td>
				</tr>
				<%
					// 获取图书信息集合
					List<Book> list = (List<Book>) request.getAttribute("list");
					// 判断集合是否有效
					if (list == null || list.size() < 1) {
						out.print("没有图书！");
					} else {
						// 遍历图书集合中的数据
						for (Book book : list) {
				%>

				<tr height="50px">
					<td><%=book.getBookid()%></td>
					<td><%=book.getBookname()%></td>
					<td><%=book.getNumber()%></td>
					<td><%=book.getAuthor()%></td>
					<td><%=book.getPublisher()%></td>
					<td><%=book.getCategory()%></td>
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
</body>
</html>