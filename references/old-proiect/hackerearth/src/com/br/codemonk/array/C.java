package com.br.codemonk.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * https://www.hackerearth.com/code-monk-array-strings/algorithm/prateek-and-his-friends/
 * DONE
 * */
public class C {
	static PrintWriter writer;
	static BufferedReader reader;
	
	public static boolean verify(long [] array, long x) {
		long sum;
		for(int i=0; i<array.length-1; i++) {
			sum = array[i];
			if(sum == x)
				return true;
			for(int j=i+1; j<array.length; j++) {
				sum += array[j];
				if(sum == x) {
					return true;
				}
				else if(sum > x)
					break;
			}
		}
		return array[array.length-1] == x ? true : false;
	}
	
	public static void main(String[] args) {
		writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer tk;
			//while( (tk = new StringTokenizer(reader.readLine(), " ")) != null) {
				int cases = Integer.parseInt(reader.readLine());
				while(cases>0) {
					tk = new StringTokenizer(reader.readLine(), " ");
					int n = Integer.parseInt(tk.nextToken());
					long x = Long.parseLong(tk.nextToken());
					long array [] = new long[n];
					for(int i=0; i<n; i++) {
						array[i] = Long.parseLong(reader.readLine());
					}
					writer.printf("%s\n", verify(array, x) ? "YES" : "NO");
					cases--;
				}
			//}
		} catch(IOException ioex) {}
	}
}
