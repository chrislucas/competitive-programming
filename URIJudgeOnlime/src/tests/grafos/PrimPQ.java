package tests.grafos;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimPQ {

	static class Edge implements Comparable<Edge> {
		int s, d, w;	// source destiny weight
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
	
	private static Map<Integer, List<Edge>> graph;
	private static Queue<Edge> pq;
	
	private static void addEdge(int s, int d, int w) {
		Edge edge = new Edge(s, d, w);
		pq.add(edge);
	}
	
	private static void addEdge() {
		/*
		addEdge(0, 1, 3);
		addEdge(0, 4, 8);
		addEdge(1, 2, 2);
		addEdge(1, 3, 2);
		addEdge(2, 1, 2);
		addEdge(2, 3, 3);
		addEdge(3, 1, 2);
		addEdge(3, 2, 3);
		addEdge(3, 4, 6);
		addEdge(3, 5, 3);
		addEdge(4, 0, 8);
		addEdge(4, 3, 6);
		addEdge(4, 5, 5);
		addEdge(4, 6, 7);
		addEdge(5, 3, 3);
		addEdge(5, 4, 5);
		addEdge(5, 6, 4);
		addEdge(6, 4, 7);
		addEdge(6, 5, 4);
		*/
		addEdge(0,1,4);
		addEdge(0,7,8);
		addEdge(1,0,4);
		addEdge(1,2,8);
		addEdge(1,7,11);
		addEdge(2,1,8);
		addEdge(2,3,7);
		addEdge(2,5,4);
		addEdge(2,8,2);
		addEdge(3,2,7);
		addEdge(3,4,9);
		addEdge(3,5,14);
		addEdge(4,3,9);
		addEdge(4,5,10);
		addEdge(5,2,4);
		addEdge(5,4,10);
		addEdge(5,6,2);
		addEdge(6,3,14);
		addEdge(6,5,2);
		addEdge(6,7,1);
		addEdge(6,8,6);
		addEdge(7,0,8);
		addEdge(7,1,11);
		addEdge(7,6,1);
		addEdge(7,8,7);
		addEdge(8,2,2);
		addEdge(8,6,6);
		addEdge(8,7,7);
	}

	static int [] prim() {
		pq = new PriorityQueue<>();
		addEdge();
		int matrix[][] = {
			/*
			{0,3,0,0,8,0,0}
			,{3,0,2,2,0,0,0}
			,{0,2,0,3,0,0,0}
			,{0,2,3,0,6,3,0}
			,{8,0,0,6,0,5,7}
			,{0,0,0,3,5,0,4}
			,{0,0,0,0,7,4,0}
			*/
			{0,4,0,0,0,0,0,8,0},
			{4,0,8,0,0,0,0,11,0},
			{0,8,0,7,0,4,0,0,2},
			{0,0,7,0,9,14,0,0,0},
			{0,0,0,9,0,10,0,0,0},
			{0,0,4,0,10,0,2,0,0},
			{0,0,0,14,0,2,0,1,6},
			{8,11,0,0,0,0,1,0,7},
			{0,0,2,0,0,0,6,7,0}	
		};
		
		int vertices = matrix.length;
		int [] spanningTree = new int[vertices], weight = new int[vertices];
		boolean [] visited = new boolean[vertices];
		for(int i=0; i<vertices; i++) {
			weight[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		/**
		 * Pegar a primeira aresta da fila de prioridades
		 * o vertice fonte("source", "s") e o vertice de
		 * utilizo para montar a MST, logo ele nao tera peso
		 * pois eh a origem da MST
		 * */
		int s = pq.peek().s;
		weight[s] = 0;
		spanningTree[s] = s;
		while( ! pq.isEmpty() ) {
			Edge edge = pq.poll();
			int u = edge.s;
			visited[u] = true;
			for(int v=0; v<vertices; v++) {
				if( matrix[u][v] > 0 && ! visited[v] && matrix[u][v] < weight[v]){
					spanningTree[v] = u;
					weight[v] = matrix[u][v];
				}
			}
		}
		int total = 0;
		for(int v=0; v<vertices; v++) {
			int u = spanningTree[v];
			int w = matrix[v][u];//weight[v];
			if(u == v)continue;
			System.out.printf("V(%d, %d) W %d\n", u, v, w);
			total += w;
		}
		System.out.printf("Total %d", total);
		return spanningTree;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prim();
	}

}
