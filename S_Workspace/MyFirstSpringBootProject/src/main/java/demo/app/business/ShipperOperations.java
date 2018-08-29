package demo.app.business;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import demo.app.MyFirstSpringBootProjectApplication;
import demo.app.MyMaths;
import demo.app.dao.IShipper;

@Component
public class ShipperOperations {
	
	private IShipper dao;
	
	@Autowired
	public ShipperOperations(IShipper dao) {
		this.dao = dao;
	}
	
	public List<Shipper> getShippers(){
		return dao.allShippers();
	}
}




