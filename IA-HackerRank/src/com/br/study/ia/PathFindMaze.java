package com.br.study.ia;

import java.util.LinkedList;
import java.util.Queue;

public class PathFindMaze {
	
	static class LocationMaze {
		int i, j;
		public LocationMaze(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		public boolean equals(LocationMaze loc) {
			if(this.i == loc.i && this.j == loc.j)
				return true;
			return false;
		}
	}
	
	public static final int OBSTACLE_MAZE = -1;
	
	public static int h, w, maze[][];
	public static boolean visited[][];
	public static LocationMaze S, D, pathFind [];
	
	private boolean search = true;
	
	public static Queue<LocationMaze> queue;
	
	public PathFindMaze(int w, int h, LocationMaze s, LocationMaze d) {
		PathFindMaze.w = w-1;
		PathFindMaze.h = h-1;
		PathFindMaze.S = s;
		PathFindMaze.D = d;
		maze = new int [w][h];
		visited = new boolean[w][h];
		pathFind = new LocationMaze[w*h];
		for(int i=0; i<w; i++){
			for(int j=0; j<h; j++) {
				maze[i][j] = 0;
				visited[i][j] = false;
			}
		}
		queue = new LinkedList<>();	
	}
	
	public static void init() {
		int w = 4, h = 4;
		LocationMaze s 		= new LocationMaze(0, 0);
		LocationMaze d 		= new LocationMaze(3, 3);
		PathFindMaze path 	= new PathFindMaze(w, h, s, d);
		//path.dfs(s, 0);
		path.bfs(s);
	}
	
	private static LocationMaze[] possiblesMoves(LocationMaze source) {
		LocationMaze [] possibilities = new LocationMaze[4];
		// lembrar que i == linha ou altura(h) do GRID
		// lembrar que j == coluna ou largura(w do GRID 
		int i = source.i, j = source.j;
		int acc=0;
		if(j<w && maze[i][j+1] != OBSTACLE_MAZE /*&& ! visited[i][j+1]*/) {
			possibilities[acc++] = new LocationMaze(i, j+1);		// direta
		}
		if(j>0 && maze[i][j-1] != OBSTACLE_MAZE /*&& ! visited[i][j-1]*/) {
			possibilities[acc++] = new LocationMaze(i, j-1);		// esquerda
		}
		if(i<h && maze[i+1][j] != OBSTACLE_MAZE /*&& ! visited[i+1][j]*/) {
			possibilities[acc++] = new LocationMaze(i+1, j);		// baixo
		}
		if(i>0 && maze[i-1][j] != OBSTACLE_MAZE /*&& ! visited[i-1][j]*/) {
			possibilities[acc++] = new LocationMaze(i-1, j);		// cima
		}
		return possibilities;
	}
	
	public void dfs(LocationMaze curr, int acc) {
		visited[curr.i][curr.j] = true;
		if(!search) { return; }
		
		LocationMaze [] moves = possiblesMoves(curr);
		for(int i=0; i<moves.length; i++) {
			if(moves[i] == null)
				break;
			pathFind[acc++] = moves[i];
		
			if(D.equals(moves[i])) {
				search = false;
				visited[moves[i].i][moves[i].j] = true;
				return;
			}
			else if(!visited[moves[i].i][moves[i].j]) {
				System.out.printf("%d %d\n", moves[i].i, moves[i].j);
				dfs(moves[i], acc);
				if(!search)
					return;
			} else {
				pathFind[acc--] = null;
			}
		}
	}
	
	public void bfs(LocationMaze curr) {
		visited[curr.i][curr.j] = true;
		queue.add(curr);
		int acc = 0;
		pathFind[acc++] = curr;
		boolean goal = false;
		while( ! queue.isEmpty()) {
			LocationMaze head = queue.peek();
			LocationMaze [] moves = possiblesMoves(head);
			for(int k=0; k<moves.length; k++) {
				if(moves[k] == null)
					break;
				int i = moves[k].i;
				int j = moves[k].j;
				if(!visited[i][j]) {
					visited[i][j] = true;
					pathFind[acc++] = moves[k];
					queue.add(moves[k]);
					if(D.equals(moves[k])) {
						queue.clear();
						goal = true;
						break;
					}
				}
			}
			queue.poll();
		}
		if(goal) {
			
		}
		for(int i=pathFind.length-1; i>=0; i--) {
			LocationMaze ant = pathFind[i];
			if(ant == null || ant.equals(S))
				break;
			System.out.printf("%d %d\n", ant.i, ant.j);
		}
	}

	public static void main(String[] args) {
		init();

	}

}
