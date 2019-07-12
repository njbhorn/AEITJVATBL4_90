package complexdata06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.RandomAccess;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class DemoRandomAccessMarker {

	public static void main(String[] args) {

		Collection[] c = {  new ArrayList<>()
				, new LinkedList()
				, new HashSet() 
				, new Vector()
				, new Stack()
				, new TreeSet()
		} ;
		
		for ( Collection lc : c ) {
			if ( lc instanceof RandomAccess ) {
				System.out.println(lc.getClass().getName() + " implements RandomAccess");
			} else {
				System.out.println(lc.getClass().getName() + " does not implements RandomAccess");
			}
		}
		
		
		

	}

}
