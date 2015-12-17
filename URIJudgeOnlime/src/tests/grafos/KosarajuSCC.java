package tests.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/strongly-connected-components/
 * SCC: Strongly connected component
 * Componente fortemente conexo 
 * */

public class KosarajuSCC {
	
	public static Map<Integer, ArrayList<Integer>> map;
	public static Set<ArrayList<Integer>> components;
	public static int vertices;
	
	static void addEdge(int u, int v) {
		if(map.containsKey(u)) {
			map.get(u).add(v);
		} else {
			ArrayList<Integer> array = new ArrayList<>();
			array.add(v);
			map.put(u, array);
		}
		
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

	public static void kosaraju(int v) {
		Stack<Integer> stack = new Stack<>();
		components = new HashSet<>();
		
		boolean[] visited = new boolean[v];
		for(int i=0; i<v; i++) {
			visited[i] = false;
		}	
		map = new HashMap<>();
		
		for(int i=0; i<v; i++) {
			if(!visited[i]) {
				fill(i, visited, stack);
			}
		}
		
		Map<Integer, ArrayList<Integer>> reverse = transpose(map);
		
		for(int i=0; i<v; i++)
			visited[i] = false;
		
		while(!stack.empty()) {
			int p = stack.pop();
			if( ! visited[p] ) {
				dfs(p, visited);
			}
		}
	}
	
	public static Map<Integer, ArrayList<Integer>> transpose(Map<Integer, ArrayList<Integer>> map) {
		Map<Integer, ArrayList<Integer>> reverse = new HashMap<>();
		for(int i=0; i<vertices; i++) {
			@SuppressWarnings("rawtypes")
			Iterator it = map.get(i).iterator();
			while(it.hasNext()) {

			}
		}

		return reverse;
	}
	
	public static void dfs(int u, boolean[] visited) {
		visited[u] = true;
		Iterator<Integer> it = map.get(u).iterator();
		while(it.hasNext()) {
			int v = it.next();
			if( ! visited[v] )
				dfs(v, visited);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
