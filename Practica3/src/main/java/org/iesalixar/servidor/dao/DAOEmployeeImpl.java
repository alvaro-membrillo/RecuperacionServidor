package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Employee;

public class DAOEmployeeImpl implements DAOEmployee {

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		Connection con = null;
		
		try {
			String sql = "Select * from employees";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				employee = new Employee();
				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setOfficeCode(rs.getString("officeCode"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));
				
				employees.add(employee);
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return employees;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		
		int resultado = 0;
		Connection con = null;
		
		try {
			String sql = "insert into employees values(?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, employee.getEmployeeNumber());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getFirstName());
			statement.setString(4, employee.getExtension());
			statement.setString(5, employee.getEmail());
			statement.setString(6, employee.getOfficeCode());
			statement.setInt(7, employee.getReportsTo());
			statement.setString(8, employee.getJobTitle());
			
			resultado = statement.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return (resultado == 0 ? false : true);
	}
	
}
