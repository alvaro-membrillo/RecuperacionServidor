package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Products;

public interface DAOProduct {
	
	public List<Products> getProductsByCategoria(String productLine);

}
