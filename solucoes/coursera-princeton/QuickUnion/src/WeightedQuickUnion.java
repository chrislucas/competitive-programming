
public class WeightedQuickUnion {
	
	public static int data[], tall[];
	
	public static int find(int n, int data[]) {
		while(data[n] != n)
			n = data[n];
		return n;
	}
	// o mesmo que o quick union
	public static boolean isConnected(int p, int q, int data[]) {
		return find(p, data) == find(q, data);
	}
	// agora alem de achar a raiz de p para mudar pela raiz de q 
	public static void union(int p, int q, int data[], int tall[]) {
		int i = find(p, data);
		int j = find(q, data);
		if(i == j)
			return;
		// verificamos quantos nos a arvore com a raiz p e q tem
		if(tall[i] >= tall[j]) { //  para arvores de tamanho igual nao faz diferenca a ligacao
			data[j] = i;		// a arvore com o menor tamanho passa ter a raiz da arovre maior
			tall[i] += tall[j]; // o tamanho da arovre maior aumenta com a soma da arvore menor
		} else {		
			data[i] = j;
			tall[j] += tall[i]; // idem acima
		}
		/*
		if(tall[i] < tall[j]) {
			data[i] = j; tall[j] += tall[i]; 
		} else {
			data[j] = i; tall[i] += tall[j];
		}
		*/
		return;
	}
	
	public static void init(int n) {
		data = new int [n];
		tall = new int [n];
		for(int i=0; i<n; i++) {
			data[i] = i;
			tall[i] = 1;
		}
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
