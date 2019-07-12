package reflection02;

public class DemoClassLoader {
	
	public static void main ( String[] args){
		DemoClassLoader dcl = new DemoClassLoader();
		
		Class c = dcl.getClass() ;
		
		ClassLoader cl = c.getClassLoader();
		
		System.out.println(cl);
		
		ClassLoader cl2 = ClassLoader.getSystemClassLoader();
		
		System.out.println(cl2);
	}
}
