package qa.schedule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EventsTest {

	public static void main(String[] args) {
		
		Event e1 = new Event("Generics", EventType.CHAPTER, "09:30", 90, 1);
		Event e2 = new Event("Morning Coffee", EventType.BREAK, "11:00", 15, 1);
		Event e3 = new Event("Reflection", EventType.CHAPTER,"11:15", 60, 1);
		Event e4 = new Event("Lunch", EventType.BREAK, "12:15", 60, 1);	
		Event e5 = new Event("Practical", EventType.PRACTICAL, "13:15", 45, 1);
		Event e6 = new Event("Lambdas", EventType.CHAPTER, "14:00", 60, 1);
		Event e7 = new Event("Afternoon Coffee", EventType.BREAK, "15:00", 15, 1);		
		Event e8 = new Event("Practical", EventType.PRACTICAL, "15:15", 45, 1);
		Event e9 = new Event("Advanced Lambdas", EventType.BREAK, "16:00", 60, 1);
		
		List<Event> events = Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9);
		Collections.shuffle(events);
			
	}
	
}
