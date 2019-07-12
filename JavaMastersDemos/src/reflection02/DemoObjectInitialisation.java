package reflection02;

import java.util.Date;

public class DemoObjectInitialisation {
	public static void main ( String[] args){
		
		// inner class subclassing date
		Date d = new Date ( 1 ) {
			{
				setYear(59);
				setMonth(10);
				setDate(13);
			}
		} ;
		
		System.out.println(d);
		
		MySub o = new MySub() ;
		
	}
}

class MySuper {
	
	MySuper ( Object o ) {
		
	}
}

class MySub extends MySuper {
	
//	MySub() {
//		super("");
//		// TODO Auto-generated constructor stub
//	}

	MySub(Object o) {
		super(o);
		// TODO Auto-generated constructor stub
	}
	
}