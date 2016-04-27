package contest.adinfinitum15;

import java.math.BigInteger;

/*
 * https://www.hackerrank.com/contests/infinitum15/challenges/birthdays
 * 
 * principio gaiola de pombos
 * https://en.wikipedia.org/wiki/Pigeonhole_principle
 * 
 * Permutation
 * https://www.cs.colostate.edu/~cs161/.Spring13/slides/08_permutations.pdf
 * 
 * Combinatory
 * http://www.aconnect.de/friends/editions/computer/combinatoricode_e.html
 * */

public class Birthday {
	
	
	public static long nPr(long n, long p) {
		long d = (n - p);
		for(long x=n-1; x>d; x--) {
			n *= x;
		}
		return n;
	}
	
	public static BigInteger perm(long n, long p) {
		long d = (n - p), x = n - 1;
		BigInteger val = BigInteger.valueOf(x);
		BigInteger ans = BigInteger.valueOf(n);
		while(x>d) {
			ans = ans.multiply(val);
			val = val.subtract(BigInteger.valueOf(1));
			x--;
		}
		return ans;
	}
	

	
	public static void main(String[] args) {
		BigInteger a 	= perm(365, 10);
		double ans = nPr(365, 10) /*/  Math.pow(365, 10)*/;
		
		System.out.println(ans);
	}
}
