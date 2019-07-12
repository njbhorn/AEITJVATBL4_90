package pack03;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class TestAnnot {
	public static void main(String args[]) {
		MyClass ob = new MyClass();
		try {
			Class<?> c = ob.getClass();
			Method m = c.getMethod("myFunc");
			MyAnnotation annoRef = m.getAnnotation(MyAnnotation.class);
			System.out.println("Name : " + annoRef.name() + "\nValue : " + annoRef.value());
		} catch (NoSuchMethodException exc) {
			System.out.println("Method Not Found.");
		}
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
	String name();
	int value();
}

class MyClass {
	@MyAnnotation(name = "Goldilocks", value = 100)
	public void myFunc() {
		System.out.println("This is a method named myFunc()");
	}
}