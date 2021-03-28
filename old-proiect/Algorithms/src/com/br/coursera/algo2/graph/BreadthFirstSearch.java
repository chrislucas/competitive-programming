package com.br.coursera.algo2.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	private boolean [] marked;
	private int [] edgeTo;
	private int s;
	
	public BreadthFirstSearch(Graph G , int source) {
		// TODO Auto-generated constructor stub
		marked = new boolean[G.V()];
		edgeTo = new int[G.E()];
		this.s = source;
	}
	
	
	public static void bfs(Graph G, int source) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		while(!queue.isEmpty()) {
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
