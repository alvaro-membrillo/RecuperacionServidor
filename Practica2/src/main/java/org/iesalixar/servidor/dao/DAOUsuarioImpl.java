package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Usuario;

public class DAOUsuarioImpl implements DAOUsuario {

	@Override
	public Usuario getUsuario(String nombre) {
		
		Usuario usuario = null;
		Connection con = null;
		
		try {
			
			String sql = "SELECT * from usuarios where usuario=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, nombre);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setRole(rs.getString("role"));
				usuario.setFirstName(rs.getString("firstName"));
				usuario.setLastName(rs.getString("lastName"));
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return usuario;
	}

	@Override
	public boolean registerUsuario(Usuario usuario) {
		
		int resultado = 0;
		
		try {
			String sql = "insert into usuarios values(?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			PreparedStatement statement = pool.getConnection().prepareStatement(sql);
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getPassword());
			statement.setString(4, usuario.getRole());
			statement.setString(5, usuario.getFirstName());
			statement.setString(6, usuario.getLastName());
			
			resultado = statement.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return (resultado == 0 ? false : true);
	}	

}
