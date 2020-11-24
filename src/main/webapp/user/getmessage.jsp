<%@ page import="com.ie.bean.Borrow" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ie.dao.BorrowDao" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/11
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看用户借阅情况</title>
</head>
<body>
<%
      String username = (String) session.getAttribute("name");
      BorrowDao messageDAo = new BorrowDao();
      List<Borrow> list = messageDAo.getBorrow(username);
      if(list.size() == 0)
          out.println("您还未借阅任何书籍");
      else {
          for (Borrow list1 : list) {
              out.write("书名：《"+list1.getbookname() + "》 借阅时间：" + list1.getdate());
              out.write("<br>");
          }
      }
%><br>
<hr>

</body>
</html>