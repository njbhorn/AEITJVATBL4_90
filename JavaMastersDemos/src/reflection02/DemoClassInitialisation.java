package reflection02;

public class DemoClassInitialisation {

	public static final int CONST = 37 ;
	public static final int CONST2 = CONST + 7 ;
	public static final int STAT ;
	public static final int STAT2 ;
	
	static {
		STAT = 99 ;
	}
	
	static {
		int x = 0 ;
		for ( int i = 0 ; i < 4 ; i++ ) {
			x += i ;
		}
		STAT2 = STAT + x ;
	}
	
	public static void main(String[] args) {
		DemoClassInitialisation dc = new DemoClassInitialisation();
		System.out.println(dc.STAT);
		System.out.println(dc.STAT2);
	}

}
