package complexdata06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DemoComparable {

	public static void main(String[] args) {
		Employee p1 = new Employee ("Zach", 31) ;
		Employee p2 = new Employee ("Andy", 21) ;
		Employee p3 = new Employee ("Fred", 41) ;
		
		List<Employee> emps = Arrays.asList ( p1, p2, p3 ) ;
		
		System.out.println ("Before Sort") ;
		emps.forEach ( p -> System.out.println ( p.name + " " + p.age ) ) ;
		
		System.out.println ( "\nAfter Sort" ) ;
		Collections.sort ( emps ) ;		// use the comparable interface compareTo
		emps.forEach( p -> System.out.println (p.name + " " + p.age ) ) ;
	
		System.out.println ( "\nAfter SortEmployeeByName" );	// use the comparator interface compareTo in custom class
		Collections.sort ( emps, new SortEmployeeByName() );
		emps.forEach ( p -> System.out.println ( p.name + " " + p.age ) ) ;
		
	}

}

