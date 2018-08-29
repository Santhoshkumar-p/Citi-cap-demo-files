package demo.struts;

import com.opensymphony.xwork2.ActionSupport;

import demo.business.Product;
import demo.dao.MySQLDataAccess;
import demo.dao.ProductData;

public class ProcessDelete extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int id;
	private Product product;
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
	
	
	@Override
    public String execute() {
		int rowsAffected;
		ProductData dao = new MySQLDataAccess();
		product = dao.getProductByID(id);
		rowsAffected = dao.deleteProduct(id);
		if(rowsAffected == 1){
			operation = product + " was deleted";
			return SUCCESS;
		}
		else{
			return "none";
		}
    }
}
