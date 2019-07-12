package pack04;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1 {
	String nameOfFunction();

	int value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
	String nameOfClass();
}

public class TestAnnots {
	public static void main(String args[]) {
		MyClass ob = new MyClass();
		try {
			Annotation annos[] = ob.getClass().getAnnotations();
			System.out.println("All annotations for MyClass:");
			for (Annotation a : annos)
				System.out.println(a);
			System.out.println();
			Method m = ob.getClass().getMethod("myFunc");
			annos = m.getAnnotations();
			System.out.println("All annotations for myFunc:");
			for (Annotation a : annos)
				System.out.println(a);

		} catch (NoSuchMethodException exc) {
			System.out.println("Method Not Found.");
		}
	}
}

@MyAnnotation2(nameOfClass = "Three Bears")
class MyClass {
	@MyAnnotation1(nameOfFunction = "Goldilocks", value = 100)
	public void myFunc() {
		System.out.println("This is a method named myFunc()");
	}
}