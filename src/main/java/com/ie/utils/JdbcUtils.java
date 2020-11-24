/**
 * 功能：连接数据库
 * 作者：王佳怡
 */
package com.ie.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class JdbcUtils {
	
	    private static String URL = null;
	    private static String ROOT = null;
	    private static String PASS = null;
	    private static String DRIVER = null;
	    
    public static Connection getConn() throws SQLException {
    	    String driver ="com.mysql.jdbc.Driver";
    	     String url="jdbc:mysql://localhost:3306/finalproject";
    	     String username = "root";
    	     String password = "123456";
    	   Connection connection =null;
    	     try {
 				Class.forName(driver);
 				connection = (Connection)DriverManager.getConnection(url,username,password);
 				System.out.println("1");
 				} catch (SQLException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 					System.out.println("3");
 					
 				}
 			catch (ClassNotFoundException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			
 			}
		System.out.println("2");
        return connection;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement){
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
