package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.util.MyDatabase;

public class EmployeeDao {
	public int insertEmployee(Employee e) {
		int check = 0;
		String sql = "insert into employee (ename, edesignation, ecompany, esalary) values (?,?,?,?)";
		try (Connection con = MyDatabase.myConnection();
			 PreparedStatement pst = con.prepareStatement(sql);){
				pst.setString(1, e.getEname());
				pst.setString(2, e.getEdesignation());
				pst.setString(3, e.getEcompany());
				pst.setDouble(4, e.getEsalary());
				
				check = pst.executeUpdate();
			
		} catch (Exception e2) {	
			e2.printStackTrace();
		}
		return check;
	}

	public int deleteEmployeeByEid(int eid) {
		int check = 0;
		String sql = "delete from employee where eid = ?";
		try (Connection con = MyDatabase.myConnection();
			 PreparedStatement pst = con.prepareStatement(sql);){		
				pst.setInt(1,  eid);
				check = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	public Employee findEmployeeByEid(int eid) {
		Employee e = null;
		String sql = "select eid, ename, edesignation, ecompany, esalary from employee where eid = ?";
		
		try(Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);) {
			
			pst.setInt(1, eid);
			ResultSet rs = pst.executeQuery();
			List<Employee> list_name = MyDatabase.employeeRowMapper(rs);	//this will return List
			
			if(!list_name.isEmpty()) {
				e = list_name.get(0);
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return e;
	}

	public List<Employee> findAllEmployee(){
		List<Employee> list_name = new ArrayList();
		
		String sql = "select eid, ename, edesignation, ecompany, esalary from employee";
		
		try (Connection con = MyDatabase.myConnection();
			 PreparedStatement pst = con.prepareStatement(sql);){
				
			ResultSet rs = pst.executeQuery();
			list_name = MyDatabase.employeeRowMapper(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list_name;
	}

	public int updateEmployee(Employee e) {
		int check = 0;
		String sql = "update employee set ename = ?, edesignation = ?, ecompany = ?, esalary = ? where eid = ?";
		
		try (Connection con = MyDatabase.myConnection();
			 PreparedStatement pst = con.prepareStatement(sql);){
				pst.setString(1, e.getEname());
				pst.setString(2, e.getEdesignation());
				pst.setString(3, e.getEcompany());
				pst.setDouble(4, e.getEsalary());
				pst.setInt(5, e.getEid());
				
				check = pst.executeUpdate();
		} catch (Exception e2) {
			e.getEcompany();
		}
		
		return check;
	}

}
