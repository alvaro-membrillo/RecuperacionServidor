package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Employee;

public interface DAOEmpleado {

	public List<Employee> getAllEmpleados();
	public boolean addEmpleado(Employee empleado);
	public boolean getEmpleadoById(int id);

}
