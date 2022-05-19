package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Customer;

public interface DAOCustomer {
	
	public List<Customer> getAllCustomers();
	public Customer getCustomer(int customerNumber);
	public boolean updateEmployeeCustomer(int customerNumber, int employee);

}
