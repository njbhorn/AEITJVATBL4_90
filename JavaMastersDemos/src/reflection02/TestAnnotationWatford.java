package reflection02;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyDemoAnnotation(myInfo="This is my Watford class")
public class TestAnnotationWatford {
	
	@MyDemoAnnotation(myInfo="This is my public field")
	public String myFieldPub = "pub value";
	
	@MyDemoAnnotation(myInfo="This is my private field")
	private String myFieldPri = "pri value";
	
	@MyDemoAnnotation(myInfo="This is my protected field")
	protected String myFieldPro = "pro value";
	
	@MyDemoAnnotation(myInfo="This is my package field")
	String myFieldPac = "pac value";
	
	@MyDemoAnnotation(myInfo="This is my Constructor")
	public TestAnnotationWatford () {
		
	}

	public static void main(String[] args) {
		@MyDemoAnnotation(myInfo="This is my Local Variable")
		String currentManager = "" ;
		
		TestAnnotationWatford ob = new TestAnnotationWatford();
		
			Class<?> c = ob.getClass();
			
			Method[] methods = c.getDeclaredMethods();
			MyDemoAnnotation annoRef = null;
			for ( Method m : methods ) {
				annoRef = m.getAnnotation(MyDemoAnnotation.class);
				if ( annoRef != null ) {
					System.out.println("Name : " + annoRef.myInfo() );	
				}
			}
			
			Field[] fields = c.getDeclaredFields();
			
			for ( Field f : fields ) {
				annoRef = f.getAnnotation(MyDemoAnnotation.class);
				if ( annoRef != null ) {
					System.out.println("Name : " + annoRef.myInfo() );	
				}
			}
			
			
		
		
		
	}
	
	@MyDemoAnnotation(myInfo="This is my public method")
	public void myMethodPub () {
		
	}
	
	@MyDemoAnnotation(myInfo="This is my private method")
	private void myMethodPri () {
		
	}
	
	@MyDemoAnnotation(myInfo="This is my protected method")
	protected void myMethodPro () {
		
	}
	
	@MyDemoAnnotation(myInfo="This is my Type")
	class MyType {
		
	}
	
	


}
