
public class QuickFind {
	public static int[] data;
	// elementos conectados possuem a mesma raiz
	static boolean isConnect(int p, int q) {
		return data[p] == data[q] ? true : false;
	}
	// que eh a raiz de p ? data[p]
	static int find(int p) {
		return data[p];
	}
	// todos que tiverem vinculados a raiz data[p], serao vinculados a raiz q
	static void union(int p, int q) {
		int rootp = data[p],
			rootq = data[q];
		for(int i=0; i<data.length; i++) {
			if(data[i] == rootp)
				data[i] = rootq;
		}
	}
	
	static void init(int n) {
		data = new int[n];
		for(int i=0; i<n; i++)
			data[i] = i;
	}
	
	static void test() {
		init(10);
		union(4,3);
		union(3,8);
		union(9,4);
		union(2,1);
		union(5,0);
		union(6,5);
		union(7,2);
		union(6,1);
		for(int i=0; i<data.length; i++)
			System.out.printf( i > 0 ? " %d" : "%d", data[i]);
	}
	public static void main(String[] args) {
		test();
	}

}
