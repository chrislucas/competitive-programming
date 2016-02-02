package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// https://www.urionlinejudge.com.br/judge/pt/problems/view/1492

public class URI1492 {
	
	static final int L = 100;
	static long [] table = new long[L+1];
	
	public static long solution(long a, long b) {
		return table[Long.bitCount(b)] - table[Long.bitCount(a)];
	}
	
	static {
		table[0] = 0;
		for(int i=1; i<=10000; i++) {
			table[i] = Long.bitCount(i) + table[i-1];
		}
	}
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			String in;
			while( (in = reader.readLine()) != null ) {
				StringTokenizer token = new StringTokenizer(in, " ");
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				writer.printf("%d\n", solution(a, b));
			}
		} catch(Exception ex) {}

	}

}
