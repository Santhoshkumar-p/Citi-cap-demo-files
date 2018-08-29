package demo.app;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import demo.app.business.Shipper;
import demo.app.business.ShipperOperations;

@SpringBootApplication
public class MyFirstSpringBootProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MyFirstSpringBootProjectApplication.class, args);
		System.out.println("Hello Spring");
		MyMaths math = ctx.getBean(MyMaths.class);
		System.out.println(String.format("The factorial of 8 is %d", math.myFactorial(8)));
		ShipperOperations ops = ctx.getBean(ShipperOperations.class);
		List<Shipper> shippers = ops.getShippers();
		for(Shipper s: shippers) {
			System.out.println(s);
		}
	}	
	
	
}
