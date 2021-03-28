package graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {

	static class Graph {
		int [] components;
		List<ArrayList<Edge>> edges;
		List<ArrayList<Integer>> adjacent;
		int vertices;
		public Graph(int v) {
			components = new int[v];
			vertices = v;
 			for(int i=0; i<v; i++)
				components[i] = -1;
 			adjacent = new ArrayList<ArrayList<Integer>>();
 			for(int i=0; i<v; i++) {
 				adjacent.add(new ArrayList<Integer>());
 			}
		}
		
		public void addEdge(int u, int v) {
			adjacent.get(u).add(v);
			adjacent.get(v).add(u);
		}
		
		public void dfs(int root, int id) {
			components[root] = id;
			for(Integer nodechild : adjacent.get(root)) {
				if(components[nodechild] == -1)
					dfs(nodechild, id);
			}
		}
		
		public int runDfs() {
			int id = 0;
			for(int i=0; i<vertices; i++) {
				if(components[i] == -1) {
					dfs(i, id++);
				}
			}
			return id;
		}
		
		public boolean sameComponent(int u, int v) {
			return components[u] == components[v];
		}
	}
	
	public class Edge {
		int d, w;
	}
	
	
	public static void main(String[] args) {
		test1();
	}
	
	public static void test1() {
		Graph g = new Graph(10);
		// 3-7 1-4 7-8 0-5 5-2 3-8 2-9 0-6 4-9 2-6 6-4
		g.addEdge(3, 7);
		g.addEdge(1, 4);
		g.addEdge(7, 8);
		g.addEdge(0, 5);
		g.addEdge(5, 2);
		g.addEdge(3, 8);
		g.addEdge(2, 9);
		g.addEdge(0, 6);
		g.addEdge(4, 9);
		g.addEdge(2, 6);
		g.addEdge(6, 4);
		System.out.println(g.runDfs());
	}

}
