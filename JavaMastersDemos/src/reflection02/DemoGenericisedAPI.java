package reflection02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DemoGenericisedAPI {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {

		Number x = new Integer ( 99 ) ;
		
		Class < ? extends Number > c = x.getClass();
		
		Constructor < ? extends Number > constr = c.getConstructor(String.class);
		
		Number n = constr.newInstance("3");
		
		System.out.println(n);
	

	}

}
