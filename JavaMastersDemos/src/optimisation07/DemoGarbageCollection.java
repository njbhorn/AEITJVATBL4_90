package optimisation07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DemoGarbageCollection {

	public static void main(String[] args) {

		List<Person> people = new ArrayList<>();
		Random randomGenerator = new Random();
		int randomInt = 0;
		int noOfPeople = 1000;
		int sleepInterval = 100;
		int gcInterval = 0;

		if (args.length != 0) {
			try {
				gcInterval = noOfPeople - Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				gcInterval = noOfPeople - 1;
			}
		}
		String val;
		Scanner inval = new Scanner( System.in );
		System.out.println(" GC interval is " + gcInterval );
		System.out.print("Create " + noOfPeople + " People Hit any Key then Return : ");
		val = inval.next( );
		System.out.println("Creating " + noOfPeople + " People...");
		for (int i = 0; i < noOfPeople; i++) {
			char[] name = new char[1000];
			for (int j = 0; j < 1000; j++) {
				randomInt = randomGenerator.nextInt(26);
				name[j] = (char) (65 + randomInt);
			}
			people.add(new Person(name.toString(), randomInt));
		}
		System.out.println("Created " + people.size() + " People...");
		System.out.print("Start Deleting People at Random Hit any Key then Return : ");
		val = inval.next( );
		// randomly delete an arraylist item
		while (people.size() > 0) {
			randomInt = randomGenerator.nextInt(people.size());
			try {
				Person oldPerson = people.remove(randomInt);
				Thread.sleep(sleepInterval);

				if (gcInterval >= people.size()) {
					System.out.print("Garbage Collect Hit any Key then Return : ");
					val = inval.next( );
		
					System.gc();
					System.out.println("GC Called...");
				}

				Person p = people.get(randomInt);
				System.out.println(oldPerson.getName() + " Age " + oldPerson.getAge());
				System.out.println(p.getName() + " Age " + p.getAge());
				System.out.println("Array size now " + people.size() );
			} catch (IndexOutOfBoundsException | InterruptedException e) {
				e.printStackTrace();
				System.out.println("Index No " + randomInt);
			}
			System.out.println("Delete Person No " + randomInt);
		}

		System.out.println("Finished...");

	}

}

class Person {
	String name;
	String name2;
	String name3;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	int age;

	public Person() {
		this.name = "who";
		this.age = 0;
	}

	public Person(String name, int age) {
		this.name = name;
		this.name2 = name ;
		this.name3 = name ;
		this.age = age;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Finalize called for " + this.getName() + " age = " + this.getAge());
	}
	
	
}