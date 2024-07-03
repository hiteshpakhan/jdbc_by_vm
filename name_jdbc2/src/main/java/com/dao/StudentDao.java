package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.util.MyDatabase;

public class StudentDao {
	public int insertStudent(Student s) {	
		int check = 0;
		
		String sql = "insert into student (sname, lname, spercentage) values (?,?,?)";
		try(Connection con = MyDatabase.myConnection();		
			PreparedStatement pst = con.prepareStatement(sql);) {
		
				pst.setString(1, s.getSname());
				pst.setString(2, s.getLname());
				pst.setDouble(3, s.getSpercentage());
				check = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		return check;
	}
	
	public int deleteStudentBySid(int sid) {
		//here just like we did in insertStudent by using resource block for autoclosable we can also do this here 
		int check = 0;

		Connection con = MyDatabase.myConnection();
		PreparedStatement pst = null;
		String sql = "delete from student where sid = ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, sid);			
			check = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			MyDatabase.closeConnection(pst, con);
//		}
		
		return check;		
	}

	public Student findStudentBySid(int sid) {
		Student s = null;
		
		String sql = "select sid, sname, lname, spercentage from student where sid = ?";
		
		try (	Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);){
			pst.setInt(1, sid);
			ResultSet rs = pst.executeQuery();
			List<Student> list_name = MyDatabase.studentRowMapper(rs);
			
			if(!list_name.isEmpty()) {
				s = list_name.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
		
	}

	public List<Student> findAllStudents(){
		List<Student> list_name = new ArrayList();
		String sql = "select sid, sname, lname, spercentage from student";
		try (	Connection con = MyDatabase.myConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();){
			
			list_name = MyDatabase.studentRowMapper(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_name;
	}

	public int updateStudent(Student s) {
	int check = 0;
	
	Connection con = MyDatabase.myConnection();
	PreparedStatement pst = null;
	String sql = "update student set sname = ?, lname = ?, spercentage = ? where sid = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getSname());
			pst.setString(2, s.getLname());
			pst.setDouble(3, s.getSpercentage());
			pst.setInt(4, s.getSid());
			check = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			MyDatabase.closeConnection(pst, con);
//		}
	return check;
	}

}








//--------------------------------------------------------------
//old code for insertStudent()
/*
  int check = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap67", "root", "Luci@714");
			String sql = "insert into student (sname, lname, spercentage) values (?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getSname());
			pst.setString(2, s.getLname());
			pst.setDouble(3, s.getSpercentage());
			check = pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check; 
  
 */

//old code for DeleteStudent()
/*
  public int deleteStudentBySid(int sid) {
		int check = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap67", "root", "Luci@714");
				String sql = "delete from student where sid = ?";
				pst = con.prepareStatement(sql);
				pst.setInt(1, sid);
				check = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}
  
*/


//old code of updateStudent()
/*
public int updateStudent(Student s) {
		int check = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap67", "root", "Luci@714");
			String sql = "update student set sname=?, lname=?, spercentage=? where sid=?"; 	
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getSname());
			pst.setString(2, s.getLname());
			pst.setDouble(3, s.getSpercentage());
			pst.setInt(4, s.getSid());
			check = pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return check;
	}
	//arsenic
	//sinite
*/

//old code of findStudentById()
/*
 
Student s = null;
Connection con = null;
PreparedStatement pst = null;
ResultSet rs = null;

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap67", "root", "Luci@714");
	String sql = "select sid,sname,lname,spercentage from student where sid = ?";
	pst = con.prepareStatement(sql);
	pst.setInt(1, sid);
	rs = pst.executeQuery();	
	while(rs.next()) {
		s = new Student();
		s.setSid(rs.getInt("sid"));
		s.setSname(rs.getString("sname"));
		s.setLname(rs.getString("lname"));
		s.setSpercentage(rs.getDouble("spercentage"));
	}
	
} catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
} finally {
	try {
		rs.close();
		pst.close();
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
return s;
 
 */




// old code of findAllStudents()

/*
		List<Student> list_name = new ArrayList();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap67", "root", "Luci@714");
			String sql = "select sid,sname,lname,spercentage from Student";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Student s = new Student();
				
				s.setSid(rs.getInt("sid"));
				s.setSname(rs.getString("sname"));
				s.setLname(rs.getString("lname"));
				s.setSpercentage(rs.getDouble("spercentage"));
				
				list_name.add(s);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				con.close();				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list_name;

*/