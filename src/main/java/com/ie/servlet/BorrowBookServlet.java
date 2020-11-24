/**
 * 功能：借书
 * 作者：王佳怡
 */
package com.ie.servlet;

import com.ie.bean.Book;
import com.ie.dao.BookDao;
import com.ie.dao.BorrowDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class BorrowBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag=false;
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        String username = (String) session.getAttribute("name");
        String bookname = request.getParameter("bookname");
        BookDao bookDAo = new BookDao();
        BorrowDao borrowdao = new BorrowDao();
        Book book = bookDAo.retandborBook(bookname);
        PrintWriter out = response.getWriter();
        flag = borrowdao.check(username, bookname);//borrow表中是否存在借阅记录
//        System.out.println("借阅《" + book_name +"》成功");
        if(book==null){
        	out.println("<script language=javascript>alert('这本书不存在！');window.location.href='borrowBook.jsp';</script>");
        }
        else if(flag==true){
        	out.println("<script language=javascript>alert('您已借阅这本书！');window.location.href='borrowBook.jsp';</script>");
        }
        else{
	        int sum = bookDAo.update(book,-1);
	        if(sum>=0){
	        	request.setAttribute("sum",sum);      
	        	out.println("<script language=javascript>alert('借阅成功！');window.location.href='borrowBook.jsp';</script>");
	        	request.getRequestDispatcher("borrowSuccess.jsp").forward(request,response);
	        }
	        else{
	        	out.println("<script language=javascript>alert('这本书已被借阅完！');window.location.href='borrowBook.jsp';</script>");
	        }
        }

//        PrintWriter printWriter = response.getWriter();
//        printWriter.write("借阅《" + book_name +"》成功");
        
    }
}
