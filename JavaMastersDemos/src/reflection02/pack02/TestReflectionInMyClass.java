package pack02;

import java.lang.reflect.*;

public class TestReflectionInMyClass {
	public static void main(String args[]) {
		try {
			MyClass a = new MyClass();
			Class<?> c = a.getClass();
			Method methods[] = c.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				int modifiers = methods[i].getModifiers();
				if (Modifier.isProtected(modifiers)) {
					System.out.println("Protected method : "
							+ methods[i].getName());
				} else if (Modifier.isPrivate(modifiers)) {
					System.out.println("Private method : "
							+ methods[i].getName());
				} else if (Modifier.isPublic(modifiers)) {
					System.out.println("Public method : "
							+ methods[i].getName());
				} else {
					System.out.println("Default method : "
							+ methods[i].getName());
				}
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}

class MyClass {
	public void meth1() {
	}

	public void meth2() {
	}

	protected void meth3() {
	}

	private void meth4() {
	}

	void meth5() {
	}
}