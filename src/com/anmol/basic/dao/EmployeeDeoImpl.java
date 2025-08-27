package com.anmol.basic.dao;

import com.anmol.basic.dao.*;
import com.anmol.basic.model.Employee;

import java.sql.*;
import java.util.*;


public class EmployeeDeoImpl implements EmployeeDeo{
	
	private Connection connection;
	private String sql;
	private PreparedStatement preparedStatement;
	private Statement stmt = null;
    private ResultSet rs = null;
    
	public EmployeeDeoImpl() throws ClassNotFoundException , SQLException{
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://@localhost:3306/db";
		String userName = "root";
		String password = "Mind@1234";
		Class.forName(driverName);
		connection = DriverManager.getConnection(url ,userName , password );
		stmt = connection.createStatement();
	}
	
	
	
	
	
	@Override
	public List<Employee> showAllRecords() throws SQLException{
		String sql = "Select * from employee";
		
		rs = stmt.executeQuery(sql);
		
		List<Employee> result = new ArrayList<Employee>();
		while(rs.next()) {
			int empno = rs.getInt("emp_id");            
            String empname = rs.getString("emp_name");
            Double salary  = rs.getDouble("salary");
            
            //////////////////////
            Employee resemp = new Employee();
            resemp.setEmpName(empname);
            resemp.setEmpNo(empno);
            resemp.setEmpSal(salary);
            
            result.add(resemp);

		}
		
		return result;
		
		
	}
	
	
	
	@Override 
	public Employee searchRecord(Integer empId) throws SQLException {
	    sql = "SELECT * FROM Employee WHERE emp_id = ?";
	    preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setInt(1, empId);
	    rs = preparedStatement.executeQuery();

	    if (rs.next()) {
	        Employee employee = new Employee();
	        employee.setEmpNo(rs.getInt("emp_id"));
	        employee.setEmpName(rs.getString("emp_name"));
	        employee.setEmpSal(rs.getDouble("salary"));
	        return employee;
	    }

	   return null; 
	}
	
	
	
	
	@Override
	public String updateRecord(Employee employee, Integer value) throws SQLException {
	    int count = 0;

	    if (value == 1) {
	        sql = "UPDATE Employee SET emp_name = ? WHERE emp_id = ?";
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, employee.getEmpName());
	        preparedStatement.setInt(2, employee.getEmpNo());
	        count = preparedStatement.executeUpdate();
	    } else if (value == 2) {
	        sql = "UPDATE Employee SET salary = ? WHERE emp_id = ?";
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setDouble(1, employee.getEmpSal());
	        preparedStatement.setInt(2, employee.getEmpNo());
	        count = preparedStatement.executeUpdate();
	    } else {
	        return "Invalid update option.";
	    }

	    return count + " Record(s) Updated";
	}
	
	
	
	@Override
	public String deleteRecord(Integer empId) throws SQLException {
	    sql = "DELETE FROM Employee WHERE emp_id = ?";
	    preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setInt(1, empId);
	    int count = preparedStatement.executeUpdate();

	    if (count > 0) {
	        return count + " Record(s) Deleted.";
	    } else {
	        return "No record found with Employee ID: " + empId;
	    }
	}

	
	
	
	
	
	
	
	@Override
	public String addRecord(Employee employee) throws SQLException {
	    sql = "INSERT INTO Employee (emp_id, emp_name, salary) VALUES (?, ?, ?)";

	    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setInt(1, employee.getEmpNo());
	        preparedStatement.setString(2, employee.getEmpName());
	        preparedStatement.setDouble(3, employee.getEmpSal());

	        int count = preparedStatement.executeUpdate();
	        return count + " Record(s) Added";
	    }
	}

}
