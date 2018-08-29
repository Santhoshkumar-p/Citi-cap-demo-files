package demo.struts;
import java.util.List;

import demo.business.Product;
import demo.business.ProductOperations;
import demo.dao.MySQLDataAccess;

public class ProcessPage {
	private List<Product> products;
	private int page;
	private int[] pages;
	public String first(){
		ProductOperations props = new ProductOperations(new MySQLDataAccess());
		List<Product> temp = props.allProducts();
		products = temp.subList(0, 10);
		int numPages = temp.size() / 10 + 1;
		pages = new int[numPages];
		for(int i = 0; i < numPages; i++){
			pages[i] = i + 1;
		}
		return "success";
	}
	public int[] getPages() {
		return pages;
	}
	public void setPages(int[] pages) {
		this.pages = pages;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String execute(){
		ProductOperations props = new ProductOperations(new MySQLDataAccess());
		List<Product> temp = props.allProducts();
		int start = page * 10 - 10;
		if(start + 10 < temp.size()){
			products = temp.subList(start, start + 10);
		}
		else{
			products = temp.subList(start, temp.size());
		}
		int numPages = temp.size() / 10 + 1;
		pages = new int[numPages];
		for(int i = 0; i < numPages; i++){
			pages[i] = i + 1;
		}
		return "success";
	}
}
