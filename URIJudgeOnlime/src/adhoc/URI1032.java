package adhoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1032
 * 
 * Sieve
 * http://math.stackexchange.com/questions/111623/is-it-a-bad-idea-to-use-a-sieve-of-eratosthenes-to-find-all-primes-up-to-very-la
 * 
 * http://introcs.cs.princeton.edu/java/14array/PrimeSieve.java.html
 * http://primesieve.org/
 * */

public class URI1032 {

	public static final int S = 40000;
	public static int [] SET;
	
	public static int init() {
		SET = new int [S+1];
		boolean P [] = new boolean[S+1];
		for(int i=2; i<S; i++)
			P[i] = true;
		int count = 0;
		for(int i = 2; i*i<=S; i++) {
			if(P[i]) {
				for(int j=i; j*i<=S; j++) {
					int idx = j*i;
					P[idx] = false;
				}
			}
		}
		
		for(int i=2; i<P.length; i++) {
			if(P[i])
				SET[count++] = i;
		}
		return count;
	}
	
	
	public static int sIterative(int n) {
		int idx = 1;
		for(int i=1; i<=n; i++) {
			int p 	= SET[i-1];
			idx 	= (idx+p-1)%i+1;
			i++;
		}
		return idx;
	}
	
	public static void test() {
		System.out.println(sIterative(6));
	}
	
	public static void main(String[] args) {
		init();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			String in;
			while( ! (in = reader.readLine()).equals("0") ) {
				int n = Integer.parseInt(in);
				writer.printf("%d\n", sIterative(n));
			}
		} catch(Exception ex) {}
	}
	
}
