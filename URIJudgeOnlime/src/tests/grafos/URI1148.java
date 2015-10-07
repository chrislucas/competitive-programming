package tests.grafos;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class URI1148 {
	
	static BufferedInputStream is = new BufferedInputStream(System.in,1<<16);
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
	static PrintWriter out = new PrintWriter(System.out, true);
	
	static int [][] graph;
	static final int INFINITY = Integer.MAX_VALUE;
	
	static void addEdge(int s, int d, int w) {
		graph[s][d] = w;
	}
	
	static int minDistance(int dist[], boolean mst[], int V) {
		int min = INFINITY, minIdx = 0;
		for(int i=0; i<V; i++) {
			if(mst[i] == false && dist[i] <= min) {
				min = dist[i];
				minIdx = i;
			}
		}
		return minIdx;
	}
	
	static int dijkstra(int s, int d, int v) {
		int V = v+1;
		boolean mst[] = new boolean[V];
		int distance[] = new int[V];
		for(int i=1; i<=V; i++) {
			distance[i] = INFINITY;
			mst[i] = false;
		}
		distance[s] = 0;
		for(int i=1; i<=V-1; i++) {
			int minIdx = minDistance(distance, mst, V);
			mst[minIdx] = true;	// adiciona
			for(int j=1; j<=V; j++) {
				int cost = minIdx == s ? 0 : distance[minIdx] + graph[minIdx][j];
				if(!mst[j] && graph[minIdx][j] != 0
						&& distance[minIdx] != INFINITY && cost < distance[j]) {
					distance[j] = cost;
				}
			}
		}
		return distance[d];
	}

	public static void main(String[] args) throws IOException {
		String in;
		StringTokenizer token;
		while( !(in = buffer.readLine()).equals("0 0")) {
			token = new StringTokenizer(in, " ");
			int v = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			graph = new int[v][v];
			int s, d;
			for(int i=0; i<e; i++) {
				in = buffer.readLine();
				s = Integer.parseInt(token.nextToken());
				d = Integer.parseInt(token.nextToken());
				int w = Integer.parseInt(token.nextToken());
				addEdge(s, d, w);
			}
			int k = Integer.parseInt(buffer.readLine());
			
			for(int i=0; i<k; i++) {
				in = buffer.readLine();
				s = Integer.parseInt(token.nextToken());
				d = Integer.parseInt(token.nextToken());
				int ans = dijkstra(s, d, v);
				out.printf("%s\n",  ans == INFINITY ? "" : String.valueOf(ans));
			}
		}
	}
}
