package generics01;

import java.util.ArrayList;
import java.util.List;

public class BasicExample {

	public static void main(String[] args) {
		List<Book> al = new ArrayList<Book>() ;
		al.add(new Book ("Treasure Island")) ;
		al.add(new Book ( "The JFC Swing Tutorial")) ;
		al.add(new Book ("Core Java") ) ;
//		al.add("Grokking the Gimp") ;
		
		Book b = al.get(1) ;
		
		System.out.println(b.getTitle());

	}

}

class Book {
	private String title ;
	
	public String getTitle() {
		return title;
	}

	public Book ( String title ) {
		this.title = title ;
	}
	
	
}
