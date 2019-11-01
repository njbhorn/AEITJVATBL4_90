package generics01;

import java.util.ArrayList;
import java.util.List;

public class DemoArrayList {

	public static void main(String[] args) {
		
		processList ( "fred", "jim", "mary" ) ;
		processList ( "fred", "jim" ) ;
		processList ("fred") ;
		processList ( "fred", "jim", "mary", "adam", "ann", "anne" ) ;

	}

	private static void processList( String... names) {
		for ( String name : names ) {
			System.out.println(name);
		}
		
	}

	

}
