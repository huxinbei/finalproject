/**
 * 功能：连接数据库；查看图书；借还书时判断数据表中是否存在这本书；更新书的库存
 * 作者：王佳怡
 */
package com.ie.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ie.bean.*;
import com.ie.dao.*;
import com.ie.utils.JdbcUtils;;
public class BookDao {
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
		//查看书籍
		public ArrayList<Book> queryAllBook()
		{
			conn = getConnection();
			ArrayList<Book> books = new ArrayList<Book>();
			
				try {
					pstm = conn.prepareStatement("select * from book");
					
					rs = pstm.executeQuery();
					while(rs.next())
					{
						Book book = new Book();
						
						book.setBookname(rs.getString("bookname"));
						book.setNumber(rs.getInt("number"));
						book.setAuthor(rs.getString("author"));
					//	book.setBookprice(rs.getDouble("bookprice"));
						book.setPublisher(rs.getString("publisher"));
						book.setCategory(rs.getString("category"));
						books.add(book);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					releaseDB(rs,pstm,conn);
				}
				return books;
		
			}
		
		 public Book retandborBook(String bookname){//借/还书是否存在本书
		        Book book = null;
		        Connection  connection = null;
		        PreparedStatement preparedStatement = null;
		        ResultSet resultSet = null;
		        String sql = "select * from book where bookname=?";
		        try {
		            connection = JdbcUtils.getConn();
		            preparedStatement = connection.prepareStatement(sql);
		            preparedStatement.setString(1,bookname);
		            resultSet = preparedStatement.executeQuery();
		            if(resultSet.next()){
		                book = new Book();
		                book.setNumber(resultSet.getInt("number"));
		                book.setBookname(resultSet.getString("bookname"));
		                book.setAuthor(resultSet.getString("author"));
		               // book.setbookprice(resultSet.getDouble("bookprice"));
		                book.setPublisher(resultSet.getString("publisher"));
		                book.setCategory(resultSet.getString("category"));
//		              //System.out.println("归还 《" + book_name + "》成功");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }finally {
		            JdbcUtils.close(connection,preparedStatement,resultSet);
		        }
		        return book;
		    }
		 
		 
	    public int update(Book book,int i){//更新书籍数量
	        int sum = (book.getNumber() + i);
	        if(sum < 0){
	            return -1;
	        }
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        String sql = "update book set number='" + sum +"' where bookname='" + book.getBookname()+"'";
	        try {
	            connection = JdbcUtils.getConn();
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            JdbcUtils.close(connection,preparedStatement);
	        }
	        return 0;
	    }
		
	    public static void main(String[] args) throws Exception {
			   BookDao dao = new BookDao();
			   Connection conn = dao.getConnection();
				if(!conn.equals(null))
				{
					System.out.println("数据库连接成功!");
				}
				ArrayList<Book> list = dao.queryAllBook();
				for(int i=0;i<list.size();i++)
				{
					Book book = new Book();
					book = list.get(i);
					System.out.print(book.getBookname());
					System.out.print(book.getNumber());
					System.out.print(book.getAuthor());
					//System.out.print(book.getbookprice());
					System.out.print(book.getPublisher());
					System.out.print(book.getCategory());
				}
		}
		
}
