<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>还书</title>
    <style type="text/css">
        body{
            background-repeat: no-repeat;
            background-position: center;
        }
    </style>
</head>
<body>
<div style="text-align:center;margin-top: 120px">
<form action="ReturnBookServlet" method="post">
    <table style="margin-left:40%">

        <tr>
            书名：<input type="text" name="bookname">
        </tr>
        <tr>
            <input type="submit" value="归还">
        </tr>
    </table>
</form>
</div>
</body>
</html>