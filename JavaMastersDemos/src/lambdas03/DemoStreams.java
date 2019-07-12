package lambdas03;

import java.util.Arrays;
import java.util.List;

public class DemoStreams {
	
	public static void main ( String[] args ) {
		
		List<String> myList = Arrays.asList( "Watford", "Leeds", "Arsenal", "Barnet", "Oxford");
		
		System.out.println(myList.stream() );
		
//		myList
//			.stream()
////			.forEach(s -> System.out.println(s));
//			.forEach(System.out::println);
		
//		myList
//		.stream()
//		.filter( s -> s.endsWith("ford"))
//		.forEach(System.out::println);
//		
//		myList
//		.stream()
//		.filter( s -> s.endsWith("ford"))
//		.map(s -> s.toUpperCase())
////		.map(String::toUpperCase)
//		.forEach(System.out::println);
//		
		myList
		.stream()
			.sorted()
			.forEach(System.out::println);
	}
	
}
