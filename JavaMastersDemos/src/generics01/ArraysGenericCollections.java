package generics01;

import java.util.ArrayList;

public class ArraysGenericCollections {

	public static void main(String[] args) {
//		ArrayList<Animal>[] al = new ArrayList<Animal>[10];
		
		ArrayList<?>[] animArray = new ArrayList<?>[5];
		ArrayList<Animal> al = new ArrayList<Animal>();
		al.add( new Bear() );
		al.add( new Aardvark() );
		al.add( new Bear() );
		al.add( new Aardvark() );
		al.add( new Cat() );
		al.add( new Bear() );
		al.add( new Aardvark() );
		al.add( new Cat() );
		al.add( new Bear() );
		al.add( new Aardvark() );
		al.add( new Cat() );
		al.add( new Aardvark() );
		al.add( new Cat() );
		al.add( new Bear() );
		al.add( new Aardvark() );
		al.add( new Cat() );
		System.out.println(al.size());
		animArray[0] = al ;
		System.out.println(animArray[0].getClass().getName());
		System.out.println(((Animal) animArray[0].get(0)).getClass().getName());
		System.out.println( animArray[0].get(0).getClass().getName());
		

	}

}
