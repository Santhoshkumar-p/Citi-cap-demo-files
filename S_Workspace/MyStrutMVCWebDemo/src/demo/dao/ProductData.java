package demo.dao;

import java.util.List;
import demo.business.Product;
import demo.business.Category;

public interface ProductData {
	public List<Product> getAllProducts();
	public Product getProductByID(int id);
	public int addProduct(Product p);
	public int updateProduct(Product p);
	public int deleteProduct(int id);
	public Product getMostExpensiveProduct();
	public List<Category> getCategories();
}
