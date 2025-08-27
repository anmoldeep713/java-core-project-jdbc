package com.anmol.basic.dao;

import java.sql.SQLException;
import java.util.*;

import com.anmol.basic.model.Employee;

public interface EmployeeDeo {
	String addRecord(Employee employee) throws SQLException;  // NOT DEO but DAO 
	
	
	String deleteRecord(Integer empId) throws SQLException;
	
	List<Employee> showAllRecords() throws SQLException ;
	
	Employee searchRecord(Integer empId) throws SQLException;
	
	
	String updateRecord(Employee employee , Integer value) throws SQLException;
}
