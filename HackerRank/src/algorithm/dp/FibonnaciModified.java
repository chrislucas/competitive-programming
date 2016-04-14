package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 
 * https://www.hackerrank.com/challenges/fibonacci-modified
 * http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibtable.html
 * http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * DONE
 * */

public class FibonnaciModified {
	
	
	public static long f(int a, int b, int k) {
		long [] s = {a,b};
		long acc = 0;
		for(int i=2; i<k; i++) {
			long n = i%2==0 ? s[(i-1)%2] * s[(i-1)%2] : s[(i-2)%2] * s[(i-2)%2];
			long m = i%2==0 ? s[(i-2)%2] : s[(i-1)%2];
			s[i%2] = n + m;	
			acc = s[i%2];
		}
		return acc; //s[k%2==0?1:1];
	}
	
	public static String f2(int a, int b, int k) {
		BigInteger [] set  = new BigInteger[k];
		set[0] = BigInteger.valueOf(a);
		set[1] = BigInteger.valueOf(b);
		for(int i=2; i<k; i++) {
			BigInteger p = set[i-2];
			BigInteger s = set[i-1].multiply(set[i-1]);
			set[i] = p.add(s);
		}
		return set[k-1].toString();
	}
	
	public static String f3(int a, int b, int k) {
		BigInteger [] set = {BigInteger.valueOf(a), BigInteger.valueOf(b)};
		for(int i=2; i<=k; i++){
			BigInteger p = set[0];
			BigInteger s = set[1];
			set[0] = set[1];
			s = s.multiply(s);
			set[1] = p.add(s);
		}
		return set[0].toString();
	}
	
	public static long expMatrix(long [][] fibo, int k) {
		Stack<Integer> stack = new Stack<>();
		while(k>2) {
			stack.add(k);
			k/=2;
		}
		while(!stack.empty()) {
			int m = stack.pop();
			// codigo de multiplicacao
			if(m%2!=0) {
				// codigo de multiplicacao
			}
		}
		return 0;
	}
	
	public static BigInteger expMatrix(int k) {
		//[2][2]
		/* {
		 * 	 {f(n+1), f(n)}
		 * 	,{f(n), f(n-1)}
		 * }
		 * 
		 * */
		BigInteger [][] mat = {{BigInteger.ONE, BigInteger.ONE},{BigInteger.ONE, BigInteger.ZERO}};
		BigInteger [][] stat = { {BigInteger.ONE, BigInteger.ONE},{BigInteger.ONE, BigInteger.ZERO}};
		
		for(int i=0; i<k; i++) {
			BigInteger a = mat[0][0].multiply(stat[0][0]).add(mat[0][1].multiply(stat[1][0]));
			BigInteger b = mat[0][0].multiply(stat[0][1]).add(mat[0][1].multiply(stat[1][1]));
			BigInteger c = mat[1][0].multiply(stat[0][0]).add(mat[1][1].multiply(stat[1][0]));
			BigInteger d = mat[1][0].multiply(stat[0][1]).add(mat[1][1].multiply(stat[1][1]));			
			mat[0][0] = a;
			mat[0][1] = b;
			mat[1][0] = c;
			mat[1][1] = d;
		}
		return mat[0][0];
	}
	
	public static BigInteger opFibonacci(int k) {
		BigInteger [][] mat = {{BigInteger.ONE, BigInteger.ONE},{BigInteger.ONE, BigInteger.ZERO}};
		optimatize2(mat, k);
		return mat[0][0];
	}
	
	public static void optimatize(BigInteger [][] mat, int k) {
		if(k == 0 || k == 1)
			return;
		BigInteger [][] stat = {{BigInteger.ONE, BigInteger.ONE},{BigInteger.ONE, BigInteger.ZERO}};
		optimatize(mat, k/2);
		multiply(mat, mat);
		if(k%2!=0)
			multiply(mat, stat);
	}
	
	public static void optimatize2(BigInteger [][] mat, int k) {
		if(k < 2)
			return;
		BigInteger [][] stat = {{BigInteger.ONE, BigInteger.ONE},{BigInteger.ONE, BigInteger.ZERO}};
		/*
		while(k>0) {
			multiply(mat, mat);
			if(k%2!=0){
				multiply(mat, stat);
			}
			k/=2;
		}
		*/

		Stack<Integer> stack = new Stack<>();
		while(k>2) {
			stack.add(k);
			k/=2;
		}
		while(!stack.empty()) {
			int m = stack.pop();
			multiply(mat, mat);
			if(m%2!=0){
				multiply(mat, stat);
			}
		}
		return;
	}
	
	public static BigInteger multiply(BigInteger [][] mat, BigInteger [][] stat ) {
		BigInteger a = mat[0][0].multiply(stat[0][0]).add(mat[0][1].multiply(stat[1][0]));
		BigInteger b = mat[0][0].multiply(stat[0][1]).add(mat[0][1].multiply(stat[1][1]));
		BigInteger c = mat[1][0].multiply(stat[0][0]).add(mat[1][1].multiply(stat[1][0]));
		BigInteger d = mat[1][0].multiply(stat[0][1]).add(mat[1][1].multiply(stat[1][1]));			
		mat[0][0] = a;
		mat[0][1] = b;
		mat[1][0] = c;
		mat[1][1] = d;
		return mat[0][0];
	}
	
	/**
	 * 0 1 10	
	 * 84266613096281243382112
	 *
	 */
	
	static class Number {
		private int[] number;							// array que representara o numero calculado
		private int digits;								// contador de digitos
		// representacao do numerom como string
		private static final StringBuilder representation = new StringBuilder();
		
		@Override
		public String toString() {
			for(int i=digits-1; i>-1; i--)
				representation.append(number[i]);
			return representation.toString();
		}
		
		public static double log(double n, long base) {
			return Math.log10(n) / Math.log10(base);
		}
		
		public static long countDigits(long n, int base) {
			return Math.round(log(n, base)) + 1;
		}
	}

	public static void main(String[] args) {
		//expMatrix(100);
		//opFibonacci(100);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
			int a = Integer.parseInt(token.nextToken())
			   ,b = Integer.parseInt(token.nextToken())
			   ,c = Integer.parseInt(token.nextToken());
			writer.printf("%s\n", f3(a, b, c));
		} catch(IOException ioex) {}
	}
}
