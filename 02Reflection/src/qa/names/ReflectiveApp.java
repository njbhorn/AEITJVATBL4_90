package qa.names;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectiveApp {

	public static void main(String[] args) {

		String classname = null;
		if (args.length == 0) {
			classname = "qa.names.NamesResource";
		} else {
			classname = args[0];
		}

		try {
			Class<?> c = Class.forName(classname);

			Object instance = c.newInstance();
			Method[] methods = c.getDeclaredMethods();
			for (Method m : methods) {
				if (satifiesCriteria(m)) {
					String s = (String) m.invoke(instance, new Object[0]);
					System.out.println(m.getName() + ": " + s);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static boolean satifiesCriteria(Method m) {

		if (!Modifier.isPublic(m.getModifiers()))
			return false;

		if (m.getReturnType() != String.class)
			return false;

		if (m.getParameterCount() != 0)
			return false;

		return true;
	}

}
