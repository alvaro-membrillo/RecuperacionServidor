package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Product;

public class DAOProductImpl implements DAOProduct {

	@Override
	public List<Product> getProductsByCategoria(String categoria) {
		
		List<Product> productsList = new ArrayList<Product>();
		Product product = null;
		Connection con = null;
		
		try {
			String sql = "Select * from products where productLine=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, categoria);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				product = new Product();
				product.setProductCode(rs.getString("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMsrp(rs.getInt("msrp"));
				productsList.add(product);
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return productsList;
	}

}
