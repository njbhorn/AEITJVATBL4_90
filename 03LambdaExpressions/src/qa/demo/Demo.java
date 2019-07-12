package qa.demo;

public class Demo {

	private String value ;
	private DemoFunctionalInterface dfi =  ( i, i2 ) -> {
		return Integer.toString(  i * i2 ) ;
	};
	
	public Demo ( String value ) {
		this.value = value ;
		System.out.println(dfi ( 1,2 ));
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void demo ( ) {
		String val = this.dfi (10,20);
	}
	
	
	
}
