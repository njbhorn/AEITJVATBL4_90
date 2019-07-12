package lambdas03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DemoMap {
	public static void main(String[] args) {
		// Map

		List<Integer> myList = Arrays.asList(100, 10, 1, 101, 99, 123);

		myList.stream().map(i -> i * 2).forEach(System.out::println);

		Stream<Boolean> isEven = myList
				.stream()
				.map(i -> i % 2 == 0);
		
		isEven.forEach(System.out::println);
				
	}
}
