package com.anmol.basic.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import com.anmol.basic.dao.EmployeeDeo;
import com.anmol.basic.dao.EmployeeDeoImpl;
import com.anmol.basic.model.Employee;

import java.util.*;

public class TestApp {
	void addEmployeeRecord() throws ClassNotFoundException, SQLException {
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Enter Employee Number: ");
	    int empNo = scanner.nextInt();
	    
	    scanner.nextLine();
	    System.out.println("Enter Employee Name: ");
	    String empName = scanner.nextLine();

	    System.out.println("Enter Employee Salary: ");
	    double empSal = scanner.nextDouble();

	    Employee employee = new Employee();
	    employee.setEmpNo(empNo);
	    employee.setEmpName(empName);
	    employee.setEmpSal(empSal);

	    EmployeeDeo employeeDeo = new EmployeeDeoImpl();
	    String msg = employeeDeo.addRecord(employee);
	    System.out.println(msg);
	}
	

	 void showEmployeeRecord() throws ClassNotFoundException ,SQLException  {
		  EmployeeDeo employeDeo = new EmployeeDeoImpl();
		  List<Employee> result = employeDeo.showAllRecords();
		  
		  for (Employee employee : result) {
			System.out.println(employee);
		}
	  }
	 
	 void updateEmployeeRecord() throws ClassNotFoundException ,  SQLException  {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter Employee NO : ");
		 
		 Integer choose = scanner.nextInt();
		 
		 
		 EmployeeDeo employeDeo = new EmployeeDeoImpl();
		  Employee res = employeDeo.searchRecord(choose);
		  
		  
		  
		  if (res != null) {
			  
			  System.out.println("What You Want to Update : ");
			  System.out.println("1. Change Name");
			  System.out.println("2. Change Salary");
			  Integer updateOption = scanner.nextInt();
			  
			  if (updateOption == 1 ) {
				  System.out.println("Enter New Name ");
				  String newName = scanner.next();
				  res.setEmpName(newName);
				  String msg = employeDeo.updateRecord(res , updateOption);
				  System.out.println(res);
				  System.out.println(msg);
				  
				  
			  } else {
				  System.out.println("Enter New Salary");
				  Double newSalary = scanner.nextDouble();
				  res.setEmpSal(newSalary);
				  String msg = employeDeo.updateRecord(res , updateOption);
				  System.out.println(res);
				  System.out.println(msg);
				   
			  }
			  
			  
			  
			  
		  } else {
			  System.out.println("Record Not Found" + choose);
		  }
		 
		 
		 
		
		  
	  }
	 
	 void findEmployeeRecord() throws ClassNotFoundException ,  SQLException  {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter Employee NO : ");
		 
		 Integer choose = scanner.nextInt();
		 
		 EmployeeDeo employeDeo = new EmployeeDeoImpl();
		  Employee res = employeDeo.searchRecord(choose);
		  
		  if (res != null) {
			  System.out.println(">>>>" + res);
		  } else {
			  System.out.println("Record Not Found" + choose);
		  }
			
		  
	 }
	 
	 
	 
	 void deleteEmployeeRecord() throws ClassNotFoundException ,  SQLException  {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter Employee NO : ");
		 
		 Integer choose = scanner.nextInt();
		 
		 
		 EmployeeDeo employeDeo = new EmployeeDeoImpl();
		  String res = employeDeo.deleteRecord(choose);
		  System.out.println(res);
		  
		  
	  }
	 
	
	 
  public static void main(String [] args) {
	 
	  Scanner scanner = new Scanner(System.in);
	  Integer ans = 7 ;
	  
	 
	  
	 
	 
	 
	  
	  try {
	  
	  do {
		  System.out.println(">>>>>>>>>>>>>>>Employee Information <<<<<<<<<<<<<<<<<<<<<<<");
		  System.out.println("1. Add Record");
		  System.out.println("2. See All Record");
		  System.out.println("3. Delete Record");
		  System.out.println("4. Update Record");
		  System.out.println("5. Find Record");
		  System.out.println("6. Exit");
		  System.out.println("Choose Your Number");
		  ans = scanner.nextInt();
		  TestApp test = new TestApp();
		  switch (ans) {
		case 1: {
			test.addEmployeeRecord();	
			break;
			}
		
		case 2: {
			test.showEmployeeRecord();	
			break;
			}
		
		case 3: {
			test.deleteEmployeeRecord();	
			break;
			}
		
		
		case 4: {
			test.updateEmployeeRecord();	
			break;
			}
		
		case 5: {
			test.findEmployeeRecord();	
			break;
			}
		
		case 6 : {
			 System.out.println("Exited Successfully");
			break;
		}
		
		
		default:
			
			throw new IllegalArgumentException("Unexpected value: " + ans);
		
		}
		  
	  } while (ans != 6 );
	  
	  
  }   catch( ClassNotFoundException e) {
	  e.printStackTrace();
  } catch (SQLException e) {
	  e.printStackTrace();
  } catch (IllegalArgumentException e ) {
	  e.printStackTrace();
  }
	  
	 
	  
	  
	  
	  
	  
	 
	  
	  
  }
}
