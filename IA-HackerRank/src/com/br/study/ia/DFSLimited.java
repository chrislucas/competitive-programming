package com.br.study.ia;

import java.util.ArrayList;
import java.util.Stack;

public class DFSLimited {

	private static class Edge {
		int s, d;
		public Edge(int s, int d) {
			this.s = s;
			this.d = d;
		}
		@Override
		public boolean equals(Object that) {
			Edge edge = (Edge) that;
			if(this.s == edge.s && this.d == edge.d)
				return true;
			return false;
		}
	}
	
	
	static ArrayList<ArrayList<Edge>> list;
	static boolean [] visited;
	
	public static void add(int s, int d) {
		list.get(s).add(new Edge(s, d));
	}
	
	
	public static void init(int vertices) {
		list 	= new ArrayList<>();
		visited = new boolean[vertices];
		for(int i=0; i<vertices; i++)
			list.add(new ArrayList<>());
		
	}
	
	public static int dfs(Edge init, Edge goal, int limit) {
		Stack<Edge> edges = new Stack<Edge>();
		edges.push(init);
		visited[init.s] = true;
		int cLimit = 0;
		while( ! edges.isEmpty() ) {
			if(limit == cLimit)
				return 0;
			Edge src = edges.pop();
			
			if(src.equals(goal))
				return 1;
			
			for(Edge dest : list.get(src.s)) {
				if( ! visited[dest.d] ) {
					visited[dest.d] = true;
					edges.add(dest);
					cLimit++;
				}
			}
		}
		return 2;
	}
	
	public static void runTest() {
		
	}
	
	public static void main(String[] args) {		
		
	}

}
