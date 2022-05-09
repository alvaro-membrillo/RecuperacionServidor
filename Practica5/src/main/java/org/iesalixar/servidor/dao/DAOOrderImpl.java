package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Order;

public class DAOOrderImpl implements DAOOrder {

	@Override
	public List<Order> getAllOrders() {
		
		Connection con = null;
		List<Order> orders = new ArrayList<Order>();
		Order order = null;
		
		try {
			String sql = "SELECT * FROM orders";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				order = new Order();
				
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setRequiredDate(rs.getDate("requiredDate"));
				order.setShippedDate(rs.getDate("shippedDate"));
				order.setStatus(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getInt("customerNumber"));
				
				orders.add(order);
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return orders;
	}

	@Override
	public Order getOrderById(int orderNumber) {
		
		Connection con = null;
		Order order = null;
		
		try {
			String sql = "SELECT * FROM orders where orderNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, orderNumber);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				order = new Order();
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setRequiredDate(rs.getDate("requiredDate"));
				order.setShippedDate(rs.getDate("shippedDate"));
				order.setStatus(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getInt("customerNumber"));
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return order;
	}

}
