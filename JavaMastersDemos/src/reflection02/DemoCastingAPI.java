package reflection02;

public class DemoCastingAPI {

	public static void main(String[] args) {

//		Class<Double> c = Double.class ;
//		
//		Number n = new Double(3);
//		
//		Double d = c.cast(n);
//		
//		// or in a single line
//		
//		Double d2 = Double.class.cast(n);
		
		// narrowing
		
		Class<Number> c = Number.class ;
		
		Class<? extends Integer> ic = c.asSubclass(Integer.class);
		
		System.out.println(ic.getName());
		
		

	}

}
