<%@ page import="com.ie.dao.BorrowDao" %>
<%@ page import="com.ie.bean.Book" %>
<%@ page import="com.ie.bean.*" %>
<%@ page import="com.ie.dao.BookDao" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>归还界面</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String bookname = request.getParameter("bookname");
    String date = request.getParameter("date");
    BookDao bookDAo = new BookDao();
    BorrowDao messageDAo = new BorrowDao();
    String username = (String) session.getAttribute("name");
   // System.out.println(name + ":" + book_name);
    boolean flag = messageDAo.check(username,bookname);
    if(flag) {
        out.write("归还 《" + bookname + "》成功");
        Borrow message = new Borrow();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.setdate(df.format(new Date()));
        message.setbookname(bookname);
        message.setusername(username);
        messageDAo.returnmessage(message);
    }
    else {
        out.write("您的操作错误: 尚未借阅本书<br>");
    }
    //out.write();
    //System.out.println();
%><br><br>

</body>
</html>