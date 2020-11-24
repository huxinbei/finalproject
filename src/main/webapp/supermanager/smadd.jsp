<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加新的管理员</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<form action="SMadd" method=post id="table">
		<table  align="center" width="500" cellpadding="4">
			<tr>
				<td align="center" colspan="2">
					<h2 align="center">添加图书管理员</h2>
					<hr>
				</td>
			</tr>
			<tr>
				<td width="100" height="55" align="center">请输入id：</td>
				<td width="195"><input class="label" name="mid" height="55" type="text"
					maxlength="20"></td>
			</tr>
			<tr>
				<td width="100" height="55" align="center">请输入姓名：</td>
				<td><input class="label" name="mname" height="40" maxlength="16"></td>
			</tr>
			<tr>
				<td width="100" height="55" align="center">请输入密码：</td>
				<td><input class="label" name="mpwd" type="password" height="40"
					maxlength="16"></td>
			</tr>
			<tr>
				<td align="center" colspan="2" width="100px">
					<input type="submit" style="width:100px; height: 35px" value="添　加">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>