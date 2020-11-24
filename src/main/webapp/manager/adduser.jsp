<!-- 功能：添加用户界面，表单内容提交到Adduserservlet
             作者：胡欣蓓 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户信息</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function check(form){
		with(form){
			if(username.value == ""){
				alert("用户名不能为空");
				return false;
			}
			if(userpwd.value == ""){
				alert("密码不能为空");
				return false;
			}
			if(userphone.value == ""){
				alert("联系电话不能为空");
				return false;
			}
			if(usersex.value == ""){
				alert("性别不能为空");
				return false;
			}
			if(userdept.value == ""){
				alert("院系不能为空");
				return false;
			}
			return true;
		}
	}
</script>
</head>
<body>
	<form action="Adduserservlet" method="post"
		onsubmit="return check(this);" id="table">
		<table align="center" width="500" cellpadding="4">
			<tr>
				<td align="center" colspan="2">
					<h2>添加用户信息</h2>
					<hr>
				</td>
			</tr>
			<tr>
				<td align="right">用户名：</td>
				<td><input class="label" type="text" name="username" /></td>
			</tr>
			<tr>
				<td align="right">密 码：</td>
				<td><input class="label" type="text" name="userpwd" /></td>
			</tr>
			<tr>
				<td align="right">联系电话：</td>
				<td><input class="label" type="text" name="userphone" /></td>
			</tr>
			<tr>
				<td align="right">性 别：</td>
				<td><input class="label" type="text" name="usersex" /></td>
			</tr>
			<tr>
				<td align="right">院 系：</td>
				<td><input class="label" type="text" name="userdept" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" style="width:100px; height: 35px" value="添　加">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>