package wiselabs.project.design.creational.singleton;

public class StaticBlockSingleton {
	
	private static StaticBlockSingleton instance = null;
	private StaticBlockSingleton(){}
	
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch(Exception e) {}
	}
	
	public static StaticBlockSingleton getInstance() {
		return instance;
	}

}
