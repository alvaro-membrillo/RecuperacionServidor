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
	public Employee getEmployeeById(int id) {

		Employee empleado = null;
		Connection con = null;

		try {
			String sql = "Select * from employees where employeeNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				empleado = new Employee();
				empleado.setEmployeeNumber(rs.getInt("employeeNumber"));
				empleado.setFirstName(rs.getString("firstName"));
				empleado.setLastName(rs.getString("lastName"));
				empleado.setExtension(rs.getString("extension"));
				empleado.setEmail(rs.getString("email"));
				empleado.setOfficeCode(rs.getString("officeCode"));
				empleado.setReportsTo(rs.getInt("reportsTo"));
				empleado.setJobTitle(rs.getString("jobTitle"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return empleado;
	}

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> empleados = new ArrayList<Employee>();
		Employee empleado = null;
		Connection con = null;

		try {
			String sql = "Select * from employees";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				empleado = new Employee();
				empleado.setEmployeeNumber(rs.getInt("employeeNumber"));
				empleado.setFirstName(rs.getString("firstName"));
				empleado.setLastName(rs.getString("lastName"));
				empleado.setExtension(rs.getString("extension"));
				empleado.setEmail(rs.getString("email"));
				empleado.setOfficeCode(rs.getString("officeCode"));
				empleado.setReportsTo(rs.getInt("reportsTo"));
				empleado.setJobTitle(rs.getString("jobTitle"));

				empleados.add(empleado);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return empleados;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "update employees set lastName=?, firstName=?, extension=?, email=?, officeCode=?, reportsTo=?, jobTitle=?  where employeeNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, employee.getLastName());
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getExtension());
			statement.setString(4, employee.getEmail());
			statement.setString(5, employee.getOfficeCode());
			statement.setInt(6, employee.getReportsTo());
			statement.setString(7, employee.getJobTitle());
			statement.setInt(8, employee.getEmployeeNumber());

			resultado = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return (resultado == 0 ? false : true);

	}

}
