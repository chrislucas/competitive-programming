package challenges.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/challenges/two-arrays
 * 
 * */

public class TwoArrays {

	public static boolean solution(int [] set, int k) {
		int L = set.length;
		for(int i=0; i<=(L/2); i++) {
			if(set[i]+set[--L] != k)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));	
		try {
			int cases = Integer.parseInt(buffer.readLine());
			StringTokenizer tk = null;
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
			for(int i=0; i<cases; i++) {
				tk = new StringTokenizer(buffer.readLine(), " ");
				int  s = Integer.parseInt(tk.nextToken())
					,k = Integer.parseInt(tk.nextToken());
				int [] A = new int[s * 2];
				tk = new StringTokenizer(buffer.readLine(), " ");
				int j = 0;
				for( ; tk.hasMoreTokens() ;j++) {
					A[j] = Integer.parseInt(tk.nextToken());
				}
				tk = new StringTokenizer(buffer.readLine(), " ");
				for( ; tk.hasMoreTokens() ;j++) {
					A[j] = Integer.parseInt(tk.nextToken());
				}
				Arrays.sort(A);
				writer.printf("%s\n", solution(A, k) ? "YES" : "NO");
			}
		} catch(IOException ioex) {}
	}
}
