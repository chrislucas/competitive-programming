package algorithm.bitm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * https://www.hackerrank.com/challenges/counter-game
 * http://www.exploringbinary.com/ten-ways-to-check-if-an-integer-is-a-power-of-two-in-c/
 * */

public class CGame {

	private static BufferedReader reader;
	private static PrintWriter writer;
	
	public static int p2 [];
	public static void init () {
		p2  = new int[31];
		for(int i=1; i<31; i++) {
			p2[i-1] = 1<<i;
		}
		p2[30] = (1<<31) - 1;
		return;
	}
	
	public static boolean powerOfTwo(long n) {
		int bits = 0;
		while(n >= 1) {
			if((n & 1) == 1)
				bits ++;
			n >>= 1;
		}
		return bits == 1;
	}
	
	// Complement and Compare
	public static boolean powerOfTwo2(long n) {
		return ((n != 0) && ((n & (~n+1))==n));
	}
	
	public static int smallerPowTwo(int n) {
		int x = 1 << 30;
		while(x > n) {
			x >>= 1;
		}
		return x;
	}
	/*
	 * http://graphics.stanford.edu/~seander/bithacks.html#RoundUpPowerOf2
	 * */
	public static int roundUpPow2(int n) {
		n--;
		n |= n >> 1;
		n |= n >> 2;
		n |= n >> 4;
		n |= n >> 8;
		n |= n >> 16;
		n++;
		return n;
	}
	
	public static boolean solver (long n) {
		boolean flag = true;
		while(n > 1) {
			if(powerOfTwo2(n)) {
				n >>= 1;
			} else {
				if(n > Integer.MAX_VALUE) {
					n = Integer.MAX_VALUE;
				} else {
					n = smallerPowTwo((int)n);
				}
			}
			flag = ! flag;
		}
		return flag;
	}
	
	public static double log(double val, int base) {
		return (Math.log10(val) / Math.log10(base) );
	}
	
	/*
	 * http://stackoverflow.com/questions/14291172/finding-the-smallest-power-of-2-greater-than-n
	 * */
	public static void runTests() {
		//System.out.println(log(100,10));
		//xSystem.out.println(log(2048, 2));
		System.out.println(roundUpPow2(5000));
		System.out.println(smallerPowTwo(5000));
		System.out.println(1 << (int)(Math.floor(log(5000, 2))) + 1 );
		for(int i=2; i<Integer.MAX_VALUE; i++) {
			if(powerOfTwo2(i)) {
				System.out.printf("%d ", i);
			}
				
		}
		System.out.println("fim teste");
	}
	
	public static void run() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		int cases;
		try {
			cases = Integer.parseInt(reader.readLine());
			while(cases>0) {
				long n = Long.parseLong(reader.readLine());
				writer.printf("%s\n", solver(n) ? "Louise" : "Richard");
				cases--;
			}
		} catch (IOException e) {} 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runTests();
		//run();
	}

}
