package generics01;

import java.util.ArrayList;
import java.util.Iterator;

public class PrimitivesToCollections {

	public static void main(String[] args) {

		ArrayList al = new ArrayList();
		
		int ip = new Integer ( 3 ) ;
		
		Integer iw = 3 ;
		
		al.add( ip ) ;
		al.add( iw ) ;
		al.add( 3 ) ;
		
		Iterator it = al.iterator();
		while ( it.hasNext()){
			System.out.println(it.next().getClass().getName());
		}

	}

}
