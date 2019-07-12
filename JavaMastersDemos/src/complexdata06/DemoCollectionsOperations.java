package complexdata06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

public class DemoCollectionsOperations {

	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList( 100, 10, 1, 101, 99, 123);
		System.out.println(myList);
		
		Collections.sort(myList);
		System.out.println(myList);
		
//		System.out.println("Pos of 100 = " + Collections.binarySearch(myList, 100));
//		System.out.println("Pos of 10 = " + Collections.binarySearch(myList, 10));
//		System.out.println("Pos of 1 = " + Collections.binarySearch(myList, 1));
//		System.out.println("Pos of 101 = " + Collections.binarySearch(myList, 101));
//		System.out.println("Pos of 99 = " + Collections.binarySearch(myList, 99));
//		System.out.println("Pos of 123 = " + Collections.binarySearch(myList, 123));
//		System.out.println("Pos of 50 = " + Collections.binarySearch(myList, 50));
//		System.out.println("Pos of 150 = " + Collections.binarySearch(myList, 150));
//		
		Collections.reverse(myList);
		System.out.println(myList);
		
		Collections.shuffle(myList);
		System.out.println(myList);
		
		Collections.shuffle(myList);
		System.out.println(myList);
		
		List<Integer> myNewList2 = Collections.EMPTY_LIST ;
		System.out.println(myNewList2);
		
		List<String> myStringList = Collections.emptyList();
		System.out.println(myStringList);
		
		List<Integer> myNewList = new ArrayList<Integer>(myList);
		System.out.println(myNewList);
		
		Collections.fill(myNewList,  99);
		System.out.println(myNewList);
		
		Collections.copy(myNewList, myList);
		System.out.println(myNewList);
		
		Set<Integer> s = Collections.singleton(99);
		s.forEach(System.out::println);
		try {
			s.add(123);
			s.forEach(System.out::println);
		} catch ( UnsupportedOperationException e ){
			e.printStackTrace();
		}
		
		java.util.Collection<Integer> readOnlyList = Collections.unmodifiableCollection(myList);
		System.out.println(readOnlyList);
		try {
			readOnlyList.clear();	
		} catch ( UnsupportedOperationException e ){
			e.printStackTrace();
		}
		
		if ( myList instanceof RandomAccess ) {
			System.out.println(myList + " is a RandomAccess instance");
		}
		
		if ( myList instanceof RandomAccess ) {
			System.out.println(myList + " is a RandomAccess instance");
		}
		 
	}

}
