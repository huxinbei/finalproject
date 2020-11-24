<!-- 功能：修改图书界面，表单内容提交到Updatebookservlet -->
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
		int bookid = Integer.parseInt(request.getParameter("id"));
		BookUserDao CD = new BookUserDao();
		Book book = CD.Queryonebook(bookid);
	%>
	<form action="Updatebookservlet" method="post"
		onsubmit="return check(this);">
		<table border="1px" width="600px" height="400px" align="center"
			cellpadding="0px" cellspacing="0px" bgcolor="white">
			<tr height="80px">
				<td colspan="2" align="center">
					<h2 size="4">图书修改</h2>
				</td>
			</tr>
			<tr>
				<td>图书编号:</td>
				<td><input type="text" name="bookid" style="border:none;height:100%;width:100%"
					value="<%=book.getBookid()%>" size="35px" /></td>
			</tr>
			<tr>
				<td align="left">图书名称:</td>
				<td><input type="text" name="bookname" style="border:none;height:100%;width:100%"
					value="<%=book.getBookname()%>" size="35px" /></td>
			</tr>
			<tr>
				<td align="left">图书库存:</td>
				<td><input type="text" name="number" style="border:none;height:100%;width:100%"
					value="<%=book.getNumber()%>" size="35px" /></td>
			</tr>
			<tr>
				<td align="left">图书作者:</td>
				<td><input type="text" name="author" style="border:none;height:100%;width:100%"
					value="<%=book.getAuthor()%>" size="35px" /></td>
			</tr>
			<tr>
				<td align="left">图书出版社:</td>
				<td><input type="text" name="publisher" border="0" style="border:none;height:100%;width:100%"
					value="<%=book.getPublisher()%>" size="35px" /></td>
			</tr>
			<tr>
				<td align="left">图书类别:</td>
				<td><input type="text" name="category" style="border:none;height:100%;width:100%"
					value="<%=book.getCategory()%>" size="35px" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input name="button"
					type="submit" value="修改" class="button1" /></td>
			</tr>
		</table>
	</form>
</body>
</html>