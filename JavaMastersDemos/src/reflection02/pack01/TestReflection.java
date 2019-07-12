package pack01;

import java.lang.reflect.*;

public class TestReflection {
	public static void main(String args[]) {
		try {
			Class<?> c = Class.forName("java.lang.Thread");
			System.out.println("The constructors of this class are:");
			Constructor<?> constructors[] = c.getConstructors();
			for (int x = 0; x < constructors.length; x++) {
				System.out.println(" " + constructors[x]);
			}

			System.out.println("The fields of this class are:");
			Field fields[] = c.getFields();
			for (int y = 0; y < fields.length; y++) {
				System.out.println(" " + fields[y]);
			}

			System.out.println("The methods of this class are:");
			Method methods[] = c.getMethods();
			for (int z = 0; z < methods.length; z++) {
				System.out.println(" " + methods[z]);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}