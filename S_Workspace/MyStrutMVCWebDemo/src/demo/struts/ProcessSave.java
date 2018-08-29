package demo.struts;

import com.opensymphony.xwork2.ActionSupport;

import demo.business.Product;
import demo.dao.MySQLDataAccess;
import demo.dao.ProductData;

public class ProcessSave extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int id;
	private String make;
	private int categoryid;
	private double price;
	private String operation;
	
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
    public String execute() {
		Product product = new Product(id,make,price,categoryid);
		int rowsAffected;
		ProductData dao = new MySQLDataAccess();
		rowsAffected = dao.updateProduct(product);
		if(rowsAffected == 1){
			operation = make + ", " + price + " changed";
			return SUCCESS;
		}
		else{
			return "none";
		}
    }
	
}
