package demo.business;

import java.util.Collections;
import java.util.List;

import demo.dao.MySQLDataAccess;
import demo.dao.ProductData;


public class ProductOperations {
	private ProductData dao = null;
	public ProductOperations(ProductData dao){
		this.dao = dao;
	}
	public List<Product> allProducts(){
		return dao.getAllProducts();
	}
	
	public Product getProduct(int id){
		return dao.getProductByID(id);
	}
	
	public Product mostExpensiveProduct(){
		Product aproduct = null;
		List<Product> allproducts = dao.getAllProducts();
		Collections.sort(allproducts);
		aproduct = allproducts.get(allproducts.size()-1);
		return aproduct;
	}
}
