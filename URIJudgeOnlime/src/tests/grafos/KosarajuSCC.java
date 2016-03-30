package tests.grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/strongly-connected-components/
 * SCC: Strongly connected component
 * Componente fortemente conexo
 * https://en.wikipedia.org/wiki/Kosaraju%27s_algorithm
 * */

public class KosarajuSCC {
	
	public static ArrayList<ArrayList<Integer>> map;
	public static Set<ArrayList<Integer>> components;
	public static int vertices;
	
	public static ArrayList<ArrayList<Integer>> create() {
		ArrayList<ArrayList<Integer>> adjacent = new ArrayList<>();
		for(int i=0; i<vertices; i++)
			adjacent.add(new ArrayList<>());
		return adjacent;
	}
	
	
	static void addEdge(int u, int v) {
		map.get(u).add(v);
	}
	
	public static void fill(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		Iterator<Integer> it = map.get(v).iterator();
		while(it.hasNext()) {
			int n = (Integer)it.next();
			if( ! visited[n] )
				fill(n, visited, stack);
		}
		stack.push(v);
	}
	
	public static void dfs(int u, boolean[] visited, ArrayList<ArrayList<Integer>> reverse) {
		visited[u] = true;
		System.out.printf("%d ", u);
		Iterator<Integer> it = reverse.get(u).iterator();
		while(it.hasNext()) {
			int v = it.next();
			if( ! visited[v] )
				dfs(v, visited, reverse);
		}
	}

	public static void kosaraju(int v) {
		vertices = v;
		map = create();
		addEdge(0, 2);
		addEdge(0, 3);
		addEdge(1, 0);
		addEdge(2, 1);
		addEdge(3, 4);
		//addEdge(2, 1);
		boolean[] visited = new boolean[v];
		for(int i=0; i<v; i++) {
			visited[i] = false;
		}
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<v; i++) {
			if(!visited[i]) {
				fill(i, visited, stack);
			}
		}
		ArrayList<ArrayList<Integer>> reverse = transpose(map);
		
		for(int i=0; i<v; i++)
			visited[i] = false;
		
		//components = new HashSet<>();
		
		while(!stack.empty()) {
			int p = stack.pop();
			if( ! visited[p] ) {
				dfs(p, visited, reverse);
				System.out.println("");
			}
		}
	}
	
	// invertendo uma lista de adjacencia
	public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> list) {
		ArrayList<ArrayList<Integer>> reverse = create();
		for(int i=0; i<vertices; i++) {
			ArrayList<Integer> array = list.get(i); 
			for(Integer vs : array) {
				reverse.get(vs).add(i);
			}
		}
		return reverse;
	}
	

	
	public static void main(String[] args) {
		kosaraju(5);

	}

}
