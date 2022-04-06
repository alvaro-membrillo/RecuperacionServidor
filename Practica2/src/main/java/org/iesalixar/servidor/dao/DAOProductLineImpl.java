package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
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
				productLines.add(productLine);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return productLines;
	}

}
