package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

// https://www.urionlinejudge.com.br/judge/pt/problems/view/1492
public class URI1492 {
	
	static long [] table;
	
	public static long solution(long a, long b) {
		return table[Long.bitCount(b)] - table[Long.bitCount(a)];
	}
	
	public static void init(){
		int lim = 1000000;
		table = new long[lim];
		table[0] = 0;
		for(int i=1; i<lim; i++) {
			table[i] = Long.bitCount(i) + table[i-1];
		}
		return;
	}
	
	public static long bitCount(BigInteger num) {
		long counter = 0;
		while( num.compareTo(BigInteger.ONE) >= 0  ) {
			if(num.testBit(0)) {
				counter++;
				System.out.print("1");
			} else {
				System.out.print("0");
			}
			num = num.shiftRight(1);
		}
		System.out.println("");
		return counter;
	}
	
	public static void runTest() {
		//10000000000000000
		BigInteger b = new BigInteger("10000000000000000");
		int count = b.bitCount();
		System.out.printf("%d %d", count, bitCount(b));
	}
	
	public static void main(String[] args) {
		init();
		runTest();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			String in;
			while( (in = reader.readLine()) != null ) {
				StringTokenizer token = new StringTokenizer(in, " ");
				long a = Long.parseLong(token.nextToken());
				long b = Long.parseLong(token.nextToken());
				writer.printf("%d\n", solution(a, b));
			}
		} catch(Exception ex) {}

	}

}
