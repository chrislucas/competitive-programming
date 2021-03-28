package module.math.ntheory.modular;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.hackerearth.com/practice/math-1/number-theory-1/
 * https://www.hackerearth.com/practice/math-1/number-theory-1/modulus-arithmetic-1/practice-problems/
 * https://www.hackerearth.com/problem/algorithm/easy-factorial-a-1/
 * DONE
 * */

public class A {
	
	public static long f(long m, int n) {
		long ans = 1;
		for(long x=m; x>0; x--) {
			ans = ((ans % n) * (x % n)) % n;
		}
		return ans;
	}

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer tk = new StringTokenizer(reader.readLine(), " ");
			int m = Integer.parseInt(tk.nextToken());
			int n = Integer.parseInt(tk.nextToken());
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
			writer.printf("%d\n", f(m,n));
		} catch(IOException ioex) {}
	}
}
