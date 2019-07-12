package generics01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HeapPollution60 {

	public static void main(String[] args) {
		List rawAnimals = new ArrayList();
		
		List<Animal> animals = rawAnimals ;
		
		rawAnimals.add( new Date() ) ;
		
//		Animal a = animals.get(0) ; // Date cannot be cast to Animal!
//		
//		System.out.println(a);
		
//		System.out.println(getFirst( animals ) ) ;
		
	}
	
	public static Animal getFirst(List<Animal>... args) {
		Object[] objectArray = args ;
		List<Date> list = new ArrayList<Date>();
		list.add(new Date());
		objectArray[0] = list ; // basically assigning List<Animal>[] to List<Date>
		Animal a = args[0].get(0) ; // exception Date cast to Animal
		return a ;
	}

}
