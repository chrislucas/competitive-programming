package tests.grafos;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * aplicaccoes para uma arvore geradora minima
 * http://www.geeksforgeeks.org/applications-of-minimum-spanning-tree/
 * */

public class Kruskal {
	static PrintWriter out = new PrintWriter(System.out, true);
	static int matrix[][], V, E;
	//static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Edge> edges, mst;
	
	static class Edge implements Comparable<Edge> {
		int s, d, w;
		// se o peso da aresta atual for menor do que a seguinte,
		// retornar um numero negativo
		// se for maior, positvo se nao zero
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		public Edge(int s, int d, int w) {
			this.s = s;
			this.d = d;
			this.w = w;
		}
	}
	static class UF {
		static int[] subset, weight;
		static void init(int edges) {
			subset = new int[edges];
			weight = new int[edges];
			for(int i=0; i<edges; i++) {
				subset[i] = i;
				weight[i] = 1;
			}
		}
		static int root(int i) {
			while( i != subset[i]) {
				subset[i] = subset[subset[i]];	// path compression
				i = subset[i];
			}
				
			return i;
		}
		static void union(int p, int q) {
			int i = root(p);
			int j = root(q);
			if(i == j)	// mesma raiz
				return;
			if(weight[i]>=weight[j]) {
				subset[j] = i;			// a arvore com menos nos passa ter como raiz a arvore com mais nos
				weight[i] += weight[j];	// adicionar os nos de q em p
			} else {
				subset[i] = j;
				weight[j] += weight[i];
			}
		}
	}
	
	static Edge[] set() {
		Edge e [] = {
			/*
			new Edge(0,1,4), new Edge(0,7,8),new Edge(1,2,8)
			,new Edge(1,7,11),new Edge(2,3,7), new Edge(2,5,4)
			,new Edge(2,8,2),new Edge(3,4,9), new Edge(3,5,14)
			,new Edge(4,5,10),new Edge(5,6,2),new Edge(6,8,6)
			,new Edge(6,7,1),new Edge(7,8,7)
			*/
			new Edge(0,1,10), new Edge(0,2,6), new Edge(0,3,5),
			new Edge(1,3,15), new Edge(2,3,4)
		};
		return e;
	}
	
	static void init() {
		//http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
		// grafo de exemplo do site citado acima
		// O numero de arestas da MST eh igual ao numero de vertices - 1 do grafo;
		edges = new ArrayList<Edge>();
		mst = new ArrayList<Edge>();
		Edge array[] = set();
		V = 4;
		E = array.length;
		for(Edge e : array) {
			edges.add(e);
		}
		Collections.sort(edges);
	}
	
	public static void kruskal() {
		Kruskal.init();
		UF.init(E);
		int e = 0,	// indice para montar a arvore geradora minima
			i = 0;	// indice para pegar uma aresta da lista
		while(e < V - 1) {
			Edge edge = edges.get(i++);
			int p = UF.root(edge.s);
			int q = UF.root(edge.d);
			// se as arestas nao incidem do mesmo vertice nao ha ciclos
			if(p != q) {
				mst.add(edge);
				UF.union(p, q);
				e++;
			}
		}
		for(Edge edge : mst) {
			out.printf("%d %d %d\n", edge.s, edge.d, edge.w);
		}
	}
	
	public static void main(String[] args) {
		kruskal();
	}

}
