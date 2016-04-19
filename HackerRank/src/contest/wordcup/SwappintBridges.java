package contest.wordcup;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class SwappintBridges {
	
	static class Graph {
		int [] components;
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
	public static void main(String[] args) throws IOException {
		InputStream in = new BufferedInputStream(System.in, 1<<10);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
		int cases;
		String enter = buffer.readLine();
		cases = Integer.parseInt(enter);
		while(cases>0) {
			String vert = buffer.readLine();
			int vertices = Integer.parseInt(vert);
			Graph g = new Graph(vertices);
			vert = buffer.readLine();
			StringTokenizer tokenizer = new StringTokenizer(vert, " ");
			int i=0;
			while(tokenizer.hasMoreTokens()) {
				int dest = Integer.parseInt(tokenizer.nextToken()) - 1;
				g.addEdge(i++, dest);
			}
			out.printf("%d\n", g.runDfs() - 1);
			cases--;
		}
	}
}
