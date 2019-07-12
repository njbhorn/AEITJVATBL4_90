package generics01;

import java.util.ArrayList;
import java.util.List;

public class FailFast {

	public static void main(String[] args) {
		List<String> beatles = new ArrayList<String>();
		beatles.add("George Harrison");
		beatles.add("John Lennon");
		beatles.add("Ringo Starr");
		beatles.add("Paul McCartney");

		for(String beatle : beatles){
			if( beatle.equals("John Lennon") )
				  beatles.remove("John Lennon");
			System.out.println(beatle);

		}


	}

}
