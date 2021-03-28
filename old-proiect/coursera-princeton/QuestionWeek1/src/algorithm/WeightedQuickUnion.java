package algorithm;

public class WeightedQuickUnion {
	public static int [] data;
	public static int [] tall;
	
	public static int root(int p, int data[]) {
		while(p != data[p])
			p = data[p];
		return p;
	}
	
	public static void union(int p, int q, int data[], int tall[]) {
		int rootp = root(p,data);
		int rootq = root(q,data);
		if(rootp == rootq)
			return;
		if(tall[rootp] < tall[rootq]) {
			// raiz da arvore com menor tamanho muda para ter como
			// raiz a raiz da arovre com maior tamanhao
			data[rootp] = rootq;
			// acrescentar a quantidade de folhas da menor arvore
			// na maior
			tall[rootq] += tall[rootp];
		} else {
			// no caso da arvore com a rais em p for maior ou igual
			// tanto faz adicionar p em q ou vice cersa
			// adotamos a solucao de adicionar a raiz de p em q
			data[rootq] = rootp;				// raiz de q muda para para raiz de p
			tall[rootp] += tall[rootq];			// adicionar nos de q em p
		}
		return;
	}
	
	public static void exec() {
		data = new int[] {0,1,2,3,4,5,6,7,8,9};
		tall = new int[] {1,1,1,1,1,1,1,1,1,1};
		union(7,3,data,tall);
		union(9,5,data,tall);
		union(1,6,data,tall);
		union(1,8,data,tall);
		union(5,2,data,tall);
		union(3,1,data,tall);
		union(0,4,data,tall);
		union(2,4,data,tall);
		union(2,7,data,tall);
		/*
		union(0,7,data,tall);
		union(5,6,data,tall);
		union(9,8,data,tall);
		union(2,3,data,tall);
		union(7,4,data,tall);
		union(2,8,data,tall);
		union(6,7,data,tall);
		union(6,2,data,tall);
		union(6,1,data,tall);
		union(4,3,data,tall);
		union(3,8,data,tall);
		union(6,5,data,tall);
		union(9,4,data,tall);
		union(2,1,data,tall);
		union(5,0,data,tall);
		union(7,2,data,tall);
		union(6,1,data,tall);
		union(7,3,data,tall);
		*/
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exec();
		// a profundidade de uma arvore pode ser no maximo
		// log(N), onde N eh o numero de folhas da arvore
		// teste loop
		// {8,3,8,8,3,8,9,8,6,3} ciclo
		// 1 2 8 0 0 0 0 8 0 0 ciclo
		// 5 1 5 7 1 1 2 5 1 0
		// 5 3 4 8 8 5 9 8 5 8  Size of tree rooted at parent of 8 < twice the size of tree rooted at 8
		// 6 3 2 8 6 1 3 4 8 1  Height of forest = 4 > lg N = lg(10)
		root(0, new int[]{8,3,8,8,3,8,9,8,6,3});
	}

}
