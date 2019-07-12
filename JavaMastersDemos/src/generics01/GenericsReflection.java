package generics01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericsReflection {
	public static void main ( String[] args) {
//		List<Animal> animals = new ArrayList<Animal>();	// ok
//		
//		Class c = animals.getClass();
//		System.out.println(c.getName()); // prints java.util.ArrayList
		
//		List<Animal> animals = new ArrayList<Bear>(); // does not compile
		
//		List<? extends Animal> animals = new ArrayList<Bear>();
//		Class c = animals.getClass();
//		System.out.println(c.getName()); // prints java.util.ArrayList
		
		List<String> as = new ArrayList<String>();
		List<Date> ad = new ArrayList<Date>();
		Class cs = as.getClass();
		System.out.println(cs.getName()); // prints java.util.ArrayList
		Class cd = ad.getClass();
		System.out.println(cd.getName()); // prints java.util.ArrayList
		if ( as instanceof ArrayList ) {
			
		}
		
		Class<? extends Number> c = Integer.class ;
		System.out.println(c.getName());
		
	}
}

