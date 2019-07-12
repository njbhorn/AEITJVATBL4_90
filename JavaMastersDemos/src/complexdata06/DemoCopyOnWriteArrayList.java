package complexdata06;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DemoCopyOnWriteArrayList {

	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		
		ListIterator<String> iter = list.listIterator();
		
		while ( iter.hasNext()){
			String s = iter.next();
			System.out.println(s);
//			iter.set("nope");
		}
		
		List<String> list2 = new ArrayList<String>();
		list2.add("One");
		list2.add("Two");
		list2.add("Three");
		
		ListIterator<String> iter2 = list2.listIterator();
		System.out.println(list2);
		while ( iter2.hasNext()){
			String s = iter2.next();
			System.out.println(s);
			iter2.set("nope");
		}
		
		System.out.println(list2);

	}

}
