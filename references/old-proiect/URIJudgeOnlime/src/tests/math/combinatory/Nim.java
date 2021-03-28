package tests.math.combinatory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * http://www.geeksforgeeks.org/combinatorial-game-theory-set-2-game-nim/
 * */

public class Nim {

	
	static int [] piles;
	
	static void initialize(int sizePile) {
		piles = new int[sizePile];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer tokens = new StringTokenizer(reader.readLine(), " ");
			int [] values = new int[tokens.countTokens()];
			int idx = 0;
			while(tokens.hasMoreTokens()) {
				values[idx++] = Integer.parseInt(tokens.nextToken());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void movement(int [] values) {
		int i, sums = sumXor(values);
		if(sums != 0) {
			
		} else {
			int n = values.length, count;
			int indices[] = new int[n];
			for(i = 0, count = 0; i<n; i++) {
				
			}
		}
	}
	
	public static int sumXor(int [] values) {
		int size = values.length-1;
		for(int i=0; i<size; i++) {
			values[i+1] = values[i] ^ values[i+1];
		}
		return values[size];
	}
	
	public static int collatz(int n) {
		int counter = 0;
		while(n!=1) {
			n = n % 2 == 0 ? n/2 : 3*n+1;
			System.out.println(n);
			counter++;
		}
		return counter;
	}
	
	
	
	public static void runTest() {
		int values [][] = {
			 {3,4,5}
			,{1,4,5}
		};
		collatz(151);
		//System.out.println(values[1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runTest();
	}

}
