package advancedlambdas04;

import java.util.Arrays;
import java.util.List;

public class DemoImplementation {
	
	List<Person> persons ;
	
	public DemoImplementation ( ) {
		Person p1 = new Person ("Fred", 31) ;
		Person p2 = new Person ("Bill", 21) ;
		Person p3 = new Person ("Eric", 42) ;
		
		this.persons = Arrays.asList( p1, p2, p3 ) ;
	}
	
	public void removeByAge ( int min, int max ) {
		
		List<Person> lp = this.persons ;
		
		persons.removeIf ( p -> ( p.age >= min && p.age <= max ) ) ;
	}
}
