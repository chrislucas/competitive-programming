package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
 * 
 * https://www.hackerrank.com/challenges/fibonacci-modified
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
		BigInteger [] set  = {BigInteger.valueOf(a), BigInteger.valueOf(b)};
		for(int i=2; i<k; i++) {
			BigInteger p = i % 2 == 0 ? set[(i-1)%2] : set[(i-2)%2];
			p = p.multiply(p);
			BigInteger s = i % 2 == 0 ? set[(i-2)%2] : set[(i-1)%2];
			set[i%2] = p.add(s);
		}
		return set[k%2==0?1:0].toString();
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
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
			int a = Integer.parseInt(token.nextToken())
			   ,b = Integer.parseInt(token.nextToken())
			   ,c = Integer.parseInt(token.nextToken());
			writer.printf("%s\n", f2(a, b, c));
		} catch(IOException ioex) {}
	}
}
