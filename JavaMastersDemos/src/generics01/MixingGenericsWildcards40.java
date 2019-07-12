package generics01;

import java.util.ArrayList;
import java.util.List;

public class MixingGenericsWildcards40 {

	public static void main(String[] args) {
		List < Animal > al = new ArrayList <> () ;
		addToList ( al, new Bear () ) ;
		System.out.println(al.size());
		
		List < String > as = new ArrayList <> () ;
		addToList ( as, "Ice" ) ;
		System.out.println(al.size());
		
	}
	
	static <T> void addToList ( List < ? super T > aniList, T animal ) {
		aniList.add( animal ) ;
	}

}
