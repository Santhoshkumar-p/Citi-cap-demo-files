package demo.business;

public class Product implements Comparable<Product>{
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
	public Product(int id, String make, double price, int categoryid) {
		super();
		this.id = id;
		this.make = make;
		this.price = price;
		this.categoryid = categoryid;
	}
	@Override
	public int compareTo(Product other) {
		// TODO Auto-generated method stub
		if(this.getPrice() > other.getPrice()){
			return 1;
		}
		else if(this.getPrice() == other.getPrice()){
			return 0;
		}
		else
		{
			return -1;
		}
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
	public String toString(){
		return String.format("%s (%d) costs %.2f", 
				make,id,price);
	}
	
}
