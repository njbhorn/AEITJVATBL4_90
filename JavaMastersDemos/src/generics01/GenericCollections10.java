package generics01;

import java.util.ArrayList;
import java.util.List;

public class GenericCollections10 {

	public static void main(String[] args) {

		List<Animal> al = new ArrayList<Animal>();
		al.add(new Cat());
		al.add( new Aardvark() );
		processList( al );
	
//		List<Animal> al2 = new ArrayList<Cat>(); // does not compile
		
		// so let's use wildcard type for list ?
//		List<?> al3 = new ArrayList<Cat>();
//		al3.add( new Cat() ); // does not compile
//		al3.add( new Aardvark() ); // does not compile

		List<Cat> al4 = new ArrayList<Cat>() ;
		al4.add(new Cat());
//		processList( al4 ) ;  // does not compile
//		processList2( al4 ) ;
		
		addToList ( al, new Cat() );
		addToList ( al , new Bear() );
//		processList( al );
//		processList3( al );
	}
	
	public static void processList( List<Animal> l ) {
		for ( Animal a : l ) {
			a.printMyType();
		}
	}
	
	public static void processList2 ( List<? super Animal> l ) {
//		for ( Animal a : l ) {
//			a.printMyType();
//		}
		l.add( new Animal() ) ; // l is unknown could be a butterfly 
		l.add( new Aardvark() ) ;
		l.add( null ) ;
	}
	
	public static <T> void addToList ( List<T> myList, T someAnimal ) {
		myList.add( someAnimal) ;
	}
	
	

}
