package contest.wcpa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
	
	
	public static int naive(int [] set, int d) {
		int counter = 0;
		int L = set.length;
		for(int i=0; i<L-2; i++) {
			for(int j=i+1; j<L-1; j++) {
				for(int k=j+1; k<L; k++) {
					if(set[k]-set[j]==d && set[j]-set[i]==d)
						counter++;
				}
			}
		}
		return counter;
	}
	
	public static int solution(int [] set, int d) {

		int L = set.length;
		int [][] table = new int[d+1][L];
		
		// um loop pelos possivels
		for(int i=1; i<d+1; i++) {
			for(int j=0; j<L; j++) {
				
			}
		}
		
		return table[d][L-1];
	}
	
	
	public static void runTest() {
		int [][] set = new int[][] {
			{1,2,4,5,7,8,10}
		};
		naive(set[0], 3);
	}

	public static void main(String[] args) throws IOException {
		//runTest();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		StringTokenizer tk = new StringTokenizer(buffer.readLine(), " ");
		int n = Integer.parseInt(tk.nextToken());
		int d = Integer.parseInt(tk.nextToken());
		int [] set = new int[n];
		
		tk = new StringTokenizer(buffer.readLine(), " ");
		for(int i=0; tk.hasMoreTokens(); i++) {
			set[i] = Integer.parseInt(tk.nextToken());
		}
		writer.printf("%d\n", solution(set, d));
	}
}
