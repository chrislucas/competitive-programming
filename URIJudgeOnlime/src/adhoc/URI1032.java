package adhoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1032
 * 
 * Sieve
 * http://math.stackexchange.com/questions/111623/is-it-a-bad-idea-to-use-a-sieve-of-eratosthenes-to-find-all-primes-up-to-very-la
 * 
 * http://introcs.cs.princeton.edu/java/14array/PrimeSieve.java.html
 * http://primesieve.org/
 * 
 * 
 * Pesquisar josephus klogn
 * http://stackoverflow.com/questions/4845260/josephus-for-large-n-facebook-hacker-cup
 * http://cs.stackexchange.com/questions/58078/josephus-problem-a-faster-solution
 * http://www.exploringbinary.com/powers-of-two-in-the-josephus-problem/
 * 
 * */

public class URI1032 {

	public static final int S = 400000;
	public static int [] SET;
	public static int count = 0;
	
	public static int init() {
		SET = new int [S+1];
		boolean P [] = new boolean[S+1];
		for(int i=2; i<S; i++)
			P[i] = true;

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
	
	
	public static int it(int n) {
		int idx = 1, i = 1;
		for(int j=0; i<n; i++, j++) {
			idx = (idx+SET[j])%i+1;
		}
		return idx;
	}
	
	public static int re(int n) {
		if(n == 1)
			return n;
		else {
			int p = re(n-1);
			int j = SET[n-2];
			return (p+j-1)%n+1;
		}
	}
	
	// TLE
	public static int so(boolean [] S, int n) {
		int rest = n-1;
		int  idxPrime = 0
			,jump = SET[idxPrime++]
			,idxCircle = 1
			,counter = 0;
		int idx = 1;
		while(rest > 0) {
			idx = idxCircle%n;
			if(S[idx]) {
				counter++;
			}
			if(counter == jump) {
				S[idx] = false;
				jump = SET[idxPrime++];
				rest--;
				counter=0;
			}
			idxCircle++;
		}
		return idx;
	}
	
	public static void gen() {
		for (int i = 1; i < 3502; i++)
			System.out.println(i);
	}
	
	public static void main(String[] args) {
		init();
		try {
			boolean oj 	= true; //System.getProperty("ONLINE_JUDGE") == null;
			BufferedReader reader;
			String path = "C:\\Users\\C.Lucas\\Desktop\\IME-seletiva\\casos-testes\\uri\\1032\\";
			reader 	= oj ? new BufferedReader(new InputStreamReader(System.in))
					: new BufferedReader(new FileReader(path.concat("in.txt")));
			PrintWriter writer;
			writer 	= oj ? new PrintWriter(new OutputStreamWriter(System.out), true)
					: new PrintWriter(new FileWriter(path.concat("out.txt")));
			String in;
			while( ! (in = reader.readLine()).equals("0") ) {
				int n = Integer.parseInt(in);
				/*
				boolean S [] = new boolean[n+1];
				for(int i=1; i<n+1; i++)
					S[i] = true;
				writer.printf("%d\n", so(S, S.length));
				*/
				writer.printf("%d\n", re(n)+1);
			}
			writer.close();
		} catch(IOException ex) {}
	}
}
