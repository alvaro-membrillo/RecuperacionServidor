package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Customer;

public interface DAOCustomer {

	public List<Customer> getAllCustomers();
	public boolean addCustomer(Customer customer);
	public boolean changeEmpleado(int numEmpleado);
	public Customer getCustomerById(int id);
	public double getTotalPagos(int customerNumber);
	public int getNumPedidos(int customerNumber);
	
}
