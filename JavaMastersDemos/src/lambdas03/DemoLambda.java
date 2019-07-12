package lambdas03;

import java.util.ArrayList;
import java.util.List;

public class DemoLambda {

	public static void main(String[] args) {

		List<Integer> intList = new ArrayList<Integer>() ;
		intList.add(100);
		intList.add(200);
		intList.add(300);
		
		
//		List<Integer> tempList = new ArrayList<Integer>() ;
//		for ( int x = 0 ; x < intList.size() ; x++ ) {
//			tempList.add(intList.get(x) + 1 ) ;
//		}
//		intList = tempList ;
		

		List<Integer> tempList = new ArrayList<Integer>() ;
		intList.forEach( i -> {
			i = i + 1 ;
			System.out.println(i);
//			
//			tempList.add(i);
		});
		
		System.out.println(tempList);
		
		tempList.forEach(System.out::println);
	}

}
