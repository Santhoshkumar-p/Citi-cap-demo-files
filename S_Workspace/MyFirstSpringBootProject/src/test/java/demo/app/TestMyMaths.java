package demo.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMyMaths {

	@Test
	void test() {
		MyMaths math = new MyMaths();
		assertEquals(120,math.myFactorial(5));
		assertEquals(720,math.myFactorial(6));

		
	}

}
