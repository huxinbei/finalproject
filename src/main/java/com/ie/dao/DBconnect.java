/**
 * 功能：数据库连接；增删查改超级管理员
 * 作者：朱海潮
 */
package com.ie.dao;

import java.sql.*;
import java.util.*;
import com.ie.bean.*;

public class DBconnect {
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	private int result;
	public Connection getConnection()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动错误!");
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject?useUnicode=true&characterEncoding=utf8","root","98715362000");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return conn;
	} 
	public void releaseDB(ResultSet rs,PreparedStatement pstm,Connection conn)
			{
				if(rs!=null)
				{
					try{
						rs.close();
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
				if(pstm!=null)
				{
					try {
						pstm.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn!=null)
				{
					try{
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
	public void allUser()
	{
		conn = getConnection();
		try {
			pstm = conn.prepareStatement("select * from manager");
			rs = pstm.executeQuery();
			while(rs.next())
			{
				String mid = rs.getString("mid");
				String mname= rs.getString("mname");
				String mpwd= rs.getString("mpwd");
				System.out.println("id："+mid+"姓名："+mid+"密码："+mpwd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			releaseDB(rs,pstm,conn);
		}
	}
	public ArrayList<Manager> queryAllUserAL()
	{
		conn = getConnection();
		ArrayList<Manager> userlist=new ArrayList<Manager>();
		try {
			pstm = conn.prepareStatement("select * from manager");
			rs=pstm.executeQuery();
			while(rs.next())
			{
				Manager user=new Manager();
				user.setmid(rs.getString("mid"));
				user.setmname(rs.getString("mname"));
				user.setmpwd(rs.getString("mpwd"));
				user.setmroot(rs.getString("mroot"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userlist;
	}
	//添加超级管理员
	public int addUser(String mid,String mname,String mpwd,String mroot)
	{
		conn=getConnection();
		try
		{
			pstm=conn.prepareStatement("insert into manager set mid=?,mname=?,mpwd=?");
			pstm.setString(1, mid);
			pstm.setString(2, mname);
			pstm.setString(3, mpwd);
			pstm.setString(4, mroot);
			result=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			releaseDB(rs,pstm,conn);
			}
			return result;
	}
	//添加超级管理员（封装）
	public int addUser(Manager user)
	{
		conn=getConnection();
		try {
				pstm=conn.prepareStatement("insert into manager	 set mid=?,mname=?,mpwd=?,mroot=?");
				 pstm.setString(1, user.getmid());
				 pstm.setString(2, user.getmname());
				 pstm.setString(3, user.getmpwd());
				 pstm.setString(4, user.getmroot());
				 result=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		} finally{
				releaseDB(rs,pstm,conn);
				}
			return result;
	}
	//修改超级管理员
	public int updateUser(Manager user,String mid)
	{
		conn=getConnection();
		try {
				pstm=conn.prepareStatement("update manager set mid=?,mname=?,mpwd=?，mroot=?");
				pstm.setString(1, mid);
				pstm.setString(2, user.getmname());
				pstm.setString(3, user.getmpwd());
				pstm.setString(4, user.getmroot());
				result=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
				releaseDB(rs,pstm,conn);
				}
			return result;
	}
	//查询超级管理员是否存在
	public boolean queryUserbyName(String mid)
	{
		conn=getConnection();
		boolean flag=false;
		
		String sql="select * from manager where mid=?";
		try
		{
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, mid);
			rs=pstm.executeQuery();
			while(rs.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			releaseDB(rs,pstm,conn);
		}
		return flag;
	}
	//删除超级管理员
	public int deleteUser(String mid)
	{
		conn=getConnection();
		try {
				pstm=conn.prepareStatement("delete from manager where mid=?");
				pstm.setString(1, mid);
				result=pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			} finally{
					releaseDB(rs,pstm,conn);
			}
				return result;
	}
	
	//
	
	//查询总记录数
	public int findCount(){
		// 总记录数
		int count = 0;
		// 获取数据库连接
		Connection conn = getConnection();
		// 查询总记录数SQL语句
		String sql = "select count(*) from book";
		try {
			// 创建Statement
			Statement stmt = conn.createStatement();
			// 查询并获取ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			// 光标向后移动，并判断是否有效
			if(rs.next()){
				// 对总记录数赋值
				count = rs.getInt(1);
			}
			// 关闭ResultSet
			rs.close();
			// 关闭Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 返回总记录数
		return count;
	}

	
	
	public static void main(String[] args) {
		  DBconnect t=new DBconnect();
		  	Connection conn = t.getConnection();
		  	if(!conn.equals(null))
		  	{
		  		System.out.println("数据库连接成功");
		  	}
		  	ArrayList<Manager> list = t.queryAllUserAL();//---模拟开发中jsp调用数据，用for循环遍历查询数据
		  	for(int i=0;i<list.size();i++)
		  	{
		  		Manager user=new Manager();
		  		user=list.get(i);
		  		System.out.print(user.getmid()+"---");
		  		System.out.print(user.getmname()+"---");
		  		System.out.print(user.getmpwd());
		  		System.out.println(user.getmroot());
		  		System.out.println();
		  	}
		  	System.out.println();
		  	for(int i=0;i<list.size();i++)
		  	{
		  		Manager user=new Manager();
		  		user=list.get(i);
		  		System.out.print(user.getmid()+"---");
		  		System.out.print(user.getmname()+"---");
		  		System.out.print(user.getmpwd());
		  		System.out.println();
		  	}
		}
}
