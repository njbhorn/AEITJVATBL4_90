package reflection02;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class DemoFieldMethods {

	public static void main(String[] args) {
		try {

			Field[] fs = MyClass.class.getDeclaredFields();

			for (Field f : fs) {
				String msg = "";
				switch (f.getModifiers()) {
				case Modifier.PRIVATE:
					msg = "Private";
					break;
				case Modifier.PROTECTED:
					msg = "Protected";
					break;
				case Modifier.PUBLIC:
					msg = "Public";
				}
				System.out.println(f.getName() + " is " + msg);
			}

		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}

}
