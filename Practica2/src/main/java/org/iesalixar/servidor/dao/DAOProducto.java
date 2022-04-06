package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Producto;

public interface DAOProducto {
	
	public Producto getProducto(String code);
	public List<Producto> getAllProductos();
	public boolean editProducto(Producto producto);

}
