package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Office;

public class DAOOfficeImpl implements DAOOffice {

	@Override
	public List<Office> getAllOffices() {
		
		List<Office> oficinas = new ArrayList<Office>();
		Office oficina;
		Connection con = null;
		
		try {
			String sql = "Select * from offices";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				oficina = new Office();
				oficina.setOfficeCode(rs.getString("officeCode"));
				oficina.setCity(rs.getString("city"));
				
				oficinas.add(oficina);
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return oficinas;
	}

	
	
}
