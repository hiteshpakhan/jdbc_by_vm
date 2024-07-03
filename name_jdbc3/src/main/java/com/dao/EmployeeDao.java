package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<Employee> findEmployeeByEname(String ename) {	
		List<Employee> list_name = new ArrayList();
		
		String sql = "select eid, ename, edesignation, ecompany, esalary from employee where ename = ?";
		
		try (Connection con = MyDatabase.myConnection();
			 PreparedStatement pst = con.prepareStatement(sql);){
				
			pst.setString(1, ename);
			ResultSet rs = pst.executeQuery();
			list_name = MyDatabase.employeeRowMapper(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list_name;
	}

	public List<Employee> findEmployeeByEnameAndEdesignation(String ename, String edesignation){
		List<Employee> list_name = new ArrayList();
		
		String str = "select eid, ename, edesignation, ecompany, esalary from employee where ename=? and edesignation=?";
		
		try (Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(str);
				){
			pst.setString(1, ename);
			pst.setString(2, edesignation);
			ResultSet rs = pst.executeQuery();
			list_name = MyDatabase.employeeRowMapper(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list_name;
	}

	public List<Employee> findEmployeeByEnameOrEdesignation(String ename, String edesignation){
		List<Employee> list_name = new ArrayList();
		
		String sql = "select eid, ename, edesignation, ecompany, esalary from employee where ename = ? or edesignation = ?";
		try (Connection con = MyDatabase.myConnection();
			 PreparedStatement pst = con.prepareStatement(sql);){
				
				pst.setString(1, ename);
				pst.setString(2, edesignation);
				
				ResultSet rs = pst.executeQuery();
				list_name = MyDatabase.employeeRowMapper(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_name;
	}

	public List<Employee> findEmployeeByEsalaryLessThan(double esalary) {
		List<Employee> list_name = new ArrayList();
		String sql = "select eid, ename, edesignation, ecompany, esalary from employee where esalary <= ?";
		
		try (Connection con = MyDatabase.myConnection();
			 PreparedStatement pst = con.prepareStatement(sql);){
				
			pst.setDouble(1, esalary);
			ResultSet rs = pst.executeQuery();
			list_name = MyDatabase.employeeRowMapper(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list_name;
	}

	public List<Employee> findEmployeeBySalaryBetween(double low, double high){
		List<Employee> list_name = new ArrayList();
		String sql = "select eid, ename, edesignation, ecompany, esalary from employee where esalary between ? and ?";
		
		try (Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
			
			pst.setDouble(1, low);
			pst.setDouble(2, high);
			
			ResultSet rs = pst.executeQuery();
			list_name = MyDatabase.employeeRowMapper(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list_name;
	}

	public List<Employee> findEmployeeBySalaryNotBetween(double low, double high){
		List<Employee> list_name = new ArrayList();
		String sql = "select eid, ename, edesignation, ecompany, esalary from employee where esalary not between ? and ?";
		
		try (Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
			
			pst.setDouble(1, low);
			pst.setDouble(2, high);
			
			ResultSet rs = pst.executeQuery();
			list_name = MyDatabase.employeeRowMapper(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_name;
	}

	public List<Employee> findEmployeeByEnameThatLike(String ename){
		List<Employee> list_name = new ArrayList();
		String sql = "select eid, ename, edesignation, ecompany, esalary from employee where ename like ?";
		
		try (Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
			
			pst.setString(1, "%"+ename);	//here we have add the % sign to the starting of %ename
			ResultSet rs = pst.executeQuery();
			list_name = MyDatabase.employeeRowMapper(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_name;
	}

	public List<Employee> findEmployeeByEidIn(List<Integer> id){
		List<Employee> list_name = new ArrayList();
		
		StringBuilder sql = new StringBuilder("select eid, ename, edesignation, ecompany, esalary from employee where eid in (");
		if(id.isEmpty()) {
			sql.append(0);
		} else {
			for(int i = 0; i < id.size(); i++) {
				sql.append(id.get(i));
				if(i < id.size()-1){
					sql.append(",");
				}
			}
			sql.append(")");			
		}
		
		try (Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql.toString());
				ResultSet rs = pst.executeQuery();){
			
			list_name = MyDatabase.employeeRowMapper(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list_name;
	}

	
	//	from sir how to featch 2 column
	public Map<String, List> findEnameAndEsalary(){
		Map<String, List> m = new HashMap();
		String sql = "select ename, esalary, edesignation from employee";
		
		try (Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery(); //we dont have question in our query so we can make the ResultSet object
				){
			//here you can not use the rowMapper because in employeeRowMapper you have featched all the columns but here we are only getting 2 columns so we can not use employeeRowMappper
			List<String> listofNames = new ArrayList();
			List<Double> listofSalary = new ArrayList();
			
			while(rs.next()) {
				listofNames.add(rs.getString("ename"));
				listofSalary.add(rs.getDouble("esalary"));
			}
			m.put("listofNames", listofNames);
			m.put("listofSalary", listofSalary);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return m;
	}

}
