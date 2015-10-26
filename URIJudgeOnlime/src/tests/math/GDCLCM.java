package tests.math;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GDCLCM {

	public static int gdc(int a, int b) {
		// se a < b, no loop ocorre a inversao automatica
		while(a%b!=0) {
			int rest = a % b;
			a = b;
			b = rest;
		}
		return b;
	}
	
	public static int lcm(int a, int b) {
		// a / gdc(a , b) * b ou b / gdc(a , b) * a ou a * b/ gdc(a , b) 
		return (a / gdc(a , b)) * b  ;
	}
	
	public static int gdc(int [] array) {
		int ans = gdc(array[0], array[1]);
		int len = array.length;
		for (int i=2; i<len; i++) {
			ans = gdc(ans, array[i]);
		}
		return ans;
	}
	
	public static int lcm(int [] array) {
		int ans = lcm(array[0], array[1]);
		int len = array.length;
		for (int i=1; i<len; i++) {
			ans = lcm(ans, array[i]);
		}
		return ans;
	}

	public static boolean isCongruent(int m, int n, int p) {
		return gdc(Math.abs(m-n), p) < p;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		String in;
		/*
		System.out.println(gdc(new int[] {10,25,60}));
		System.out.println(lcm(new int[] {25,10,60}));
		System.out.println(gdc(new int[] {20,30,60}));
		System.out.println(lcm(new int[] {60,30,20}));
		*/
		while( !(in = buffer.readLine()).equals("0")) {
			StringTokenizer tokenizer = new StringTokenizer(in, " ");
			int n[] = new int[tokenizer.countTokens()];
			int c = 0;
			while(tokenizer.hasMoreTokens()) {
				n[c++] = Integer.parseInt(tokenizer.nextToken());
			}
			System.out.printf("%d %d\n", gdc(n),lcm(n));
		}
	}

}
