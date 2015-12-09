package tests.grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


// http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
public class DijikstraPQ {
	
	// explicacao do que eh Edge em Kruskal.java
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
	
	@SuppressWarnings("serial")
	public static class UniqueQueue<E> extends PriorityQueue<E> {
		@Override
		public boolean offer(E e) {
			boolean isAdd = false;
			if(!super.contains(e))
				isAdd = super.offer(e);
			return isAdd;
		}
	}
	
	static ArrayList<ArrayList<Edge>> list;

	static final int INFINITY = Integer.MAX_VALUE;
	static int V, E;
	
	public static int[] dijkstra(Edge init) {
		int [] distance = new int[V];
		//boolean [] set = new boolean[V];
		int [] path = new int[V];
		for(int i=0; i<V; i++) {
			distance[i] = INFINITY;
			//set[i] = false;
		}
		// fila de prioridade com as arestas do grafo
		Queue<Edge> pqueue 	= new DijikstraPQ.UniqueQueue<Edge>();
		//set[init.s		= true;
		distance[init.s] 	= 0;
		path[init.s] 		= init.s;
		pqueue.add(init);
		while(!pqueue.isEmpty()) {
			Edge top = pqueue.poll();
			// end.s e start.s sao iguais
			int source = top.s;
			//set[source] = true;
			// pegar as arestas que estao ligadas ao vertice source(s)
			for(Edge edge : list.get(source)) {
				// somar a distance de s ate d
				int destiny = edge.d,weight = edge.w;
				int cost = distance[source] + weight;
				if( /*! set[destiny] && */ cost < distance[destiny]) {
					distance[destiny] = cost;
					for(Edge e : list.get(destiny)) {
						// se o vertice de destino for diferente do da fonte
						if(e.d != source)
							pqueue.add(e);
					}
					path[destiny] = source;
				}
			}
		}
		int i=7;
		while(path[i] != i) {
			System.out.printf("%d ", path[i]);
			i = path[i];
		}
		return distance;
	}
	
	public static void init(int v, int e) {
		V = v;
		E = e;
		list = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<v; i++) {
			list.add(new ArrayList<Edge>());
		}
		return;
	}
	
	public static void addEdge(Edge edge) {
		// adioinar ao indice S (source)
		// a aresta com o vertice d (destiny) e
		// o peso w (weight)
		list.get(edge.s).add(edge);
	}
	
	public static void addEdges(List<Edge> edges) {
		for(Edge edge : edges) {
			addEdge(edge);
		}
	}
	
	public static void test() {
		init(9, 28);
		addEdge(new Edge(0, 1, 4));
		addEdge(new Edge(0, 7, 8));
		addEdge(new Edge(1, 0, 4));
		addEdge(new Edge(1, 2, 8));
		addEdge(new Edge(1, 7, 11));
		addEdge(new Edge(2, 8, 8));
		addEdge(new Edge(2, 3, 7));
		addEdge(new Edge(2, 5, 4));
		addEdge(new Edge(2, 8, 2));
		addEdge(new Edge(3, 2, 7));
		addEdge(new Edge(3, 4, 9));
		addEdge(new Edge(3, 5, 14));
		addEdge(new Edge(4, 3, 9));
		addEdge(new Edge(4, 5, 10));
		addEdge(new Edge(5, 2, 4));
		addEdge(new Edge(5, 4, 10));
		addEdge(new Edge(5, 6, 2));
		addEdge(new Edge(5, 3, 14));
		addEdge(new Edge(6, 5, 2));
		addEdge(new Edge(6, 7, 1));
		addEdge(new Edge(6, 8, 6));
		addEdge(new Edge(7, 0, 8));
		addEdge(new Edge(7, 1, 11));
		addEdge(new Edge(7, 6, 1));
		addEdge(new Edge(7, 8, 7));
		addEdge(new Edge(8, 2, 2));
		addEdge(new Edge(8, 6, 6));
		addEdge(new Edge(8, 7, 7));
		dijkstra(list.get(0).get(0));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 test();
	}

}
