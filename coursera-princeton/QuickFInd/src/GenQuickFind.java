import java.util.ArrayList;

// tutorial QuickFind video curso de algoritmo Coursera Princeton University

/*
 * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
 * http://stackoverflow.com/questions/975134/why-cant-we-have-static-method-in-a-non-static-inner-class
 * */

public class GenQuickFind {
	
	/*
	 * Porque Inner class nao podem definir metodos estaticos ?
	 * 
	 * Uma instancia de Inner class esta associada a sua classe
	 * Externa. Quando a Inner class nao eh estatica nao podemos
	 * criar um metodo estatico dentro dela. Para acessar metodos
	 * de uma Inner class Non-static precisamos de uma instancia
	 * da classe Externa, entao faz sentido nao podemos ter um metodo
	 * estatico, se nao fariamos algo assim:
	 * 
	 * OuterClass.InnerClass inner = new
	 * 
	 * */
	public class Data<V> {
		@SuppressWarnings("unused")
		private V data;
		private Integer root;
		public Data(Integer root, V data) {
			this.data = data;
			this.root = root;
		}
	}
	
	
	static public ArrayList<Data<?>> set;
	
	public GenQuickFind(int sz) {}
	
	public GenQuickFind() {
		set = new ArrayList<>();
	}
	
	public void add(Data<?> data) {
		set.add(data);
	}
	
	public void exec() {
	
		GenQuickFind ge = new GenQuickFind();
		// o casting evita ter que usar o annotation
		GenQuickFind.Data<String> data0 = (Data<String>) ge.new Data<String>(0, "Milene");
		GenQuickFind.Data<String> data1 = new GenQuickFind.Data<String>(1, "Amanda");
		add(data0);
		add(data1);
		add(ge.new Data<String>(2, "Gerusa"));
		add(ge.new Data<String>(3, "Talita"));
		add(ge.new Data<String>(4, "Tamara"));
		add(ge.new Data<String>(5, "Jurema"));
	}
	
	public boolean isConnected(int p, int q) {
		Data<?> pd = set.get(p);
		Data<?> qd = set.get(q);
		return pd.root == qd.root;
	}
	
	public void test() {

	}

	public static void main(String[] args) {

	}

}
