package qa.schedule;

public class Event {

	private String name;
	private EventType type;
	private String start;
	private int duration;
	private int day;

	public Event(String name, EventType type, String start, int duration,
			int day) {
		super();
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

	public String getStart() {
		return start;
	}

	public int getDuration() {
		return duration;
	}

	public int getDay() {
		return day;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", type=" + type + ", start=" + start
				+ ", duration=" + duration + ", day=" + day + "]";
	}

}
