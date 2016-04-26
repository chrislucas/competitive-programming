package com.br.coursera.algo2.graph;

import java.util.Stack;

public class DepthFirstSearch {

	private boolean [] marked;
	private int [] edgeTo;
	private int s;
	
	public DepthFirstSearch(Graph G, int source) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.E()];
		this.s = source;
		dfs(G, source);
	}
	
	public void dfs(Graph G, int source) {
		marked[source] = true;
		for( int w : G.adjacentes(source) ){
			if(!marked[w]) {
				dfs(G, w);
				edgeTo[w] = source;
			}
		}
	}
	
	public boolean hasPath(int v) {
		return marked[v];
	}
	
	public void printPath() {}
	
	public Iterable<Integer> pathTo(int v) {
		if(!hasPath(v))
			return null;
		Stack<Integer> path = new Stack<>();
		for(int x = v; x!=s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
	
	
	public static void main(String[] args) {

	}
}
