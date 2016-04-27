package com.br.coursera.algo2.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/*
 * Resumo:
 * 
 * No mundo real grafos tendem a ser esparsos(muitos vertices, poucas arestas)
 * um grafo denso tem muitas arestas
 * 
 * */

public class Graph {
	
	private int vertices, edges;
	private Bag<Integer> [] list;
	
	private static boolean [] marked;
	private static int [] edgeTo;
	private static int s;
	
	public Graph(int vertices, int edges) {
		this.vertices 	= vertices;
		this.edges		= edges;
	}
	
	public Graph(int vertices) {
		this.vertices = vertices;
		for(int i=0; i<vertices; i++)
			list[i] = new Bag<Integer>();
		
		marked = new boolean[vertices];
	}
	
	public Graph(In in) {
		
	}
	
	public void addEdge(int v, int w) {
		list[v].add(w);
		list[w].add(v);
	}
	
	public Iterable<Integer> adjacentes(int v) {
		return list[v];
	}
	
	public int V() {
		return this.vertices;
	}
	
	public int E() {
		return this.edges;
	}
	
	// Quantos vertices estão ligados ao vertice V  ?
	public static int degree(Graph G, int v) {
		int acc = 0;
		Iterator<Integer> iterator = G.adjacentes(v).iterator();
		while(iterator.hasNext()) {
			iterator.next();
			acc++;
		}
		return acc;
	}
	
	public static int [] maxDegree(Graph G) {
		int [] max = {degree(G, 0), 0};
		for(int v=1; v<G.V(); v++) {
			int aMax = degree(G, v);
			if(aMax > max[0]) {
				max[0] = aMax;
				max[1] = v;
			}
		}
		return max;
	}
	// 2 * numerode arestas dividido pelo numero de vertices
	// isso para grafos nao dirigidos onde ocorre u -> w e w -> u
	public static double averageDegree(Graph G) {
		return 2.0 * G.E() / G.V();
	}
	
	public static int numberOfSelfLoops(Graph G) {
		int acc = 0;
		for(int v=0; v<G.V(); v++) {
			Iterator<Integer> it = G.adjacentes(v).iterator();
			while(it.hasNext()) {
				if(it.next() == v)
					acc++;
			}
		}
		// cada aresta contem 2 vertices
		return acc / 2;
	}
	
	public static void dfs(Graph G, int source) {
		marked[source] = true;
		for( int w : G.adjacentes(source) ){
			if(!marked[w]) {
				dfs(G, w);
				edgeTo[w] = source;
			}
		}
	}
	
	public static void bfs(Graph G, int source) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		while(!queue.isEmpty()) {
			int s = queue.poll();
			marked[s] = true;
			for(int w : G.adjacentes(s)) {
				if(!marked[w]) {
					queue.add(w);
				}
			}			
		}
	}

}
