/**
 * 功能：连接数据库；查看图书；检索图书或用户
 * 作者：胡欣蓓
 * 功能：分页；根据用户名与密码判断数据库中是否存在用户、管理员、超级管理员
 * 作者：施淇
 */

package com.ie.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ie.bean.Book;
import com.ie.bean.User;

public class BookUserDao {
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	public boolean flags = false;
	//---------------------------连接数据库--------------------------------
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/finalproject?useUnicode=true&characterEncoding=utf8", "root", "98715362000");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("链接字符串出错！");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动加载出错！");
		}
		return conn;
	}
	
	//分页查询所有书本信息
//		public List<Book> find(int page){
//			// 创建List
//			List<Book> list = new ArrayList<Book>();
//			// 获取数据库连接
//			Connection conn = getConnection();
//			// 分页查询的SQL语句
//			String sql = "select * from book limit ?,?";
//			try {
//				// 获取PreparedStatement
//				PreparedStatement ps = conn.prepareStatement(sql);
//				// 对SQL语句中的第1个参数赋值
//				ps.setInt(1, (page - 1) * Book.PAGE_SIZE);
//				// 对SQL语句中的第2个参数赋值
//				ps.setInt(2, Book.PAGE_SIZE);
//				// 执行查询操作
//				ResultSet rs = ps.executeQuery();
//				// 光标向后移动，并判断是否有效
//				while(rs.next()){
//					// 实例化Product
//					Book b = new Book();
//					// 对bookid属性赋值
//					b.setBookid(rs.getInt("bookid"));
//					// 对bookname属性赋值
//					b.setBookname(rs.getString("bookname"));
//					// 对number属性赋值
//					b.setNumber(rs.getInt("number"));
//					// 对author属性赋值
//					b.setAuthor(rs.getString("author"));
//					// 对publisher属性赋值
//					b.setPublisher(rs.getString("publisher"));
//					//对category属性赋值
//					b.setCategory(rs.getString("category"));
//					// 将Book添加到List集合中
//					list.add(b);
//				}
//				// 关闭ResultSet
//				rs.close();
//				// 关闭PreparedStatement
//				ps.close();
//				// 关闭Connection
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return list;
//		}
		
		//查询总记录数
		public int findBookCount(){
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
		
		
		//查询总记录数
				public int findUserCount(){
					// 总记录数
					int count = 0;
					// 获取数据库连接
					Connection conn = getConnection();
					// 查询总记录数SQL语句
					String sql = "select count(*) from user";
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
		
	//------------------查看所有图书-2ArrayList<Book>存储------------------------
	public ArrayList<Book> queryAllBookAL()
	{
		conn = getConnection();
		ArrayList<Book> userlist = new ArrayList<Book>();
		
			try {
				pstm = (PreparedStatement) conn.prepareStatement("select * from book");
				rs = (ResultSet) pstm.executeQuery();
				while(rs.next())
				{
					Book book = new Book();
					book.setBookid(rs.getInt("bookid"));
					book.setBookname(rs.getString("bookname"));
					book.setNumber(rs.getInt("number"));
					book.setAuthor(rs.getString("author"));
					book.setPublisher(rs.getString("publisher"));
					book.setCategory(rs.getString("category"));
					userlist.add(book);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				releaseDB(rs,pstm,conn);
			}
			return userlist;
	
		}
	
	 //查询用户by bookname ArrayList存储
	 public ArrayList<Book> QuerybookBybookname(String bookname)
	 {
		 conn=getConnection();
		 ArrayList<Book> list=new ArrayList<Book>();
		 String sql="select*from book where bookname=?";
		 try{
			 pstm=(PreparedStatement)conn.prepareStatement(sql);
			 pstm.setString(1,bookname);
			 rs=(ResultSet)pstm.executeQuery();
			 while(rs.next())
			 {
				 Book book=new Book();
	             book.setBookname(rs.getString("bookname"));
	             book.setNumber(rs.getInt("number"));
	             book.setAuthor(rs.getString("author"));
	             book.setPublisher(rs.getString("publisher"));
                 book.setCategory(rs.getString("category"));
	             list.add(book);
			 }
		 } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            releaseDB(rs, pstm, conn);
	        }
	        return list;
	    }
	 
	//查询用户by author ArrayList存储
		 public ArrayList<Book> QuerybookByauthor(String author)
		 {
			 conn=getConnection();
			 ArrayList<Book> list=new ArrayList<Book>();
			 String sql="select*from book where author=?";
			 try{
				 pstm=(PreparedStatement)conn.prepareStatement(sql);
				 pstm.setString(1,author);
				 rs=(ResultSet)pstm.executeQuery();
				 while(rs.next())
				 {
					 Book book=new Book();
		             book.setBookname(rs.getString("bookname"));
		             book.setNumber(rs.getInt("number"));
		             book.setAuthor(rs.getString("author"));
		             book.setPublisher(rs.getString("publisher"));
	                 book.setCategory(rs.getString("category"));
		             list.add(book);
				 }
			 } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            releaseDB(rs, pstm, conn);
		        }
		        return list;
		    }
		 
		//查询用户by category ArrayList存储
		 public ArrayList<Book> QuerybookBycategory(String category)
		 {
			 conn=getConnection();
			 ArrayList<Book> list=new ArrayList<Book>();
			 String sql="select*from book where category=?";
			 try{
				 pstm=(PreparedStatement)conn.prepareStatement(sql);
				 pstm.setString(1,category);
				 rs=(ResultSet)pstm.executeQuery();
				 while(rs.next())
				 {
					 Book book=new Book();
		             book.setBookname(rs.getString("bookname"));
		             book.setNumber(rs.getInt("number"));
		             book.setAuthor(rs.getString("author"));
		             book.setPublisher(rs.getString("publisher"));
	                 book.setCategory(rs.getString("category"));
		             list.add(book);
				 }
			 } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            releaseDB(rs, pstm, conn);
		        }
		        return list;
		    }
		 
	//********根据id返回某一本书*******************
	public Book Queryonebook(int bookid)
	{
		conn=getConnection();
		Book book=new Book();
		String sql="select * from book where bookid=?";
		try{
			pstm=(PreparedStatement)conn.prepareStatement(sql);
			pstm.setInt(1,bookid);
			rs=(ResultSet) pstm.executeQuery();
			while(rs.next())
			{
				book.setBookid(rs.getInt("bookid"));
				book.setBookname(rs.getString("bookname"));
				book.setNumber(rs.getInt("number"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setCategory(rs.getString("category"));
				}
		}catch(SQLException e)
		{
			e.printStackTrace();
			
		}finally{
			releaseDB(rs,pstm,conn);
		}
		return book;
}
	
	
	
	//------------------查看所有用户-2ArrayList<User>存储------------------------
		public ArrayList<User> queryAllUserAL()
		{
			conn = getConnection();
			ArrayList<User> userlist = new ArrayList<User>();
			
				try {
					pstm = (PreparedStatement) conn.prepareStatement("select * from user");
					rs = (ResultSet) pstm.executeQuery();
					while(rs.next())
					{
						User user = new User();
						user.setUserid(rs.getInt("userid"));
						user.setUsername(rs.getString("username"));
						user.setUserpwd(rs.getString("userpwd"));
						user.setUserphone(rs.getString("userphone"));
						user.setUsersex(rs.getString("usersex"));
						user.setUserdept(rs.getString("userdept"));
						userlist.add(user);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					releaseDB(rs,pstm,conn);
				}
				return userlist;
		
			}
		
		//********根据id返回某一个用户*******************
		public User Queryoneuser(int userid)
		{
			conn=getConnection();
			User user=new User();
			String sql="select * from user where userid=?";
			try{
				pstm=(PreparedStatement)conn.prepareStatement(sql);
				pstm.setInt(1,userid);
				rs=(ResultSet) pstm.executeQuery();
				while(rs.next())
				{
					user.setUserid(rs.getInt("userid"));
					user.setUsername(rs.getString("username"));
					user.setUserpwd(rs.getString("userpwd"));
					user.setUserphone(rs.getString("userphone"));
					user.setUsersex(rs.getString("usersex"));
					user.setUserdept(rs.getString("userdept"));
					}
			}catch(SQLException e)
			{
				e.printStackTrace();
				
			}finally{
				releaseDB(rs,pstm,conn);
			}
			return user;
	}
	
		
		//查询用户by username ArrayList存储
		 public ArrayList<User> QueryuserByusername(String username)
		 {
			 conn=getConnection();
			 ArrayList<User> list=new ArrayList<User>();
			 String sql="select*from user where username=?";
			 try{
				 pstm=(PreparedStatement)conn.prepareStatement(sql);
				 pstm.setString(1,username);
				 rs=(ResultSet)pstm.executeQuery();
				 while(rs.next())
				 {
					 User user=new User();
		             user.setUsername(rs.getString("username"));
		             user.setUserpwd(rs.getString("userpwd"));
		             user.setUserphone(rs.getString("userphone"));
		             user.setUsersex(rs.getString("usersex"));
	                 user.setUserdept(rs.getString("userdept"));
		             list.add(user);
				 }
			 } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            releaseDB(rs, pstm, conn);
		        }
		        return list;
		    }
		 
		 
		//查询用户by userdept ArrayList存储
		 public ArrayList<User> QueryuserByuserdept(String userdept)
		 {
			 conn=getConnection();
			 ArrayList<User> list=new ArrayList<User>();
			 String sql="select*from user where userdept=?";
			 try{
				 pstm=(PreparedStatement)conn.prepareStatement(sql);
				 pstm.setString(1,userdept);
				 rs=(ResultSet)pstm.executeQuery();
				 while(rs.next())
				 {
					 User user=new User();
		             user.setUsername(rs.getString("username"));
		             user.setUserpwd(rs.getString("userpwd"));
		             user.setUserphone(rs.getString("userphone"));
		             user.setUsersex(rs.getString("usersex"));
	                 user.setUserdept(rs.getString("userdept"));
		             list.add(user);
				 }
			 } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            releaseDB(rs, pstm, conn);
		        }
		        return list;
		    }
	
		//查看数据库是否已存在用户
			public  boolean queryUserbyNameandPwd(String username, String userpwd) {

				conn = getConnection();
				try {
					pstm = conn.prepareStatement
							("select * from user where username=? and userpwd=?");
					pstm.setString(1, username);
					pstm.setString(2, userpwd);
					rs = pstm.executeQuery();
					if (rs.next()) {
						flags = true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					releaseDB(rs, pstm, conn);
				}

				return flags;
			}
			//查看数据库是否已存在图书管理员
			public  boolean queryManagerbyNameandPwd(String mname, String mpwd) {

				conn = getConnection();
				try {
					pstm = conn.prepareStatement
							("select * from manager where mname=? and mpwd=?");
					pstm.setString(1, mname);
					pstm.setString(2, mpwd);
					rs = pstm.executeQuery();
					if (rs.next()) {
						flags = true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					releaseDB(rs, pstm, conn);
				}

				return flags;
			}
			
			//查看数据库是否已存在超级管理员
			public  boolean querySMbyNameandPwd(String smname, String smpwd) {

				conn = getConnection();
				try {
					pstm = conn.prepareStatement
							("select * from supermanager where smname=? and smpwd=?");
					pstm.setString(1, smname);
					pstm.setString(2, smpwd);
					rs = pstm.executeQuery();
					if (rs.next()) {
						flags = true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					releaseDB(rs, pstm, conn);
				}

				return flags;
			}
			

	//---------------------------关闭数据库-----------------------------------
	
	public void releaseDB(ResultSet rs,PreparedStatement pst,Connection conn)
	{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pst!=null)
		{
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
public static void main(String[] args) {
		
		BookUserDao BD = new BookUserDao();
			Connection conn = BD.getConnection();
			if(!conn.equals(null))
			{
				System.out.println("数据库连接成功!");
			}
			
			
		}

}