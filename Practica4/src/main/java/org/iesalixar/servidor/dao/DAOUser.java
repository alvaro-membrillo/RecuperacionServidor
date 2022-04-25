package org.iesalixar.servidor.dao;

import org.iesalixar.servidor.model.Usuario;

public interface DAOUser {
	
	public Usuario getUser(String email);
	
}
