package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Employee;

public interface DAOEmployee {
	
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	public boolean updateEmployee(Employee employee);
	
}
