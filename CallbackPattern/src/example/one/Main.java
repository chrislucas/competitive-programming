package example.one;

public class Main {

	public static void main(String[] args) {
		EventSum event = new EventSum();
		EventNotifier en = event.getEn();
		if(en != null)
			en.notifyInteresting();
		
		EventMinus event2 = new EventMinus();
		en = event2.getEn();
		if(en != null)
			en.notifyInteresting();
	}

}
