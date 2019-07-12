package qa.schedule;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class EventStreams {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Event e1 = new Event("Generics", EventType.CHAPTER, new Date(115, 4, 6, 9, 30), 60);
		Event e2 = new Event("Morning Coffee Break", EventType.BREAK, new Date(115, 4, 6, 10, 30), 15);
		Event e3 = new Event("Reflection", EventType.CHAPTER, new Date(115, 4, 6, 10, 45), 60);
		Event e4 = new Event("Practical", EventType.PRACTICAL, new Date(115, 4, 6, 12, 0), 30);
		Event e5 = new Event("Lunch", EventType.BREAK, new Date(115, 4, 6, 12, 30), 60);
		Event e6 = new Event("Lambda Expressions", EventType.CHAPTER, new Date(115, 4, 6, 13, 30), 60);
		Event e7 = new Event("Practical", EventType.PRACTICAL, new Date(115, 4, 6, 14, 30), 60);
		Event e8 = new Event("Advanced Lambda Expressions", EventType.CHAPTER, new Date(115, 4, 6, 15, 30), 30);
		Event e9 = new Event("Practical", EventType.PRACTICAL, new Date(115, 4, 6, 16, 30), 30);

		List<Event> list = Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9);
		Collections.shuffle(list);

//		Consumer<List<Event>> printer = l -> {for(Event x:l) System.out.println(x);};
//		printer.accept(list);



//		System.out.println("Before sort...");
//		list.forEach(System.out::println);
//
//		list.sort ( ( a, b ) -> a.getStart().compareTo(b.getStart())) ;
//
//		System.out.println("After sort...");
//		list.forEach(System.out::println);
//
//		System.out.println("Chapter Events...");
//		list.stream()
//			.filter( e -> e.getType().equals(EventType.CHAPTER))
//			.forEach(System.out::println);

		list.stream()
//			.sorted( ( a, b ) -> a.getStart().compareTo(b.getStart()))
			.sorted()
			.forEach(System.out::println);



















	}

}
