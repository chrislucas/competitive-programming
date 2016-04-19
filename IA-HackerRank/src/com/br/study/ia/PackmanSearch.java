package com.br.study.ia;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	
	public static void init() {
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
				
			}
		}
	}
	
	
	public static void main(String[] args) {

	}

}
