package qa.schedule;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Event {

	private String name;
	private EventType type;
	private LocalTime start;
	private Duration duration;
	private int day;

	public Event(String name, EventType type, LocalTime start, Duration duration, int day) {
		this.name = name;
		this.type = type;
		this.start = start;
		this.duration = duration;
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public EventType getType() {
		return type;
	}

	public LocalTime getStart() {
		return start;
	}

	public Duration getDuration() {
		return duration;
	}
	
	private LocalTime getEnd() {
		return start.plus(duration);
	}

	public int getDay() {
		return day;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", type=" + type + ", start=" + start
				+ ", duration=" + duration.toMinutes() + ", day=" + day + "]";
	}

}
