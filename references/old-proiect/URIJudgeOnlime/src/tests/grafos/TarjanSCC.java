package tests.grafos;

import java.util.ArrayList;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/
 * http://algs4.cs.princeton.edu/42digraph/TarjanSCC.java.html
 * http://algorithmsandme.in/2015/03/find-strongly-connected-component-in-graph-tarjan-algorithm/
 * http://algorithmsandme.in/2015/03/find-strongly-connected-component-in-graph-tarjan-algorithm/
 * https://www.quora.com/Whats-a-good-explanation-for-Tarjans-strongly-connected-components-algorithm
 * */

public class TarjanSCC {

	public static ArrayList<ArrayList<Integer>> adjacent;
	// vetor que armazema o momento em o i-esimo(reached[i]) vertice, foi alcancado na DFS
	public static int [] reached;
	/**
	 * https://en.wikipedia.org/wiki/Depth-first_search#Output_of_a_depth-first_search
	 * existem 3 tipos de aresta numa arvore
	 * https://en.wikipedia.org/wiki/File:Tree_edges.svg
	 * Forward edges: que possuem um vertice numa ponta e seu vertice
	 * descendente noutra.
	 * Back edges: que possuem um vertice numa ponta e seu antecessor noutra
	 * Cross Edge: uma aresta que liga 2 vertices que não são antecessores nem descendentes
	 * numa busca na árvore
	 * 
	 * */
	//public static int [] low;
	//public static boolean [] visited;
	public static int vertices;
	
	public static void add(int u, int v) {
		adjacent.get(u).add(v);
	}
	
	public static void tarjan(int v) {
		int [] reached = new int[vertices];
		int [] low = new int[vertices];
		boolean [] visited = new boolean[vertices];
		for(int i=0; i<vertices; i++) {
			reached[i] = low [i] = -1;
			visited[i] = false;
		}
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<vertices; i++)
			if(reached[i] == -1)
				SCC(i, reached, low, stack, visited, 0);
	}
	
	public static void SCC(int u, int[] reached
			,int[] low, Stack<Integer> stack, boolean[] visited, int acc) {
		
		reached[u] = low[u] = ++acc;
		stack.push(u);
		visited[u] = true;
		for(Integer v : adjacent.get(u)) {
			if(reached[v] == - 1) {
				SCC(v, reached, low, stack, visited, acc);
				// se low[u] < low[v] for verdadeiro, quer dizer que
				// o vertice u foi descoberto primeiro que v
				// na busca em profundidade
				low[u] = low[u] < low[v] ? low[u] : low[v];
			}
			// caso o no 'v' ja estiver sido visitado
			// o caminho de u - v eh uma aresta do tipo back (aresta de volta, formando um ciclo)
			else if(visited[v])
				low[u] = low[u] < reached[v] ? low[u] : reached[v];
		}
		
		if(low[u] == reached[u]) {
			int x;
			//while( ! stack.empty() && reached[stack.peek()] != low[u]) {
			while(stack.peek() != u) {
				x = stack.pop();
				System.out.printf("%d ", x);
				visited[x] = false;
			}
			x = stack.pop();
			System.out.printf("%d\n", x);
			visited[x] = false;
		}
	}
	
	public static void create(int v) {
		vertices = v;
		adjacent = new ArrayList<>();
		for(int i=0; i<v; i++)
			adjacent.add(new ArrayList<>());
		
		switch (v) {
			case 5:
				add(1, 0);
				add(0, 2);
				add(2, 1);
				add(0, 3);
				//add(3, 4);
				break;
			case 4:
				add(0, 1);
				add(1, 2);
				add(2, 3);
				break;
			case 7:
				add(0, 1);
				add(1, 2);
				add(2, 0);
				add(1, 3);
				add(1, 4);
				add(1, 6);
				add(3, 5);
				add(4, 5);
				break;
			default:
				break;
		}
		tarjan(v);
	}
	
	public static void main(String[] args) {
		create(5);

	}

}
