package lambdas03;

import java.util.Arrays;
import java.util.List;

public class DemoFilter {

	public static void main(String[] args) {

		List<Integer> myList = Arrays.asList( 100, 10, 1, 101, 99, 123);
		
		myList
			.stream()
			.filter( i -> i > 100 )
			.forEach(System.out::println);
		
		myList
			.stream()
			.map(i -> i - 100 )
			.filter(i -> i < 0 )
			.forEach(System.out::println);
	}

}
