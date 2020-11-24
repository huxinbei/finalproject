<!-- 功能：检索用户结果界面，将检索到的结果显示出来 -->
<!-- 作者：胡欣蓓 -->
<%@ page language="java" import="java.util.*,com.ie.dao.*,com.ie.bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userqueryresult.jsp' starting page</title>
  </head>
  
  <body>
    <div style="border-bottom:solid#CCCCCC1px;margin-top:10px;"></div>
    <div style="width:100%;margin-top:100px;margin-left:100px;"align="Left"></div>
    <table  border="1px" width="600px" align="center" cellpadding="0px" cellspacing="0px">
    <tr height="40px">
    <td align="center">用户名</td>
    <td align="center">密码</td>
    <td align="center">联系电话</td>
    <td align="center">性别</td>
    <td align="center">院系</td>
    </tr>
    <%
    ArrayList<User> list=(ArrayList<User>)request.getAttribute("userlist");
    Iterator<User> it=list.iterator();
    while(it.hasNext())
    {
    User user=it.next();
    %>
    <tr height="40px">
	<td align="center"><%=user.getUsername() %></td>
	<td align="center"><%=user.getUserpwd() %></td>
	<td align="center"><%=user.getUserphone() %></td>
	<td align="center"><%=user.getUsersex() %></td>
	<td align="center"><%=user.getUserdept() %></td>
     </tr>
     <%
     }
      %>
    </table>
  </body>
</html>