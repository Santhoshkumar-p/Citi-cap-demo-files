package demo.app;

import org.springframework.stereotype.Component;

@Component
public class MyMaths {
		
		public long myFactorial(int n) {
			if(n == 0 || n==1) {
				return 1;
		}
			else {
				return n * myFactorial(n-1);
		}
}
}
