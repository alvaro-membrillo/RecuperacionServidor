package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Product;

public interface DAOProduct {
	
	public List<Product> getProductsByCategoria(String productLine);

}
