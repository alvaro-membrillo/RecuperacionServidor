package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Usuario;

public class DAOUsuarioImpl implements DAOUsuario {

	@Override
	public Usuario getUsuario(String usuario) {
		
		Usuario user = null;
		Connection con = null;
		
		try {
			String sql = "Select * from usuarios where usuario=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, usuario);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				user = new Usuario();
				user.setUsuario(rs.getString("usuario"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return user;
	}

}
