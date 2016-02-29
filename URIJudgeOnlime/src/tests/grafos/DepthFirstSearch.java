package tests.grafos;

import java.util.ArrayList;
import java.util.Stack;


/*
 * Uma forma iterativa
 * http://www.geeksforgeeks.org/iterative-depth-first-traversal/
 * */		
public class DepthFirstSearch {

	static ArrayList<ArrayList<Integer>> list;
	private static int vertices;
	private static boolean [] visited;
	public static void init(int vertx) {
		list = new ArrayList<ArrayList<Integer>>();
		vertices = vertx;
		visited = new boolean[vertices];
		for(int i=0; i<vertx; i++) {
			list.add(new ArrayList<>());
		}
	}
	
	public static void addEdge(int u, int v) {
		list.get(u).add(v);
	}
	
	public static void dfsIterative(int source) {
		Stack<Integer> queue = new Stack<>();
		queue.push(source);
		visited[source] = true;
		while(!queue.empty()) {
			int s = queue.pop();
			System.out.println(s);
			for(Integer dest : list.get(s)) {
				if(!visited[dest]) {
					visited[dest] = true;
					queue.push(dest);
				}
			}
		}
	}
	
	public static void dfsRecursive(int source) {
		visited[source] = true;
		System.out.println(source);
		for(Integer dest : list.get(source)) {
			if(!visited[dest]) {
				visited[dest] = true;
				dfsRecursive(dest);
			}
		}
	}
	
	public static void main(String[] args) {
		init(5);
		addEdge(1, 0);
		addEdge(0, 2);
		addEdge(2, 1);
		addEdge(0, 3);
		addEdge(3, 4);
		addEdge(4, 0);
		dfsIterative(0);
		//dfsRecursive(0);

	}

}
