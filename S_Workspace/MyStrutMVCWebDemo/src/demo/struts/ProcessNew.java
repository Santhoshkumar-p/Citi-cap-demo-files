package demo.struts;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import demo.business.Category;
import demo.dao.MySQLDataAccess;
import demo.dao.ProductData;

public class ProcessNew extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	@Override
    public String execute() {
		ProductData dao = new MySQLDataAccess();
		categories = dao.getCategories();
		return SUCCESS;
    }
}
