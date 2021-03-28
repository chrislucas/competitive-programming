package com.br.study.ia.search;

import java.util.ArrayList;

import com.br.study.ia.search.TemplatePackmanJava.Place;

/**
 * https://www.hackerrank.com/challenges/pacman-astar
 * */

public class PackmanASearch {
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
	
	public static void main(String[] args) {
		
	}
}
