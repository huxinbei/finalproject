/**
 * 功能：还书
 * 作者：王佳怡
 */
package com.ie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ie.bean.Book;
import com.ie.dao.BookDao;

/**
 * Servlet implementation class ReturnBookServlet
 */
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String bookname = request.getParameter("bookname");
        BookDao bookDAo = new BookDao();
        Book book = bookDAo.retandborBook(bookname);
        PrintWriter out = response.getWriter();
//        System.out.println("借阅《" + book_name +"》成功");
        if(book==null){
        	out.println("<script language=javascript>alert('这本书不存在！');window.location.href='borrowBook.jsp';</script>");
        }
        else{
	        int sum = bookDAo.update(book,+1);
	        request.getRequestDispatcher("returnSuccess.jsp").forward(request,response);
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
