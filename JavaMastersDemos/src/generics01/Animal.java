package generics01;

public class Animal {

	public void printMyType() {
		System.out.println(this.getClass().getName());
	}
}

class Aardvark extends Animal {
	
}

class Bear extends Animal {
	
}

class Cat extends Animal {
	public void printMyType() {
		System.out.println("I am a cat " + this.getClass().getName());
	}
	
}