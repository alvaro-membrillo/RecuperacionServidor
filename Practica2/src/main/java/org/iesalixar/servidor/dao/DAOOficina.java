package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Oficina;

public interface DAOOficina {
	
	//La oficina hay que buscarla por id
	public Oficina getOficina(String id);
	public List<Oficina> getAllOficinas();
	
}
