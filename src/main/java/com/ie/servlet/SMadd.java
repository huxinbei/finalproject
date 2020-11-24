/**
 * 功能：添加图书管理员信息
 * 作者：朱海潮
 */
package com.ie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ie.bean.*;
import com.ie.dao.*;
import java.io.*;

/**
 * Servlet implementation class AddManager
 */
public class SMadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SMadd() {
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
	  String mid=request.getParameter("mid");
	  String mname=request.getParameter("mname");
	  String mpwd=request.getParameter("mpwd");
	  String mroot = "Yes";
	  
	  DBconnect op=new DBconnect();
	  boolean flag=op.queryUserbyName(mid);
	  if(flag)
	  {
	  out.println("<script language=javascript>alert('该id已存在，请更换id！');window.location.href='supermanager/design.jsp';</script>");
	  }
	  else
	  {
	  Manager user=new Manager();
	  user.setmid(mid);
	  user.setmname(mname);
	  user.setmpwd(mpwd);
	  user.setmroot(mroot);
//	  out.print(mid);
//	  out.print(mname);
//	  out.print(mpwd);
	  if(mid!=mname)
	  {
		  int i = op.addUser(user);
		  if(i>0)
		  {
		  out.println("<script language=javascript>alert('添加成功！');window.location.href='design.jsp';</script>");
		  
		  }
		  else
		  {
		   out.println("<script language=javascript>alert('添加失败！');window.location.href='design.jsp';</script>");
		   }
	  }
	  else
	  {
		  out.println("<script language=javascript>alert('id不能为空！');window.location.href='design.jsp';</script>");
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
