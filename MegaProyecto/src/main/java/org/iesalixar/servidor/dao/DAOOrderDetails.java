package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.OrderDetail;

public interface DAOOrderDetails {
	
	public List<OrderDetail> getOrderDetailsByOrderNumber(int orderNumber);

}
