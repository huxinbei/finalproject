/**
 * 功能：查询借阅、归还记录；插入借阅、归还记录；判断borrow表中是否存在相应的借阅记录
 * 作者：王佳怡
 */
package com.ie.dao;

import com.ie.bean.Borrow;
import com.ie.bean.User;
import com.ie.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class BorrowDao {
    public List<Borrow> getBorrow(String username){//查阅所借书
        List<Borrow> list = new ArrayList<Borrow>();
        Borrow m = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from borrow where username=?";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                m = new Borrow();
                m.setusername(resultSet.getString("username"));
                m.setbookname(resultSet.getString("bookname"));
                m.setdate(resultSet.getString("date"));
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return list;
    }
    
    public List<Borrow> getReturn(String username){//查阅所借书
        List<Borrow> list = new ArrayList<Borrow>();
        Borrow m = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from returnbook where username=?";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                m = new Borrow();
                m.setusername(resultSet.getString("username"));
                m.setbookname(resultSet.getString("bookname"));
                m.setdate(resultSet.getString("date"));
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return list;
    }

    public  void addMessage(Borrow mess){//添加借阅记录
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into borrow(username,bookname,date) values(?,?,?)";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,mess.getusername());
            preparedStatement.setString(2,mess.getbookname());
            preparedStatement.setString(3,mess.getdate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement);
        }

    }

    public  void returnmessage(Borrow mess){//添加归还记录
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into returnBook(username,bookname,date) values(?,?,?)";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,mess.getusername());
            preparedStatement.setString(2,mess.getbookname());
            preparedStatement.setString(3,mess.getdate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement);
        }

    }
    
  //查看borrow表中是否存在相应的借阅记录
    public boolean check(String username, String bookname){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from borrow where username=? and bookname=?";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,bookname);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name1 = resultSet.getString("username");
                String book_name1 = resultSet.getString("bookname");
                //System.out.println(name1 + "==" + book_name1);
                if(username.equals(name1) && (bookname).equals(book_name1)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return false;
    }

}

