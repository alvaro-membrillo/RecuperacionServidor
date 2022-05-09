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
	public boolean addProduct(Product product) {

		int resultado = 0;
		Connection con = null;

		try {
			String sql = "insert into products values(?,?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, product.getProductCode());
			statement.setString(2, product.getProductName());
			statement.setString(3, product.getProductLine());
			statement.setString(4, product.getProductScale());
			statement.setString(5, product.getProductVendor());
			statement.setString(6, product.getProductDescription());
			statement.setInt(7, product.getQuantityInStock());
			statement.setDouble(8, product.getBuyPrice());
			statement.setDouble(9, product.getMsrp());

			resultado = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public Product getProductById(String productCode) {

		Product product = null;
		Connection con = null;

		try {
			String sql = "SELECT * FROM products WHERE productCode=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.executeQuery();

			product = new Product();
			statement.setString(1, product.getProductCode());
			statement.setString(2, product.getProductName());
			statement.setString(3, product.getProductLine());
			statement.setString(4, product.getProductScale());
			statement.setString(5, product.getProductVendor());
			statement.setString(6, product.getProductDescription());
			statement.setInt(7, product.getQuantityInStock());
			statement.setDouble(8, product.getBuyPrice());
			statement.setDouble(9, product.getMsrp());

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return product;
	}

	@Override
	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList<Product>();
		Product product = null;
		Connection con = null;

		try {
			String sql = "SELECT * FROM products";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				product = new Product();
				statement.setString(1, product.getProductCode());
				statement.setString(2, product.getProductName());
				statement.setString(3, product.getProductLine());
				statement.setString(4, product.getProductScale());
				statement.setString(5, product.getProductVendor());
				statement.setString(6, product.getProductDescription());
				statement.setInt(7, product.getQuantityInStock());
				statement.setDouble(8, product.getBuyPrice());
				statement.setDouble(9, product.getMsrp());
				products.add(product);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return products;
	}

}
