/**
 * 功能：分页显示图书信息
 * 作者：施淇
 */
package com.ie.servlet;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ie.bean.Book;
import com.ie.dao.BookUserDao;

public class Showbookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				// 当前页码
		           try {
						int currPage = 1;
						// 判断传递页码是否有效
						if(request.getParameter("page") != null){
							// 对当前页码赋值
							currPage = Integer.parseInt(request.getParameter("page"));
						}
						Class.forName("com.mysql.jdbc.Driver");
						// 数据库连接字符串
						String url = "jdbc:mysql://localhost:3306/finalproject";
						// 数据库用户名
						String username = "root";
						// 数据库密码
						String password = "98715362000";
						// 创建Connection连接
						Connection conn = DriverManager.getConnection(url,username,password);
						// 添加图书信息的SQL语句
						String sql = "select * from book limit ?,?";
						// 获取PreparedStatement
						PreparedStatement ps = conn.prepareStatement(sql);
						// 对SQL语句中的第1个参数赋值
						ps.setInt(1, (currPage - 1) * Book.PAGE_SIZE);
						// 对SQL语句中的第个参数赋值
						ps.setInt(2, Book.PAGE_SIZE);
						// 执行查询
						ResultSet rs = ps.executeQuery();
						// 实例化List对象
						List<Book> list = new ArrayList<Book>();
						// 判断光标向后移动，并判断是否有效
						while(rs.next()){
							// 实例化Book对象
							Book book = new Book();
							// 对bookid属性赋值
							book.setBookid(rs.getInt("bookid"));
							// 对bookname属性赋值
							book.setBookname(rs.getString("bookname"));
							// 对number属性赋值
							book.setNumber(rs.getInt("number"));
							// 对author属性赋值
							book.setAuthor(rs.getString("author"));
							// 对publisher属性赋值
							book.setPublisher(rs.getString("publisher"));
							// 对category属性赋值
							book.setCategory(rs.getString("category"));
							// 将图书对象添加到集合
							list.add(book);
						}
						// 将list放置到request之中
						request.setAttribute("list",list);
						// 总页
						int pages ;
						// 查询总记录数
						BookUserDao dao=new BookUserDao();
						int count = dao.findBookCount();
						// 计算总页
						if(count % Book.PAGE_SIZE == 0){
							// 对页数赋值
							pages = count / Book.PAGE_SIZE;
						}else{
							// 对页数赋值
							pages = count / Book.PAGE_SIZE + 1;
						}
						// 实例化StringBuffer
						StringBuffer sb = new StringBuffer();
						// 通过循环构建分页
						for(int i=1; i <= pages; i++){
							// 判断是否为当前页
							if(i == currPage){
								// 构建分页
								sb.append("『" + i + "』");
							}else{
								// 构建分页
								sb.append("<a href='Showbookservlet?page=" + i + "'>" + i + "</a>");
							}
							// 构建分页
							sb.append("　");
						}
						// 将分页条的字符串放置到request之中
						request.setAttribute("bar", sb.toString());
						rs.close();		// 关闭ResultSet
						ps.close();	// 关闭Statement
						conn.close();	// 关闭Connection
		           } catch (ClassNotFoundException e) {
		   			e.printStackTrace();
		   		} catch (SQLException e) {
		   			e.printStackTrace();
		   		}
						// 转发到booklist.jsp页面
						request.getRequestDispatcher("/user/showBooks.jsp").forward(request, response);
                    } 
}
//		try {
//			// 加载数据库驱动，注册到驱动管理器
//			Class.forName("com.mysql.jdbc.Driver");
//			// 数据库连接字符串
//			String url = "jdbc:mysql://localhost:3306/finalproject";
//			// 数据库用户名
//			String username = "root";
//			// 数据库密�?
//			String password = "98715362000";
//			// 创建Connection连接
//			Connection conn = DriverManager.getConnection(url,username,password);
//			// 获取Statement
//			Statement stmt = conn.createStatement();
//			// 添加图书信息的SQL语句
//			String sql = "select * from book";
//			// 执行查询
//			ResultSet rs = stmt.executeQuery(sql);
//			// 实例化List对象
//			List<Book> list = new ArrayList<Book>();
//			// 判断光标向后移动，并判断是否有效
//			while(rs.next()){
//				// 实例化Book对象
//				Book book = new Book();
//				// 对bookid属�?�赋�?
//				book.setBookid(rs.getInt("bookid"));
//				// 对bookname属�?�赋�?
//				book.setBookname(rs.getString("bookname"));
//				// 对number属�?�赋�?
//				book.setNumber(rs.getInt("number"));
//				// 对author属�?�赋�?
//				book.setAuthor(rs.getString("author"));
//				// 对publisher属�?�赋�?
//				book.setPublisher(rs.getString("publisher"));
//				// 对category属�?�赋�?
//				book.setCategory(rs.getString("category"));
//				// 将图书对象添加到集合�?
//				list.add(book);
//			}
//			// 将图书集合放置到request之中
//			request.setAttribute("list", list);
//			rs.close();		// 关闭ResultSet
//			stmt.close();	// 关闭Statement
//			conn.close();	// 关闭Connection
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		// 请求转发到booklist.jsp
//		request.getRequestDispatcher("booklist2.jsp").forward(request, response);
//	}