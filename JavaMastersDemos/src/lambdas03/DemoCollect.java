package lambdas03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoCollect {

	public static void main(String[] args) {
		
		List<Integer> myList = Arrays.asList( 10, 20, 30, 40, 50 );
		
		List<Integer> myNewList = myList
		.stream()
		.map(i -> i - 30 )
		.filter(i -> i < 0 )
		.collect( Collectors.toList() );
			
		System.out.println(myNewList);
		
		System.out.println("For List " + myList);
		
		// stream can only be used once
		Stream<Integer> st = myList.stream() ;
		
		System.out.println("Sum = " + 
				st.collect( Collectors.summarizingInt( i -> i ) )
				.getSum());
		
		st = myList.stream();
		
		System.out.println("Avg = " + 
				st.collect( Collectors.averagingInt( i -> i ) )
				.intValue());
		
		
		
	}

}
