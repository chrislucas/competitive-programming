package com.br.study.ia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/challenges/pacman-dfs
 * https://www.hackerrank.com/challenges/pacman-bfs
 * */

public class PackmanSearch {

	static boolean [][] visited;
	static int dimX, dimY;
	static Place [][] map;
	static Place origin, destiny;
	
	static class Place {
		private char label;
		private int x, y;
		public Place() {}
		public Place(int x, int y, char label) {
			this.x = x;
			this.y = y;
			this.label = label;
		}
		
		@Override
		public boolean equals(Object object) {
			// TODO Auto-generated method stub
			Place place = (Place) object;
			if(this.x == place.x && this.y == place.y && this.label == place.label)
				return true;
			return false;
		}	
	}
	
	public static void init(int dx, int dy) {
		dimX = dx;
		dimY = dy;
		map = new Place[dimX][dimY];
		visited = new boolean[dimX][dimY];
	}
	
	public static void add(int x, int y, char label) {
		Place place = new Place(x, y, label);
		if(label == '.')
			destiny = place;
		else if(label == 'P')
			origin = place;
		map[x][y] = place;
	}
	
	public static Place[] validSpace(int x, int y) {
		Place [] places = new Place[4];
		int counter = 0;
		if(x < dimX-1) {
			places[counter++] = map[x+1][y];
		}
		if(x > 0) {
			places[counter++] = map[x-1][y];
		}
		if(y < dimY-1) {
			places[counter++] = map[x][y+1];
		}
		if(y > 0){
			places[counter++] = map[x][y-1];
		}
		return null;
	}
	
	public static void dfs(int x, int y) {
		Stack<Place> stack = new Stack<Place>();
		stack.push(map[x][y]);
		visited[x][y] = true;
		
		while( ! stack.isEmpty() ) {
			Place curr = stack.pop();
			if(curr.equals(destiny)) {
				break;
			}
			for(Place neighboor : validSpace(curr.x, curr.y)) {
				int dx = neighboor.x, dy = neighboor.y;
				if( ! visited[dx][dy] ) {
					visited[dx][dy] = true;
					stack.push(neighboor);
				}
			}
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Place> queue = new LinkedList<>();
		queue.add(map[x][y]);
		visited[x][y] = true;
		
		while( ! queue.isEmpty() ) {
			Place curr = queue.poll();
			if(curr.equals(destiny)) {
				break;
			}
			
			for(Place neighboor : validSpace(curr.x, curr.y)) {
				int dx = neighboor.x, dy = neighboor.y;
				if( ! visited[dx][dy] ) {
					visited[dx][dy] = true;
					queue.add(neighboor);
				}
			}
		}
	}
	
	public static void run() {
		CompIO.init();
		int [] src = CompIO.readInts(" ");
		origin = new Place(src[0], src[1], 'P');
		int [] dt = CompIO.readInts(" ");
		destiny = new Place(dt[0], dt[1], '.');
		int [] dim = CompIO.readInts(" ");
		PackmanSearch.init(dim[0], dim[1]);
		
		for(int i=0; i<dim[0]; i++) {
			char [] e = CompIO.readChars("");
			for(int j=0; j<e.length; j++) {
				add(i, j, e[j]);
			}
		}
		
		bfs(src[0], src[1]);
	}
	
	
	public static void main(String[] args) {
		run();
	}
	
	
	public static class CompIO {
		private CompIO() {  throw new UnsupportedOperationException(); }
		private static BufferedReader buffer;
		private static PrintWriter writer;
		private static StringTokenizer tk;
		
		public static void init() {
			buffer = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		}
		
		public static String read(String delimiter) {
			while(tk == null || ! tk.hasMoreTokens()) {
				try {
					if(delimiter == null)
						tk = new StringTokenizer(buffer.readLine());
					else
						tk = new StringTokenizer(buffer.readLine(), delimiter);
				} catch(IOException ioex){}
			}
			return tk.nextToken();
		}
		
		public static String readLine() {
			String line = null;
			try {
				line = buffer.readLine();
			} catch(IOException ioex) {}
			return line;
		}
		
		public static char [] readChars(String delimiter) {
			StringTokenizer tk = new StringTokenizer(CompIO.readLine(), " ");
			char [] array = new char[tk.countTokens()];
			int i=0;
			while(tk.hasMoreTokens()) {
				array[i++] = tk.nextToken().toCharArray()[0];
			}
			return array;
		}
		
		public static String read() {
			return read(null);
		}
		
		public static int readInt(String delimiter) {
			return Integer.parseInt(read(delimiter));
		}
		
		public static int [] readInts(String delimiter) {
			StringTokenizer token = new StringTokenizer(readLine(), delimiter);
			int i = 0, array []  = new int[token.countTokens()];
			while(token.hasMoreTokens()) {
				array[i++] = Integer.parseInt(token.nextToken());
			}
			return array; 
		}
		
		public static void pritf(String format, Object ... objects) {
			writer.printf(format, objects);
		}
		
		public static void print(String data) {
			writer.printf("%s\n", data);
		}
	}
}
