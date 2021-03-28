package algorithm;

public class QuickFind {
	public static int [] data;
	
	public static int root(int p) {
		return data[p];
	}
	
	public static boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	// union(p,q): todos que tiverem raiz em p, mudaram para raiz em q
	public static void union(int p, int q, int data[]) {
		int rootq = data[q], rootp = data[p];
		for(int i=0; i<data.length; i++) {
			if(data[i] == rootp)
				data[i] = rootq;
		}
		return;
	}
	
	public static void exec() {
		data = new int[] {0,1,2,3,4,5,6,7,8,9};
		union(3, 7, data);
		union(2, 3, data);
		union(7, 1, data);
		union(0, 9, data);
		union(9, 8, data);
		union(3, 5, data);
		/*
		union(5, 4, data);
		union(7, 5, data);
		union(0, 3, data);
		union(9, 3, data);
		union(8, 4, data);
		union(0, 5, data);
		union(4,3,data);
		union(3,8,data);
		union(9,4,data);
		union(2,1,data);
		union(5,0,data);
		union(6,5,data);
		union(7,2,data);
		union(6,1,data);*/
		return;
	}
	
	public static void main(String[] args) {
		exec();
	}

}
