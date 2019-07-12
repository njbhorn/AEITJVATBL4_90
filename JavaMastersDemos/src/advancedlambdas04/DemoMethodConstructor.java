package advancedlambdas04;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;

public class DemoMethodConstructor {

	public static void main(String[] args) {

		Person p1 = new Person ("Fred", 31) ;
		Person p2 = new Person ("Bill", 21) ;
		Person p3 = new Person ("Eric", 42) ;
		
		List<Person> persons = Arrays.asList( p1, p2, p3 ) ;
		
		persons.sort ( ( Person a, Person b ) -> a.name.compareTo( b.name ) ) ;
		
		persons.forEach( p -> System.out.println(p.name) );
		
//		List<Person> personsByAge = Arrays.asList( p1, p2, p3 ) ;
//		
//		personsByAge.sort ( comparing ( Person::getAge ) ) ;
//		
//		personsByAge.forEach( p -> System.out.println(p.name) );
//
//		Supplier<Person> s1 = () -> new Person("Jim", 21) ;
//		Person sp1 = s1.get();
//		
//		Supplier<Person> s2 = Person::new ;
//		Person sp2 = s2.get() ;
//		
//		BiFunction<String,Integer,Person> s3 = Person::new;
//		Person p4 = s3.apply("Lewis",42);

//		If you had three constructor args, then there isn't an appropriate functional interface in the java.util.function package, but you can invent one, e.g.:

		
		
		PersonConstructor s4 = Person::new;
		Person p5 = s4.makePerson("Lewis",42, new Date());

//		In general, the 'Function' and 'BiFunction' interfaces have an apply() method, with appropriate numbers of parameters, so it may be a resonable approach to define a generic 'TriFunction' interface, etc.

		
//		Person sp3 = s2.
		

	}

}

class Person {
	String name ;
	int age ;
	Date dob ;
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	
	
	public Person () {
		this.name ="who";
		this.age = 0 ;
	}
	
	public Person ( String name, int age ) {
		this.name = name ;
		this.age = age ;
	}
	
	public Person ( String name, int age, Date d) {
		this.name = name ;
		this.age = age ;
		this.dob = new Date();
	}
}

interface PersonConstructor {
	  public Person makePerson(String n, int a, Date d);
}
