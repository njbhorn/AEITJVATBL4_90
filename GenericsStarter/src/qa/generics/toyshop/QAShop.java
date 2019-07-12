package qa.generics.toyshop;

import qa.generics.Section;

public class QAShop {

	public static void main(String[] args) {

		Section<TeddyBear> teddies = new Section<TeddyBear>("Teddies");
		Section<TrainSet> trainsets = new Section<TrainSet>("Train Sets");

		teddies.addItem(new TeddyBear("Rupert"));
		teddies.addItem(new TeddyBear("Pooh"));
		teddies.addItem(new TeddyBear("Paddington"));
		trainsets.addItem(new TrainSet("Hornby Deluxe"));
		trainsets.addItem(new TrainSet("Lego Rail"));

		listItems(teddies);
//		listItems(shop);



	}

	private static void listItems(Section<? extends ShopItem> section) {
		System.out.println("Items in " + section.getSectionName() + " Section:");
		for (ShopItem item : section) {
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
