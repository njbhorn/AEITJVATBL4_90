package reflection02;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoDynamicMethodCall {

	public static void main(String[] args) {
		
		try {
			Class c = Class.forName("reflection02.MyClass");
			
			Method m = c.getMethod("getProp");
			Object o = c.newInstance();
			Object val = m.invoke(o);
			System.out.println(val);
			
			
			Class[] paramTypes = {String.class};
			m = c.getMethod("setProp", paramTypes);
			Object[] params = {"Test"};
			m.invoke(o, params); // invoke method m, on object o, passing params
			System.out.println(o);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
