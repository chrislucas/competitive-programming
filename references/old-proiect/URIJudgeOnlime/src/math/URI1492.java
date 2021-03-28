package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.urionlinejudge.com.br/judge/pt/problems/view/1492
public class URI1492 {
	
	static long [] table;
	static Map<BigInteger, Integer> map;
		
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
	
	public static void initialize() {
		map = new HashMap<>();
		map.put(BigInteger.ZERO, 0);
		BigInteger idx = BigInteger.ONE;
		BigInteger lim = new BigInteger("10000000000000000");
		while(idx.compareTo(lim) == -1) {
			map.put(idx, idx.bitCount());
			idx = idx.add(BigInteger.ONE);
		}
		return;
	}
	
	public static void runTest() {
		initialize();
		//10000000000000000
		BigInteger b = new BigInteger("10000000000000000");
		int count = b.bitCount();
		System.out.printf("%d %d\n", count, bitCount(b));
	}
	
	public static void main(String[] args) {
		//init();
		runTest();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			String in;
			while( (in = reader.readLine()) != null ) {
				StringTokenizer token = new StringTokenizer(in, " ");
				long a = Long.parseLong(token.nextToken());
				long b = Long.parseLong(token.nextToken());
				writer.printf("%d\n");
			}
		} catch(Exception ex) {}

	}

}
