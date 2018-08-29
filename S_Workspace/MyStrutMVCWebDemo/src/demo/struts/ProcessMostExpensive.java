package demo.struts;

import demo.business.Product;
import demo.dao.MySQLDataAccess;
import demo.dao.ProductData;

public class ProcessMostExpensive {
	private int id;
	private double price;
	private String name;
	private int categoryid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String operation;
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String mostExpensiveProduct(){
		Product product = new Product(id,name,price,categoryid);
		double expensiveprice;
		String expensivename;
		ProductData dao = new MySQLDataAccess();
		expensiveprice = dao.getMostExpensiveProduct().getPrice();
		expensivename = dao.getMostExpensiveProduct().getMake();
		if(expensiveprice != 0 && expensivename != null){
			operation = "The Most Expensive Product is " + expensivename + " and the price is " + expensiveprice + ".";
			return "success";
		}
		else{
			return "none";
		}
	}
}
