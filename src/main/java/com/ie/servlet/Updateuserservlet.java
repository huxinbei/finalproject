/**
 * 功能：获取updateuser.jsp修改用户信息表单，修改用户
 * 作者：胡欣蓓
 */
package com.ie.servlet;

import java.io.IOException;


import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 修改用户信息的Servlet
 */
public class Updateuserservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 处理GET请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.valueOf(request.getParameter("userid"));
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
			// 更新SQL语句
			String sql = "update user set username=?,userpwd=?,userphone=?,usersex=?,userdept=? where userid=?";
			// 获取PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// 对SQL语句中的第一个参数赋值
			ps.setString(1, username);
			// 对SQL语句中的第二个参数赋值
			ps.setString(2, userpwd);
			// 对SQL语句中的第三个参数赋值
			ps.setString(3, userphone);
			// 对SQL语句中的第四个参数赋值
			ps.setString(4, usersex);
			// 对SQL语句中的第五个参数赋值
			ps.setString(5, userdept);
			// 对SQL语句中的第六个参数赋值
			ps.setInt(6, userid);
			// 执行更新操作
			ps.executeUpdate();
			// 关闭PreparedStatement
			ps.close();
			// 关闭Connection
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		// 重定向到Finduserservlet
		response.sendRedirect("Finduserservlet");
	}

}
