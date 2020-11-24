<!-- 功能：借书界面，信息提交到BorrowBookServlet
	   作者：王佳怡 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>借书</title>
</head>
<body>
<div style="text-align:center;margin-top: 120px">
<form action="BorrowBookServlet" method="post">
    <table style="margin-left:40%">
        <tr>
            书名：<input type="text" name="bookname" >
        </tr>
        <tr>
            <input type="submit" value="借阅">
        </tr>
    </table>
</form>
</div>
</body>
</html>