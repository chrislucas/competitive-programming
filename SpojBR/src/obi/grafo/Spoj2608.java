package obi.grafo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



/**
 * http://br.spoj.com/problems/DUENDE/
 * 
 * */

public class Spoj2608 {

	static int [][] maze;
	static boolean [][] visited;
	static int width, height;
	static PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
	public static class Node {
		int x, y, cost;
		boolean visited;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			this.cost = 0;
			this.visited = false;
		}
		
		@Override
		public boolean equals(Object o) {
			Node that = (Node) o;
			int cx = this.x, cy = this.y;
			int tx = that.x, ty = that.y;
			return cx == tx && cy == ty;
		}
	}
	
	public static ArrayList<Node> getNeighbors(Node n) {		
		return validadteStep(n.x, n.y);
	}
	
	private static ArrayList<Node> validadteStep(int x, int y) {
		ArrayList<Node> nb = new ArrayList<>();
		if(y+1<width && maze[x][y+1] != 2 ) {
			nb.add(new Node(x, y+1));// direita
		}
		if(y-1>=0 && maze[x][y-1] != 2) {
			nb.add(new Node(x, y-1));// esquerda
		}
		if(x+1<height && maze[x+1][y] != 2) {
			nb.add(new Node(x+1, y));// baixo
		}
		if(x-1>=0 && maze[x-1][y] != 2) {
			nb.add(new Node(x-1, y));// cima
		}
		return nb;
	}
	static void solution(int pi, int pj, ArrayList<Node> exits) {
		Queue<Node> queue = new LinkedList<>();
		Node n = new Node(pi, pj);
		queue.add(n);
		while( ! queue.isEmpty() ) {
			n = queue.poll();
			if(goal(n, exits)) {
				break;
			}
			visited[n.x][n.y] = true;
			ArrayList<Node> neighboors = getNeighbors(n);
			for(Node neighboor : neighboors) {
				if(visited[neighboor.x][neighboor.y])
					continue;
				neighboor.cost = n.cost + 1;
				queue.add(neighboor);
			}
 		}
		writer.printf("%d\n", n.cost);
		return;
	}
	
	public static boolean goal(Node node, ArrayList<Node> exits) {
		for(Node exit : exits) {
			if(exit.equals(node))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			//String e;
			//while ( ( e = reader.readLine())  != null) {
				StringTokenizer enter = new StringTokenizer(reader.readLine(), " ");
				int h = Integer.parseInt(enter.nextToken());
				int w = Integer.parseInt(enter.nextToken());
				maze = new int[h][w];
				visited = new boolean[h][w];
				width = w;
				height = h;
				int pi = 0, pj = 0;
				 ArrayList<Node> exits = new ArrayList<>();
				for(int i=0; i<h; i++) {
					enter = new StringTokenizer(reader.readLine(), " ");
					int j = 0;
					while(enter.hasMoreTokens()) {
						int value = Integer.parseInt(enter.nextToken());
						if(value == 3) {
							pi = i;
							pj = j;
						} else if(value == 0) {
							exits.add(new Node(i,j));
						}
						maze[i][j] = value;
						j++;
					}
				}
				solution(pi, pj, exits);	
			//}
		} catch(IOException ioex) {}
	}
}
