package prova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cartoes {

	static class Solution {
		
		private static void solver(int [] numbers) {
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
			int s = numbers.length;
			int [][] dp = new int [2][s];
			for(int i=0; i<s-1; i++) {
				dp[0][i] = Math.max(numbers[i], numbers[i+1]);
			}
			int idx = 0;
			for(int i=4; i<=s; i+=2) {
				for(int j=0; j<=s-i; j++) {
					int k=j+i-1;
					int pi = numbers[j] + Math.min(dp[idx%2][j+1], dp[idx%2][j+2]);
					int pj = numbers[k] + Math.min(dp[idx%2][j], dp[idx%2][j+1]);
					dp[1 - idx%2][j] = Math.max(pi, pj);
				}
				idx++;
			}
			writer.printf("%d\n", dp[idx%2][0]);
			return;
		}
		
		@SuppressWarnings("unused")
		private static void solver2(int [] numbers)  {
			int s = numbers.length;
			int dp[] = new int[s];
		}
		
		public static int exp(int b, int e) {
			if(e == 0)
				return 1;
			else if(e ==1)
				return b;
			int y=1;
			while(e>1) {
				if(e%2==0) {
					e /= 2;
				} else {
					y *= b;
					e = (e - 1) / 2;
				}
				b *= b;
			}
			return b * y;
		}
		
		@SuppressWarnings("unused")
		private static int simpleParseInt(String n) {
			int i = 1, s = n.length();
			if(n.substring(0,1).equals("-")){ 
				i = 2;
			}
			int multiply = exp(10, s-i), sum = 0;
			for(int x=s; x>=i-1; x--) {
				char c = n.charAt(x);
				sum += (c & 0x0f) * multiply;
				multiply /= 10;
			}
			return sum;
		}
		
		public static void read() {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String in;
			try {
				while( (in = reader.readLine() ) != null) {
					int n = Integer.parseInt(in);
					int [] numbers = new int[n];
					StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
					for(int i=0; tokenizer.hasMoreTokens(); i++) {
						numbers[i] = Integer.parseInt(tokenizer.nextToken());
					}
					Solution.solver(numbers);
				}
			} catch(IOException ioex){}
		}
	}
	
	public static void main(String[] args) {
		Solution.read();
	}

}
