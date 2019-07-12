package complexdata06;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DemoEnhancedLoop {

	public static void main(String[] args) {
		Person p1 = new Person ("Fred", 31) ;
		Person p2 = new Person ("Bill", 21) ;
		Person p3 = new Person ("Eric", 42) ;
		
		List<Person> persons = Arrays.asList( p1, p2, p3 ) ;
		
		DemoEnhancedLoop d = new DemoEnhancedLoop() ;
		d.applyToAll(persons);
		persons.forEach( p -> System.out.println(p.getName() + " age = " + p.getAge())); 

	}
	
	public void applyToAll ( Collection<Person> col ) {
		for ( Person p : col ) {
			p.incAge() ;
		}
		
		for  ( Iterator i = col.iterator() ; i.hasNext() ; ) {
			Person p = ( Person ) i.next() ;
			p.incAge();
			System.out.println(p.getName() + " age = " + p.getAge() ) ;
		}
		
		for ( Person p : col ) {
			p.incAge() ;
		}
			
	}
	

}

class Person {
	String name ;
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	int age ;
	
	public Person () {
		this.name ="who";
		this.age = 0 ;
	}
	
	public Person ( String name, int age ) {
		this.name = name ;
		this.age = age ;
	}
	
	public void incAge() {
		this.age += 1 ;
	}
}
