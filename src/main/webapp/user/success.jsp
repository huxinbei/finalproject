<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录成功页面</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    session.setAttribute("username",username);
%>
<center>
<h1>登录成功</h1>
<hr>
<a href="/showBooks.jsp">查看剩余书籍情况</a>
<br>
<a href="/returnBook.jsp">还书</a><br>
<a href="/borrowBook.jsp">借书</a><br>
<br>
<a href="/loginout.jsp">注销</a><br><br>
    <a href="/getmessage.jsp">查看借阅情况</a>
</center>
</body>
</html>