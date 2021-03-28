package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.hackerrank.com/challenges/jack-goes-to-rapture
 * 
 * */

public class Jack {
	
	static ArrayList<ArrayList<Edge>> list;
	static int [] cost, real, path;
	static int vertices;
	static final int INF = Integer.MAX_VALUE;
	static boolean [] visited;
	
	static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
	
	public static boolean bfs(int s, int d) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		while(!queue.isEmpty()) {
			int vertice = queue.poll();
			if(vertice == d)
				return true;
			for(Edge destiny : list.get(vertice)) {
				int idx = destiny.dest;
				if(!visited[idx]) {
					visited[idx] = true;
					queue.add(idx);
				}	
			}
		}
		return false;
	}
	
	public static void solution() {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int vertices = Integer.parseInt(tokenizer.nextToken());
			int edges = Integer.parseInt(tokenizer.nextToken());
			
			Jack.vertices 	= vertices;
			Jack.cost 		= new int[vertices+1];
			Jack.real 		= new int[vertices+1];
			Jack.path		= new int[vertices+1];
			Jack.list 		= new ArrayList<>();
			Jack.visited	= new boolean[vertices+1];
			for(int i=0; i<vertices+1; i++) {
				list.add(new ArrayList<Edge>());
				cost[i] 	= INF;
				real[i] 	= INF;
			}
			/*
				5 5
				1 2 60
				3 5 70 
				1 4 120
				4 5 150
				2 3 80
			*/

			for(int i=0; i<edges; i++) {
				tokenizer = new StringTokenizer(reader.readLine(), " ");
				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());
				int w = Integer.parseInt(tokenizer.nextToken());
				add(u,v,w);
			}
			
			if(!bfs(1, vertices)) {
				writer.printf("NO PATH EXISTS\n");
				return;
			}
			
			visited = new boolean[vertices+1];
			
			Queue<Edge> pq = new PriorityQueue<>();
			Edge edge = list.get(1).get(0);
			cost[edge.source] = 0;
			real[edge.source] = 0;
			path[edge.source] = edge.source;
			pq.add(edge);
			//int S = Integer.MAX_VALUE;
			while(!pq.isEmpty()) {
				Edge top 		= pq.poll();
				int source 		= top.source;
				for(Edge destiny : list.get(source)) {
					int  dest 	= destiny.dest
						,weight = destiny.weight;
					
					int realCost = weight - cost[source];
					realCost 	 = realCost < 0 ? 0 : realCost;
					int sum = realCost + cost[source];
					
					if(realCost < real[dest] && sum < cost[dest]) {
						real[dest] 	 = realCost;
						cost[dest]	 = sum;
						for(Edge e : list.get(dest)) {
							if(!visited[e.dest]) {
								pq.add(e);
							}	
						}
						path[dest] = source;
					}
				}
				visited[source] = true;
			}	// fim while(queue)
			writer.printf("%d\n", cost[vertices]);
		} catch(IOException ioex){}
		return;
	}
	
	public static class Edge implements Comparable<Edge> {
		int source, dest, weight;
		public Edge(int source, int dest, int weight) {
			// TODO Auto-generated constructor stub
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge that) {
			// TODO Auto-generated method stub
			return this.weight - that.weight;
		}
	}
	
	public static void add(int s, int d, int w) {
		list.get(s).add(new Edge(s, d, w));
		list.get(d).add(new Edge(d, s, w));
	}

	public static void main(String[] args) {
		solution();
	}
}
