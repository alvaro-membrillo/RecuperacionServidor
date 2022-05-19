package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Product;
import org.iesalixar.servidor.model.ProductLine;

public interface DAOProductLine {
	
	public List<ProductLine> getAllProductLines();
	public boolean addProductLine(ProductLine categoria);
	public ProductLine getProductLine(String productLine);
	public int getAllProducts(String productLine);
//	public ArrayList<Product> getProductsFromProductLine(String productLine);

}
