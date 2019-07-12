package qa.schedule;


import java.util.Date;

public class Event {

	private String name;
	private EventType type;
	private Date start;
	private int durationMins;

	public Event(String name, EventType type, Date start, int durationMins) {
		super();
		this.name = name;
		this.type = type;
		this.start = start;
		this.durationMins = durationMins;
	}

	public String getName() {
		return name;
	}

	public EventType getType() {
		return type;
	}

	public Date getStart() {
		return start;
	}
	
	public int getDuration() {
		return durationMins;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", type=" + type + ", start=" + start
				+ ", durationMins=" + durationMins + "]";
	}
	


}
