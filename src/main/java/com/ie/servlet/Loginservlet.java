/**
 * 功能：获取login.jsp登录信息，根据身份进入相应界面
 * 作者：施淇、朱海潮
 */
package com.ie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class loginservlet
 */
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		HttpSession session=request.getSession();
		session.setAttribute("name", name);
		String password = request.getParameter("password");
		BookUserDao dao = new BookUserDao();
		String identity=request.getParameter("identity");
		PrintWriter out = response.getWriter();
		if(identity.equals("1")==true){
			boolean flag = dao.queryUserbyNameandPwd(name, password);
			if(name==null || password==null){
				out.println(
						"<script language=javascript>alert('用户名或密码不能为空!!');window.location.href='login.jsp';</script>");
			}
			else if (flag) {
				out.println(
						"<script language=javascript>alert('登录成功！！');window.location.href='user/User.jsp';</script>");
			} 
			else {
				out.println(
						"<script language=javascript>alert('用户名或者密码错误！！');window.location.href='login.jsp';</script>");
			}
		}
		else if(identity.equals("2")==true){
			boolean flag1 = dao.queryManagerbyNameandPwd(name, password);
			out.print(flag1);
			if(name==null || password==null){
				out.println(
						"<script language=javascript>alert('图书管理员工号或密码不能为空!!');window.location.href='login.jsp';</script>");
			}
			else if (flag1) {
				DBconnect t=new DBconnect();
				ArrayList<Manager> list = t.queryAllUserAL();
			  	for(int i=0;i<list.size();i++)
			  	{
			  		Manager user=new Manager();
			  		user=list.get(i);
			  		if(user.getmname().equals(name))
			  		{
			  			String root=user.getmroot();
			  			session.setAttribute("root", root);
			  		}
			  	}
				out.println(
						"<script language=javascript>alert('登录成功！！');window.location.href='manager/Manager.jsp';</script>");
			} 
			else {
				out.println(
						"<script language=javascript>alert('图书管理员工号或密码错误！！');window.location.href='login.jsp';</script>");
			}
		}
		else{
			boolean flag2 = dao.querySMbyNameandPwd(name, password);
			if(name==null || password==null){
				out.println(
						"<script language=javascript>alert('超级管理员工号或密码不能为空!!');window.location.href='login.jsp';</script>");
			}
			else if (flag2) {
				out.println(
						"<script language=javascript>alert('登录成功！！');window.location.href='supermanager/Smanager.jsp';</script>");
			} 
			else {
				out.println(
						"<script language=javascript>alert('超级管理员工号或密码错误！！');window.location.href='login.jsp';</script>");
			}
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
