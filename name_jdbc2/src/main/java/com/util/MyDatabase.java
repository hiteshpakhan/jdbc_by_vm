package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class MyDatabase {

	//this is the myConnection() method for creating the connection
	public static Connection myConnection() {	
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap67", "root", "Luci@714");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		return con;
	}
	
	
	public static List<Student> studentRowMapper(ResultSet rs) throws SQLException{
		List<Student> list_name = new ArrayList();
		
		while(rs.next()) {
			Student s = new Student();
			s.setSid(rs.getInt("sid"));
			s.setSname(rs.getString("sname"));
			s.setLname(rs.getString("lname"));
			s.setSpercentage(rs.getDouble("spercentage"));
			list_name.add(s);
		}
		rs.close();
		return list_name;
	}
	
	
	
	
	
	
//	//this is the closeConnection() method for closing the connection of DML query
//	public static void closeConnection(PreparedStatement pst, Connection con) {
//		try {
//			pst.close();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	//this is the closeConnection() method for closing the connection of DQL query here you have to also close ResultSet
//		public static void closeConnection(ResultSet rs,PreparedStatement pst, Connection con) {
//			try {
//				rs.close();
//				pst.close();
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
}