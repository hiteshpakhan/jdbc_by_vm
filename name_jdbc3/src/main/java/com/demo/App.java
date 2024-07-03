package com.demo;

import java.util.Random;

import com.dao.EmployeeDao;
import com.model.Employee;

public class App 
{
    public static void main( String[] args )
    {
    
////    	for inserting multiple randome employee in bulck
//        EmployeeDao ed = new EmployeeDao();
//        for(int i = 0; i<=10; i++) {
//        	Employee e = new Employee();
//        	StringBuilder name = new StringBuilder();
//        	StringBuilder designation = new StringBuilder();
//        	StringBuilder company = new StringBuilder();
//        	for(int j = 1; j<=15; j++) {
//        		name.append((char)(new Random().nextInt(26)+65));
//        		designation.append((char)(new Random().nextInt(26)+65));
//        		company.append((char)(new Random().nextInt(26)+65));
//        	}
//        	e.setEname(name.toString());
//        	e.setEdesignation(designation.toString());
//        	e.setEcompany(company.toString());
//        	e.setEsalary(new Random().nextDouble()*1000000);
//        	System.out.println(ed.insertEmployee(e));
//        }
        
        
        
        
////	for inserting one employee      
//    	EmployeeDao ed = new EmployeeDao();
//        Employee e1 = new Employee();
//        e1.setEname("kaustubh");
//        e1.setEdesignation("sqldeveloper");	
//        e1.setEcompany("wipro");
//        e1.setEsalary(212.5);
//        
//        System.out.println(ed.insertEmployee(e1));
    	
    	
    	
////    	for deletingEmployeebyEid
//    	EmployeeDao ed = new EmployeeDao();
//    	System.out.println(ed.deleteEmployeeByEid(578));
    	
    	
////    	for finding specific employee by Eid
//    	EmployeeDao ed = new EmployeeDao();
//    	Employee e = ed.findEmployeeByEid(126);
//    	System.out.println(e);
    	
    	
////    	find all the employes data 
//    	EmployeeDao ed = new EmployeeDao();
//    	for(Employee e : ed.findAllEmployee()) {
//    		System.err.println(e);
//    	}
    	
    	
//    	to update specific employee
    	EmployeeDao ed = new EmployeeDao();
    	Employee e1 = ed.findEmployeeByEid(122);
    	e1.setEname("name_one");
    	e1.setEdesignation("designation_one");
    	e1.setEcompany("company_one");
    	e1.setEsalary(12332);
    	System.err.println(ed.updateEmployee(e1));
    
    }
}
