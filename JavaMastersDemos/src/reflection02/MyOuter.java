package reflection02;

public class MyOuter {
	
	String outerProp = "declared" ;
	
	public MyOuter () {
		outerProp += ", constructor";
	}

	{
		
		outerProp += ", initialiser";
		
	}
	
	public MyOuter ( String prop ) {
		outerProp += ", constructor parameter";
	}
	
	public static void main ( String[] args){
		MyOuter mo = new MyOuter();
		MyOuter mo2 = new MyOuter("new ");
		MyOuter.MyInner mi = mo.new MyInner("new ");
		System.out.println(mo);
		System.out.println(mo2);
		System.out.println(mi);
	}
	
	@Override
	public String toString() {
		return "MyOuter [outerProp= " + outerProp + "]";
	}

	
	class MyInner {
		String innerProp = "declared" ;
		
		{
			innerProp += ", initialiser";
		}
		
		MyInner(){
			innerProp += ", constructor";
		}
		MyInner(String prop){
			innerProp += ", constructor parameter";
		}
		@Override
		public String toString() {
			return "MyInner [innerProp=" + innerProp + "]";
		}
	}

}
