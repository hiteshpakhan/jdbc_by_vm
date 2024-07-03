package name.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args )
    {
    	//if we create the connection object into the try block then it will be considered as local then we can not access it from outside 
    	Connection con = null;
    	PreparedStatement pst = null;
    	int check = 0;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap67", "root", "Luci@714");
				String sql = "insert into t1(name, city) values(?,?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, "def");
				pst.setString(2, "mumbai");
				check = pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					pst.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(check);
    }
}






//
//"MyDatabase.java
//----------------------------------
//
//public class MyDatabase {
//
//public static Connection myConnection() {
//Connection con = null;
//try {
//Class.forName("com.mysql.cj.jdbc.Driver");
//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap67", "root", "root");
//} catch (ClassNotFoundException | SQLException e) {
//e.printStackTrace();
//}
//return con;
//}
//
//public static void closeConnection(PreparedStatement pst, Connection con) {
//try {
//pst.close();
//con.close();
//} catch (SQLException e) {
//e.printStackTrace();
//}
//}
//public static void closeConnection(ResultSet rs ,PreparedStatement pst, Connection con) {
//try {
//pst.close();
//con.close();
//} catch (SQLException e) {
//e.printStackTrace();
//}
//}
//}
//
//--------------------------------------
//StudentDao.java
//---------------------------
//
//public class StudentDao {
//
//public int insertStudent(Student s) {
//int check = 0;
//Connection con = MyDatabase.myConnection();
//String sql = "insert into Student(sname,scity,spercentage)values(?,?,?)";
//PreparedStatement pst = null;
//try {
//pst = con.prepareStatement(sql);
//pst.setString(1, s.getSname());
//pst.setString(2, s.getScity());
//pst.setDouble(3, s.getSpercentage());
//check = pst.executeUpdate();
//} catch (SQLException e) {
//e.printStackTrace();
//}finally {MyDatabase.closeConnection(pst, con);}
//return check;
//}
//}"
