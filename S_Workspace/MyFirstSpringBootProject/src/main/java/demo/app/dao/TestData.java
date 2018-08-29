package demo.app.dao;

import java.util.ArrayList;

import demo.app.business.Shipper;
@Component
public class TestData implements IShipper {
@Override
public ArrayList<Shipper> allShippers() {
	ArrayList<Shipper> shippers = new ArrayList<>();
	shippers.add(new Shipper(1,"Chennai couriers","5445243"));
	shippers.add(new Shipper(2,"Kochi couriers","3545664"));
	shippers.add(new Shipper(3,"Mumbai couriers","5645553"));
	return shippers;
}
}
