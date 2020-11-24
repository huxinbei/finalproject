<!-- 功能：检索用户界面，跳转到检索用户结果界面 -->
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
     ArrayList<User> search=new ArrayList<User>();
     String condition=request.getParameter("condition");
     String querykey=request.getParameter("querykey").trim();
     BookUserDao db=new BookUserDao();
     
     if(condition.equals("username"))
     {
     search=(ArrayList<User>)db.QueryuserByusername(querykey);
     request.setAttribute("userlist",search);
     request.getRequestDispatcher("queryuserresult.jsp").forward(request,response);
     }
     else if(condition.equals("userdept"))
     {
     search=(ArrayList<User>)db.QueryuserByuserdept(querykey);
     request.setAttribute("userlist",search);
     request.getRequestDispatcher("queryuserresult.jsp").forward(request,response);
     }
  %>
  </body>
</html>