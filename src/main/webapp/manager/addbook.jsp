<!-- 功能：添加图书界面，表单内容提交到Addbookservlet -->
<!-- 作者：胡欣蓓 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书信息</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function check(form){
		with(form){
			if(bookname.value == ""){
				alert("图书名称不能为空");
				return false;
			}
			if(number.value == ""){
				alert("数量不能为空");
				return false;
			}
			if(author.value == ""){
				alert("作者不能为空");
				return false;
			}
			if(publisher.value == ""){
				alert("出版社不能为空");
				return false;
			}
			if(category.value == ""){
				alert("类别不能为空");
				return false;
			}
			return true;
		}
	}
</script>
</head>
<body>
	<form action="Addbookservlet" method="post" onsubmit="return check(this);" id="table">
		<table align="center" width="500" cellpadding="4">
			<tr>
				<td align="center" colspan="2">
					<h2>添加图书信息</h2>
					<hr>
				</td>
			</tr>
			<tr>
				<td align="right">图书名称：</td>
				<td><input class="label" type="text" name="bookname" /></td>
			</tr>
			<tr>
				<td align="right">数　　量：</td>
				<td><input class="label" type="text" name="number" /></td>
			</tr>
			<tr>
				<td align="right">作　　者：</td>
				<td><input class="label" type="text" name="author" /></td>
			</tr>
			<tr>
				<td align="right">出版社名：</td>
				<td><input class="label" type="text" name="publisher" /></td>
			</tr>
			<tr>
				<td align="right">类　　别：</td>
				<td><input class="label" type="text" name="category" /></td>
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