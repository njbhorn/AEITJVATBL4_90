package reflection02;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DemoArrayElements {

	public static void main(String[] args) {
		try {
			Object o = MyArrayContainer.class.newInstance();
			Field f = MyArrayContainer.class.getField("nums");
			Array.setInt(f.get(o), 1, 99);
			Method m = MyArrayContainer.class.getMethod("printArray");
			m.invoke ( o ) ;
		} catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class MyArrayContainer {
	public int[] nums = new int[3];
	
	public void printArray() {
		System.out.println(Arrays.toString(nums));
	}
}
