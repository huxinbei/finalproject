<!-- 功能：显示添加图书是否成功 
	  作者：胡欣蓓 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加结果</title>
</head>
<body>
	<%
		try {
			out.print("成功添加了 1本书！");
		} catch (Exception e) {
			out.print("图书信息添加失败！");
			e.printStackTrace();
		}
	%>
	<br>
	<a href="addbook.jsp">返回</a>
</body>
</html>