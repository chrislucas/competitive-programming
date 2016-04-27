package com.br.coursera.algo2.graph;

import edu.princeton.cs.algs4.StdOut;

public class Paths {
	/*
	private boolean [] marked;
	private int [] edgeTo;
	private int s;
	*/
	Paths(Graph G, int source) {
		
	}
	
	public boolean hasPathTo(int v) {
		return true;
	}
	
	public Iterable<Integer> pathTo(int v) {
		return null;
	}

	public static void main(String[] args) {
		Graph G = new Graph(10);
		DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
		
		Paths paths = new Paths(G, 0);
		for(int v=0; v<G.V(); v++) {
			if(paths.hasPathTo(v)) {
				StdOut.println(v);
			}
		}

	}

}
