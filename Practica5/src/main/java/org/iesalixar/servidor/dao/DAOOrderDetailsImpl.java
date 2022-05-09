package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.OrderDetail;

public class DAOOrderDetailsImpl implements DAOOrderDetails {

	@Override
	public List<OrderDetail> getOrderDetailsByOrderNumber(int orderNumber) {

		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		Connection con = null;
		OrderDetail orderDetail = null;
		
		try {
			String sql = "SELECT * FROM orderdetails WHERE orderNumber=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, orderNumber);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				orderDetail = new OrderDetail();
				orderDetail.setOrderNumber(rs.getInt("orderNumber"));
				orderDetail.setProductCode(rs.getString("productCode"));
				orderDetail.setQuantityOrdered(rs.getInt("quantityOrdered"));
				orderDetail.setPriceEach(rs.getDouble("priceEach"));
				orderDetail.setOrderLineNumber(rs.getInt("orderLineNumber"));
				orderDetails.add(orderDetail);
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return orderDetails;
	}

}
