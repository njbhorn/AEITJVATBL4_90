import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10) ;

		Stream<Integer> newList = intList.stream()
										.map( i -> i * 2 ) ;

		newList.forEach(System.out::println);

		Stream<Boolean> isEven = intList.stream()
										.map(i -> i % 2 == 0 ) ;
		isEven.forEach(s -> System.out.println(s + ", "));

		String total = intList.stream()
				.map( i -> i * i )
				.filter ( i -> i % 2 == 0 )
				.collect ( Collectors.summarizingInt( i -> i ))
				.toString() ;
		System.out.println("stats = " + total );

		DemoInterface di = s -> s.toUpperCase() ;

		System.out.println(di.demo("fred"));
	}

}
