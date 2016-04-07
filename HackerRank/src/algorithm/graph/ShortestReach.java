package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.hackerrank.com/challenges/bfsshortreach
 * 
 * ler isso http://www.geeksforgeeks.org/applications-of-depth-first-search/
 * 
 * */

public class ShortestReach {
	
	static ArrayList<ArrayList<Integer>> list;
	static final int L = 6;
	static int vertices, distance[];
	static boolean [] visited;
	
	
	public static void add(int u, int v) {
		list.get(u).add(v);
	}
	
	public static int min() {
		return 0;
	}
	
	public static void bfs(int source) {
		Queue<Integer> queue = new LinkedList<>();
		visited[source] = true;
		distance[source] = 0;
		queue.add(source);
		while(!queue.isEmpty()) {
			int s = queue.poll();
			for(Integer d : list.get(s)) {
				/*
				int cost = distance[d];
				cost = cost < 0 ? 6 : cost + 6;
				if( ! visited[d]&& cost < distance[d] ) {
					distance[d] = cost;
					queue.add(d);
				}
				*/
			}
		}
	}
	
	public static void init(int v) {
		vertices 	= v;
		visited 	= new boolean[v+1];
		distance 	= new int[v+1];
		list 		= new ArrayList<>();
		for(int i=0; i<v+1; i++) {
			list.add(new ArrayList<>());
			distance[i] = -1;
		}
			
	}
	
	public static void run()  {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			int cases = Integer.parseInt(reader.readLine());
			for(int i=0; i<cases; i++) {
				StringTokenizer tk = new StringTokenizer(reader.readLine(), " ");
				int  v = Integer.parseInt(tk.nextToken())
					,e = Integer.parseInt(tk.nextToken());
				init(v);
				for(int j=0; j<e; j++) {
					tk = new StringTokenizer(reader.readLine(), " ");
					int  x = Integer.parseInt(tk.nextToken())
						,y = Integer.parseInt(tk.nextToken());
					add(x, y);
					add(y, x);
				}
				// da onde parte a busca
				int source = Integer.parseInt(reader.readLine());
				bfs(source);
			}
		} catch(IOException ioex) {}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
