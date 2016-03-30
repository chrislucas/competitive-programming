package tests.grafos;

import java.util.ArrayList;



/*
 * 
 * http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 * */

public class DetectCycleGraphII {
	
	
	public static class Edge implements Comparable<Edge> {
		int s, d, w;
		Edge (int s, int d, int w) {
			this.s = s;
			this.d = d;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge that) {
			return this.w - that.w;
		}
	}
	
	public static ArrayList<ArrayList<Edge>> list;
	public static boolean [] visiteds, stack;
	public static int vertices;
	
	public DetectCycleGraphII(int vertx) {
		vertices 	= vertx;
		visiteds 	= new boolean[vertx];
		stack  		= new boolean[vertx];
		list 	 	= new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<vertx; i++) {
			list.add(new ArrayList<>());
		}
	}
	
	
	public static void add(Edge edge) {
		list.get(edge.s).add(edge);
	}
	
	public static boolean dfs(int source) {
		if( ! visiteds[source] ) {
			visiteds[source] = true;
			stack[source] = true;
			for(Edge edge : list.get(source)) {
				if(!visiteds[edge.d]) {
					System.out.printf(" %d", edge.d);
					dfs(edge.d);
				}
				else if(stack[edge.d])
					return true;
			}
		} else {
			return true;
		}
		stack[source] = false;
		return false;
	}
	
	
	public static boolean execute() {
		add(new Edge(0, 1, 0));
		add(new Edge(0, 2, 0));
		add(new Edge(1, 2, 0));
		add(new Edge(2, 0, 0));
		add(new Edge(2, 3, 0));
		add(new Edge(3, 3, 0));
		
		for(int i=3; i<vertices; i++) {
			System.out.printf("%d: ", i);
			if(dfs(i)) {
				return true;
			}
			System.out.println("\n");
		}
		return false;
	}

	public static void main(String[] args) {
		new DetectCycleGraphII(4);
		System.out.println(execute());

	}

}
