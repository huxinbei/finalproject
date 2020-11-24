<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户</title>
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
<header id="header">
	<!-- 导航部分  -->
	<div class="pilot">
		<h1 class="logo">图书管理系统登陆界面</h1>
		<nav>
			<ul class="link">
				<li><a href="register.jsp">用户注册</a></li>
				<li class="active"><a href="login.jsp">首页</a></li>
			</ul>
		</nav>
	</div>
</header>

<div id="login">
	<img src="img/login.jpg">
	<div class="center"></div>
	<div class="content">
		<h1 class="word1" align="center">用户注册</h1><br>
		<form action="Registerservlet" method="post" onsubmit="return check(this);">
			<table cellpadding="6" class="word2">
				<tr>
					<td align="right"><label for="username">用户名</label></td>
					<td><input id="username" class="label2" type="text" name="username" /></td>
				</tr>
				<tr>
					<td align="right"><label for="userpwd">密    码</label></td>
					<td><input id="userpwd" class="label2" type="password" name="userpwd" /></td>
				</tr>
				<tr>
					<td align="right"><label for="userphone">联系电话</label></td>
					<td><input id="userphone" class="label2" type="text" name="userphone" /></td>
				</tr>
				<tr>
					<td align="right"><label>性     别</label></td>
					
					<td><input class="label2" type="text" name="usersex" /></td>
				</tr>
				<tr>
					<td align="right"><label for="userdept">院     系</label></td>
					<td><input id="userdept" class="label2" type="text" name="userdept" /></td>
				</tr>
			</table>
			<input class="submit2" type="submit" value="注册">
		</form>
	</div>
</div>

<div id="body">
	<section class="center">
		<h2>文献网站</h2>
		<p>国内文献检索网站、国外文献检索</p>
	</section>
	<figure>
		<img alt="检索文献" src="img/cnki.png">
		<figcaption>
			<div class="book_title">
				<strong class="title">中国知网知识发现网络平台-面向海内外读者提供中国学术文献、外文文献、学位论文、报纸、会议、年鉴、工具书等各类资源统一检索、统一导航、在线阅读和下载服务。</strong>
			</div>
		</figcaption>
	</figure>
	<figure>
		<img alt="检索文献" src="img/wanfang.jpg">
		<figcaption>
			<div class="book_title">
				<strong class="title">万方数据库是由万方数据公司开发的，涵盖期刊、会议纪要、论文、学术成果、学术会议论文的大型网络数据库</strong>
			</div>
		</figcaption>
	</figure>
	<figure>
		<img alt="检索文献" src="img/njxz.jpg">
		<figcaption>
			<div class="book_title">
				<strong class="title">南京晓庄学院是南京市属全日制公办本科院校，办学历史可追溯至1927年3月陶行知先生创办的晓庄试验乡村师范。</strong>
			</div>
		</figcaption>
	</figure>
</div>

<footer id="footer">
	<div class="top sm-hidden">
		<div class="block left">
			<h2>合作伙伴</h2>
			<hr>
			<ul>
				<li>南京晓庄学院</li>
				<li>知网</li>
				<li>维普</li>
			</ul>
		</div>
		<div class="block center">
			<h2>图书信息</h2>
			<hr>
			<ul>
				<li>图书价格？</li>
				<li>图书信息是否准确</li>
			</ul>
		</div>
		<div class="block right">
			<h2>联系方式</h2>
			<hr>
			<ul>
				<li>电话：88888888888</li>
				<li>邮件：66666666666</li>
				<li>地址：南京晓庄学院</li>
			</ul>
		</div>
	</div>
	
	<div class="clearfix"></div>
	
	<div class="version sm-visible">
		客户端 | 触屏版 | 电脑版
	</div>
	
	<div class="bottom">
		Copyright © 图书管理系统<span class="sm-hidden"> | 网站许可证：S-QWJYHXBZ-HC</span>
	</div>
</footer>
</body>
</html>