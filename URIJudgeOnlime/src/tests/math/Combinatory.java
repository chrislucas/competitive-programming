package tests.math;

public class Combinatory {
	
	public static long nPr(long n, long p) {
		long d = (n - p);
		for(long x=n-1; x>d; x--) {
			n *= x;
		}
		return n;
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
		System.out.println(nPr(100, 5));
		System.out.println(nCr1(10, 7));
		System.out.println(nCr2(10, 7));

	}

}
