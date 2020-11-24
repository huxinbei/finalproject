/**
 * 功能：连接数据库；删除用户信息
 * 作者：胡欣蓓
 */
package com.ie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 删除用户信息的Servlet
 */
public class Deleteuserservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 处理GET请求
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int userid=Integer.valueOf(request.getParameter("id"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/finalproject";
			String username="root";
			String password="98715362000";
			Connection conn=DriverManager.getConnection(url,username,password);
			String sql="delete from user where userid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,userid);
			int i = ps.executeUpdate();
			// 判断是否更新成功
			if(i > 0){
				// 更新成输出信息
				out.println("<script language=javascript>alert('删除成功！');window.location.href='manager/Manager.jsp';</script>");
			}
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
