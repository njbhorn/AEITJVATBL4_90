package generics01;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcard30 {

	public static void main(String[] args) {
		List < Animal > al = new ArrayList < > ( ) ;
//		List < Cat > al = new ArrayList < > ( ) ;
		System.out.printf("size of ArrayList %d%n", al.size());
		addToList ( al ) ;
		System.out.printf("size of ArrayList %d%n", al.size());
	}
	
	public static void addToList ( List < ? super Animal > anList ) {
		anList.add( new Bear ( ) ) ;
		anList.add( new Cat ( ) ) ;
		
	}

}
