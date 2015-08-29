package tests.grafos;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

	static final int INFINITY = Integer.MAX_VALUE;
	static int V, E;
	static Queue<Edge> pqueue = new PriorityQueue<Edge>();
	static ArrayList<ArrayList<Edge>> list;
	
	// explicacao do que eh Edge em Kruskal.java
	static class Edge implements Comparable<Edge> {
		int s, d, w;
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
	
	static void init(int v, int e) {
		V = v;
		E = e;
		Edge edges[] = {};
	}
	
	// verifica Qual no nao incluso na AGM tem menor custo para ser alcaçado
	// o vertice como menor custo eh retornado
	static int minDistance(int dist[], boolean mst[]) {
		int min = INFINITY, minIdx = 0;
		for(int i=0; i<V; i++) {
			if(mst[i] == false && dist[i] <= min) {
				min = dist[i];
				minIdx = i;
			}
		}
		return minIdx;
	}
	
	static void dijkstraMatrix(int source) {
		int distance[] = new int[V];
		// matrix e boolean mst soh existem quando usado matriz de adhacencia
		int matrix[][] = {
			{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 0, 10, 0, 2, 0, 0},
            {0, 0, 0, 14, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}	
		};						
		boolean mst[] = new boolean[V];;
		for(int i=0; i<V; i++) {
			distance[i] = INFINITY;
			mst[i] = false;
		}
		distance[source] = 0;
		for(int i=0; i<V-1; i++) {
			int minCost = minDistance(distance, mst);
			mst[minCost] = true;	// adiciona
			for(int j=0; j<V; j++) {
				int cost = distance[minCost] + matrix[minCost][j];
				if(!mst[j] && matrix[minCost][j] != 0
						&& distance[minCost] != INFINITY && cost < distance[j]) {
					distance[j] = cost;
				}
			}
		}
		for(int i=0; i<V; i++) {
			System.out.printf("%d %d\n", i, distance[i]);
		}
	}
	
	static void dijkstraList() {
		while(!pqueue.isEmpty()) {
			Edge e = pqueue.poll();
			int s = e.s, w = e.w;
		}
	}
	
	
	
	public static void main(String[] args) {
		init(9, 14);
		dijkstraMatrix(8);

	}

}
