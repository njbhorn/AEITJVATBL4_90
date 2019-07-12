package generics01;

import java.util.ArrayList;

public class LegacyCodeCollections {

	public static void main(String[] args) {
//		ArrayList<String> al = new ArrayList<>();
//		al.add("My String");
//		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(123);
		
		myMethod(al);
//		myMethod2(al);
	}
	
	public static void myMethod ( ArrayList l ) {
//		for ( String s : l ) {
//			System.out.println(s);
//		}
		for ( Object o : l ) {
			System.out.println(o.getClass().getName());
		}
		
	}
	
//	public static <T> void myMethod2 ( ArrayList<T> l ) {
//		for ( T t : l ) {
//			System.out.println(t.getClass().getName());
//		}
//	}

}
