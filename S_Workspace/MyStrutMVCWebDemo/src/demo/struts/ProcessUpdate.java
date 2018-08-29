package demo.struts;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import demo.business.Category;
import demo.business.Product;
import demo.dao.MySQLDataAccess;
import demo.dao.ProductData;

public class ProcessUpdate extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int id;
	public int getId() {
		return id;
	}
	private Product product;
	private List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	@Override
    public String execute() {
		int rowsAffected;
		ProductData dao = new MySQLDataAccess();
		product = dao.getProductByID(id);
		categories = dao.getCategories();
		return SUCCESS;
    }


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public void setId(int id) {
		this.id = id;
	}
}
