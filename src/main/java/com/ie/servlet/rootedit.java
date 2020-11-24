package com.ie.servlet;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import com.ie.dao.*;

import com.ie.bean.Manager;

/**
 * Servlet implementation class rootedit
 */
public class rootedit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rootedit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
		String mid= request.getParameter("mid");
		DBconnect t=new DBconnect();
		ArrayList<Manager> list = t.queryAllUserAL();
	  	for(int i=0;i<list.size();i++)
	  	{
	  		Manager user=new Manager();
	  		user=list.get(i);
//	  		out.print(user.getmroot());
	  		if(mid.equals(user.getmid()))
	  		{
	  			if(user.getmroot().equals("Yes"))
	  			{
	  				out.println("<script language=javascript>alert('用户已拥有权限!');window.location.href='supermanager/root.jsp';</script>");
	  			}
	  			else {
	  				out.println("<script language=javascript>alert('修改权限成功!');window.location.href='supermanager/root.jsp';</script>");
	  				t.deleteUser(mid);
	  				String mpwd=user.getmpwd();
	  				String mname=user.getmname();
	  				String mroot="Yes";
	  				Manager user1=new Manager();
	  				user1.setmid(mid);
	  				user1.setmname(mname);
	  				user1.setmpwd(mpwd);
	  				user1.setmroot(mroot);
	  				t.addUser(user1);
	  			}
	  		}
	  	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
