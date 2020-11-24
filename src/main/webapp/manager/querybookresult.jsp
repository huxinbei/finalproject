<!-- 功能：检索图书结果界面，将检索到的结果显示出来 -->
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
    <td align="center">图书名称</td>
    <td align="center">图书数量</td>
    <td align="center">图书作者</td>
    <td align="center">图书出版社</td>
    <td align="center">图书类别</td>
    </tr>
    <%
    ArrayList<Book> list=(ArrayList<Book>)request.getAttribute("booklist");
    Iterator<Book> it=list.iterator();
    while(it.hasNext())
    {
    Book book=it.next();
    %>
    <tr height="40px">
	<td align="center"><%=book.getBookname() %></td>
	<td align="center"><%=book.getNumber() %></td>
	<td align="center"><%=book.getAuthor() %></td>
	<td align="center"><%=book.getPublisher() %></td>
	<td align="center"><%=book.getCategory() %></td>
     </tr>
     <%
     }
      %>
    </table>
  </body>
</html>