package com.br.practice.track.datastruct.uf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.hackerearth.com/practice/data-structures/disjoint-data-strutures/basics-of-disjoint-data-structures/tutorial/
 * */

public class Test {
	public static int [] array, tall;
	public static boolean [] added;	
	// weighted
	public static void wUnion(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);		
		int qp = tall[rootP];
		int qq = tall[rootQ];
		if(qp < qq) {
			array[rootP] = array[rootQ];
			tall[rootQ] += tall[rootP];
		}
		else {
			array[rootQ] = array[rootP];
			tall[rootP] += tall[rootQ];
		}
		added[qp < qq ? rootP : rootQ] = true;
		print(tall);
	}
	
	public static void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		array[rootP] = array[rootQ];
		tall[rootQ] += tall[rootP];
		added[rootP] = true;
		print(tall);
	}
	
	public static int root(int p) {
		while(p != array[p]) {
			array[p] = array[array[p]];
			p = array[p];
		}
		return p;
	}
	
	public static boolean find(int p, int q) {
		return root(p) == root(q);
	}
	
	public static void init(int size) {
		array 	= new int[size];
		tall 	= new int[size];
		added	= new boolean[size];
		for(int i=0; i<size; i++) {
			array[i] = i;
			tall[i] = 1;
		}		
	}
	
	public static int [] process(int [] array, int p, int sz) {
		int newArray [] = new int [sz];
		for(int i=0, j=0; j<sz; i++) {
			if(added[i])
				continue;
			newArray[j++] = array[i];
		}
		return newArray;
	}
	
	public static void print(int [] array) {
		int N [] = Arrays.copyOf(array, array.length);
		Arrays.sort(N);
		for(int i=0; i<array.length; i++) {
			if(added[i])
				continue;
			System.out.printf("%d ", N[i]);
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer token = new StringTokenizer(buffer.readLine(), " ");
			int nodes, edges;
			nodes = Integer.parseInt(token.nextToken());
			edges = Integer.parseInt(token.nextToken());
			init(nodes);
			while(edges>0) {
				token = new StringTokenizer(buffer.readLine(), " ");
				int p = Integer.parseInt(token.nextToken());
				int q = Integer.parseInt(token.nextToken());
				union(p-1, q-1);
				edges--;
			}
		} catch(IOException ieox) {}
	}
}
