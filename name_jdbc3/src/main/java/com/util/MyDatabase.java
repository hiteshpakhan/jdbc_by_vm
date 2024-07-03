package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class MyDatabase {
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

	
	public static List<Employee> employeeRowMapper(ResultSet rs) throws SQLException{
		List<Employee> list_name = new ArrayList();
		
		while(rs.next()) {
			Employee e = new Employee();
			e.setEid(rs.getInt("eid"));
			e.setEname(rs.getString("ename"));
			e.setEdesignation(rs.getString("edesignation"));
			e.setEcompany(rs.getString("ecompany"));
			e.setEsalary(rs.getDouble("esalary"));
			
			list_name.add(e);
		}
		rs.close();
		return list_name;
	}
}
