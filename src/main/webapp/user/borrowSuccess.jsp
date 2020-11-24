<%@ page import="com.ie.dao.BorrowDao" %>
<%@ page import="com.ie.dao.BookDao" %>
<%@ page import="com.ie.bean.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
    <title>借阅成功</title>
</head>
<body>
<%
    String bookname = request.getParameter("bookname");
    int x = (int)request.getAttribute("sum");
   //BookDao bookDAo = new BookDao();
   //Book book = bookDAo.retandborBook(bookname);
   //int x=bookDAo.update(book,1);
    if(x != -1){
        out.write("借阅《" + request.getParameter("bookname") +"》成功");
        String username = (String) session.getAttribute("name");
        Borrow message = new Borrow();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.setdate(df.format(new Date()));
        message.setbookname(bookname);
        message.setusername(username);
        BorrowDao messageDAo = new BorrowDao();
        messageDAo.addMessage(message);
    }
    else
        out.write("《" + request.getParameter("bookname") + "》" + "已全部被借阅");
%><br><br>
</body>
</html>
