package lambdas03;

import java.util.Arrays;
import java.util.List;

public class DemoReduce {

	public static void main(String[] args) {
		
		List<String> myList = Arrays.asList( "Watford", "Leeds", "Arsenal", "Barnet", "Oxford");
		
		String concatenated = myList
				.stream()
				.reduce( "Teams : ", String::concat );
		
		System.out.println(concatenated);
		
		List<Integer> myListNumbers = Arrays.asList ( 1, 2, 3, 4, 5, 6, 7) ;
		
		Integer i = myListNumbers
				.stream()
				.reduce( 1, (x, a) -> a + x ) ;
			
			System.out.println(i);
			
			
//		List<Integer> myListNumbers = Arrays.asList ( 1, 2 , 3) ;
//		
//		Integer i = myListNumbers
//			.stream()
//			.reduce( 0, (x, a) -> a + x ) ;
//		
//		System.out.println(i);
	}

}
