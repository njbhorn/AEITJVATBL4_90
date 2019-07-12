package generics01;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeInference20 {

	public static void main(String[] args) {
		Object o = getFirst ( new String[] {
				"Tom",
				"Dick",
				"Harry"
		}) ;
		
		List<String> collect = new ArrayList<String>() ;
		collect.add("Donatello");
		collect.add("Raphael");
		collect.add("Leonardo");
		collect.add("Michaelangelo");
		
		System.out.println(o);
		System.out.println(getLast(collect));

	}
	
	public static <T> T getFirst ( T [] tArr ) {
		T t = tArr [ 0 ] ;
		return t ;
	}
	
	public static <T> T getLast ( List<T> tCollect ) {
		return tCollect.get( tCollect.size() - 1 ) ;
	}

}
