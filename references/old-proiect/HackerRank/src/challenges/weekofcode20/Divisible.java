package challenges.weekofcode20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import challenges.weekofcode20.NonDivisible.IO;

/*
 * https://www.hackerrank.com/contests/w20/challenges/divisible-sum-pairs
 * Sended
 * 
 * */

public class Divisible {
	
	static class IO {
		static BufferedReader reader;
		static PrintWriter writer;

		public static void init() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		}
		
		public static String read() {
			String enter = null;
			try {
				enter = reader.readLine();
			} catch (IOException e) {}
			return enter;
		}
		
		public static int readInt() {
			return Integer.parseInt(read());
		}
		
		public static int[] readInts(String del) {
			int array [] = null;
			try {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), del);
				array = new int [tokenizer.countTokens()];
				for(int i=0; tokenizer.hasMoreTokens(); i++) {
					array[i] = Integer.parseInt(tokenizer.nextToken());
				}
			} catch (IOException e) {}
			return array;
		}
		
		public static double[] readDoubles(String del) {
			double array [] = null;
			try {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), del);
				array = new double [tokenizer.countTokens()];
				for(int i=0; tokenizer.hasMoreTokens(); i++) {
					array[i] = Double.parseDouble(tokenizer.nextToken());
				}
			} catch (IOException e) {}
			return array;
		}
		
		public static void println(String fmt, Object ... data) {
			writer.printf(fmt, data);
		}
	}
		
	public static void solution() {
		IO.init();
		int n[] = IO.readInts(" ");
		int array [] = IO.readInts(" ");
		int counter = 0;
		for(int i=0; i<n[0]-1; i++) {
			for(int j=i+1; j<n[0]; j++) {
				if( i < j && (array[i] + array[j]) % n[1] == 0)
					counter++;
			}
		}
		IO.println("%d\n", counter);
	}
	
	public static void main(String[] args) {
		solution();
	}
}
