package optimisation07;

import java.util.ArrayList;
import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {
		ArrayList<StringBuilder> al = new ArrayList<>() ;
		int count = Integer.parseInt(args[0]);
		for ( int i = 0 ; i < count ; i++){
			al.add(new StringBuilder());
			for ( int j = 0 ; j < 100 ; j++ ){
				al.get(0).append("abcdefghijklmnopqrstuvwxyz");
			}
		}
		al = null ;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter any char to terminate: ");
	    String username = scanner.next();

	}

}
