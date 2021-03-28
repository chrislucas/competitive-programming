package challenges.weekofcode20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;




public class NonDivisible {
	
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
	
	static class Pair implements Comparable<Pair> {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pair that) {
			if(this.equals(that)) {
				return 0;
			} else {
				return 1;
			}
		}
		
		@Override
		public boolean equals(Object object) {
			Pair that = (Pair) object;
			if(this.x == that.x  && this.y == that.y)
				return true;
			else
				return false;
		}
	}

	/*
	 * Travei
	 * */
	public static void run() {
		IO.init();
		int values[] = IO.readInts(" ");
		int n = values[0], k = values[1];
		int array [] = IO.readInts(" ");
		//Set<Integer> ints = new HashSet<>();
		int counter = 0;
		int [][] dp = new int[n+1][n+1];
		
		for(int i=1; i<n+1; i++) {
			dp[0][i] = dp[i][0] = array[i-1];
		}
		
		//array = new int[n];	
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i == j || dp[i][j] == -1)
					continue;
				else if( (dp[i][0] + dp[0][j]) % k == 0)
					dp[j][i] = dp[i][j] = -1;
				else {
					dp[j][i] = dp[i][j] = 1/*dp[0][j]*/;
				}
			}
		}
		/*
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i == j || dp[i][j] == -1)
					continue;
			}
		}
		*/
		IO.println("%d\n", counter);
	}
/**
5 5
1 5 6 8 9
10 2
1 7 2 4 5 8 9 6 10 3
**/
	public static void RX() {
		IO.init();
		int values[] = IO.readInts(" ");
		int n = values[0], k = values[1];
		int array [] = IO.readInts(" ");
		int set [] = new int[k];
		/*
		 * se a%k == 0 e b%k == 0 entao (a+b)%k == 0
		 * */
		for(int val : array) {
			set[val % k] += 1;
		}
		int ans = 0;
		for(int i=0; i<k/2+1; i++) {
			if( (i == 0 || i*2==k) && set[i] != 0)
				ans += 1;
			/*
			else {
				int p = set[i];
				int q = set[k-i];
				ans = Math.max(p, q);
			}
			*/
		}
		IO.println("%d\n", ans);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(false & true);
		RX();
	}


}
