package reflection02;

public class MyClass extends MyBase {
	private String prop;
	public String pubProp;
	
	public MyClass(){
		this("Hello");
	}
	
	public MyClass ( String prop){
		
		this.prop = prop ;
	}
	
	public static void main ( String[] args){
		MyClass mc = new MyClass("Goodbye");
		mc.prop = "";
	}
	
	public void setProp(String prop){
		this.prop = prop;
	}
	
	public String getProp() {
		
		return prop ;
	}

	@Override
	public String toString() {
		return "MyClass [prop=" + prop + "]";
	}
	
	

}
