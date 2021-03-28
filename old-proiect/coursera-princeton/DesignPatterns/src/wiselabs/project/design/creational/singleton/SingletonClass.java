package wiselabs.project.design.creational.singleton;


/**
 * 
 * A solucao usando bloco sincronizado dentro do metodo getInstance
 * causa alguns problemas de memoria no Java 5, por isso
 * foir pensado na solucao abaixo. COm uma Inner class estatica
 * Empacota-se a classe que se quer criar um singleton, e deixa
 * a responsabilidade para inner class criar uma unica referencia
 * para class empacotada.
 * */

// using holder pattern

public class SingletonClass {
	/**
	 * qando a classe WrappedSingletonClass eh carregada pela VM
	 * a classe WrapperHelper
	 * */
	private SingletonClass(){}
	
	private static class HolderPatternHelper {
		private static final  SingletonClass INSTANCE = new SingletonClass();
		private HolderPatternHelper(){}
		public static SingletonClass getInstance() {
			return HolderPatternHelper.INSTANCE;
		}
	}
	
	public static void Main(String[] args) {
		System.out.println(SingletonClass.HolderPatternHelper.getInstance());
	}
}
