package qa.generics.toyshop;

import qa.generics.Department;
import qa.generics.Section;

public class QAShop {
	
	public static void main(String[] args) {

		Department<ShopItem> shop = new Department<ShopItem>("Shop");
		Department<Toy> toyDepartment = new Department<Toy>("Toys");
		Department<Book> bookDepartment = new Department<Book>("Books");
		
		shop.addSubDepartment(toyDepartment);
		shop.addSubDepartment(bookDepartment);
		
		Department<SoftToy> softToys = new Department<SoftToy>("Soft Toys");
		
		Section<TeddyBear> teddies = new Section<TeddyBear>("Teddies", softToys);
		Section<TrainSet> trainsets = new Section<TrainSet>("Train Sets", toyDepartment);
		
		toyDepartment.addSubDepartment(softToys);
		
		teddies.addItem(new TeddyBear("Rupert"));
		teddies.addItem(new TeddyBear("Pooh"));
		teddies.addItem(new TeddyBear("Paddington"));
		
		trainsets.addItem(new TrainSet("Hornby Deluxe"));
		trainsets.addItem(new TrainSet("Lego Rail"));
		
		printItems(teddies);
		printItems(shop);
		
		System.out.println("There are " + shop.getCount() + " things in the Shop.");
		
		System.out.println("All TrainSets:");
		for (TrainSet t : shop.getAll(TrainSet.class)) {
			System.out.println("\t" + t.getToyName());
		}

	}
	
	private static void printItems(Section<? extends ShopItem> section) {
		System.out.println("Items in " + section.getSectionName() + " Section:");
		for (ShopItem item : section) {
			System.out.println("\t" + item.getName());
		}
	}
	
	private static void printItems(Department<? extends ShopItem> department) {
		System.out.println("Items in " + department.getDepartmentName() + " Department:");
		for (ShopItem item : department) {
			System.out.println("\t" + item.getName());
		}
	}

	
	public static abstract class ShopItem {
		private String name;

		public String getName() {
			return name;
		}
		public ShopItem(String name) {
			this.name = name;
		}
	}
	
	public static class Book extends ShopItem {
		public Book(String title) {
			super(title);
		}		
		public String getTitle() {
			return super.getName();
		}
	}
	
	public static abstract class Toy extends ShopItem {
		public Toy(String toyName) {
			super(toyName);
		}
		public String getToyName() {
			return super.getName();
		}
	}
	
	public static class SoftToy extends Toy {
		public SoftToy(String toyName) {
			super(toyName);
		}
	}

	public static class TeddyBear extends SoftToy {
		public TeddyBear(String toyName) {
			super(toyName);
		}
	}
	
	public static class TrainSet extends Toy {
		public TrainSet(String toyName) {
			super(toyName);
		}
	}
	
	

}


//List < Department < ? extends T > subDept
//List < Section < ? extends T > section
//
//Both say that ? must be a subclass of T eg.
//if T = Toy then ? can be a SoftToy or a TeddyBear or a Train
//If T = SoftToy then ? can be a TeddyBear
//
//with
//
//Department < ? super T > dept
//if T = SoftToy then ? must be a superclass eg. Toy or ShopItem

