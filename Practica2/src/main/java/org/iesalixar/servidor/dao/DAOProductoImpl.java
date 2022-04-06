package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Producto;

public class DAOProductoImpl implements DAOProducto {

	@Override
	public Producto getProducto(String code) {

		Producto producto = null;
		Connection con = null;

		try {
			String sql = "Select * from products where productCode=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, code);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				producto = new Producto();
				producto.setProductCode(rs.getString("productCode"));
				producto.setProductName(rs.getString("productName"));
				producto.setProductLine(rs.getString("productLine"));
				producto.setProductScale(rs.getString("productScale"));
				producto.setProductVendor(rs.getString("productVendor"));
				producto.setProductDescription(rs.getString("productDescription"));
				producto.setQuantityInStock(rs.getInt("quantityInStock"));
				producto.setBuyPrice(rs.getDouble("buyPrice"));
				producto.setMsrp(rs.getDouble("msrp"));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return producto;
	}

	@Override
	public List<Producto> getAllProductos() {

		List<Producto> productos = new ArrayList<Producto>();
		Producto producto = null;
		Connection con = null;

		try {
			String sql = "select * from products";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				producto = new Producto();
				producto.setProductCode(rs.getString("productCode"));
				producto.setProductName(rs.getString("productName"));
				producto.setProductLine(rs.getString("productLine"));
				producto.setProductScale(rs.getString("productScale"));
				producto.setProductVendor(rs.getString("productVendor"));
				producto.setProductDescription(rs.getString("productDescription"));
				producto.setQuantityInStock(rs.getInt("quantityInStock"));
				producto.setBuyPrice(rs.getDouble("buyPrice"));
				producto.setMsrp(rs.getDouble("msrp"));

				productos.add(producto);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return productos;
	}

	@Override
	public boolean editProducto(Producto producto) {

		int resultado = 0;
		Connection con = null;

		try {
			String sql = "update products set productCode=?, productName=?, productLine=?, productScale=?, productVendor=?, productDescription=?, quantityInStock=?, buyPrice=?, msrp=? where productCode = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1,producto.getProductCode());
			statement.setString(2,producto.getProductName());
			statement.setString(3,producto.getProductLine());
			statement.setString(4,producto.getProductScale());
			statement.setString(5,producto.getProductVendor());
			statement.setString(6,producto.getProductDescription());
			statement.setInt(7, producto.getQuantityInStock());
			statement.setDouble(8, producto.getBuyPrice());
			statement.setDouble(9, producto.getMsrp());
			statement.setString(10, producto.getProductCode());
			
			resultado = statement.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado==0?false:true);
	}

}
