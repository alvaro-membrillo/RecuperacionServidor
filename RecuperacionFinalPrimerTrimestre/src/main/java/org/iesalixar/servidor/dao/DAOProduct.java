package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Product;

public interface DAOProduct {
	
	public boolean addProduct(Product product);
	public Product getProductById(String productCode);
	public List<Product> getAllProducts();
	public boolean updateProduct(String productCode, String productLine);
	
}
