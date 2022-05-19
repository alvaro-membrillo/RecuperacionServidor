package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Customer;

public class DAOCustomerImpl implements DAOCustomer {

	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = null;
		Connection con = null;

		try {
			String sql = "SELECT * FROM customers";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				customer = new Customer();
				customer.setCustomerNumber(rs.getInt("customerNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactLastName(rs.getString("contactLastName"));
				customer.setContactFirstName(rs.getString("contactFirstName"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddressLine1(rs.getString("AddressLine1"));
				customer.setAddressLine2(rs.getString("AddressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPostalCode(rs.getString("postalCode"));
				customer.setCountry(rs.getString("country"));
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
				customer.setCreditLimit(rs.getInt("creditLimit"));

				customers.add(customer);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return customers;
	}

	@Override
	public boolean updateEmployeeCustomer(int customerNumber, int employee) {

		int resultado = 0;
		Connection con = null;

		try {
			String sql = "udpate customers set salesRepEmployeeNumber=? where customerNumber = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, employee);
			statement.setInt(2, customerNumber);

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

	@Override
	public Customer getCustomer(int customerNumber) {

		Customer customer = null;
		Connection con = null;

		try {
			String sql = "Select * from customers where=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, customerNumber);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				customer = new Customer();

				customer.setCustomerNumber(rs.getInt("customerNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactLastName(rs.getString("contactLastName"));
				customer.setContactFirstName(rs.getString("contactFirstName"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddressLine1(rs.getString("addressLine1"));
				customer.setAddressLine2(rs.getString("addressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPostalCode(rs.getString("postalCode"));
				customer.setCountry(rs.getString("country"));
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
				customer.setCreditLimit(rs.getInt("creditLimit"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return customer;
	}

}
