package org.iesalixar.servidor.dao;

import org.iesalixar.servidor.model.Usuario;

public interface DAOUsuario {
	
	public boolean registerUsuario(Usuario usuario);
	public Usuario getUsuario(String usuario);

}
