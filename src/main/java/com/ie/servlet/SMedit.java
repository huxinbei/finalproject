/**
 * 功能：修改图书管理员信息
 * 作者：朱海潮
 */
package com.ie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ie.bean.*;
import com.ie.dao.*;

/**
 * Servlet implementation class edit
 */
public class SMedit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SMedit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  PrintWriter out = response.getWriter();
		  String mid=request.getParameter("mid");
		  String mname=request.getParameter("mname");
		  String mpwd=request.getParameter("mpwd");
		  String mpwd1=request.getParameter("mpwd1");
		  
		  DBconnect op=new DBconnect();
		  op.deleteUser(mid);
//		  out.print(mpwd1);
//		  out.print(mpwd);
	    if(!mpwd.equals(mpwd1))
	    {
	    	out.println("<script language=javascript>alert('两次密码不一致，请确认！');window.location.href='smedit.jsp';</script>");
	    }
	    else 
	    {
			  Manager user=new Manager();
			  user.setmid(mid);
			  user.setmname(mname);
			  user.setmpwd(mpwd);
			  op.addUser(user);
			  out.println("<script language=javascript>alert('修改信息成功！');window.location.href='design.jsp';</script>");
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