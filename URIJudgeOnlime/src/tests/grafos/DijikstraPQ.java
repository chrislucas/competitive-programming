package tests.grafos;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import tests.grafos.Dijkstra.Edge;



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
	
	static ArrayList<ArrayList<Edge>> list;
	// fila de prioridade com as arestas do grafo
	static Queue<Edge> pqueue = new PriorityQueue<Edge>();
	static final int INFINITY = Integer.MAX_VALUE;
	static int V, E;
	
	public static int[] minDistance(int s) {
		int [] distance = new int[V];
		boolean [] set = new boolean[V];
		
		for(int i=0; i<V; i++) {
			distance[i] = INFINITY;
			set[i] = false;
		}
		distance[s] = 0;
		while(!pqueue.isEmpty()) {
			
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
	}
	
	public static void addEdge(Edge edge) {
		// adioinar ao indice S (source)
		// a aresta com o vertice d (destiny) e
		// o peso w (weight)
		list.get(edge.s).add(edge);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init(10, 25);
	}

}
