package qa.schedule;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static java.util.Comparator.comparing;

public class EventsTest {

	public static void main(String[] args) {
		
		Event e1 = new Event("Generics", EventType.CHAPTER, LocalTime.of(9, 30, 0), Duration.ofMinutes(90), 1);
		Event e2 = new Event("Morning Coffee", EventType.BREAK, LocalTime.of(11, 0, 0), Duration.ofMinutes(15), 1);
		Event e3 = new Event("Reflection", EventType.CHAPTER, LocalTime.of(11, 15, 0), Duration.ofMinutes(60), 1);
		Event e4 = new Event("Lunch", EventType.BREAK, LocalTime.of(12, 15, 0), Duration.ofHours(1), 1);	
		Event e5 = new Event("Practical", EventType.PRACTICAL, LocalTime.of(13, 15, 0), Duration.ofMinutes(45), 1);
		Event e6 = new Event("Lambdas", EventType.CHAPTER, LocalTime.of(14, 0, 0), Duration.ofMinutes(60), 1);
		Event e7 = new Event("Afternoon Coffee", EventType.BREAK, LocalTime.of(15, 0, 0), Duration.ofMinutes(15), 1);		
		Event e8 = new Event("Practical", EventType.PRACTICAL, LocalTime.of(15, 15, 0), Duration.ofMinutes(45), 1);
		Event e9 = new Event("Advanced Lambdas", EventType.BREAK, LocalTime.of(16, 0, 0), Duration.ofMinutes(60), 1);
		
		List<Event> events = Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9);
		Collections.shuffle(events);
		
		System.out.println("Sorted by duration:");
		events.stream().sorted(comparing(Event::getDuration)).forEach(System.out::println);
		
		System.out.println("Sorted by start time:");
		events.stream().sorted(comparing(Event::getStart)).forEach(System.out::println);
		
		ZoneId zone = ZoneId.of("Europe/Prague");
		System.out.println(getActualStartDateTime(e1, LocalDate.now(), zone));
		
	}
	
	private static String getActualStartDateTime(Event e, LocalDate date, ZoneId zone) {
		
		LocalTime start = e.getStart();
		LocalDateTime actualStart = LocalDateTime.of(date, start);
		
		ZonedDateTime localStart = actualStart.atZone(zone);
		return localStart.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm", Locale.UK));
		
	}

}
