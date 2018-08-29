package demo.struts;

import demo.business.Product;
import demo.dao.MySQLDataAccess;
import demo.dao.ProductData;

public class ProcessAdd {
	private int id;
	private String make;
	private double price;
	private int categoryid;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	private String operation;
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

	public String addProduct(){
		Product product = new Product(id,make,price,categoryid);
		int rowsAffected;
		ProductData dao = new MySQLDataAccess();
		rowsAffected = dao.addProduct(product);
		if(rowsAffected == 1){
			operation = make + ", " + price + " added";
			return "success";
		}
		else{
			return "none";
		}
	}
}
