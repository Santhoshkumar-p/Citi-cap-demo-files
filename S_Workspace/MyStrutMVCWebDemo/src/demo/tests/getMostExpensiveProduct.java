package demo.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import demo.dao.MySQLDataAccess;

class getMostExpensiveProduct {

	@Test
	void testGetProducts() {
		MySQLDataAccess dao = new MySQLDataAccess();
		assertEquals(263.50 ,dao.getMostExpensiveProduct().getPrice() );
	}

}
