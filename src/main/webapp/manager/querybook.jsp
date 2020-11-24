<!-- 功能：检索图书界面，跳转到检索图书结果界面 -->
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
    
    <title>My JSP 'userquerydeal.jsp' starting page</title>
  </head>
  
  <body>
  <%
  	request.setCharacterEncoding("UTF-8");
     response.setCharacterEncoding("UTF-8");
     ArrayList<Book> search=new ArrayList<Book>();
     String condition=request.getParameter("condition");
     String querykey=request.getParameter("querykey").trim();
     BookUserDao db=new BookUserDao();
     
     if(condition.equals("bookname"))
     {
     search=(ArrayList<Book>)db.QuerybookBybookname(querykey);
     request.setAttribute("booklist",search);
     request.getRequestDispatcher("querybookresult.jsp").forward(request,response);
     }
     else if(condition.equals("author"))
     {
     search=(ArrayList<Book>)db.QuerybookByauthor(querykey);
     request.setAttribute("booklist",search);
     request.getRequestDispatcher("querybookresult.jsp").forward(request,response);
     }
     else if(condition.equals("category"))
     {
     search=(ArrayList<Book>)db.QuerybookBycategory(querykey);
     request.setAttribute("booklist",search);
     request.getRequestDispatcher("querybookresult.jsp").forward(request,response);
     }
  %>
  </body>
</html>