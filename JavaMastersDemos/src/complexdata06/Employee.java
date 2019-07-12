package complexdata06;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	
	public int compareTo ( Employee other ) {
		return this.age - other.age ;
	}
	
	String name ;
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	int age ;
	
	public Employee () {
		this.name ="who";
		this.age = 0 ;
	}
	
	public Employee ( String name, int age ) {
		this.name = name ;
		this.age = age ;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
}

class SortEmployeeByName implements Comparator<Employee> {
	public int compare ( Employee p1, Employee p2 ) {
		String name1 = p1.getName() ;
		String name2 = p2.getName() ;
		return name1.compareTo(name2) ;		
	}
}
