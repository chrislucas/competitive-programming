package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * https://www.hackerrank.com/challenges/maxsubarray
 * 
 * ALMOST 
 * 
 * */

public class MaxSubArray {

	
	public static long [] kadane1D(long [] array) {
		long [] ans = {array[0], 0, 0, array[0]/*array[0] > - 1 ? array[0] : 0*/};
		long parcial = ans[0];
		for(int i=1; i<array.length; i++) {
			parcial += array[i];
			if(parcial > ans[0]) {
				ans[0] = parcial;
				ans[2] = i;
			}
			
			if(parcial < 0) {
				parcial = 0;
				ans[1] = i+1;
			}
			// pequena moficicacao no algoritmo para resolver um problema
			if(array[i] > 0) {
				ans[3] += array[i];
			}
			else {
				if(array[i] > array[i-1])
					ans[3] = array[i];
				if(array[i] > ans[0])
					ans[0] = array[i];
			}
		}
		return ans;
	}
	
	public static void runTest() {
		long [][] array = {
			 {2,-1,2,3,4,-5}
			,{31,-41,59,26,-53,58,97,-93,-23,84}
			,{-1,-3,-4}
		};
		long [] ans = kadane1D(array[1]);
		System.out.printf("%d %d %d %d\n", ans[0], ans[1], ans[2], ans[3]);
	}
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			reader(buffer);
		} catch(IOException ioex) {}
	}
	
	public static void reader(BufferedReader buffer) throws IOException {
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		int n = Integer.parseInt(buffer.readLine());
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(buffer.readLine());
			long [] set = new long[x];
			StringTokenizer tk = new StringTokenizer(buffer.readLine(), " ");
			for(x = 0; tk.hasMoreTokens() ;x++)
				set[x] = Integer.parseInt(tk.nextToken());
			long [] ans = kadane1D(set);
			writer.printf("%d %d\n", ans[0], ans[3]);
		}
	}
}
