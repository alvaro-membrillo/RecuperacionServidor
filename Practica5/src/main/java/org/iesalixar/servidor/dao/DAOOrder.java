package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Order;

public interface DAOOrder {
	
	public List<Order> getAllOrders();
	public Order getOrderById(int orderNumber);

}
