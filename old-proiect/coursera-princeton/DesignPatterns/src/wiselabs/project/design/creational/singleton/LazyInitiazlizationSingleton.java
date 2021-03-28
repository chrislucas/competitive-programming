package wiselabs.project.design.creational.singleton;

public class LazyInitiazlizationSingleton {

	private static LazyInitiazlizationSingleton INSTANCE;
	private LazyInitiazlizationSingleton(){}
	
	/*
	 * versao 1 thread safe, easiest method
	 * o uso da keyword synchronized causa problemas de performance
	 * */ 
	
	public static synchronized LazyInitiazlizationSingleton getInstace() {
		if(INSTANCE == null) {
			INSTANCE = new LazyInitiazlizationSingleton();
		}
		return INSTANCE;
	}
	
	/**
	 * versao 2 thread safe
	 * para contornar o problema de performance causado pelo uso
	 * do sync na assinatura do metodo, usa-se o principio 'Double checked locking'
	 * Nessa abordagem, eh criado um bloco synchronized na estrutura condicional 'if'
	 * 
	 * */
	public static LazyInitiazlizationSingleton getInstanceDoubleLocking() {
		if(INSTANCE == null) {
			synchronized (LazyInitiazlizationSingleton.class) {
				if(INSTANCE == null)
					INSTANCE = new LazyInitiazlizationSingleton();
			}
		}
		return INSTANCE;
	}
	
}
