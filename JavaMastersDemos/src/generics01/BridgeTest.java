package generics01;

import java.util.Comparator;

public class BridgeTest {
	public static void main ( String[] args ) {
		MyComparator mc = new MyComparator();
		mc.compare ( "x", "y") ;
	}
}


