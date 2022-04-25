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

		List<Customer> listaCustomers = new ArrayList<Customer>();
		Customer customer = null;
		Connection con = null;

		try {
			String sql = "Select * from customers";
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
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));

				listaCustomers.add(customer);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return listaCustomers;
	}

	@Override
	public boolean addCustomer(Customer customer) {

		int resultado = 0;
		Connection con = null;

		try {
			String sql = "insert into customers values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setInt(1, customer.getCustomerNumber());
			statement.setString(2, customer.getCustomerName());
			statement.setString(3, customer.getContactLastName());
			statement.setString(4, customer.getContactFirstName());
			statement.setString(5, customer.getPhone());
			statement.setString(6, customer.getAddressLine1());
			statement.setString(7, customer.getAddressLine2());
			statement.setString(8, customer.getCity());
			statement.setString(9, customer.getState());
			statement.setString(10, customer.getPostalCode());
			statement.setString(11, customer.getCountry());
			statement.setInt(12, customer.getSalesRepEmployeeNumber());
			statement.setDouble(13, customer.getCreditLimit());

			resultado = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean changeEmpleado(int numEmpleado) {

		Connection con = null;

		try {
			String sql = "update customers set salesRepEmployeeNumber=? where salesRepEmployeeNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			// ResultSet rs = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return false;
	}

	@Override
	public Customer getCustomerById(int id) {

		Connection con = null;
		Customer customer = null;

		try {
			String sql = "Select * from customers where customerNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				customer = new Customer();
				
				customer.setCustomerNumber(rs.getInt("customerNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactFirstName(rs.getString("contactFirstName"));
				customer.setContactLastName(rs.getString("contactLastName"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddressLine1(rs.getString("addressLine1"));
				customer.setAddressLine2(rs.getString("addressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPostalCode(rs.getString("postalCode"));
				customer.setCountry(rs.getString("country"));
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
				customer.setCreditLimit(rs.getDouble("creditLimit"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return customer;
	}

	@Override
	public double getTotalPagos(int customerNumber) {
		
		Connection con = null;
		double total = 0;
		
		try {						
			String sql = "SELECT SUM(amount) AS 'total' FROM payments WHERE customerNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, customerNumber);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			total = rs.getDouble("total");
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return total;
	}

	@Override
	public int getNumPedidos(int customerNumber) {
		
		Connection con = null;
		int pedidos = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS 'pedidos' from orders where customerNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, customerNumber);
			ResultSet rs = statement.executeQuery();
			rs.next();
			pedidos = rs.getInt("pedidos");
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return pedidos;
	}

}
