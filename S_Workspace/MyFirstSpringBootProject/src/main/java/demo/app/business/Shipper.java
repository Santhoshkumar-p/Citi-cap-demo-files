package demo.app.business;

public class Shipper {
	private int id;
	private String company;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return String.format("Shipper details %s phone %s id %d" , company,phone,id);
	}
	public Shipper(int id, String company, String phone) {
		super();
		this.id = id;
		this.company = company;
		this.phone = phone;
	}
	
	
}
