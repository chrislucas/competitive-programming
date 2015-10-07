package tests.grafos;

import java.util.PriorityQueue;
import java.util.Queue;


public class PQueue {

	
	static Queue<Edge> pqueue = new PriorityQueue<Edge>();
	
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
	
	static void init() {
		Edge edges [] = {
			new Edge(0,1,4), new Edge(0,7,8),new Edge(1,2,8)
			,new Edge(2,8,2),new Edge(3,4,9), new Edge(3,5,14)
			,new Edge(4,5,10),new Edge(5,6,2),new Edge(6,8,6)
		};
		for(Edge e : edges)
			pqueue.add(e);
	}
	
	public static void main(String[] args) {
		init();
		while(!pqueue.isEmpty()) {
			Edge e = pqueue.poll();
			System.out.printf("%d %d %d\n", e.d, e.s, e.w);
		}
		

	}

}
