package tests.grafos;

import java.util.ArrayList;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * */

public class BreadthFirstSearch {
	public static ArrayList<ArrayList<Integer>> adjacent;
	public static int vertices;
	
	public static void BFS(int source) {
		boolean[] visited = new boolean[vertices];
		for(int i=0; i<vertices; i++)
			visited[i] = i == source ? true : false;
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		while(!stack.empty()) {
			int u = stack.pop();
			System.out.printf("%d ", u);
			for(int v : adjacent.get(u)) {
				if(!visited[v]) {
					visited[v] = true;
					stack.add(v);
				}
			}
		}
	}
	
	public static void add(int u, int v) {
		adjacent.get(u).add(v);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
