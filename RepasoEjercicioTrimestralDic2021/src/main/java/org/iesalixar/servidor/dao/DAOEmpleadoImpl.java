package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Employee;

public class DAOEmpleadoImpl implements DAOEmpleado {

	@Override
	public List<Employee> getAllEmpleados() {
		
		List<Employee> empleados = new ArrayList<Employee>();
		Employee empleado;
		Connection con = null;
		
		try {
			String sql = "Select * from employees e inner join offices o on e.officeCode=o.officeCode inner join employees em on em.employeeNumber=e.reportsTo";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				empleado = new Employee();
				empleado.setEmployeeNumber(rs.getInt("employeeNumber"));
				empleado.setFirstName(rs.getString("firstName"));
				empleado.setLastName(rs.getString("lastName"));
				empleado.setOfficeCode(rs.getString("officeCode"));
				empleado.setReportsTo(rs.getInt("reportsTo"));
				empleado.setJobTitle(rs.getString("jobTitle"));
				empleado.setOficina(rs.getString("city"));
				empleado.setJefe(rs.getString("em.firstName"));
				
				empleados.add(empleado);
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return empleados;
	}

	@Override
	public boolean addEmpleado(Employee empleado) {
		
		int resultado = 0;
		Connection con = null;
		
		try {
			String sql = "insert into employees values(?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, empleado.getEmployeeNumber());
			statement.setString(2, empleado.getLastName());
			statement.setString(3, empleado.getFirstName());
			statement.setString(4, empleado.getExtension());
			statement.setString(5, empleado.getEmail());
			statement.setString(6, empleado.getOfficeCode());
			statement.setInt(7, empleado.getReportsTo());
			statement.setString(8, empleado.getJobTitle());
			
			resultado = statement.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean getEmpleadoById(int id) {
		
		Employee employee;
		Connection con = null;
		
		try {
			String sql = "select * from employees where employeeNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return true;
	}
	
	
	
	
}
