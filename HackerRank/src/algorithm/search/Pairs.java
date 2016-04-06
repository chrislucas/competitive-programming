package algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * 
 * https://www.hackerrank.com/challenges/pairs
 * https://www.hackerrank.com/challenges/pairs/topics
 * 
 * 
 * */

public class Pairs {
	
	// solucao da TLE em 6 casos de teste
	public static int f(int [] set, int k) {
		int acc = 0;
		int s 	= set.length;
		for(int i=0; i<s-1; i++) {
			for(int j=i+1; j<s; j++)
				if(abs(set[i]-set[j])==k)
					acc++;
		}
		return acc;
	}
	
	public static int abs(int a) {
		return a < 0 ? -a : a;
	}

	public static void main(String[] args) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			StringTokenizer token = new StringTokenizer(buffer.readLine(), " ");
			int n = Integer.parseInt(token.nextToken())
			   ,k = Integer.parseInt(token.nextToken());
			token = new StringTokenizer(buffer.readLine(), " ");
			int [] set = new int[n];
			for(int i=0; token.hasMoreTokens(); i++)
				set[i] = Integer.parseInt(token.nextToken());
			writer.printf("%d\n", f(set, k));
		} catch(IOException ioex){}
	}
}
