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
		List<Employee> listaEmpleados = new ArrayList<Employee>();
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
				
				listaEmpleados.add(empleado);
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return listaEmpleados;
	}

}
