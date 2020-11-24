/**
 * 功能：连接数据库；查询用户；添加用户；根据用户名判断是否存在用户
 * 作者：王佳怡
 */
package com.ie.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ie.bean.*;
import com.ie.utils.JdbcUtils;
public class UserDao {
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	private int result;
	
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
		
		public ArrayList<User> queryAllUser()
		{
			conn = getConnection();
			ArrayList<User> users = new ArrayList<User>();
			
				try {
					pstm = conn.prepareStatement("select * from user");
					
					rs = pstm.executeQuery();
					while(rs.next())
					{
						User user = new User();
						
						user.setUsername(rs.getString("username"));
						user.setUserpwd(rs.getString("userpwd"));
						user.setUserphone(rs.getString("userphone"));
						user.setUsersex(rs.getString("usersex"));
						user.setUserdept(rs.getString("userdept"));
						//user.setuserinfo(rs.getString("userinfo"));
						users.add(user);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					releaseDB(rs,pstm,conn);
				}
				return users;
		
			}
		
	    public User Login(String username, String userpwd){
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        User user = null;

	        try {
	            connection = JdbcUtils.getConn();
	            String sql = "select * from user where username=? and userpwd=?";
	            preparedStatement  = connection.prepareStatement(sql);
	            preparedStatement.setString(1,username);
	            preparedStatement.setString(2,userpwd);
	            resultSet = preparedStatement.executeQuery();
	            if(resultSet.next()){
	                user = new User();
	                user.setUsername(resultSet.getString("username"));
	                user.setUserpwd(resultSet.getString("userpwd"));
	                System.out.println("登录成功");
	            }else {
	                System.out.println("登录失败");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            JdbcUtils.close(connection,preparedStatement,resultSet);
	        }
	        return user;
	    }
		
		
		//添加用户（带封装）
		public int addUser(User user) {
			conn = getConnection();
			try {
				pstm = conn.prepareStatement("insert into user set username=?,userpwd=?,userphone=?,usersex=?,userdept=?,userinfo=?");
			    pstm.setString(1, user.getUsername());
			    pstm.setString(2, user.getUserpwd());
			    pstm.setString(2, user.getUserphone());
			    pstm.setString(3, user.getUsersex());
			    pstm.setString(4, user.getUserdept());
			    //pstm.setString(5, user.getuserinfo());
			    result=pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				releaseDB(rs, pstm, conn);
			}
			return result;
		}
		
		//根据用户名判断是否存在用户
	    public boolean isExist(String username){
	        Connection connection = null;
	        String sql = "select * from user where username=?";
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        try {
	            connection = JdbcUtils.getConn();
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1,username);
	            resultSet = preparedStatement.executeQuery();
	            if(resultSet.next()){
	                return false;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return true;
	    }
		
	    public List<String> showBook(){//剩余各种书的信息
	        List<String> list = new ArrayList<String>();
	        int i = 0;
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        try {
	            connection = JdbcUtils.getConn();
	            String sql = "select * from book";
	            preparedStatement = connection.prepareStatement(sql);
	            resultSet = preparedStatement.executeQuery();
	            while(resultSet.next()){
	                String message = "书名：" + resultSet.getString("bookname")
	                        + "<--->剩余数量：" + resultSet.getInt("number")
	                        + "<--->作者为：" + resultSet.getString("author")
	                       // + "<--->书的价格为：" + resultSet.getDouble("bookprice")
	                        + "<--->出版社为：" + resultSet.getString("publisher")
	                        + "<--->类别为：" + resultSet.getString("category")+"\n";
	                list.add(message);
//	                System.out.println(message);
	                //System.out.println();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            JdbcUtils.close(connection,preparedStatement,resultSet);
	        }
	        return list;
	    }
		public static void main(String[] args) throws Exception {
			   UserDao dao = new UserDao();
			   Connection conn = dao.getConnection();
				if(!conn.equals(null))
				{
					System.out.println("数据库连接成功!");
				}
				ArrayList<User> list = dao.queryAllUser();
				for(int i=0;i<list.size();i++)
				{
					User user = new User();
					user = list.get(i);
					System.out.print(user.getUsername());
					System.out.print(user.getUserpwd());
					System.out.print(user.getUserphone());
					System.out.print(user.getUsersex());
					System.out.print(user.getUserdept());
					//System.out.print(user.getuserinfo());
				}
		}
}
