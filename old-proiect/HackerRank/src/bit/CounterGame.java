package bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * https://www.hackerrank.com/challenges/counter-game
 * DONE porem o metodo solver2  nao resolve o problema
 * */
public class CounterGame {
	private static BufferedReader reader;
	private static PrintWriter writer;
	
	public static boolean ipot(long n) {
		return n+(n-1) == (n^(n-1));
	}
	
	public static boolean ipot(BigInteger n) {
		BigInteger o = n.subtract(BigInteger.ONE);
		return n.add(o).equals(n.xor(o));
	}
	
	public static boolean ipot2(BigInteger n) {
		BigInteger o = n.subtract(BigInteger.ONE);
		return n.compareTo(BigInteger.ONE) >= 1 && n.and(o).compareTo(BigInteger.ZERO) == 0;
	}
	
	public static BigInteger roundDownPOT(BigInteger n) {
		n = roundPOT(n);
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
	
	public static BigInteger rd(BigInteger n) {
		if(ipot2(n))
			return n;
		/*
		long bc = 0;
		while(n.compareTo(BigInteger.ZERO) == 1) {
			n = n.shiftRight(1);
			bc++;
		}
		*/
		BigInteger o = BigInteger.ONE;
		while(o.compareTo(n) == -1) {
			o = o.shiftLeft(1);
		}
		return  o;
	}
	
	public static boolean solver2(BigInteger n) {
		boolean flag = false;
		while(n.compareTo(BigInteger.ONE) == 1) {
			if(ipot2(n))
				n = n.shiftRight(1);
			else
				n =  roundDownPOT(n); //rd(n); //n.subtract(roundPOT(n));
			flag = ! flag;
		}
		return flag;
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
	
	public static void run() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		int cases;
		try {
			cases = Integer.parseInt(reader.readLine());
			while(cases>0) {
				writer.printf("%s\n", solver2(new BigInteger(reader.readLine()))
						? "Louise" : "Richard");
				cases--;
			}
		} catch (IOException e) {} 
	}
	
	public static void main(String[] args) {		
		//run();
		/*
		BigInteger o = new BigInteger("10822793693366807750");
		System.out.printf("%s %s %s\n", rd(o), roundPOT(o), roundDownPOT(o));
		*/
	}
}
