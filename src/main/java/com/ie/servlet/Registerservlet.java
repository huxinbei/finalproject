/**
 * 功能：获取register.jsp表单信息，注册用户
 * 作者：施淇
 */
package com.ie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registerservlet
 */
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String userphone = request.getParameter("userphone");
		String usersex = request.getParameter("usersex");
		String userdept = request.getParameter("userdept");
		try {
			// 加载数据库驱动，注册到驱动管理器
						Class.forName("com.mysql.jdbc.Driver");
						// 数据库连接字符串
						String url = "jdbc:mysql://localhost:3306/finalproject";
						// 数据库用户名
						String usename = "root";
						// 数据库密码
						String password = "98715362000";
						// 创建Connection连接
						Connection conn = DriverManager.getConnection(url,usename,password);
						// 添加图书信息的SQL语句
						String sql = "insert into user(username,userpwd,userphone,usersex,userdept) values(?,?,?,?,?)";
						// 获取PreparedStatement
						PreparedStatement ps = conn.prepareStatement(sql);
						// 对SQL语句中的第1个参数赋值
						ps.setString(1, username);
						// 对SQL语句中的第2个参数赋值
						ps.setString(2, userpwd);
						// 对SQL语句中的第3个参数赋值
						ps.setString(3,userphone);
						// 对SQL语句中的第4个参数赋值
						ps.setString(4, usersex);
						// 对SQL语句中的第5个参数赋值
						ps.setString(5, userdept);
						// 执行更新操作，返回所影响的行数
						int row = ps.executeUpdate();
						// 判断是否更新成功
						PrintWriter out = response.getWriter();
						if(row > 0){
							// 更新成输出信息
							//response.sendRedirect("registerdeal.jsp");
							out.println("<script language=javascript>alert('注册成功！');window.location.href='login.jsp';</script>");
						}
						// 关闭PreparedStatement，释放资源
						ps.close();
						// 关闭Connection，释放资源
						conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
