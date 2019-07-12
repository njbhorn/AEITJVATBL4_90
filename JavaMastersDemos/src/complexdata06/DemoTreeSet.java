package complexdata06;

import java.util.Iterator;
import java.util.TreeSet;
 
public class DemoTreeSet {
 
   public static void main(String[] args) {
	   
	TreeSet<Employee> tree = new TreeSet<Employee>();
	Employee p1 = new Employee ("Zach", 31) ;
	Employee p2 = new Employee ("Andy", 21) ;
	Employee p3 = new Employee ("Fred", 41) ;
	Employee p4 = new Employee ("Bill", 32) ;
	Employee p5 = new Employee ("Xavi", 20) ;
	
	tree.add(p1);
	tree.add(p2);
	tree.add(p3);
	tree.add(p4);
	tree.add(p5);
 
	Iterator<Employee> iterator = tree.iterator();
	System.out.print("Tree set data:\n");
 
	// Displaying the Tree set data
	while (iterator.hasNext()) {
		System.out.print(iterator.next() + "\n");
	}
	System.out.println();
 
	// Check empty or not
	if (tree.isEmpty()) {
		System.out.print("Tree Set is empty.");
	} else {
		System.out.println("Tree Set size: " + tree.size());
	}
 
	// Retrieve first data from tree set
	System.out.println("First data: " + tree.first());
 
	// Retrieve last data from tree set
	System.out.println("Last data: " + tree.last());
 
	if (tree.remove(p3)) { // remove element by value
		System.out.println("\nData is removed from tree set");
	} else {
		System.out.println("\nData doesn't exist!");
	}
	System.out.print("Now the tree set contain:\n");
	iterator = tree.iterator();
 
	// Displaying the Tree set data
	while (iterator.hasNext()) {
		System.out.print(iterator.next() + "\n");
	}
	System.out.println();
	System.out.println("Now the size of tree set: " + tree.size());
	
	System.out.println("\nNow insert new data with a duplicate age");
	tree.add ( new Employee ( "Fred", 21 ));
	System.out.println("Now the size of tree set: " + tree.size());
	
	System.out.println("\nNow insert new data with a unique age");
	tree.add ( new Employee ( "Fred", 25 ));
	System.out.println("Now the size of tree set: " + tree.size());
	
	// remember we have new 8 syntax...
	tree.forEach ( System.out::println ) ;
 
	// Remove all
	tree.clear();
	if (tree.isEmpty()) {
		System.out.print("\nTree Set is empty.");
	} else {
		System.out.println("\nTree Set size: " + tree.size());
	}
   }
}
