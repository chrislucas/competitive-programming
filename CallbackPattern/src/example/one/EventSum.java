package example.one;

public class EventSum implements Event {

	private EventNotifier en;
	
	public EventNotifier getEn() {
		return en;
	}

	public void setEn(EventNotifier en) {
		this.en = en;
	}

	public EventSum() {
		en = new EventNotifier(this);
	}
	
	@Override
	public void interestingEvent() {
		System.out.println("Executar evento da classe ".concat(getClass().getName()));
	}

}
