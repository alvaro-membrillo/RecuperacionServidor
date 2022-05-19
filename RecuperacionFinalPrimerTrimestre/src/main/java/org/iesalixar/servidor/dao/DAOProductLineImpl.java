package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.OrderDetail;
import org.iesalixar.servidor.model.Product;
import org.iesalixar.servidor.model.ProductLine;

public class DAOProductLineImpl implements DAOProductLine {

	@Override
	public List<ProductLine> getAllProductLines() {

		List<ProductLine> productLines = new ArrayList<ProductLine>();
		ProductLine productLine = null;
		Connection con = null;

		try {
			String sql = "Select * from productlines";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				productLine = new ProductLine();
				productLine.setProductLine(rs.getString("productLine"));
				productLine.setTextDescription(rs.getString("textDescription"));

				productLines.add(productLine);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return productLines;
	}

	@Override
	public boolean addProductLine(ProductLine categoria) {
		int resultado = 0;
		Connection con = null;

		try {
			String sql = "insert into productlines (productLine, textDescription) values(?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, categoria.getProductLine());
			statement.setString(2, categoria.getTextDescription());

			resultado = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public ProductLine getProductLine(String productLine) {

		ProductLine categoria = null;
		Connection con = null;

		try {
			String sql = "Select * from productlines where productLine=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			categoria = new ProductLine();
			statement.setString(1, categoria.getProductLine());
			statement.setString(2, categoria.getTextDescription());

			statement.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return categoria;
	}

	@Override
	public int getAllProducts(String productLine) {
		
		int totalProductos=0;
		Connection con = null;
		
		try {
			String sql = "select count(*) as totalProductos from products p inner join productlines pl on p.productLine = pl.productLine where p.productLine=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, productLine);
			statement.executeQuery();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return totalProductos;
	}

}
