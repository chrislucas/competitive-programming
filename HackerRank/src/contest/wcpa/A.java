package contest.wcpa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
https://www.hackerrank.com/contests/world-codesprint-april/challenges/jumping-on-the-clouds
**/
public class A {

	public static int solution(int [] set) {
		int counter = 1, i = 0, Lim = set.length-3;
		while(i<Lim) {
			if(set[i+1] == 0 && set[i+2] == 0) {
				i+=2;
			} else {
				i += set[i+1] == 0 ? 1 : 2;
			}
			counter += 1;
		}
		return counter;
	}
	
	public static void runTest() {
		int [][] set = new int[][] {
			 {0,0,1,0,0,1,0}
			,{0,0,0,0,1,0}
		};
		solution(set[1]);
	}
	
	public static void main(String[] args) throws IOException {
		runTest();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		int n = Integer.parseInt(buffer.readLine());
		int [] set = new int[n];
		StringTokenizer tk = new StringTokenizer(buffer.readLine(), " ");
		for(int i=0; tk.hasMoreTokens(); i++) {
			set[i] = Integer.parseInt(tk.nextToken());
		}
		writer.printf("%d\n", solution(set));
	}
}
