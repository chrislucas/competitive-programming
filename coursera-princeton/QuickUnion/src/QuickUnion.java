
public class QuickUnion {
	// elementos conectados possuem a mesma raiz
	public static boolean isConnected(int p, int q, int data[]) {
		return root(p, data) == root(q, data);
	}
	// busca recursiva pela raiz do elemento i
	public static int root(int i, int data[]) {
		if(data[i] == i)
			return i;
		else return root(data[i], data);
	}
	// busca iterativa pela raiz do elemento i
	public static int find(int i, int data[]) {
		while(i != data[i])
			i = data[i];
		return i;
	}
	// a funcao unior muda a raiz de data[p] para a raiz de data[q]
	// dessa forma a union fica em tempo O(1) e todos os elementos abaixo de data[p] 
	// passam a ser filhos de data[q], Para descobrir quem eh a raiz de um elemento
	// de data[p] basta fazer uma busca recursiva que chegara no valor data[q]
	public static void union(int p, int q, int data[]) {
		int i = root(p, data);
		int j = root(q, data);
		data[i] = j;
		return;
	}
	
	public static void init(int n, int data[]) {
		data = new int[n];
		for(int i=0; i<n; i++)
			data[i] = i;
		return;
	}
	
	public static void main(String[] args) {
		testRoot();
		int data[] = null;
		init(10, data);
	}
	
	public static void testRoot() {
		/*
		 * {0,1,9,4,9,6,6,7,8,0};
		 * {0,1,1,8,3,0,5,7,8,8};
		 * */
		int data[] = {0,1,1,8,3,0,5,7,8,8};
		System.out.printf("%d %d", root(4, data), find(4, data));
	}

}
