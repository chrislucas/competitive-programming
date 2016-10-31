package algorithm.bitm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

/*
 * https://www.hackerrank.com/challenges/counter-game
 * http://www.exploringbinary.com/ten-ways-to-check-if-an-integer-is-a-power-of-two-in-c/
 * DONE porem o metodo solver2  nao resolve o problema
 * */

public class CGame {

	private static BufferedReader reader;
	private static PrintWriter writer;
	
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
	// usar propriedades do operador XOR
	public static boolean ipot(long n) {
		return n+(n-1) == (n^(n-1));
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
	
	public static long roundDownNPOT(long n) {
		n--;
		n |= n >> 1;
		n |= n >> 2;
		n |= n >> 4;
		n |= n >> 8;
		n |= n >> 16;
		n++;
		return n >>= 1;
	}
	
	public static long roundDownNPOT2(long n) {
		return (long) Math.pow(2, Math.floor(mlog(n, 2)));
	}
	
	public static BigInteger roundDownPOT(BigInteger n) {
		n = n.subtract(BigInteger.ONE);
		n = n.or(n.shiftRight(1));
		n = n.or(n.shiftRight(2));
		n = n.or(n.shiftRight(4));
		n = n.or(n.shiftRight(8));
		n = n.or(n.shiftRight(16));
		n = n.add(BigInteger.ONE);
		return n.shiftRight(1);
	}
	
	public static BigInteger roundPOT(BigInteger n) {
		n = n.subtract(BigInteger.ONE);
		n = n.or(n.shiftRight(1));
		n = n.or(n.shiftRight(2));
		n = n.or(n.shiftRight(4));
		n = n.or(n.shiftRight(8));
		n = n.or(n.shiftRight(16));
		n = n.add(BigInteger.ONE);
		return n;
	}
	
	public static boolean ipot(BigInteger n) {
		BigInteger o = n.subtract(BigInteger.ONE);
		return n.add(o).equals(n.xor(o));
	}
	
	public static boolean solver(long n) {
		boolean flag = false;
		while(n > 1) {
			if(!ipot(n))
				n = roundDownNPOT(n);
			if(ipot(n))
				n >>= 1;
			//n = ipot(n) ? n >> 1 : roundDownNPOT(n);
			flag = ! flag;
		}
		return flag;
	}
	
	public static boolean solver2(BigInteger n) {
		boolean flag = false;
		if(!ipot(n))
			n = roundPOT(n);
		while(n.compareTo(BigInteger.ONE) == 1) {
			n = n.shiftRight(1);
			flag = ! flag;
		}
		return flag;
	}
	
	public static boolean solver3(BigInteger n) {
		n = n.subtract(BigInteger.ONE);
		int bc = n.bitCount();
		return (bc & 1) == 1;
	}
	
	public static boolean solver4(BigInteger n) {
		long bc = 0;
		n = n.subtract(BigInteger.ONE);
		while(n.compareTo(BigInteger.ZERO) == 1) {
			n = n.and(n.subtract(BigInteger.ONE));
			bc++;
		}
		return (bc & 1) == 1;
	}
	
	public static double mlog(double val, int base) {
		return (Math.log10(val) / Math.log10(base) );
	}
	
	/*
	 * http://stackoverflow.com/questions/14291172/finding-the-smallest-power-of-2-greater-than-n
	 * */
	public static void runTests() {
		//System.out.println(mlog(100,10));
		//System.out.println(mlog(2048, 2));
		System.out.println(roundUpPow2(5000));
		System.out.println(smallerPowTwo(5000));
		System.out.println(1 << (int)(Math.floor(mlog(5000, 2))) + 1 );
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
				//long n = Long.parseLong(reader.readLine());
				writer.printf("%s\n", solver4(new BigInteger(reader.readLine()))
						? "Louise" : "Richard");
				cases--;
			}
		} catch (IOException e) {} 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//runTests();
		run();
	}

}
