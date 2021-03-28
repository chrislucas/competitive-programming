package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * https://www.hackerrank.com/challenges/security-encryption-scheme
 * DONE
 * */

public class SecurityEncriptionScheme {
	
	public static long f(int n, int acc) {
		if(n < 2)
			return acc;
		else
			return f(n-1, acc * n);
	}
	
	public static long f2(long n) {
		for(long x=n-1; x>1; x--) {
			n*=x;
		}
		return n;
	}

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			int n = Integer.parseInt(reader.readLine());
			writer.printf("%d\n", f2(n)/*f(n, 1)*/);
		} catch(IOException ioex){}
	}
}
