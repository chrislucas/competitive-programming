package com.br.study.ia.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


/**
 * https://www.hackerrank.com/challenges/pacman-dfs
 * https://www.hackerrank.com/challenges/pacman-bfs
 * DONE :)
 * */

public class TemplatePackmanJava {
	
	static boolean [][] visited;
	static int dimX, dimY;
	static Place [][] map, parent;
	static Place origin, destiny;
	static ArrayList<Place> path;
	
	static class Place implements Comparable<Place> {
		private String label;
		private int x, y, w;
		public Place() {}
		public Place(int x, int y, String label) {
			this.x = x;
			this.y = y;
			this.w = 1;
			this.label = label;
		}
		
		public Place(int x, int y, int w,  String label) {
			this.x = x;
			this.y = y;
			this.w = w;
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
		
		@Override
		public int compareTo(Place that) {
			return this.w - that.w;
		}
	}
	
	public static void init(int dx, int dy) {
		dimX = dx;
		dimY = dy;
		map 	= new Place[dimX][dimY];
		parent 	= new Place[dimX][dimY];
		visited = new boolean[dimX][dimY];
		path 	= new ArrayList<>();
	}
	
	public static void add(int x, int y, String label) {
		Place place = new Place(x, y, label);
		if(label.equals("."))
			destiny = place;
		else if(label.equals("P"))
			origin = place;
		map[x][y] = place;
	}
	
	public static void add(int x, int y, Place place) {
		map[x][y] = place;
	}
	
	public static void setMap(int x, int y, String label) {
		map[x][y].label = label;
	}
	
	public static void setParent(int x, int y, Place ancestor) {
		parent[x][y] = ancestor;
	}
	
	static void nextMove(int r, int c, int pacman_r, int pacman_c, int food_r, int food_c, String [] grid){
		origin = new Place(pacman_r, pacman_c, "P");
		destiny = new Place(food_r, food_c, ".");
		
		TemplatePackmanJava.init(r, c);
		add(pacman_r, pacman_c, origin);
		add(food_r, food_c, destiny);
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				add(i, j, String.valueOf(grid[i].charAt(j)));
			}
		}
		bfs(pacman_r, pacman_c);
		//dfs(pacman_r, pacman_c);
		return;
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
		stack.add(map[x][y]);
		visited[x][y] = true;
		boolean F = false;
		while( ! stack.empty() ) {
			Place curr = stack.pop();
			//CompIO.pritf("%d %d\n", curr.x, curr.y);
			path.add(new Place(curr.x, curr.y, null));
			if(curr.equals(destiny)) {
				F = true;
				break;
			}
			Queue<Place> places = validSpaceQueue(curr.x, curr.y);
			while( ! places.isEmpty() ) {
				Place neighboor = places.poll();
				int dx = neighboor.x, dy = neighboor.y;
				if( visited[dx][dy] == false ) {
					visited[dx][dy] = true;
					neighboor.w = curr.w + 1;
					stack.push(neighboor);
					setParent(dx, dy, curr);
				}
			}
		}
		
		if( ! F )
			return;
		
		System.out.printf("%d\n", path.size());
		for(Place place : path) {
			System.out.printf("%d %d\n", place.x, place.y);
		}
		
		path = new ArrayList<>();
		path.add(destiny);
		int sx = destiny.x, sy = destiny.y;
		for(Place anc = parent[sx][sy]; ;anc = parent[anc.x][anc.y] ) {
			if( anc.equals(origin) ) {
				path.add(anc);
				break;
			}
			path.add(anc);
		}
		
		System.out.printf("%d\n", path.size() - 1);
		for(int i = path.size() - 1; i >= 0; i--) {
			Place place  = path.get(i);
			System.out.printf("%d %d\n", place.x, place.y);
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Place> queue = new LinkedList<>();
		queue.add(map[x][y]);
		visited[x][y] = true;
		boolean F = false;
		while( ! queue.isEmpty() ) {
			Place curr = queue.poll();
			path.add(new Place(curr.x, curr.y, null));
			if(curr.equals(destiny)) {
				F = true;
				break;
			}
			Queue<Place> places = validSpaceQueue(curr.x, curr.y);
			while( ! places.isEmpty()  ) {
				Place neighboor = places.poll();
				int dx = neighboor.x, dy = neighboor.y;
				if( ! visited[dx][dy] ) {
					neighboor.w = curr.w + 1;			// quantidade de passos que se deve caminhar no grafo para chegar ao ponto [dx][dy]
					visited[dx][dy] = true;
					queue.add(neighboor);
					setParent(dx, dy, curr);
				}
			}
		}
		
		if(!F)
			return;
		
		System.out.printf("%d\n", path.size());
		for(Place place : path) {
			System.out.printf("%d %d\n", place.x, place.y);
		}
		
		// realizar o caminho contrario para verificar qual o menor caminho nesse GRID
		// Todo o no expandido a partir de um nó PAI tem o custo da soma de se alcançar o
		// NO antetior +1
		path = new ArrayList<>();
		path.add(destiny);
		int sx = destiny.x, sy = destiny.y;
		for(Place anc = parent[sx][sy]; ;anc = parent[anc.x][anc.y] ) {
			if( anc.equals(origin) ) {
				path.add(anc);
				break;
			}
			path.add(anc);
		}
		
		System.out.printf("%d\n", path.size() - 1);
		for(int i = path.size() - 1; i >= 0; i--) {
			Place place  = path.get(i);
			System.out.printf("%d %d\n", place.x, place.y);
		}
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pacman_r = in.nextInt();
        int pacman_c = in.nextInt();
        
        int food_r = in.nextInt();
        int food_c = in.nextInt();
        
        int r = in.nextInt();
        int c = in.nextInt();
    
        String grid[] = new String[r];

        for(int i = 0; i < r; i++) {
            grid[i] = in.next();
        }

        nextMove( r, c, pacman_r, pacman_c, food_r, food_c, grid);
    }
}
