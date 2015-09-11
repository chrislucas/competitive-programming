package example.one;

public class EventNotifier {
	private Event event;
	private boolean occurEvent;
	
	public EventNotifier(Event event) {
		this.event = event;
		this.occurEvent = true;
	}
	
	public void notifyInteresting() {
		if(occurEvent) {
			event.interestingEvent();
		}
	}
}
