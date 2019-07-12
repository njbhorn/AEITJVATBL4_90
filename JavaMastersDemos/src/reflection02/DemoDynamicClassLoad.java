package reflection02;

import java.io.Serializable;

public class DemoDynamicClassLoad {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		// class to load MyClass
		
//		Object o = Class.forName("reflection02.MyClass");
//		
//		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//		
//		Object o2 = classLoader.loadClass("reflection02.MyClass");
		
		Class c = Class.forName("reflection02.MyDynamicClass");
		
		Object o = c.newInstance();
		
		MyDynamicClass mdc = (MyDynamicClass) o ;
		
		System.out.println(mdc.getProp());
		System.out.println(o.getClass().getName());
		
		Class c2 = int.class;
		Class c3 = int[].class;
		Class c4 = void.class;
		Class c5 = java.util.ArrayList.class;
		System.out.println("interfaces = " + c.getInterfaces());
		for ( Class ci : c.getInterfaces()){
			System.out.println(ci.getName());
		}

	}
}

class MyDynamicClass implements Serializable {
	String prop = "my dynamic class";
	
	public String getProp() {
		return prop;
	}
}