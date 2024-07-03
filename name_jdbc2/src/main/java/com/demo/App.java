package com.demo;

import java.util.List;

import com.dao.StudentDao;
import com.model.Student;

public class App 
{
    public static void main( String[] args )
    {
////for inserting student
//    	StudentDao sd = new StudentDao();
//    	Student s1 = new Student();
//    	s1.setSname("eak6");
//    	s1.setLname("pune6");
//    	s1.setSpercentage(5.22);
//    	System.out.println(sd.insertStudent(s1));
    	
////for deleting student
//    	StudentDao sd = new StudentDao();
//    	System.out.println(sd.deleteStudentBySid(2));

////for selecting specific student
//    	StudentDao sd = new StudentDao();
//    	Student s = sd.findStudentBySid(4);
//    	System.out.println(s);
    	
//for selecting all data
    	StudentDao sd = new StudentDao();
    	List<Student> list_name = sd.findAllStudents();
    	for(Student s: list_name) {
    		System.out.println(s);
    	}
    	
////for update student
//    	StudentDao sd = new StudentDao();
//    	Student s1 = sd.findStudentBySid(5);	
//    	s1.setLname("HiteshPakhan");					
//    	System.out.println(sd.updateStudent(s1));
//    
    }
}	
 