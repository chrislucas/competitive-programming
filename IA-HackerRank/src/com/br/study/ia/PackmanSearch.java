package com.br.study.ia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
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
	static Place [][] map, parent;
	static Place origin, destiny;
	static ArrayList<Place> path;
	
	static class Place {
		private String label;
		private int x, y;
		public Place() {}
		public Place(int x, int y, String label) {
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
		parent = new Place[dimX][dimY];
		visited = new boolean[dimX][dimY];
		path = new ArrayList<>();
	}
	
	public static void add(int x, int y, String label) {
		Place place = new Place(x, y, label);
		if(label.equals("."))
			destiny = place;
		else if(label.equals("P"))
			origin = place;
		map[x][y] = place;
	}
	
	public static void setMap(int x, int y, String label) {
		map[x][y].label = label;
	}
	
	public static void setParent(int x, int y, Place ancestor) {
		parent[x][y] = ancestor;
	}
	
	public static void add(int x, int y, Place place) {
		map[x][y] = place;
	}
	
	public static Stack<Place> validSpaceStack(int x, int y) {
		Stack<Place>places = new Stack<Place>();
		// % representa uma parede

		if(x > 0 && ! map[x-1][y].label.equals("%")) {	//UP
			places.push( map[x-1][y] );
		}
		if(y > 0 && ! map[x][y-1].label.equals("%")){	//LEFT
			places.push(map[x][y-1]);
		}
		if(y < dimY-1 && ! map[x][y+1].label.equals("%")) {	// RIGHT
			places.push(map[x][y+1]);
		}
		if(x < dimX-1 && ! map[x+1][y].label.equals("%")) {	//DOWN
			places.push(map[x+1][y] );
		}
		return places;
	}
	
	public static Queue<Place> validSpaceQueue(int x, int y) {
		Queue<Place> places = new LinkedList<Place>();
		// % representa uma parede
		if(x > 0 && ! map[x-1][y].label.equals("%")) {	// UP
			places.add( map[x-1][y] );
		}
		if(y > 0 && ! map[x][y-1].label.equals("%")){ // LEFT
			places.add(map[x][y-1]);
		}
		if(y < dimY-1 && ! map[x][y+1].label.equals("%")) {	//RIGHT
			places.add(map[x][y+1]);
		}
		if(x < dimX-1 && ! map[x+1][y].label.equals("%")) {	// DOWN
			places.add(map[x+1][y] );
		}
		return places;
	}
	
	public static void dfs(int x, int y) {
		Stack<Place> stack = new Stack<Place>();
		stack.push(map[x][y]);
		visited[x][y] = true;
		while( ! stack.isEmpty() ) {
			Place curr = stack.pop();
			//CompIO.pritf("%d %d\n", curr.x, curr.y);
			path.add(new Place(curr.x, curr.y, null));
			if(curr.equals(destiny)) {
				break;
			}
			Stack<Place> places = validSpaceStack(curr.x, curr.y);
			while( ! places.empty() ) {
				Place neighboor = places.pop();
				int dx = neighboor.x, dy = neighboor.y;
				if( ! visited[dx][dy] ) {
					visited[dx][dy] = true;
					stack.push(neighboor);
					setParent(dx, dy, curr);
				}
			}
		}
		CompIO.printf("%d\n", path.size());
		for(Place place : path) {
			CompIO.printf("%d %d\n", place.x, place.y);
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Place> queue = new LinkedList<>();
		queue.add(map[x][y]);
		visited[x][y] = true;
		while( ! queue.isEmpty() ) {
			Place curr = queue.poll();
			//CompIO.pritf("%d %d\n", curr.x, curr.y);
			path.add(new Place(curr.x, curr.y, null));
			if(curr.equals(destiny)) {
				break;
			}
			Queue<Place> places = validSpaceQueue(curr.x, curr.y);
			while( ! places.isEmpty()  ) {
				Place neighboor = places.poll();
				int dx = neighboor.x, dy = neighboor.y;
				if( ! visited[dx][dy] ) {
					visited[dx][dy] = true;
					queue.add(neighboor);
					setParent(dx, dy, curr);
				}
			}
		}
		CompIO.printf("%d\n", path.size());
		for(Place place : path) {
			CompIO.printf("%d %d\n", place.x, place.y);
		}
	}
	
	public static void run() {
		CompIO.init();
		int [] src = CompIO.readInts(" ");
		origin = new Place(src[0], src[1], "P");
		int [] dt = CompIO.readInts(" ");
		destiny = new Place(dt[0], dt[1], ".");
		int [] dim = CompIO.readInts(" ");
		PackmanSearch.init(dim[0], dim[1]);
		
		add(src[0], src[1], origin);
		add(dt[0], dt[1], destiny);
		
		for(int i=0; i<dim[0]; i++) {
			String [] e = CompIO.readStrings();
			for(int j=0; j<e.length; j++) {
				add(i, j, e[j]);
			}
		}
		//
		bfs(src[0], src[1]);
		//System.out.println("");
		//visited = new boolean[dimX][dimY];
		//dfs(src[0], src[1]);
		return;
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
		
		public static String [] readStrings(String delimiter) {
			StringTokenizer tk = new StringTokenizer(CompIO.readLine(), delimiter);
			String [] array = new String[tk.countTokens()];
			int i=0;
			while(tk.hasMoreTokens()) {
				array[i++] = tk.nextToken();
			}
			return array;
		}
		
		public static String [] readStrings() {
			String [] array = CompIO.readLine().split("");
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
		
		public static void printf(String format, Object ... objects) {
			writer.printf(format, objects);
		}
		
		public static void print(String data) {
			writer.printf("%s\n", data);
		}
	}
}
