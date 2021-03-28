package math.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * https://www.hackerrank.com/challenges/handshake
 * DONE
 * 
 * */

public class Handshake {

	
	public static double pow(double b, double e, double acc) {
		if(e==0)
			return 1;
		else if(e == 1)
			return b*acc;
		else if(e<0)
			return pow(1/b,-e,acc);
		else if(e%2==0)
			return pow(b*b, e/2, acc);
		else
			return pow(b*b, (e-1)/2, acc*b);
	}
	
	public static long f(int n) {
		long acc = n;
		for(long s = n-1; s>0; s--)
			acc += s;
		return acc;
	}
	
	public static long f2(int n) {
		return (n*n-n)/2;
	}
	

	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			int cases = Integer.parseInt(reader.readLine());
			for(int i=0; i<cases; i++) {
				int n = Integer.parseInt(reader.readLine());
				writer.printf("%d\n", /*n < 2 ? 0 :*/ f2(n));
			}
		} catch(IOException ioex) {}
	}
}
