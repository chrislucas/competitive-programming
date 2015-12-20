package tests.grafos;

import java.util.ArrayList;

/**
 * http://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/
 * http://algs4.cs.princeton.edu/42digraph/TarjanSCC.java.html
 * */

public class TarjanSCC {

	public static ArrayList<ArrayList<Integer>> adjacent;
	
	
	public static void add(int u, int v) {
		adjacent.get(u).add(v);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
