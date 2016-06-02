package algorithm.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * https://www.hackerrank.com/challenges/insertionsort2
 * DONE
 * Resolver Esse
 * https://www.hackerrank.com/challenges/correctness-invariant?h_r=next-challenge&h_v=legacy
 * */

public class InsertionSortP2 {

	static class LiteTemplateIO {
		
		private static BufferedReader reader;
		private static PrintWriter writer;
		
		public static void init()  {
			boolean oj 	= System.getProperty("ONLINE_JUDGE") == null;
			try {
				reader 		= oj ? new BufferedReader(new InputStreamReader(System.in)) : new BufferedReader(new FileReader("input.txt"));
				writer 		= oj ? new PrintWriter(new OutputStreamWriter(System.out), true) : new PrintWriter(new FileWriter("output.txt"));
			} catch (IOException e) {}
		}
		
		public static String read(String del) {
			StringBuilder builder = new StringBuilder();
			try {
				StringTokenizer tokenize = new StringTokenizer(reader.readLine(), del);
				while(tokenize.hasMoreTokens()) {
					builder.append(tokenize.nextToken());
				}
			} catch (IOException e) {}
			return builder.toString();
		}
		
		public static String read() {
			String enter = null;
			try {
				enter = reader.readLine();
			} catch (IOException e) {}
			return enter;
		}
		
		public static Integer[] readInts(String del) {
			Integer array [] = null;
			try {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), del);
				array = new Integer [tokenizer.countTokens()];
				for(int i=0; tokenizer.hasMoreTokens(); i++) {
					array[i] = Integer.parseInt(tokenizer.nextToken());
				}
			} catch (IOException e) {}
			return array;
		}
		
		public static void printf(String fmt, Object ... data) {
			writer.printf(fmt, data);
		}
		
		public static void printf(String fmt, Object data) {
			writer.printf(fmt, data);
		}
	}
	
	public static <T extends Comparable<T>> void  insertionSort(T [] array, int n) {
		for(int i=1; i<n; i++) {
			int j = i-1;
			T cur = array[i];
			while(j>=0 && cur.compareTo(array[j]) < 0) {
				array[j+1] = array[j--];
			}
			array[j+1] = cur;
			for(j=0; j<n; j++) {
				LiteTemplateIO.printf(j == 0 ? "%d" : " %d", array[j]);
			}
			LiteTemplateIO.printf("\n");
		}
	}
	
	public static void main(String[] args) {
		// caraca muleke
		// System.out.printf("%d %d %d", new Object[] {1,2,3});
		LiteTemplateIO.init();
		int  n 			 = Integer.parseInt(LiteTemplateIO.read());
		Integer array [] = LiteTemplateIO.readInts(" ");
		insertionSort(array, n);
	}

}
