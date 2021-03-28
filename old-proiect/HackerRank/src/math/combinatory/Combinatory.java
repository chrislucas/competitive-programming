package math.combinatory;

import java.math.BigInteger;

public class Combinatory {
	
	/*
	 * http://cgi.csc.liv.ac.uk/~ped/teachadmin/algor/dyprog.html
	 * http://stackoverflow.com/questions/18153810/how-to-find-npr-permutations-efficiently
	 * */
	
	public static long nPr(long n, long p) {
		long d = (n - p);
		for(long x=n-1; x>d; x--) {
			n *= x;
		}
		return n;
	}
	
	// http://www.geeksforgeeks.org/power-set/
	public static void subset(int [] array) {
		int sz 			= array.length;
	
		for(int i=0; i<(1<<sz); i++) {
			for(int j=0; j<sz; j++) {
				if( (i & 1<<j) > 0) {
					System.out.printf("%d", array[j]);
				}
			}
			System.out.println("");
		}
		/*
		for(int i=0; i<(1<<sz); i++) {
			for(int j=sz-1; j>=0; j--) {
				if( (i & 1<<j) > 0) {
					System.out.printf("%d", array[j]);
				}
			}
			System.out.println("");
		}
		*/
	}
	
	public static int subsetEven(int [] array) {
		int sz 			= array.length;
		int [] subset 	= new int[sz];
		int counter = 0, idx;
		for(int i=0; i<(1<<sz); i++) {
			idx = 0;
			int odd = 0;
			for(int j=sz-1; j>=0; j--) {
				if( (i & 1<<j) > 0 ) {
					subset[idx++] = array[j];
					if( (array[j] & 1) == 1)
						odd++;
				}
			}
			if(odd%2==0 && idx > 0)
				counter++;
		}
		return counter;
	}
	
	public static void table(int n) {
		for(int i=0; i<(1<<n); i++) {
			for(int j=n-1; j>=0; j--) {
				System.out.printf("%d", (i & 1<<j) > 0 ? 1 : 0);
			}
			System.out.println("");
		}
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
	
	// n! /(n-p)!p!
	public static long nCr1(long n, long p) {
		long diff = n-p;
		for(long x=n-1; x>diff; x--) {
			n *= x;
		}
		for(long x=p-1; x>1; x--) {
			p *= x;
		}
		return n / p;
	}
	// C(n, r) == C(n, n - r)
	public static long nCr2(long n, long p) {
		if(p > n / 2)
			p = n - p;
		long ans = 1;
		for(long i=1; i<=p; i++) {
			ans = ans * (n - p + i);
			ans /= i;
		}
		return ans;
	}


	public static void main(String[] args) {
		//System.out.println(nPr(100, 5));
		//System.out.println(nCr1(10, 7));
		//System.out.println(nCr2(10, 7));
		int [][] set = {
			{
				1,2,3
			}
			,{
				1,1,2,2
			}
			,{
				2,4,6,1
			}
			,{
				1,2,2
			}
		};
		subset(set[3]);
		System.out.println(subsetEven(set[3]));
		//table(3);
	}

}
