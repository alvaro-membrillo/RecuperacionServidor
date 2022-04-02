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

}
