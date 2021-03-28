
public class PathCompression {
	public static int data[], tall[];
	// path compression: ao procurar o nó raiz principal do elemento i
	// ja que passamos pelos elementos que estao
	// acima de i e estao ligados ao mesmo nó raiz indiretamente, podemos mudar
	// a raiz secundaria desses elementos diretamente para a raiz principal
	public static int root(int i, int data[]) {
		while(i != data[i]) {
			// path compression, faz com que um no indiretamente ligado a raiz
			// seja ligado diretamente
			data[i] = data[data[i]];
			i = data[i];
		}
		return i;
	}
	
	public static int find(int i, int data[]) {
		if(i == data[i])
			return i;
		else {
			data[i] = data[data[i]];
			return find(data[i], data);
		}
	}
	
	public static void union(int p, int q, int data[], int tall[]) {
		int i = root(p, data);
		int j = root(q, data);
		if (i == j)		// mesma raiz, nada a se fazer
			return;
		if(tall[i] >= tall[j]) {
			data[j] = i;			// os elementos abaixo da raiz j estarao abaixo de i
			tall[i] += tall[j];		// o tamanho da arvore i soma-se ao da arvore j
		} else {
			data[i] = j;			// os elementos abaixo da raiz i estarao abaixo de j
			tall[j] += tall[i];
		}
	}
	
	public static boolean is(int p, int q, int data[]) {
		return root(p, data) == root(q, data); 
	}
	
	public static void init(int n) {
		data = new int[n];
		tall = new int[n];
		for(int i=0; i<n; i++) {
			data[i] = i;
			tall[i] = 1;
		}
		return;
	}
	
	public static void test() {
		init(10);
		union(4,3,data,tall);
		union(3,8,data,tall);
		union(6,5,data,tall);
		union(9,4,data,tall);
		union(2,1,data,tall);
		union(5,0,data,tall);
		union(7,2,data,tall);
		union(6,1,data,tall);
		union(7,3,data,tall);
		for(int i=0; i<data.length; i++)
			System.out.printf( i > 0 ? " %d" : "%d", data[i]);
		//System.out.println(isConnected(3, 6, data));
	}
	
	public static void main(String[] args) {
		test();

	}

}
