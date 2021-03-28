package wiselabs.project.design.creational.singleton;

/**
 * 
 * The instance of class in Eager initialization is created at the time of
 * Class Loading.
 * THis is the easiest method but it has a drawback that instance is created even
 * though client application might not be using it.
 * */

public class EagerInitializationSingleton {
	
	private static final EagerInitializationSingleton instance = new EagerInitializationSingleton();
	
	private EagerInitializationSingleton() {}
	
	public static EagerInitializationSingleton getInstance() {
		return instance;
	}
	
}
