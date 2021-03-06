/**
 * 功能：获取updatebook.jsp修改图书信息表单，修改图书
 * 作者：胡欣蓓
 */
package com.ie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.ie.bean.Manager;
import com.ie.dao.BookUserDao;
import com.ie.dao.DBconnect;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 修改图书信息的Servlet
 */
public class Updatebookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 处理GET请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int bookid = Integer.valueOf(request.getParameter("bookid"));
		String bookname = request.getParameter("bookname");
		int number = Integer.valueOf(request.getParameter("number"));
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String category = request.getParameter("category");
		HttpSession session=request.getSession();
		String aroot=(String) session.getAttribute("root");
//		if(aroot.equals("Yes")) {
			try {
				// 加载数据库驱动，注册到驱动管理器
				Class.forName("com.mysql.jdbc.Driver");
				// 数据库连接字符串
				String url = "jdbc:mysql://localhost:3306/finalproject";
				// 数据库用户名
				String username = "root";
				// 数据库密码
				String password = "98715362000";
				// 创建Connection连接
				Connection conn = DriverManager.getConnection(url,username,password);
				// 更新SQL语句
				String sql = "update book set bookname=?,number=?,author=?,publisher=?,category=? where bookid=?";
				// 获取PreparedStatement
				PreparedStatement ps = conn.prepareStatement(sql);
				// 对SQL语句中的第一个参数赋值
				ps.setString(1, bookname);
				// 对SQL语句中的第二个参数赋值
				ps.setInt(2, number);
				// 对SQL语句中的第三个参数赋值
				ps.setString(3, author);
				// 对SQL语句中的第四个参数赋值
				ps.setString(4, publisher);
				// 对SQL语句中的第五个参数赋值
				ps.setString(5, category);
				// 对SQL语句中的第六个参数赋值
				ps.setInt(6, bookid);
				// 执行更新操作
				ps.executeUpdate();
				// 关闭PreparedStatement
				ps.close();
				// 关闭Connection
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
//		}
//		else
//		{
//			 out.println("<script language=javascript>alert('您无权限！');</script>");
//		}
		// 重定向到Findbookservlet
		response.sendRedirect("Findbookservlet");
	}

}
